<template>
  <transition enter-active-class="bounceInRight">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>会员信息管理</h2>
    </div>
    <div class="table-wrapper">
    <table class="table table-hover table-striped table-bordered">
  <tbody>
  <tr>
    <th>用户ID</th>
    <th>姓名</th>
    <th>邮箱</th>
    <th>住址</th>
    <th>会员等级</th>
    <th>手机号</th>
    <th>操作</th>
  </tr>
  <tr v-for="item in res.customers">
    <td>{{item.id}}</td>
    <td>{{item.nickName}}</td>
    <td>{{item.email}}</td>
    <td>{{item.address}}</td>
    <td>{{item.level}}</td>
    <td>{{item.phoneNum}}</td>
    <td>
      <button type="button" class="btn btn-warning">修改</button>
      <button type="button" class="btn btn-warning">删除</button>
    </td>
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
