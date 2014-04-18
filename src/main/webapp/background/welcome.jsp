<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
	<title>Admin</title>
     <script language="javascript" src="background/jquery.js"></script>
	 <script language="javascript" src="background/js/showo_page.js"></script>
	 <script src="background/js/calendar.js"></script>
	 
	 
	 
	
	 <script type="text/javascript">
	 function user_doPri(){
           var pri= ${pri.user_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
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
           
 	var result = "<%=request.getAttribute("result")%>";
      if(result == 1){
      	alert("修改成功！点击【确定】即将跳转...");
      	// location.reload("news.do?post=queryInformation","_self");
      	window.location.href="background/index.jsp";
      }
      if(result==0){
      	alert("修改失败，原密码错误！");
      	window.location.href="background/pasmodify.jsp?name=${adminname}";
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
 
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body onload="showhead();show();">
<div id="main">
	<div id="header">
		<a href="index.jsp" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
            <li class="active"><span><span><a href="background/welcome.jsp" >首页</a></span></span></li>
			<li><span><span><a href="background/index.jsp" onclick="return user_doPri();" >用户管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/product.do?service=queryAllProduct" onclick="return product_doPri();">商品管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/category.do?service=queryAll" onclick="return product_category_doPri();">商品分类管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation" onclick="return news_doPri();">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp" onclick="return orderPri();">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			<h3><li ><a href="#" id="test1">后台管理</a></li></h3>
            
            
	         <div id="testa" style="width:150px; height:49px">
            <ul class="nav">
				
				<li class="last"><a href="/ccMall_gj3_g9/admin.do?service=exit">退出</a></li>
			</ul> </div>
           
            
            
			
			
		</div>
	 <div id="center-column">
			<div class="top-bar">
				<a href="background/pasmodify.jsp?name=${adminname}" class="button">密码修改 </a>
				<h1>欢迎${adminname}，您的权限为普通管理员</h1>
				<div class="breadcrumbs"></div>
			</div><br />
	        <div class="select-bar">
	      <html:form  action="user.do?method=queryUsers">
	        <table class="listing form" cellpadding="0" cellspacing="0">
					<tr>
						<th class="full" colspan="2">管理员详细信息</th>
					</tr>
					<tr>
						<td class="first style1" width="172"><strong>管理员账号：</strong></td>
						<td class="last">${adminname}</td>
					</tr>
					<tr class="bg">
						<td class="first style1"><strong>管理员权限：</strong></td>
						<td class="last">
						<table>
						               <html:checkbox  value="1" name="pri"property="product_do" disabled="true">商品的增加、删除、修改、查询</html:checkbox><br/>
						               <html:checkbox  value="1"name="pri" property="product_category_do" disabled="true">商品分类的增、删、改、查</html:checkbox><br/>
						               <html:checkbox  value="1"name="pri" property="news_do" disabled="true">首页公告的修改，咨询的管理</html:checkbox><br/>
						               <html:checkbox  value="1"name="pri" property="user_do" disabled="true">用户密码和详细资料的查询，删除用户</html:checkbox><br/>
						               <html:checkbox  value="1"name="pri" property="order_do" disabled="true">对历史订单的查询，修改</html:checkbox><br/>
						         
						     </table>
						
						
						
						
						</td>
					</tr>
					
					
					
				</table>
    	  </html:form>
        </div>
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				
					
					
			 
				
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
</body>
</html>
