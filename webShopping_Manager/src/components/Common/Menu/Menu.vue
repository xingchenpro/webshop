<template>
  <!-- 侧边导航栏 -->
  <div class="left-sidebar">
    <!-- 用户信息 -->
    <div class="tpl-sidebar-user-panel">
      <div class="tpl-user-panel-slide-toggleable">
        <div class="tpl-user-panel-profile-picture">
          <img :src=returnRole alt="">
        </div>
        <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
             {{returnName}}
          </span>
        <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
      </div>
    </div>
    <!--  管理员菜单 -->
    <ul class="sidebar-nav" v-if="this.user==1">
      <li class="sidebar-nav-link">
        <a href="javascript:;" class="sidebar-nav-sub-title">
          <i class="am-icon-table sidebar-nav-link-logo"></i> 用户信息管理
          <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
        </a>
        <ul class="sidebar-nav sidebar-nav-sub">
          <li class="sidebar-nav-link">
            <router-link to="/MembershipInformation">
              <i class="am-icon-table sidebar-nav-link-logo"></i> 会员信息管理
            </router-link>
          </li>
          <li class="sidebar-nav-link">
            <router-link to="/BusinessInformation">
              <i class="am-icon-table sidebar-nav-link-logo"></i> 商家信息管理
            </router-link>
          </li>
        </ul>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/GoodsInformation" class="sidebar-nav-sub-title">
          <i class="am-icon-refresh sidebar-nav-link-logo"></i> 商品信息管理
        </router-link>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/GoodsExamination" class="sidebar-nav-sub-title">
          <i class="am-icon-refresh sidebar-nav-link-logo"></i> 审核商品申请
        </router-link>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/ManagerPersonalInfo" class="sidebar-nav-sub-title">
          <i class="am-icon-refresh sidebar-nav-link-logo"></i> 修改个人信息
        </router-link>
      </li>
    </ul>
    <!--  辅导员菜单 -->
    <ul class="sidebar-nav" v-if="this.user==2">
      <li class="sidebar-nav-link">
        <router-link to="/addGoods" class="sidebar-nav-sub-title">
          <i class="am-icon-tv sidebar-nav-link-logo"></i> 申请新的商品
        </router-link>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/AllGoodsInfo" class="sidebar-nav-sub-title">
          <i class="am-icon-user sidebar-nav-link-logo"></i> 全部商品信息
        </router-link>
      </li>
      <li class="sidebar-nav-link">
      <router-link to="/MyGoodsInfo" class="sidebar-nav-sub-title">
        <i class="am-icon-user sidebar-nav-link-logo"></i> 可以售卖的商品
      </router-link>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/ApplicationStatus" class="sidebar-nav-sub-title">
          <i class="am-icon-user sidebar-nav-link-logo"></i> 申请状况
        </router-link>
      </li>
      <li class="sidebar-nav-link">
        <router-link to="/PersonalInfo" class="sidebar-nav-sub-title">
          <i class="am-icon-user sidebar-nav-link-logo"></i>个人信息
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
window.onload = function(){
};
    export default {
    props:{
        role:""
    },
    data(){
    return{
       user:""
    }
    },
    computed:{
       returnRole(){
         this.user = this.role;
         return '/static/images/t'+this.role+'.jpg'
       },
      returnName(){
       if(this.user=="1"){
         return"管理员"
       }
        if(this.user=="2"){
          return"商家"
        }
      }
    },
    mounted(){
    }
    }
</script>

<style scoped lang="stylus">

</style>
