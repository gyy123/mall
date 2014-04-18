<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
     <base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/js/jquerynew.js"></script>
	
	<style media="all" type="text/css">@import "background/css/all.css";</style>
	
</head>
<body>
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
			<li class="active"><span><span>管理员权限</span></span></li>
			
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			
            
            <h3><li ><a href="#" id="test2">系统管理员操作</a></li></h3>
            
            
	        <div id="testa" style="width:150px; height:49px">
            <ul class="nav">
				<li><a href="background/addadmin.jsp"> 添加管理员</a></li>
				<li class="last"><a href="background/searchadmins.jsp">查询管理员</a></li>
			</ul> </div>
            
            
			
			
		</div>
		<div id="center-column">
			<div class="top-bar">
				
				<h1>Contents：欢迎，您的权限为系统管理员</h1>
				<div class="breadcrumbs"><a href="background/index.jsp">管理员权限</a> / <a href="searchadmins.html">查询管理员</a>/ <a href="adminmodify.html">修改权限</a></div>
			</div><br />
			<div class="table">
				<img src="background/img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="background/img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing form" cellpadding="0" cellspacing="0">
					<tr>
						<th class="full" colspan="2">修改管理员权限</th>
					</tr>
					<tr>
						<td class="first" width="172"><strong>账号：</strong></td>
						<td class="last">&nbsp;</td>
					</tr>
					
					<tr class="bg">
						<td class="first"><strong>权限：</strong></td>
						<td class="last"><input type="checkbox"/>商品的增加、删除、修改、查询<br/>
						                 <input type="checkbox"/>商品分类的增、删、改、查<br/>
										 <input type="checkbox"/>首页公告的修改，咨询的管理<br/>
										 <input type="checkbox"/>用户密码和详细资料的查询，删除用户<br/>
										 <input type="checkbox"/>商品的增加、删除、修改、查询<br/>
						</td>
					</tr>
					<tr>
						<td  colspan="3"><input type="submit" value="提交"></input><input type="reset" value="重置"></input></td>
					</tr>
				</table>
	        <p>&nbsp;</p>
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
</html>
