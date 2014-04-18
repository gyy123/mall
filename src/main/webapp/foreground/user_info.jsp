<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	

  </head>
  
  <body><center>

<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="foreground/home.jsp">主页</a>&raquo;查询个人信息</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
        <tr>
          <td class="inputTitle" >查看个人信息</td>
        </tr>
        <tr>
          <td class="inputTitle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
              <tr>
                <td width="45%" class="inputHeader" align="right">用户名：</td>
                <td class="inputContent"><bean:write name="userbean" property="username"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">真实姓名：</td>
                <td class="inputContent"><bean:write name="userbean" property="truename"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">身份证号：</td>
                <td class="inputContent"><bean:write name="userbean" property="id_card"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">电子邮箱：</td>
                <td class="inputContent"><bean:write name="userbean" property="email"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">邮政编码：</td>
                <td class="inputContent"><bean:write name="userbean" property="postcode"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">邮寄地址：</td>
                <td class="inputContent"><bean:write name="userbean" property="address"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">联系电话：</td>
                <td class="inputContent"><bean:write name="userbean" property="phone"/></td>
              </tr>
              <tr>
                <td align="right" class="inputHeader">注册时间：</td>
                <td class="inputContent"><bean:write name="userbean" property="registerdate"/></td>
              </tr>
              <tr>
                <td colspan="2" align="center">
                	<a href="foreground/user_info_update.jsp"><img src="foreground/img/infor.gif" border="0"/></a></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>

  </center></body>
</html>
