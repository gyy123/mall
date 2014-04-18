<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head> <base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/jquery.js"></script>
	<script language="javascript" src="background/js/showo_page.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body>
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><html:img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li><span><span><a href="background/index.jsp">管理员权限</a></span></span></li>
			<li><span><span><a href="goods_index.html">商品管理</a></span></span></li>
			<li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
<<<<<<< news.jsp
			<li class="active"><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
=======
			<li class="active"><span><span><a href="news.html">新闻管理</a></span></span></li>
			<li><span><span><a href="order.html">订单管理</a></span></span></li>
			<li><span><span><a href="total.html">销售统计</a></span></span></li>
>>>>>>> 1.7
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			<h3><li><a href="#" id="test1">新闻管理</a></li></h3>
            
            
	        <div id="test" style="width:150px; height:50px">
            <ul class="nav">
				
				<li><a href="/ccMall_gj3_g9/news.do?post=queryInformation">资讯管理</a></li>
                <li><a href="/ccMall_gj3_g9/news.do?post=queryPost"> 公告管理</a></li>
			</ul> </div>
            
           
            
            
			
		</div>
        
	  <div id="center-column">
	    <div class="top-bar">
          <h1>新闻管理</h1>
	      <div class="breadcrumbs"><a href="index.html">新闻管理</a> </div>
        </div>
	    <br />
		<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="179">资讯</th>
						<th class="first" width="148">资讯类型</th>
						<th width="90">查看</th>
						<th width="90">修改</th>
						<th width="90" class="last">删除</th>
					</tr>
					<tr>
						<td class="first style1">- Lorem Ipsum </td>
						<td class="first style1">未发布</td>
						<td><a href="information_details.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
						<td><a href="information_modify.html"><img src="img/edit-icon.gif" width="16" height="16" alt="" /></a></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					
					<tr>
						<td colspan="5">
							<input type="button" value="添加" onclick="location='information_add.html'"/>						</td>
					</tr>
				</table>
				<Script Language=JavaScript >
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,4)
		</Script>
		</div>
	  </div>
	  <div id="right-column">
			<strong class="h">日期</strong>
			<div class="box">今天是</div>
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
