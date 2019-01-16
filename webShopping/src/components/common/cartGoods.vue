<template>
<div>
<div class="cartGoods" v-for="item in watchRes.carts">
  <div class="seller">
    <div style="width:15px;height:30px;display: inline-block">
      <!--
          <SelAll></SelAll>
      -->
    </div>
    <div class="name">
      {{item.goods[0].seller.name}}
    </div>
    <div class="price">
      ￥{{totalPrice}}
    </div>
  </div>
  <div class="goods" v-for="item2 in item.goods">
    <div style="width:15px;height:30px;display: inline-block">
      <!--
          <SelOne></SelOne>
      -->
    </div>
    <div class="photo">
      <img src="../../assets/6.png">
    </div>
    <div class="name">
      ￥{{item2.name}}
    </div>
    <div class="price">
      {{item2.price}}
    </div>
    <div class="count">
      <i class="fa fa-minus-circle" @click="modifyCount(item.cartId,item2.id,-1)"></i>
      {{item2.orderCount}}
      <i class="fa fa-plus-circle" @click="modifyCount(item.cartId,item2.id,1)"></i>
    </div>
    <div class="price">
      ￥{{item2.price*item2.count}}
    </div>
  </div>
</div>
</div>
</template>

<script>
import SelAll from "./SelAll"
import SelOne from "./SelOne"
import qs from "qs"
    export default {
    props:{
      res:{}
    },
      components:{
       SelAll,
       SelOne,

      },
      data(){
      return{

      }
      },
      methods:{
      //加减数量
        modifyCount(cartId,goodsId,status){
          var data = qs.stringify({
            cartId:cartId,
            goodsId:goodsId,
            status:status
          });
          this.$axios.get('/modifyCartGoodsCount?cartId='+cartId+"&goodsId="+goodsId+"&status="+status).then( (res)=>{
             if(res.data.resultCode===200){
               this.res.carts = res.data.result.carts;
               console.log(this.res.carts)
             }
          }).catch( (error)=>{
              console.log(error)
          })
        }
      },
      computed:{
        watchRes(){
          return this.res;
        }
      },

    }
</script>

<style scoped lang="stylus">
  .cartGoods{
    width:360px;
    padding:10px;
    font-size:14px;
    background:#fff
    margin-bottom:20px;
  }
  .seller{
    display flex
    width:100%;
    height:34px;
    padding:5px;
    border-bottom:1px solid #e8e8e8;
  }
  .seller .name,.seller .price,.goods .name,.goods .price,.goods .photo,.goods .count{
    display inline-block
    vertical-align top
  }
  .seller .name{
    flex:0.7
    margin-right:20px;
  }
  .seller .price{
    flex:0.3
    color:#c4c4c4
  }
  .goods{
     width:100%;
     height:100px;
     padding:5px;
    white-space nowrap
  }
  .goods .photo{
    vertical-align top
    width:60px;
    height:60px;
  }
    .goods .photo img{
    width:60px;
    height:60px;
  }
  .goods .name{
    width:55px;
    line-height:60px;
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .goods .count{
    line-height:60px;
    font-size:16px;
    margin-right:10px;
  }
  .goods .count i{
    padding:5px;
    color:#208df4;
  }
  .goods .price{
    line-height 60px
    font-size:12px;
    color:#3c3f41
  }
</style>
