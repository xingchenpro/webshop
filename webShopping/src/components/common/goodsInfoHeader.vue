<template>
<div  class="goodsInfoHeader">
  <div class="goodsInfoHeader_left" style="text-align: center">
     <div style="border-right:3px solid #efefef;width:240px;font-size:30px;color:#fd0036;display: inline-block;margin-right:10px;"><img src="../../assets/捞宝2.png"></div>
    <div @click="sellerGoods(res.goodsDetails[0].seller.id)" style="cursor:pointer; border-right:3px solid #efefef;width:140px;font-size:16px;color:black;font-weight:700;display: inline-block">{{res.goodsDetails[0].seller.name}}<br><img src="../../assets/3.png"></div>
    <div style="border-right:3px solid #efefef;width:140px;font-size:16px;color:#d3d2d3;display: inline-block">商家评分<br><span style="color:#fd0036">{{res.goodsDetails[0].seller.rating}}</span></div>
  </div>
  <div class="goodsInfoHeader_right"  >
        <div style="display: flex;">
          <div style=" flex:0.9;">
            <input type="text" class=" " style="height:50px;width:100%;border: 4px solid #fd4201 ;font-size:16px; padding-left:10px;" placeholder="请输入要搜索的关键词">
          </div>
          <div style=" flex:0.1;">
            <button type="button"  style="margin-left:0 ;height:50px;width:100%;background: #fd4201;border:4px solid #fd4201;color:#fff ">搜索</button>
          </div>
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
        sellerGoods(id){
          this.$router.push({
            path:'/sellerGoods/'+id,
            query:{
              id:id
            }
          })
        }
      }
    }
</script>

<style scoped lang="stylus">
.goodsInfoHeader{
  display flex
  width 100%
  height 150px
  padding 30px 50px
  border-bottom:2px solid #e4e4e4
  white-space nowrap
}
.goodsInfoHeader_left{
  flex 1
}
.goodsInfoHeader_right{
  padding-left 200px
  flex:1
}
</style>
