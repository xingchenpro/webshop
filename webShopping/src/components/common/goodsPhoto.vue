<template>
<!--<router-link to="/goodsInfo">-->
<div>
  <div class="goodsPhoto" v-for="item in res.goods" @click="goodsDetail(item.id,res.goodsDetails[0].id)">
      <img :src="photoLocation(item.photo)" v-if="item.photo!==undefined">
  </div>
</div>
<!--</router-link>-->
</template>

<script>
    export default {
      props:{
        res:{}
      },
      created(){
        console.log("goodsPhoto");
        console.log(this.res);
      },
      methods:{
        //返回图片地址
        photoLocation(location){
          var a = "http://520a8cbd.nat123.cc/getImage?imageUrl="+location;
          return a;
        },
        //显示商品细节
        goodsDetail(goodsId,sellerId){
          this.$router.push({
            path:'/goodsInfo/'+sellerId+'/'+goodsId,
            query:{
              sellerId:sellerId,
              goodsId:goodsId
            }
          });
          location.reload()
        },
      }
    }
</script>

<style scoped lang="stylus">
.goodsPhoto{
  cursor:pointer;
  margin-bottom 15px;
}
.goodsPhoto img{
  width:160px;
  height:160px;
}
</style>
