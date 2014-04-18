// JavaScript Document
//判断每一位为数字，且首字符不为0
function checkNumStr(msg ){

 var norma = "0123456789";

 msg = trim(msg);

 if((msg.length ==0)||(msg == null)){

  return 0;  

 }

 for (var i=0; i<msg.length; i++) 

 {

  var temp = "" + msg.substring(i, i+1);

  if (norma.indexOf(temp) == "-1")

  {

   return  -1;

  }

 }

 return 1;

}

//判断是不是数字
function isDigit(num) {

    var string="1234567890";

    if (string.indexOf(num) != -1) {

        return true;

    }

    return false;

}

//判断是不是整数
function isInteger(val) {

    for (var i=0; i < val.length; i++) {

    if (!isDigit(val.charAt(i))) { return false; }

    }

    return true;

}
//去左空格; 
function ltrim(s){ 
return s.replace( /^\s*/, ""); 
} 
//去右空格; 
function rtrim(s){ 
return s.replace( /\s*$/, ""); 
} 
//去左右空格; 
function trim(s){ 
return rtrim(ltrim(s)); 
}
