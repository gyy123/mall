<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bottom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	
  </head>
  
<body>
<table width="10" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><img src="foreground/img/whole.jpg"></td>
  </tr>
</table>
<table width="770" border="0" cellspacing="0" cellpadding="0" class="pagefoot">
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td class="pagefootTl"><img src="img/space.gif" width="1" height="1"></td>
        </tr>
        <tr align="center">
          <td class="inputTitle">&nbsp;</td>
        </tr>
        <tr align="center">
          <td class="pagefoot"><a href="#" class="menuLinkf" target="_parent">关于窗窗网</a>&nbsp;
            |&nbsp;<a href="#" class="menuLinkf" target="_parent">我们的团队</a>&nbsp;
            |&nbsp;<a href="#" class="menuLinkf" target="_parent">网站联盟</a>&nbsp;
            |&nbsp;<a href="#" class="menuLinkf" target="_parent">诚征英才</a>&nbsp;
            |&nbsp;<a href="#" class="menuLinkf" target="_parent">媒体报道</a>&nbsp;
            |&nbsp;<a href="#" class="menuLinkf" target="_parent">加盟标准</a>&nbsp; </td>
        </tr>
        <tr align="center">
          <td class="pagefoot"><a href="#" class="menuLinkf" target="_parent">经营许可证&nbsp;|&nbsp;京ICP备100000号&nbsp;|&nbsp;营业执照</a></td>
        </tr>
        <tr align="center">
          <td class="pagefoot"><a href="#" class="menuLinkf" target="_parent"> Copyright &copy; 窗窗网上超市 2007-2011，All Rights Reserved</a></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
