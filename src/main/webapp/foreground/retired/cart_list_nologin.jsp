<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
		
  </head>
  
  <body><center>
<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="home.htm">主页</a>&raquo;购物车</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">我的购物车</td>
          </tr>
          <tr>
            <td class="inputTitle">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
            		<tr>
            			<td rowspan="3" width="30%" align="center"><img src="foreground/img/nogoods.jpg" alt="购物车中没有商品"></td>
            			<td class="inputHeader"><b>您的购物车还是空的，赶紧行动吧！您可以选择：</b></td>
            		</tr>
            		<tr>
            			<td class="inputHeader">①如果您还未登录，可能导致购物车为空，请马上<a href="foreground/login.jsp" class="menuLinkSel">登录</a></td>
            		</tr>
            		<tr>
            			<td class="inputHeader">②马上去<a href="foreground/home_nologin.jsp" class="menuLinkSel">挑选商品</a></td>
            		</tr>
            	</table>
            </td>
          </tr>
        </table>
    </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
