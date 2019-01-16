<template>
  <span>
    <i class="fa fa-circle-o" @click="item.isSel=!item.isSel" :class="{'fa fa-dot-circle-o':myType===true}"></i>
  </span>
</template>

<script>
    export default {
      props:{
         item:Object
      },
      computed:{
        myType(){
          return this.item.isSel
        }
      }
    }
</script>

<style scoped lang="stylus">

</style>
