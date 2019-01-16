<template>
<div>
<header_nav></header_nav>
<goodsInfoHeader :res="res"></goodsInfoHeader>
<div style="width:100%;height:50px;border:2px solid #e8e8e8;padding-top:5px;">
  <form class="form form-horizontal" role="form" style="width:20%;">
    <div class="form-group">
      <label class="col-sm-6 control-label">筛选类别</label>
      <div class="col-sm-6">
        <select v-model="goodsType" class="form-control">
          <option value=0>全部</option>
          <option value=1>1</option>
          <option value=2>2</option>
          <option value=3>3</option>
          <option value=4>4</option>
        </select>
      </div>
    </div>
  </form>
</div>

<goods :res="res"></goods>
</div>
</template>

<script>
    import header_nav from "./common/header"
    import goodsInfoHeader from "./common/goodsInfoHeader"
    import goods from "./common/goods"
    export default {
      components:{
        header_nav,
        goodsInfoHeader,
        goods
      },
      data(){
      return{
      res:{},
      goodsType:1
      }
      },
      created(){
      console.log(this.$route);
        var sellerId = this.$route.query.id;
        this.$axios.get('/goodsDetails?sellerId='+sellerId).then( (res)=>{
          if(res.data.resultCode===200){
            console.log(res);
            this.res = res.data.result;
          }
        }).catch( (error)=>{
          console.log(error)
        });
      }
    }
</script>

<style scoped lang="stylus">

</style>
