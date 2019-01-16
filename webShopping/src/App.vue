<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import header_nav from "./components/common/header"
import search from "./components/common/search"
import sel_filter from "./components/common/filter"
import home_body from "./components/common/body"
import sellerCover from "./components/common/sellerCover"
import cart from "./components/cart"
export default {

  name: 'App',
  components:{
  cart,
  header_nav,
  search,
  sel_filter,
  home_body,
  sellerCover
  },
  data(){
  return{
  }
  },
  beforeDestroy(){
    /*this.$axios.get('/logout?username='+this.res[0].nickName).then( (res)=>{
      if(res.data.resultCode===200){
        this.login = 0;
      }
    }).catch( (error)=>{
      console.log(error)
    })*/
  }
}
</script>

<style>
.wrapper{
 padding-left:20px;
}
</style>
