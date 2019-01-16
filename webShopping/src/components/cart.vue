<template>
<div>
<cartHead :cartDisplay="cartDisplay"></cartHead>
  <div class="cart" v-show="cartDisplay.display===1">
  <div class="cart_head">
    全选
  </div>
  <div class="cart_body">
    <cartGoods :res="res"></cartGoods>
  </div>
  <div class="cart_footer">
    <div style="width:100%"><span>已选33件</span><span style="float:right;color:#fb0036">￥33030.33</span></div>
    <button>结&nbsp;算<i class="fa fa-chevron-circle-right" style="margin-left:10px;"></i></button>
  </div>
  </div>
  </div>
</template>

<script>
import cartHead from "./common/cartHead"
import cartGoods from "./common/cartGoods"
    export default {
      data(){
      return{
      //定义一个对象传给cartHead，这样讲究可以让子组件cartHead修改display值
        cartDisplay:{'display':0},
      }
      },
      components:{
      cartHead,
      cartGoods,
      },
      created(){
        this.$axios.get('/customerAllCart').then( (res)=>{
          console.log("购物车：");
          if(res.data.resultCode===200){
            console.log("购物车：");
            console.log(res);
            this.res = res.data.result
          }else{
            console.log(res);
          }
        })
      }
    }
</script>

<style scoped lang="stylus">
.cart{
  position:fixed;
  top:0;
  right:0;
  height:100%;
  width:360px;
  background:#e5e5e5;
  border-left:2px solid #e8e8e8;
}
.cart_body{
  overflow:scroll;
  height:calc(100% - 120px);
  width:100%;
}
.cart_head{
  height:30px;
  width:100%;
}
.cart_footer{
  width:100%;
  padding:10px 20px;
  height:110px;
  font-size:16px;
}
.cart_footer button{
  width:100%;
  height:45px;
  background:#fd0036;
  color:#fff;
  font-size:16px;
}
</style>
