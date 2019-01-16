function setCookie(name,value,date){
    var oDate = new Date();
    oDate.setDate(oDate.getDate()+date);
    document.cookie = name+"="+value+";expires="+oDate;
}
function getCookie(name){

   var arr=document.cookie.split("; ");
   console.log(arr);
    for(var i=0;i<arr.length;i++){
      var arr2 = arr[i].split("=");
      console.log(arr2);
      if(arr2[0]===name){
      console.log("匹配成功");
      return arr2[1];
      }
    }
    return"";
}
function removeCookie(name){
  setCookie(name,1,-1);
}
export default{
setCookie,
getCookie,
removeCookie
}
