<template>
<div>
<div class="sellerCover" v-for="item in res.goods" @click="goodsDetail(item.id,res.goodsDetails[0].seller.id)">
  <div class="photo">
    <img :src="photoLocation(item.photo)">
  </div>
  <div class="info">
    <div class="price">￥{{item.price}}</div>
    <div class="gooos_desc">{{item.desc}}</div>
    <div class="goods_count">{{item.sellCount}}人付款</div>  
  </div>
</div>
</div>
</template>
<script>
    export default {
      props:{
        res:{}
      },
      methods:{
        goodsDetail(goodsId,sellerId){
          this.$router.push({
            path:'/goodsInfo/'+sellerId+'/'+goodsId,
            query:{
              sellerId:sellerId,
              goodsId:goodsId
            }
          })
        },
        //返回图片地址
        photoLocation(location){
          var a = "http://520a8cbd.nat123.cc/getImage?imageUrl="+location;
          return a;
        },
      }
    }
</script>

<style scoped lang="stylus">
.sellerCover{
  display inline-block
  cursor pointer
  height: 320px;
  width:220px;
  border:2px solid #e8e8e8;
  margin-right:15px;
  margin-top:20px;
  }
.photo{
  width:220px;
  height:220px;
}
.photo img{
  width:216px;
  height:216px;
}
.info{
  width:100%;
  padding:10px;
}
.price {
  font-size 16px
  color #fd4a01
}
.gooos_desc{
  word-wrap break-word
  color: black;
  font-size 12px
}
.goods_count,.seller_rating{
  display inline-block
}
</style>
