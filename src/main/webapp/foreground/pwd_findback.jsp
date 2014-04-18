<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwd_findback.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script language="javascript" src="../js/checkform.js"></script>
	<script type="text/javascript">
		function checkIsNull(){
			var uname = document.userform.username.value;
			if(uname == null || uname == ""){
				alert("用户名不可以为空！");
				document.userform.username.focus();
				return false;
			}
		}
		
		var result = "<%=request.getAttribute("result")%>";
		if(result == 0){
			alert("对不起，用户名不存在，请重新输入！");
		}
	</script>
  </head>
  
  <body><center>
<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="home_nologin.jsp">主页</a>&raquo;找回密码</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">找回密码——第一步</td>
          </tr>
          <tr>
            <td class="inputTitle">
	            <html:form action="user.do?method=findBackPassword">
	            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	            	<tr><td colspan="3">&nbsp;</td></tr>	                   
	            	<tr>
	            		<td colspan="3" align="center"><html:img page="/foreground/img/step1.jpg" alt=""/></td>
	            	</tr>     
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">请输入用户名：</td>
	                  <td width="35%" class="inputHeader">
	                  	<html:text property="username" styleClass="text width100"></html:text>
	                  </td>
	                  <td class="inputContent" id="name2"><font color="#CC0000">&nbsp;</font></td>
	                </tr>                              
	                <tr>
	                  <td class="inputContent" align="center" colspan="3">
	                  	<html:submit styleClass="bt1" onclick="return checkIsNull()">下一步</html:submit>
	                  </td>
	                </tr>
	            </table>
	            </html:form>
            </td>
          </tr>
        </table>
    </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html:html>
