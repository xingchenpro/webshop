<template>
<div class="login">
<div class="login_body">
<div class="login_info">
  <h1 style="margin-left:60px;width:50px;height:50px;margin-bottom:30px;"><img src="../assets/捞宝3.png"></h1>
  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label ">账号</label>
      <input type="text" class="form-control"placeholder="会员名/邮箱/手机号" v-model="username">
    </div>
    <div class="form-group">
      <label class="control-label ">密码</label>
      <input type="password" class="form-control"  v-model="password">
    </div>
    <div class="form-group">
      <button type="button" @click="login()" class="form-control" style="background: #fd4401;height:40px;color:#fff;font-size:20px;">登录</button>
    </div>
  </form>
  <div class="login_footer">
    <router-link to="/register"><span style="float:right;color:#dcdcdc;font-size:14px;">免费注册</span></router-link>
  </div>
</div>
</div>
</div>
</template>

<script>
import qs from "qs"
import cookie from "../assets/js/cookie"
    export default {
    data(){
      return{
        username:"",
        password:""
      }
    },
      methods:{
        login(){
          if(this.username===""||this.password===""){
            alert("账号或密码为空，请填写完整")
          }
          else{
            var date = qs.stringify({
              "username":this.username,
              "password":this.password
            });
            this.$axios.get('/login?username='+this.username+"&password="+this.password).then( (res)=>{
              if(res.data.resultCode==200){
                cookie.setCookie('username',this.username,7) ;
                cookie.setCookie('password',this.password,7) ;
                this.$router.push("/")
              }
              else{
                alert("账号密码不正确，请重新输入！")
              }
            }).catch( (error)=>{
              console.log(error);
            });
          }
          /*  cookie.setCookie('role',this.role,7) ;
            cookie.setCookie('username',this.username,7) ;
            cookie.setCookie('password',this.password,7) ;
            var a= cookie.getCookie("role");
            console.log(document.cookie);
            console.log(a);
          this.$router.push("/Home")*/
        }
      }
    }
</script>

<style scoped lang="stylus">
.login{
  width:100%;
  color:#fff;
  font-size:16px;
}
.login_body{
  position:fixed;
  top:0px;
  left:0;
  bottom:0;
  right:0;
  background url("../assets/7.png") no-repeat
  background-size 100%;
}
.login_info{
  position:fixed;
  right:100px;
  top:80px;
  width:320px;
  height:400px;
  border-radius 10px;
  background:rgba(232,232,241,0.3);
  padding:30px;
}
</style>
