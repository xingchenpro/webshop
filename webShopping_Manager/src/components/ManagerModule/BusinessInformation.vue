<template>
  <transition enter-active-class="bounceInRight">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>商家信息管理</h2>
    </div>
    <div class="table-wrapper">
      <table class="table table-hover table-striped table-bordered">
       <tbody>
       <tr>
         <th>商家ID</th>
         <th>商家名称</th>
         <th>商家描述</th>
         <th>评级</th>
         <th>手机号</th>
         <th>地址</th>
         <th>操作</th>
       </tr>
       <tr v-for="item in res.sellers">
         <td>{{item.id}}</td>
         <td>{{item.name}}</td>
         <td>{{item.desc}}</td>
         <td>{{item.rating}}</td>
         <td>{{item.phoneNum}}</td>
         <td>{{item.location}}</td>
         <td><button type="button" class="btn btn-info">删除</button></td>
       </tr>
       </tbody>
      </table>
    </div>
  </div>
  </transition>
</template>

<script>
  export default {
  props:{
    res:{}
  },
    data(){
      return{

      }
    },
    create(){
      this.nextTick( ()=>{

      })
    }
  }
</script>

<style scoped lang="stylus">

</style>
