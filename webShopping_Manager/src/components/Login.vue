<template>
  <div class="wrapper">
    <div class="login-wrapper">
      <div class="title">
        网上购物管理系统
      </div>
      <div class="logo">
        <img :src="'../../static/images/t'+role+'.jpg' ">
      </div>
      <form  class="form-wrapper " role="form">
        <div class="form-group ">
          <select class="form-control " style="margin-bottom:20px;" v-model="role">
            <option selected="selected" disabled="true" value="0">请选择身份</option>
            <option v-for="item in options" :value="item.value">{{item.text}}</option>
          </select>
          <input type="text" placeholder="账号" class="form-control" v-model="username" style="margin-bottom:20px;">
          <input type="password" placeholder="密码" class="form-control" v-model="password" style="margin-bottom:20px;">
          <input type="text" placeholder="验证码" class="form-control" style="margin-bottom:20px;">
        <!--  <router-link to="/Home">-->
          <button type="button" @click="login()" class="btn btn-info form-control" style="height:40px;">登录</button>
          <!--</router-link>-->
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import cookie from "../assets/js/cookie"
import qs from "qs"
    export default {
      data(){
      return{
        options: [
          {value: 1, text: '管理员'},
          {value: 2, text: '商家'},
        ],
        role:0,
        username:"",
        password:"",
      }
      },
      methods:{
        login(){
        if(this.photoValue===0){
          alert("请选择身份")
        }
        if(this.username===""||this.password===""){
        alert("账号或密码为空，请填写完整")
        }
        else{
          var date = qs.stringify({
            "role":this.role,
            "username":this.username,
            "password":this.password
          });
          this.$axios.post('/login',date).then( (res)=>{
            if(res.data.resultCode==200){
              cookie.removeCookie("username");
              cookie.setCookie('role',this.role,7) ;
              cookie.setCookie('userId',this.username,7) ;
              cookie.setCookie('password',this.password,7) ;
              this.$router.push("/Home")
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
  .wrapper {
    position: fixed;
    top: 0;
    left: 0;
    bottom: 0;
    right:0;
  background:url("../../static/images/bg-2563.jpg") no-repeat fixed top;
  }

  .login-wrapper {
    width: 350px;
    height: 500px;
    background: rgba(255, 255, 255, 0.5);
    margin: 20px auto;
  }

  .title {
    padding-top: 30px;
    text-align: center;
    font-size: 22px;
    font-weight: 200;
  }

  .logo {
    height: 110px;
    text-align: center;
    padding-top: 18px;
    padding-bottom: 15px;
  }

  .logo img {
    height: 80px;
    width: 80px;
    border-radius: 50%;
  }

  .form-wrapper {
    width: 90%;
    height: 60%;
    padding: 20px;
    box-sizing: border-box;
    margin: 10px auto;
    background: #fff;
    border-radius: 5px;
  }

</style>
