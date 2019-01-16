<template>
<div class="order">
  <header_nav></header_nav>
  <cart></cart>
  <div class="search">
    <div class="search_left">
      <span><img src="../assets/捞宝2.png" style="display: inline-block;margin-right:20px;" ><h1 style="color:#fd4201;margin-right:30px;display: inline-block">订单</h1></span>
    </div>
    <div class="search_right">
      <div class="search_right_top">
        <div style="display: flex;">
          <div style=" flex:0.9;">
            <input type="text" class=" " style="height:40px;width:100%;border: 2px solid #fd4201 ;font-size:16px; padding-left:10px;" placeholder="搜索">
          </div>
          <div style=" flex:0.1;">
            <button type="button"  style="margin-left:0 ;height:40px;width:100%;background: #fd4201;border:2px solid #fd4201;color:#fff ">搜索</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <order_info :res="res"></order_info>
</div>
</template>

<script>
import header_nav from "./common/header"
import order_info from "./common/order_info"
import cart from "./cart"
    export default {
      components:{
        header_nav,
        order_info,
        cart
      },
      data(){
      return{
        res:{}
      }
      },
      methods:{

      },
      created(){
        this.$axios.get('/customerAllOrder').then( (res)=>{
          if(res.data.resultCode===200){
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
  .search_right_top{
  }
  .search_right_bottom{
    margin-left 10px
    margin-top 5px
  }
  ul{
    white-space nowrap
  }
  li{
    display inline-block
    width 50px
    cursor pointer
    color black
  }
  li:hover{
    color #fd4201
  }
  .search{
    display flex
    width calc(100% - 30px)
    height 110px
    padding-left:50px;
    border-bottom:2px solid #e8e8e8;
    margin-bottom 10px;
  }
  .search .search_left{
    flex 1
  }
  .search .search_right{
    padding-top:40px;
    flex 1
  }
</style>
