<template>
  <transition enter-active-class="bounceInLeft">
    <div class="tpl-content-wrapper">
      <div class="content-container-header">
        <h2>我的商品信息</h2>
      </div>
      <div class="table-wrapper">
        <table class="table table-hover table-striped table-bordered">
          <tbody>
          <tr>
            <th>名称</th>
            <th>类别</th>
            <th>参照价格</th>
            <th>描述</th>
            <th>状态</th>
          </tr>
          <tr v-for="item in res.goodsCheckStatus">
            <td>{{item.name}}</td>
            <td>{{item.goodsTypesName}}</td>
            <td>{{item.price}}</td>
            <td>{{item.desc}}</td>
            <td>
            <span v-show="item.status===0">审核中</span>
              <span v-show="item.status===1">已通过</span>
              <span v-show="item.status===2">审核未通过</span>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </transition>
</template>

<script>
  import cookie from "../../assets/js/cookie";
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

    }
  }
</script>

<style scoped lang="stylus">

</style>
