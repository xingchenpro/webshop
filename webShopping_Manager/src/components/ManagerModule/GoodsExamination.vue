<template>
  <transition enter-active-class="bounceInRight">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>审核商品信息</h2>
    </div>
    <div class="table-wrapper">
      <table class="table table-hover table-striped table-bordered" style="white-space: nowrap">
       <tbody>
       <tr>
         <th style="width:15%;">名称</th>
         <th style="width:15%;">类别</th>
         <th style="width:15%;">价格</th>
         <th style="width:15%;">图片</th>
         <th style="width:15%;">描述</th>
         <th style="width:25%;">操作</th>
       </tr>
       <tr v-for="item in res.uncheckedGoods">
         <td>{{item.name}}</td>
         <td>{{item.goodsTypesName}}</td>
         <td>{{item.price}}</td>
         <td>{{item.photo}}</td>
         <td>{{item.desc}}</td>
         <td><button type="button" class="btn btn-sm btn-info" @click="approval(item)"><i class="fa fa-check"></i>批准</button>
         <button type="button" class="btn btn-sm  btn-danger" @click="noApproval(item)"><i class="fa fa-close"></i>不批准</button></td>
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
    data(){
      return{

      }
    },
    methods:{
      approval(item){
        var date = qs.stringify({
          'goodsId':item.id,
          'status':1,
        });
        this.$axios.post('/goodsCheck',date).then( (res)=>{
          if(res.data.resultCode===200){
            this.res.uncheckedGoods = res.data.result.uncheckedGoods;
            alert("已批准")
          }
        }).catch( (error)=>{
            console.log(error)
        })
      },
      noApproval(item){
        var date = qs.stringify({
          'goodsId':item.id,
          'status':2,
        });
        this.$axios.post('/goodsCheck',date).then( (res)=>{
          if(res.data.resultCode===200){
            this.res.uncheckedGoods = res.data.result.uncheckedGoods;
            alert("已拒绝申请")
          }
        }).catch( (error)=>{
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped lang="stylus">
i{
  color #fff
}
button{
  width:80px;
  padding-right:20px;
}
</style>
