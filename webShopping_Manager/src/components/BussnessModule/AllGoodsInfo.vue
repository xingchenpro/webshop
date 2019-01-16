<template>
  <transition enter-active-class="bounceInLeft">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>全部商品信息</h2>
    </div>
    <div class="table-wrapper">
      <table class="table table-hover table-striped table-bordered">
     <tbody>
       <tr>
         <th>名称</th>
         <th>类别</th>
         <th>参照价格</th>
         <th>描述</th>
         <th>操作</th>
       </tr>
       <tr v-for="item in res.AllGoods">
         <td>{{item.name}}</td>
         <td>{{item.goodsTypesName}}</td>
         <td>{{item.price}}</td>
         <td>{{item.desc}}</td>
         <td><button class="btn btn-info" @click="add(item.id)">添加该商品</button></td>
       </tr>
     </tbody>
      </table>
    </div>
  </div>
  </transition>
</template>

<script>
  import qs from "qs"
  export default {
  props:{
    res:{}
  },
    methods:{
      add(id){
          var date = qs.stringify({
            'goodsId':id
          });
          this.$axios.post('/addSellerGoods',date).then( (res)=>{
            if(res.data.resultCode===200){
              alert("添加该商品成功");
              this.res.canSellGoods = res.data.result.canSellGoods;
            }else{
              alert("您已拥有该商品，不能重复添加")
            }
          }).catch( (error)=>{
            console.log(error)
          })
      }
    }
  }
</script>

<style scoped lang="stylus">

</style>
