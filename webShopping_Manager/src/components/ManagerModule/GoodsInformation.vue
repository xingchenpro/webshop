<template>
  <transition enter-active-class="bounceInRight">
  <div class="tpl-content-wrapper">
    <div class="content-container-header">
      <h2>商品信息管理</h2>

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

    <div class="table-wrapper">
      <table class="table table-hover table-striped table-bordered">
        <tbody>
        <tr>
          <th>ID</th>
          <th>名称</th>
          <th>类别</th>
          <th>参照价格</th>
          <th>操作</th>
        </tr>
             <tr v-for="good in res.checkedGoods" v-show="goodsType==0||good.typeId==goodsType">
          <td><span  v-show="now==='00000'||now!==good.id">{{good.id}}</span><span v-show="good.id==now"><input type="text" v-model="good.id"></span></td>
               <td><span  v-show="now==='00000'||now!==good.id">{{good.name}}</span><span v-show="good.id==now"><input type="text" v-model="good.name"></span></td>
               <td><span  v-show="now==='00000'||now!==good.id">{{good.goodsTypesName}}</span><span v-show="good.id==now"><input type="text" v-model="good.typeId"></span></td>
               <td><span  v-show="now==='00000'||now!==good.id">{{good.price}}</span><span v-show="good.id==now"><input type="text" v-model ="good.price"></span></td>
          <td>
          <button class="btn btn-warning" type="button" @click="now=good.id" v-show="now==='00000'||now!==good.id">修改</button>
            <button class="btn btn-info" type="button" @click="save(good.id,good.name,good.typeId,good.price)" v-show="now!=='00000'&&good.id===now">保存</button>
          <button class="btn btn-danger" type="button" @click="delCfm(good.id)">删除</button>
          </td>
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
  components:{

  },
    data(){
      return{

        goodsType:0,
        now:"00000"
      }
    },
    methods:{
    //修改完毕保存
      save(id,name,typeId,price){
        alert(price);
      //整理传递格式
          var data = qs.stringify({
          id:id,
          name:name,
          typeId:typeId,
          price:price
          });
        //递交后台修改数据
        this.$axios.post('/updateGoodsInfo',data).then( (res)=>{
        if(res.data.resultCode===200){
          this.res.checkedGoods = res.data.result.checkedGoods;
          console.log(res.data.result);
          alert("修改成功")
        }else{
          alert("修改失败")
        }
        }).catch( (error)=>{
          console.log(error)
        });
        //初始化now
        this.now="00000";
      },
      //删除
      delCfm(id){
      if(!confirm("确认删除吗？")){
        window.event.returnValue = false;
      }
      else{
      //整理格式
      var data = qs.stringify({
      id:id
      });
        this.$axios.delete('/delGoods/'+id).then( (res)=>{
          if(res.data.resultCode===200){
            this.res.checkedGoods = res.data.result.checkedGoods;
            console.log(res.data.result);
            alert("修改成功")
          }else{
            alert("删除失败")
          }
        }).catch( (error)=>{
          console.log(error)
        });
      }
      }
    },
    create(){
      this.nextTick( ()=>{

      })
    }
  }
</script>

<style scoped lang="stylus">
input{
  text-align center
}
</style>

