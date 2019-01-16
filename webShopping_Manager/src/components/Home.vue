<template>
<div class="am-g tpl-g" style="overflow-x:hidden">
<Header :role="role"></Header>
<Skin></Skin>
<Menu :role="role"></Menu>

<router-view :res="res" :role="role" class="animated"></router-view>

  <Footer></Footer>
  </div>
</template>

<script>
  import Header from "./Common/Header/Header"
  import Sidebar from "./Common/Sidebar/Sidebar"
  import Footer from "./Common/Footer/Footer"
  import Menu from "./Common/Menu/Menu"
  import Skin from "./Common/Skin/Skin"
  import cookie from "../assets/js/cookie"

  export default {
    components: {
      Header,
      Sidebar,
      Footer,
      Menu,
      Skin
    },
    data(){
      return{
        res:{},
        role:"",
        username:"",
        password:""
      }
    },
    created() {
        alert(document.cookie);
        this.role = cookie.getCookie("role") ;
        console.log(document.cookie);
      console.log("role="+this.role);
        this.username = cookie.getCookie('userId');
        console.log("username="+this.username);
        this.password = cookie.getCookie('password');
      console.log("password="+this.password);
        console.log(this.role);
        this.$axios.get('/home?role='+this.role+'&username='+this.username+'&password='+this.password).then( (res)=>{
            if(res.data.resultCode===200){
            console.log(res);
              this.res = res.data.result;
              console.log(this.res)
            }
            else{
            console.log(res)
            }
        }).catch( (error)=>{
          console.log(error)
        });
    },
    mounted(){
      this.$nextTick( function(){

      })
    }
  }
</script>

<style scoped lang="stylus">

</style>
