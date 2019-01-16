<template>
<div class="header">
  <div class="header_left">
    <span v-show="login===0"><router-link to="/login" style="color:#fd4302;margin:0 20px 0 40px;">亲，请登录</router-link></span>
    <span v-if="login===1" style="color:#fd4302;margin:0 20px 0 40px;">欢迎你！{{res[0].nickName}}</span>
    <span v-show="login===0"><router-link to="/register"  style="color:#6c6c6c">免费注册</router-link></span>
    <span v-show="login===1" class="logout" style="margin:0 20px 0 40px; cursor: pointer;" @click="logout()" >注销</span>
  </div>
  <div class="header_right">
    <ul>
      <router-link to="/"><li><i class="fa fa-home"></i>捞宝网首页</li></router-link>
      <li @click="myOrder()"><i class="fa fa-book"></i>我的订单</li>
      <li><i class="fa fa-star"></i>我的收藏</li>
      <li><i class="fa fa-shopping-cart"></i>购物车</li>
      <router-link to="/registerSeller"><li><i class="fa fa-registered"></i>注册商家</li></router-link>
      <li><i class="fa fa-phone"></i>联系客服</li>
    </ul>
  </div>
</div>
</template>

<script>
import cookie from "../../assets/js/cookie"
    export default {
    data(){
    return{
    login:0,
    res:{}
    }
    },
    methods:{
     myOrder(){
       this.$axios.get('customerAllOrder').then( (res)=>{
         if(res.data.resultCode===100){
           alert("请先登录"),
           this.$router.push({
             path:'/login'
           })
         }
         if(res.data.resultCode===200){
             this.$router.push({
               path:'/order'
             })
         }
         else{
           console.log(res);
         }
       })
     },
     //注销
      logout(){
        var username = cookie.getCookie('username');
        this.$axios.get('/logout?username='+username).then( (res)=>{
            if(res.data.resultCode===200){
              this.login = 0;
            }
        }).catch( (error)=>{
          console.log(error)
        })
      }
    },
    beforeCreate(){
      this.$axios.get('/isLogin').then( (res)=>{
          if(res.data.resultCode===200){
            this.login = 1;
            console.log(res);
            this.res = res.data.result
          }
        if(res.data.resultCode===100){
          this.login = 0;
            console.log(res);
        }
      }).catch( (error)=>{
        console.log(error)
      })
    }
    }
</script>

<style scoped lang="stylus">
.header{
  display flex
  height:40px;
  width:100%;
  background:#f4f4f4;
  line-height: 40px;
  color:#6c6c6c
  white-space nowrap
}
.header .header_left{
  flex 1
  display inline-block
  height 40px
}
.header .header_right{

  float right
  height 40px

}
.header .header_right li{
  display inline-block
  cursor pointer
  width 100px
}
.header .header_right li:hover{
  color:#fd4302
}
i{
  margin-right 5px
}
.logout :hover{
  color:#fd4302
}
</style>
