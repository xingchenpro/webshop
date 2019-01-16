import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'
import MembershipInformation from '../components/ManagerModule/MembershipInformation'
import GoodsInformation from '../components/ManagerModule/GoodsInformation'
import GoodsExamination from '../components/ManagerModule/GoodsExamination'
import BusinessInformation from '../components/ManagerModule/BusinessInformation'
import ManagerPersonalInfo from '../components/ManagerModule/ManagerPersonalInfo'
import addGoods from '../components/BussnessModule/addGoods'
import AllGoodsInfo from '../components/BussnessModule/AllGoodsInfo'
import MyGoodsInfo from '../components/BussnessModule/MyGoodsInfo'
import PersonalInfo from '../components/BussnessModule/PersonalInfo'
import ApplicationStatus from "../components/BussnessModule/ApplicationStatus"
Vue.use(Router);
export default new Router({
  routes: [
    {
      path: '/',
      component:Login
    },
    {
      path: '/Home',
      component: Home,
      children: [
        {path:'/MembershipInformation',component:MembershipInformation},
        {path:'/GoodsExamination',component:GoodsExamination},
        {path:'/GoodsInformation',component:GoodsInformation},
        {path:'/BusinessInformation',component:BusinessInformation},
        {path:'/ManagerPersonalInfo',component:ManagerPersonalInfo},
        {path:'/AllGoodsInfo',component:AllGoodsInfo},
        {path:'/MyGoodsInfo',component:MyGoodsInfo},
        {path:'/PersonalInfo',component:PersonalInfo},
        {path:'/addGoods',component:addGoods},
        {path:'/ApplicationStatus',component:ApplicationStatus}
      ]
    },
  ]
})
