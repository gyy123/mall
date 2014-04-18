<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
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
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body><br />
<html:form action="admin.do?service=modifypas">
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li class="active"><span><span>管理员权限</span></span><br /></li>
			
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
				
				<h1>Contents：欢迎，您的权限为普通管理员</h1>
				<div class="breadcrumbs"><a href="index.html">管理员权限</a> / <a href="pasmodify.html">密码修改</a></div>
			</div><br />
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing form" cellpadding="0" cellspacing="0">
					<tr>
						<th class="full" colspan="3">密码修改<br /></th>
					</tr>
					<tr>
						<td width="188" height="42" class="first"><strong>请输入旧密码：</strong><br /></td>
						<td width="231" class="last"><html:text property="passwordold"></html:text><br /></td><td width="192"><font color="red">与旧密码不符,请重新输入</font></td>
					</tr>
					<tr class="bg">
						<td height="43" class="first"><strong>请输入新密码：</strong></td>
						<td class="last"><html:text property="passwordnew"></html:text></td><td>&nbsp;</td>
						
						
						
					</tr>
					<tr>
						<td height="42" class="first""><strong>新密码确认：</strong></td>
						<td class="last"><input type="text"  /></td><td>&nbsp;</td>
					</tr>
					<tr>
					  <td height="30"  colspan="3"><html:submit>提交</html:submit></td>
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
</html:form>
</body>
</html:html>
