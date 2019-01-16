<template>
<div class="filter">
  <div class="form-wrapper">
    <form class="form-inline" role="form">
      <div class="form-group">
        <label class="control-label">价格:</label>
        <input type="text" class="form-control" style="width:100px;" v-model="priceScope.lowPrice">
        <label class="control-label">-</label>
        <input type="text" class="form-control" style="width:100px;" v-model="priceScope.highPrice">
        <button type="button" class="form-control btn btn-info" @click="transmitPriceScope">搜索</button>
      </div>
    </form>
  </div>
</div>
</template>

<script>
    export default {
      data(){
        return{
        priceScope:{
        lowPrice:"",
          highPrice:"",
          }

        }
      },
      methods:{
        transmitPriceScope(){
           this.$emit('transmitPriceScope',this.priceScope)
        }
      }
    }
</script>

<style scoped lang="stylus">
.filter{
  border:2px solid #e8e8e8;
  width:100%-20px;
  height:60px;
  padding:10px 10px;
  margin-top 10px;
  margin-right:20px;
}
.form-wrapper{
  width:500px;
}

</style>
