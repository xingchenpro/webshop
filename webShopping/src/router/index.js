import Vue from 'vue'
import Router from 'vue-router'
import home from "../components/home"
import goodsInfo from "../components/goodsInfo"
import sellerGoods from "../components/sellerGoods"
import login from "../components/Login"
import register from "../components/register"
import order from "../components/order"
import registerSeller from "../components/registerSeller"
Vue.use(Router);

export default new Router(
{
routes:[
  {path:"/",component:home},
  {path:"/goodsInfo/:sellerId/:goodsId",component:goodsInfo,name: 'goodsInfo',},
  {path:"/sellerGoods/:sellerId",component:sellerGoods},
  {path:"/login",component:login},
  {path:"/register",component:register},
  {path:"/order",component:order},
  {path:"/registerSeller",component:registerSeller}
]
}
)
