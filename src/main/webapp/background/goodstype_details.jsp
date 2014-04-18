<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/js/showo_page.js"></script>
	<script language="javascript" src="background/js/jquery.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
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
</head>
<body onload="showhead();show();">
<html:form action="category.do?service=updateCategory">
<div id="main">
	<div id="header">
		<a href="background/index.jsp" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li><span><span><a href="background/index.jsp">管理员权限</a></span></span></li>
			<li><span><span><a href="background/goods_index.jsp">商品管理</a></span></span></li>
			<li class="active"><span><span><a href="background/goodstype_index.jsp">商品类型管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
  </div>
	<div id="middle">
	  <div id="left-column">
			<h3>
			  <li ><a href="background/goodstype_index.jsp" id="test1">查询分类</a></li>
			</h3>
            
            
	        <div id="test" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="/ccMall_gj3_g9/category.do?service=queryMainAll">查询大分类</a></li>
				<li><a href="/ccMall_gj3_g9/category.do?service=querySubAll">查询小分类</a></li>
			</ul> </div>
			<h3>
			  <li ><a href="background/goodstype_index.jsp" id="test2">添加分类</a></li>
			</h3>
            
            
	        <div id="testa" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="/ccMall_gj3_g9/category.do?service=queryMainAll_add">添加大分类</a></li>
				<li><a href="/ccMall_gj3_g9/category.do?service=querySubAll_add">添加小分类</a></li>
			</ul> </div> 
			<h3>
			  <li ><a href="background/goodstype_index.jsp" id="test3">修改分类</a></li>
			</h3>
            
            
	        <div id="testb" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="/ccMall_gj3_g9/category.do?service=queryMainAll_up">修改大分类</a></li>
				<li><a href="/ccMall_gj3_g9/category.do?service=querySubAll_up">修改小分类</a></li>
			</ul> </div>  
			<h3>
			  <li ><a href="background/goodstype_index.jsp" id="test4">删除分类</a></li>
			</h3>
            
            
	        <div id="testc" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="/ccMall_gj3_g9/category.do?service=queryMainAll_del">删除大分类</a></li>
				<li><a href="/ccMall_gj3_g9/category.do?service=querySubAll_del">删除小分类</a></li>
			</ul></div>
			
			                                                
      </div>
		<div id="center-column">
			<div class="top-bar">
			  <h1>商品分类信息</h1>
				<div class="breadcrumbs">
					<a href="background/goodstype_index.jsp">商品类型管理</a></div>
			</div><br />
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="177">&nbsp;</th>
						<th><html:hidden property="id" value="${details.id}"></html:hidden></th>
						<th>&nbsp;</th>
					</tr>
					<tr>
						<td>商品分类名称</td>
						<td>
							<html:text property="name" value="${details.name}">
							</html:text>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr class="bg">
						<td>商品上行分类</td>
						<td>
							<bean:write name="details" property="upper_id"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>商品分类级别</td>
						<td>
							<bean:write name="details" property="type"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
				  	  <td colspan="3" align="center" >
							<html:submit>提交</html:submit>
							<html:reset>重置</html:reset>
					  </td> 
					</tr>
				</table>
				
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
$("#test3").toggle(function(){$("#testb").slideDown()},function(){$("#testb").slideUp()})
$("#test4").toggle(function(){$("#testc").slideDown()},function(){$("#testc").slideUp()})
</script>
</html:form>
</body>
</html:html>

