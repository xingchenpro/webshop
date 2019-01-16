<template>
<div>
  <div class="order_info" v-for="item in res.orders">
    <div class="order_info_header">
      <div class="time">{{item.time}}</div>
      <div class="orderId">{{item.id}}</div>
      <div class="seller_name"><img src="../../assets/捞宝1.png" style="width:25px;height:25px;margin-right:10px;">{{item.goods[0].seller.name}}</div>
    </div>
    <div class="order_info_content" v-for="item2 in item.goods">
      <div class="photo">
        <img src="../../assets/8.png">
      </div>
      <div class="goods_name">
        <span>{{item2.name}}</span><br>
        <span><img src="../../assets/9.png" title="如实描述" style="width:16px;height:16px;margin-right:5px;"></span>
        <span><img src="../../assets/10.png" title="正品保障" style="width:16px;height:16px;"></span>
      </div>
      <div class="price">
        ￥{{item2.price}}
      </div>
      <div class="count">
        {{item2.orderCount}}
      </div>
      <div class="totalPrice">
        ￥{{item2.price*item2.orderCount}}
      </div>
      <div class="location" style="text-align: center">
        山东省济南市历城区凤鸣路1000号山东建筑大学
      </div>
      <div class="status" style="color:red;">
        {{item.status===1?'交易成功':'待支付'}}
      </div>
      <div class="comment">
        <button class="btn btn-info" v-show="item.status===1">立即评价</button>
        <button class="btn btn-warning" v-show="item.status===0"  @click="modifyOrderStatus(item.id)">立即支付</button>
      </div>
    </div>
  </div>
  <!-- 模态框 -->
 <!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
      </div>&lt;!&ndash; /.modal-content &ndash;&gt;
    </div>&lt;!&ndash; /.modal &ndash;&gt;
  </div>-->
</div>
</template>

<script>
import qs from "qs"
    export default {
      props:{
        res:{}
      },
      methods:{
        //点完立即支付以后 将status状态置为1
        modifyOrderStatus(id){
        if(!confirm("确认支付？")){
          window.event.returnValue = false;
        }else{
          var data = qs.stringify({
            'orderId':id
          });
          this.$axios.get('/modifyOrderStatus?orderId='+id).then( (res)=>{
            console.log(res);
            if(res.data.resultCode===200){
              alert("购买成功");
              location.reload();
              console.log(res)
            }
          }).catch( (error)=>{
            console.log(error)
          })
        }
        }
      }
    }
</script>

<style scoped lang="stylus">
.order_info{
  width:880px;
  margin:0 auto;
  margin-bottom:10px;
  border:1px solid #e8e8e8;

}
.order_info_header{
  height:40px;
  width:100%;
  background #f0f0f0;
  padding:10px 20px;
}
.order_info_header .time,.order_info_header .orderId,.order_info_header .seller_name{
  display inline-block;
  margin-right:30px;
}
.order_info_header .time{
  font-weight:700;
}
.order_info_content{
  height:110px;
  width:100%;
  font-size:12px;
  border-bottom 1px solid #e8e8e8;
}
.order_info_content .goods_name,.order_info_content .photo,.order_info_content .price,.order_info_content .count,.order_info_content .totalPrice,.order_info_content .location,.order_info_content .status,.order_info_content .comment{
  display inline-block
  width 105px
  padding:10px
  height:100%;
  vertical-align top
  border-left 1px solid #e8e8e8;

}
.order_info_content .price,.order_info_content .count,.order_info_content .totalPrice,.order_info_content .status,.order_info_content .comment {
  line-height:80px;
  text-align center
}
.order_info_content .photo img{
  width:80px;
  height:80px;
}
</style>
