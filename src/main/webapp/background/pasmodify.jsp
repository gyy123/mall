<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
 session.setAttribute("adname",request.getParameter("name")); 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
    <base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/js/jquerynew.js"></script>
	<script language="javascript" src="background/js/showo_page.js"></script>
	<script src="js/calendar.js"></script>
	 <script type="text/javascript">
	  function product_doPri(){
           var pri= ${pri.product_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function product_category_doPri(){
           var pri= ${pri.product_category_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function news_doPri(){
           var pri= ${pri.news_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function orderPri(){
           var pri= ${pri.order_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
  </script>
 
  <script type="text/javascript">  
     function showhead(){   
		    var date=new Date();   
		    var now="";   
		    now=date.getFullYear()+"年";   
		    now=now+date.getMonth()+"月";   
		    now=now+date.getDate()+"日";
		    document.getElementById("ithead").innerHTML=now;   
		    setTimeout("showhead()",1000);   
		       
		}   
     
       function showdetail(){   
		    
		    document.getElementById("itdetail").innerHTML="<br/>";   
	   }   
      
		function show(){   
		    var date=new Date();   
		    var now="";   
		    now=now+date.getHours()+"时";   
		    now=now+date.getMinutes()+"分";   
		    now=now+date.getSeconds()+"秒";   
		    document.getElementById("it").innerHTML=now;   
		    setTimeout("show()",1000);   
		       
		}   
	</script> 
	<script>    
            function r1(){
           var div = document.getElementById("uid");
           div.innerHTML ="<font color='red' >请输入原密码</font>";
		   }
		   function r2(){
           var div = document.getElementById("pid");
           div.innerHTML ="<font color='red' >请输入新密码</font>";
		   }
		   function r3(){
           var div = document.getElementById("wid");
           div.innerHTML ="<font color='red' >请再次输入</font>";
		   }
		   function check(){
		   var persId = /^\d{15}|\d{18}|\d{17}[x X]$/;
		   var flag = true;
		 
		  if(document.adminform.passwordnew.value==""){
		  document.getElementById("pid").innerHTML="<font color='red'>密码不能为空</font>";
		  flag = false;
		   
		   }
		  
		   if((document.adminform.passwordnew.value)!=(document.adminform.pas2.value)){
		   
           document.getElementById("wid").innerHTML ="<font color='red'>俩次输入不一致</font>";
		   flag=false;
		   }
		  
		   if(flag == true){
		   document.adminform.submit();
		   
		   }
		   
		   return flag;
		
  		}
		   
</script>

	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body onload="showhead();show();"><br />

<html:form action="admin.do?service=modifypas&adname=${adname}">
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
            <li  class="active"><span><span><a href="background/welcome.jsp" >首页</a></span></span></li>
			<li><span><span><a href="background/index.jsp" >用户管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/product.do?service=queryAllProduct" onclick="return product_doPri();">商品管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/category.do?service=queryAll" onclick="return product_category_doPri();">商品分类管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation" onclick="return news_doPri();">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp" onclick="return orderPri();">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
	</div>
	<div id="middle">
		<div id="left-column">
			<h3><li><a href="#" id="test1">后台管理</a><br /></li></h3>
            <div id="test" style="width:150px; height:50px">
           </div>
      </div>
		<div id="center-column">
			<div class="top-bar">
				
				<h1>欢迎<%=request.getParameter("name") %>，您的权限为普通管理员</h1>
				
				<div class="breadcrumbs"><a href="index.html">首页</a> / <a href="pasmodify.html">密码修改</a></div>
			</div><br />
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<div class="select-bar">
				<table class="listing form" cellpadding="0" cellspacing="0">
					<tr>
						<th class="full" colspan="3">密码修改<br /></th>
					</tr>
					<tr>
						<td width="188" height="22" class="first style1"><strong>输入旧密码：</strong><br /></td>
						<td width="231" class="last"><html:password property="passwordold" onclick="r1();"></html:password><br /></td>
						<td width="192" id="uid">&nbsp;</td>
					</tr>
					<tr class="bg">
						<td height="23" class="first style1"><strong>输入新密码：</strong></td>
						<td class="last"><html:password property="passwordnew" onclick="r2();"></html:password></td>
						<td id="pid">&nbsp;</td>
						
						
						
					</tr>
					<tr>
						<td height="22" class="first style1""><strong>新密码确认：</strong></td>
						<td class="last"><input type="password" onclick="r3();" /></td>
						<td id="wid">&nbsp;</td>
					</tr>
					<tr>
					  <td height="20"  colspan="3"><html:image src="background/img/dd1.png" onclick="return check()"></html:image></td>
					</tr>
				</table>
				</div>
	        <p>&nbsp;</p>
		  </div>
		</div>
		<div id="right-column">
			<strong class="h">日期</strong>
			<div class="box"><font color="#FF7A00">北京时间：</font><div id="ithead"></div><div id="itdetail"></div><div id="it"></div></div>
	  </div>
	</div>
	<div id="footer"></div>
</div>
<script language="javascript">
$("#test1").toggle(function(){$("#test").slideDown()},function(){$("#test").slideUp()})
$("#test2").toggle(function(){$("#testa").slideDown()},function(){$("#testa").slideUp()})
</script>
</html:form>
</body>
</html:html>
