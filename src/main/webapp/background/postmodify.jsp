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
    <script language="javascript" src="background/jquery.js"></script>
    <script type="text/javascript">   
		function show(){   
		    var date=new Date();   
		    var now="";   
		    now=date.getFullYear()+"年";   
		    now=now+date.getMonth()+"月";   
		    now=now+date.getDate()+"日";   
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
<body onload="show()">
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li><span><span><a href="index.html">管理员权限</a></span></span></li>
			<li><span><span><a href="goods_index.html">商品管理</a></span></span></li>
			<li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
			<li class="active"><span><span><a href="news.html">新闻管理</a></span></span></li>
			<li><span><span><a href="order.html">订单管理</a></span></span></li>
			<li><span><span><a href="total.html">销售统计</a></span></span></li>
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			<h3><li ><a href="#" id="test1">新闻管理</a></li></h3>
            <div id="test" style="width:150px; height:50px">
            <ul class="nav"><li><a href="news.do?post=queryInformation">资讯管理</a></li>
				<li><a href="news.do?post=queryPost">公告管理</a></li>
			</ul> </div>
       </div>
        
	  <div id="center-column">
	    <div class="top-bar">
          <h1>新闻管理</h1>
	      <div class="breadcrumbs"><a href="news.html">新闻管理</a>/<a href="post.html">公告管理</a>/<a href="postmodify.html">修改公告</a></div>
        </div>
	    <br />
		<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				
				<html:form action="news.do?post=updatePost">
				<table width="125" cellpadding="0" cellspacing="0" class="listing">
				
					<tr>
						<th class="first" width="121">公告</th>
					</tr>
					<tr>
						<td height="103" class="first style4">
						   <html:textarea property="content" cols="100" rows="4"><%=request.getAttribute("ppb")%></html:textarea></td>
					</tr>
					<tr>					
					<td><input type="submit" value="修改"/></td>
					
					</tr>
			  </table>
			  </html:form>
		</div>
	  </div>
	  <div id="right-column">
			<strong class="h">日期</strong>
			<div class="box">北京时间：<div id="it"></div></div>
	  </div>
	</div>
	<div id="footer"></div>
</div>

<script language="javascript">
$("#test1").toggle(function(){$("#test").slideDown()},function(){$("#test").slideUp()})
$("#test2").toggle(function(){$("#testa").slideDown()},function(){$("#testa").slideUp()})
</script>
</body>
</html:html>
