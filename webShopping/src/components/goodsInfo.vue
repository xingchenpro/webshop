<template>
<div>
<header_nav></header_nav>
  <goodsInfoHeader :res=res></goodsInfoHeader>
  <cart></cart>
  <div class="goodsInfoContent">
    <div class="photo"  v-if="res!==undefined">
      <img :src="photoLocation(res.goodsDetails[0].photo)">
    </div>
    <div class="info"  v-if="res!==undefined">
      <div class="desc">{{res.goodsDetails[0].desc}}</div>
      <div class="price">价格:<span style="color:#fd0036;font-size:24px;margin-left:50px;">￥{{res.goodsDetails[0].price}}</span></div>
      <div class="count">
        数量<input type="text" v-model="count" style="text-align:center;height:30px;width:70px;margin-left:50px;border:1px solid #a6a5ab"/>
        <i class="fa fa-angle-up" @click="count++"></i>
        <i class="fa fa-angle-down" @click="decrease()"></i>
      </div>
      <div class="count">库存<span style="color:#fd0036;font-size:24px;margin-left:50px;">{{res.goodsDetails[0].count}}</span></div>
      <div class="count">销量<span style="color:#fd0036;font-size:24px;margin-left:50px;">{{res.goodsDetails[0].sellCount}}</span></div>
      <div class="buy">
        <button type="button" style="height:45px;width:150px;border:2px solid #fd0036;color:#fd0036;background:#fdecec;margin-right:30px;" data-toggle="modal" data-target="#myModal" @click="generateOrder()">立即购买</button>
        <button @click="addToCart()" type="button" style="height:45px;width:150px;border:2px solid #fd0036;color:#fff;background:#fd0036"><i style="margin-right:10px;" class="fa fa-shopping-cart" ></i>加入购物车</button>
      </div>
      <div>承诺 <span style="margin-left:40px;margin-right:15px;color:black">正品保证</span><span style="margin-right:20px;color:black">极速退款</span><span style="margin-right:15px;color:black">七天无理由退换</span></div>
    </div>
    <div class="other">
      <div>……<span style="font-size:16px;">本店其他商品</span>……</div>
      <goodsPhoto :res="res"></goodsPhoto>
    </div>
  </div>
  <!-- 模态框 -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">交易详情</h4>
        </div>
        <div class="modal-body">
        <table class="table table-bordered table-hover">
         <tbody>
         <tr>
           <th>图片</th>
           <th>商品名</th>
           <th>商品单价</th>
           <th>购买数量</th>
           <th>总价</th>
           <th>收货地址</th>
         </tr>
         <tr style="height:80px;">
           <td><img src="../assets/8.png" style="width:80px;height:80px;"></td>
           <td style="padding-top:30px;">
           {{res.goodsDetails[0].name}}
           <br>
             <span><img src="../assets/9.png" title="如实描述" style="width:16px;height:16px;margin-right:5px;"></span>
             <span><img src="../assets/10.png" title="正品保障" style="width:16px;height:16px;"></span>
           </td>
           <td style="line-height:80px;">{{res.goodsDetails[0].price}}</td>
           <td style="color:red;line-height:80px;">{{count}}</td>
           <td style="color:red;line-height:80px; ">{{res.goodsDetails[0].price*count}}</td>
           <td style="overflow: hidden;text-overflow: ellipsis;">山东省济南市历城区凤鸣路1000号山东建筑大学</td>
         </tr>
         </tbody>
        </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">暂时取消</button>
          <button type="button" class="btn btn-primary" data-dismiss="modal"  @click="modifyOrderStatus()">确认购买</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
  </div>
</div>
</template>

