<template>
</template>

<script>
    import goodsPhoto from "./goodsPhoto"
    export default {
    data(){
    return{
      arr:[1,2,3,4],
      count:1,
      sellerGoods:{}
    }
    },
    components:{
      goodsPhoto
    },
    methods:{
      decrease(){
        if(this.count>1){
          this.count--
        }
      }
    },
    created(){
      var sellerId = this.res.goods.seller.id;
      this.axios.get('./sellerGoods?sellerId='+sellerId).then( (res)=>{
          if(res.data.resultCode===200){
            this.sellerGoods = res.data.result;
          }
      }).catch( (error)=>{
          console.log(error)
      })
    }
    }
</script>

<style scoped lang="stylus">

</style>
