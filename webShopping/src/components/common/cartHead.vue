<template>
<div class="cartHead" @click="display()" ref="cartHead">
 <i class="fa fa-shopping-cart"></i><br>
 <span style="font-size:16px;color:#fff">购<br>物<br>车</span>
</div>
</template>

<script>
    export default {
      props:{
        cartDisplay:{}
      },
      methods:{
        display(){


          if(this.cartDisplay.display===0){
            this.$axios.get('/isLogin').then( (res)=>{
              if(res.data.resultCode===200){
                this.$refs.cartHead.style.right=360+"px";
                this.cartDisplay.display=1;
              }
              if(res.data.resultCode===100){
                alert("请先登录");
                this.$router.push({
                  path:'/login'
                })
              }
            });
          }

          else{
            this.$refs.cartHead.style.right=0;
            this.cartDisplay.display=0;
          }
        }
      }
    }
</script>

<style scoped lang="stylus">
.cartHead{
  z-index 100
  width:50px;
  height:150px;
  background:#000001;
  position:fixed;
  top:50%;
  right:0;
  text-align:center;
  padding:30px 0;
  cursor:pointer;
}
.cartHead:hover{
  background-color:#fd0036;
  color:#fff;
}
i{
  color:#fff;
  font-size:24px;
}

</style>
