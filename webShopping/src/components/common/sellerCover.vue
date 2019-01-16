<template>
<div>
<div class="sellerCover" v-for="item in res.goods" v-show="show(item)"> <!---->
  <div class="photo">
    <img :src="photoLocation(item.photo)">
  </div>
  <div class="info">

    <div class="price"><router-link to="/goodsInfo">￥{{item.price}}</router-link></div>
    <div class="gooos_desc" @click="goodsDetail(item.id,item.seller.id)">{{item.desc}}</div>
    <div class="seller_name">{{item.seller.name}}</div>
    <div class="goods_count">{{item.sellCount}}人付款</div>
    <div class="seller_head"><img src="../../assets/捞宝1.png" style="width:30px;height:30px;"></div>
    <div class="seller_rating">商家评分{{item.seller.rating}}</div>
  </div>
</div>
</div>
</template>

<script>
    export default {
      props: {
        res: {},
        //类别筛选
         typeId:0,
         //价格筛选
        priceScope:{}
      },
      data(){
        return{
         /* photoLocation:"http://520a8cbd.nat123.cc/getImage?imageUrl=/resources",*/
        }
      },
      methods: {
        goodsDetail(goodsId,sellerId){
          this.$router.push({
          path:'/goodsInfo/'+sellerId+'/'+goodsId,
          query:{
            sellerId:sellerId,
            goodsId:goodsId
          }
          })
          location.reload()
        },
        photoLocation(location){
            var a = "http://520a8cbd.nat123.cc/getImage?imageUrl="+location;
            return a;
        },
        //商品显示条件
        show(item){
          if((item.typeId===this.typeId||this.typeId===0)){
       /*   //如果只写了最低价
            if(this.priceScope.lowPrice!==""&&this.priceScope.lowPrice===""){
              if(item.price>=this.priceScope.lowPrice){
                return true
              }else{
                return false
              }
            }
            //如果只写了最高价
            if(this.priceScope.lowPrice===""&&this.priceScope.lowPrice!==""){
              if(item.price<=this.priceScope.hignPrice){
                return true
              }else{
                return false
              }
            }
            //如果都写了
            if(this.priceScope.lowPrice!==""&&this.priceScope.lowPrice!==""){
              if(item.price<=this.priceScope.hignPrice&&item.price>=this.priceScope.lowPrice){
                return true
              }else{
                return false
              }
            }*/
            return true;
          }
          else{
            return false;
          }
        }
      },
      watch:{
        changeTypeId(){

        }
      }
    }
</script>

<style scoped lang="stylus">
.sellerCover{
  display inline-block
  cursor pointer
  height: 370px;
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
  padding:8px;
}
.price a{
  font-size 12px
  color #fd4a01
}
.gooos_desc {
  word-wrap break-word
  color: black;
  font-size 12px
}
.seller_name,.seller_head{
  display inline-block
  width:100px;
  margin-bottom 5px
}
.goods_count,.seller_rating{
  display inline-block
  float:right
}
</style>
