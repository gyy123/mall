 window.onload=function(){
 function nowtime(ev,type){
  /*
   * ev:显示时间的元素
   * type:时间显示模式.若传入12则为12小时制,不传入则为24小时制
   */
  //年月日时分秒www.3ppt.com
  var y,m,d,w,h,i,s;
  //月日时分秒为单位时前面补零
  function fillzero(v){
   if(v<10){v='0'+v;}
   return v;
  }
  (function(){
   var d=new date();
   var week=['星期天','星期一','星期二','星期三','星期四','星期五','星期六']
   y=d.getfullyear();
   m=fillzero(d.getmonth()+1);
   d=fillzero(d.getdate());
   w=week[d.getday()];
   h=fillzero(d.gethours());
   i=fillzero(d.getminutes());
   s=fillzero(d.getseconds());
   //12小时制显示模式
   if(type && type==12){
    //若要显示更多时间类型诸如中午凌晨可在下面添加判断
    if(h<=12){
     h='上午&nbsp;'+h;
    }else if(h>12 && h<24){
     h-=12;
     h='下午&nbsp;'+fillzero(h);
    }else if(h==24){
     h='下午&nbsp;00';
    }
   }
   ev.innerhtml=y+'年'+m+'月'+d+'日 '+' '+w+'&nbsp;'+h+':'+i+':'+s;
   //每秒更新时间
   settimeout(arguments.callee,1000);
  })();
 }
 
 //24小时制调用
 nowtime(document.getelementbyid('time24'));
 //12小时制调用
 nowtime(document.getelementbyid('time12'),12);

}