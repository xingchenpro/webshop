<template>
<span>
 <i class="fa fa-circle-o" @click="allSel" :class="{'fa fa-dot-circle-o':allSelFlag===true}"></i>
</span>
</template>

<script>
  export default {
  data(){
    return{
      isAllSel:false,
    }
  },
    props:{
      subjects:Array
    },
    methods:{
      allSel(){
        for(let i=0;i<this.subjects.length;i++){
          if(!this.subjects[i].isSel){
            this.subjects[i].isSel=true;
            this.isAllSel = false
          }
        }
        if(this.isAllSel){
          for(let i=0;i<this.subjects.length;i++){
            this.subjects[i].isSel=false;
          }
        }
        this.isAllSel=!this.isAllSel;
      },
    },
    computed:{
      allSelFlag(){
        for(let i=0;i<this.subjects.length;i++){
          if(!this.subjects[i].isSel){
            this.isAllSel=false;
            break
          }
        }
        return this.isAllSel;
      },
    }
  }
</script>

<style scoped lang="stylus">

</style>
