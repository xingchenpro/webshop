<template>
  <transition enter-active-class="bounceInLeft">
    <div class="tpl-content-wrapper">
      <div class="content-container-header">
        <span class="font-thin h3 ">个人信息管理</span>
      </div>
      <div class="info-editor">
        <h4>个人信息编辑</h4>
        <form class="form-inline">
          <div class="form-group">
            <label class="col-md-3">职工号</label><label class="col-md-9">000001</label>
          </div>
          <div class="form-group">
            <label class="col-md-3">姓名</label><label class="col-md-9">捞总</label>
          </div>
          <div class="form-group">
            <label class="col-md-3">姓名</label>
            <label class="col-md-9" v-show="!isEdit">男</label>
            <select class="form-control col-md-9 " v-show="isEdit">
              <option value="1">男</option>
              <option value="2">女</option>
            </select>
          </div>
          <div class="form-group">
            <label class="col-md-3">公司</label>
            <label class="col-md-9" v-show="!isEdit">捞宝公司</label>
            <select class="form-control col-md-9 " v-show="isEdit">
              <option value="1">CEO</option>
              <option value="2">办公室</option>
              <option value="3">领导办公室</option>
              <option value="4">捞宝公司管理部</option>
              <option value="5">捞宝公司设计部</option>
              <option value="6">捞宝公司技术</option>
              <option value="7">捞宝公司运营</option>
              <option value="8">捞宝公司营销</option>
              <option value="9">捞宝公司后勤</option>
            </select>
          </div>
          <div class="form-group">
            <label class="col-md-3">职称</label>
            <label class="col-md-9" v-show="!isEdit">CEO</label>
            <select class="form-control col-md-9 " v-show="isEdit">
              <option value="1">CEO</option>
              <option value="2">CFO</option>
              <option value="3">COO</option>
              <option value="4">CTO</option>
              <option value="5">PM</option>
              <option value="6"></option>
              <option value="7"></option>
              <option value="8"></option>
            </select>
          </div>
          <div class="form-group">
            <label class="col-md-3">学位</label>
            <label class="col-md-9" v-show="!isEdit">博士</label>
            <select class="form-control col-md-9 " v-show="isEdit">
              <option value="1">博士</option>
              <option value="2">硕士</option>
              <option value="3">学士</option>
            </select>
          </div>
          <div class="form-group">
            <label class="col-md-3">从事:</label>
            <label class="col-md-9" v-show="!isEdit">未填写</label>
            <input type="text" class="form-control col-md-9" v-show="isEdit">
          </div>
          <div class="form-group">
            <label class="col-md-3">邮箱:</label>
            <label class="col-md-9" v-show="!isEdit">未填写</label>
            <input type="text" class="form-control col-md-9" v-show="isEdit">
          </div>
          <div class="form-group">
            <label class="col-md-3">手机号:</label>
            <label class="col-md-9" v-show="!isEdit">未填写</label>
            <input type="text" class="form-control col-md-9" v-show="isEdit">
          </div>
          <div class="form-group">
            <label class="col-md-3">备注:</label>
            <label class="col-md-9" v-show="!isEdit">未填写</label>
            <input type="text" class="form-control col-md-9" v-show="isEdit">
          </div>
          <div class="form-group">
            <button type="button" class="btn btn-info" @click="edit" v-show="!isEdit">编辑</button>
            <button type="button" class="btn btn-info" @click="edit" v-show="isEdit">保存</button>
            <button type="button" class="btn btn-info" @click="edit" v-show="isEdit">取消</button>
          </div>
        </form>
      </div>
    </div>
  </transition>
</template>

<script>
  export default {
    data(){
      return {
        isEdit:false
      }
    },
    methods:{
      edit(){
        this.isEdit = !this.isEdit
      }
    }
  }
</script>

<style scoped lang="stylus">
  .info-editor
    width 40%
    border 1px solid rgba(7, 17, 26, 0.2)
    background-color: rgba(255, 255, 255, 0.5)
    margin-left 40px
    margin-top 40px
    .form-group
      box-sizing border-box
      width 100%
      border-bottom: 1px dashed rgba(7, 17, 27, 0.1)
      height 40px
      line-height 40px
      font-weight normal
      padding-left 15px;
      label
        font-weight normal

</style>
