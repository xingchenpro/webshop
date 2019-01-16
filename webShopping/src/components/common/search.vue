<template>
<div class="search">
  <div class="search_left">
    <span  style="color:#fb4202"><img src="../../assets/捞宝2.png"></span>
  </div>
  <div class="search_right">
  <div class="search_right_top">

    <div style="display: flex;">
      <div style=" flex:0.9;">
      <input type="text" class=" " style="height:40px;width:100%;border: 2px solid #fd4201 ;font-size:16px; padding-left:10px;" placeholder="请输入要搜索的关键词">
    </div>
    <div style=" flex:0.1;">
      <button type="button"  style="margin-left:0 ;height:40px;width:100%;background: #fd4201;border:2px solid #fd4201;color:#fff ">搜索</button>
    </div>
    </div>


  </div>
    <div class="search_right_bottom">
      <ul>
        <li @click="filterGoods(0)" :class="{'active':index===0}">全部</li>
        <li @click="filterGoods(item.id)"  v-for="item in res.goodsTypes" :class="{'active':item.id===index}">
        {{item.name}}
        </li>
        <!---->
      </ul>
    </div>
  </div>
</div>
</template>

<script>
    export default {
      props:{
        res:{},
      },
      data(){
        return{
          index:0
        }
      },
      methods:{
        filterGoods(id){
          this.index = id;
          this.$emit('transmitTypeId',id)
        }
      }
    }
</script>

<style scoped lang="stylus">
.search_right_top{
  }
.search_right_bottom{
  margin-left 10px
  margin-top 5px
}
ul{
  white-space nowrap
}
li{
  display inline-block
  width 50px
  cursor pointer
  color black
}
li:hover{
  color #fd4201
}
.search{
  display flex
  width calc(100% - 30px)
  height 130px
  padding-top:40px;
}
.search .search_left{
  flex 0.3
  text-align center
}
.search .search_right{
  flex 0.7
}
.active{
  color:red;
}
</style>
