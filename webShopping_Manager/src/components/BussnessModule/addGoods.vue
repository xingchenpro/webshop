<template>
  <transition enter-active-class="bounceInLeft">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>审核商品信息</h2>
    </div>
    <div class="table-wrapper">
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-sm-2 control-label">商品名称</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" v-model="name" placeholder="请输入商品名称">
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">商品类别</label>
          <div class="col-sm-10">
            <select v-model="goodsType" class="form-control ">
              <option value="1" >衣服</option>
              <option value="2" >食品</option>
              <option value="3" >家具</option>
              <option value="4" >化妆品</option>
              <option value="5" >家电</option>
              <option value="6" >手机</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">商品描述</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" v-model="desc" placeholder="请输入商品描述">
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">售卖价格</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" v-model="price" placeholder="请输入售卖价格">
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-2 control-label">图片地址</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" v-model="photo" placeholder="请输入图片地址">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-info" @click="add()">提交申请</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  </transition>
</template>

<script>
import qs from "qs"
  export default {
    data(){
      return{
          goodsType:1,
          name:"",
          desc:"",
          price:"",
          photo:"",
      }
    },
   methods:{
     add(){
       var date = qs.stringify({
       'typeId':this.goodsType,
       'name':this.name,
       'desc':this.desc,
       'price':this.price,
       'photo':this.photo
       });
       this.$axios.post('/addNewGoods',date).then( (res)=>{
         if(res.data.resultCode===200){
           alert("申请已提交，请等待审核");
           this.goodsType = 1;
            this.name = "";
            this.desc = "";
            this.price = "";
            this.photo = "";
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
