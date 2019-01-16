<template>
  <div>
    <header_nav></header_nav>
    <div class="wrapper">
      <search :res="res" v-on:transmitTypeId="recTypeId"></search>
      <sel_filter v-on:transmitPriceScope="recPriceScope"></sel_filter>
      <home_body></home_body>
      <seller-cover :res="res" :typeId="typeId" ></seller-cover>
      <cart></cart>
    </div>
  </div>
</template>

<script>
  import header_nav from "./common/header"
  import search from "./common/search"
  import sel_filter from "./common/filter"
  import home_body from "./common/body"
  import sellerCover from "./common/sellerCover"
  import cart from "./cart"
  export default {
    components:{
      cart,
      header_nav,
      search,
      sel_filter,
      home_body,
      sellerCover,
    },
    data(){
      return{
        res:{},
        typeId:0,
        priceScope:{
          lowPrice:"",
          hignPrice:"",
        }
      }
    },
    created(){
            this.$axios.get('/index').then((res)=>{
              if(res.data.resultCode===200){
                console.log(res);
                this.res = res.data.result
              }
            }).catch( (error)=>{
              console.log("homeError");
              console.log(error)
            })
    },
    methods:{
    //接收类别
      recTypeId(id){
        this.typeId = id;
      },
      //接收价格范围
      recPriceScope(priceScope){
        this.priceScope = priceScope
      }
    }
  }
</script>

<style>
  .wrapper{
    padding-left:20px;
  }
</style>