<script>
import header_nav from "./common/header"
import goodsInfoHeader from "./common/goodsInfoHeader"
import goodsInfoContent from "./common/goodsInfoContent"
import goodsPhoto from "./common/goodsPhoto"
import qs from "qs"
import cart from "./cart"
    export default {
      components:{
        cart,
        header_nav,
        goodsInfoHeader,
        goodsInfoContent,
        goodsPhoto
      },
      data(){
        return{
          res:{},
          count:1,
          sellerId:"",
          goodsId:"",
          sellerGoods:{},
          //记录刚生成的订单ID，用来传递状态给这个订单
          orderId:""
        }
      },
      beforeCreate(){
        this.sellerId = this.$route.query.sellerId;
        this.goodsId = this.$route.query.goodsId;
        this.$axios.get('/goodsDetails?sellerId='+this.sellerId+'&goodsId='+this.goodsId).then( (res)=>{
               if(res.data.resultCode===200){
                 console.log(res);
                 this.res = res.data.result;
               }
        }).catch( (error)=>{
          console.log(error)
        });
      },
      methods:{
        decrease(){
          if(this.count>1){
            this.count--
          }
        },
        //返回图片地址
        photoLocation(location){
          var a = "http://520a8cbd.nat123.cc/getImage?imageUrl="+location;
          return a;
        },
        //立刻购买  //生成status为0的订单
        generateOrder(){
          var data = qs.stringify({
            goodsId:this.res.goodsDetails[0].id,
            count:this.count
          });
          this.$axios.get('/generateOrder?goodsId='+this.res.goodsDetails[0].id+"&count="+this.count).then( (res)=>{
            if(res.data.resultCode===100){
              alert("请先登录"),
                this.$router.push({
                  path:'/login'
                })
            }
              if(res.data.resultCode===200){
                console.log("生成订单");
                console.log(res);
                this.orderId = res.data.result;
              }
          }).catch( (error)=>{
            console.log(error)
          })
        },
        //点完立即支付以后 将status状态置为1
        modifyOrderStatus(){
          console.log(this.orderId);
          var data = qs.stringify({
            'orderId':this.orderId
          });
          this.$axios.get('/modifyOrderStatus?orderId='+this.orderId).then( (res)=>{
            console.log(res);
            if(res.data.resultCode===200){
              alert("购买成功");
              console.log(res)
            }
          }).catch( (error)=>{
            console.log(error)
          })
        },
        //加入购物车
        addToCart(){
          console.log(this.count);
          var data = qs.stringify({
            goodsId:this.res.goodsDetails[0].id,
            count:this.count
          });
          this.$axios.get('/addCart?goodsId='+this.res.goodsDetails[0].id+"&count"+this.count).then( (res)=>{
            if(res.data.resultCode===100){
              alert("请先登录"),
                this.$router.push({
                  path:'/login'
                })
            }
            if(res.data.resultCode===200){
              console.log(res);
              alert("加入购物车成功");
              location.reload()
            }
          }).catch( (error)=>{
            console.log(error)
          })
        }
      }
    }
</script>

<style scoped lang="stylus">
  .goodsInfoHeader{
    display flex
    width 100%
    height 150px
    padding 30px 50px
    border-bottom:2px solid #e4e4e4
    white-space nowrap
  }
  .goodsInfoHeader_left{
    flex 1
  }
  .goodsInfoHeader_right{
    padding-left 200px
    flex:1
  }
  .goodsInfoContent{
    width 100%
    padding 30px
    white-space nowrap
    vertical-align top
  }
  .photo{
    display inline-block
    margin-right:30px;
  }
  .photo img{
    width:400px;
    height:400px;
  }
  .info{
    display inline-block
    width 500px
    vertical-align top
    color:#8e8e8e;
    font-size:20px;
    border-right:2px solid #e8e8e8;
    padding-right:30px;
  }
  .desc{
    font-size:16px;
    font-weight:700
    margin-bottom:26px;
  }
  .price{
    background:#efeeee;
    margin-bottom:26px;
  }
  .count{
    margin-bottom:26px;
    vertical-align top
  }
  .buy{
    margin-bottom:30px;
  }
  .other{
    display inline-block
    width:200px;
    height:400px;
    vertical-align top
    margin-left 10px;
    text-align center
    overflow-y scroll
  }
  .count i{
    border:1px solid #a6a5ab

    padding 4px;
  }
</style>
