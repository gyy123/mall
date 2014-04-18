<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
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
		function check(){
			var pw = document.userform.password.value;
			var pw2 = document.getElementById("pwdConfirm").value;
			if(pw==null || pw==""){
				alert("新密码不能为空！");
				document.userform.password.focus();
				return false;
			}
			if(pw2==null || pw2==""){
				alert("确认新密码不能为空！")
				document.getElementById("pwdConfirm").focus();
				return false;
			}
			if(pw != pw2){
				alert("两次输入密码不一致，请重新输入！");
				document.userform.password.value = "";
				document.getElementById("pwdConfirm").value = "";
				document.userform.password.focus();
				return false;
			}
		}
		
		var result = "<%=request.getAttribute("result")%>";
		if(result == 1){
			alert("恭喜，密码修改成功，点击【确定】即将跳转到登录页面...");
			window.open("foreground/login.jsp","_self");
		}
		if(result == 0){
			alert("对不起，密码修改失败，请重新操作！");
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
            <td class="inputTitle">找回密码——第三步</td>
          </tr>
          <tr>
            <td class="inputTitle">
	            <html:form action="user.do?method=findBackPassword2">
	            <html:hidden property="username" value="<%=username %>"/>
	            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	            	<tr><td colspan="3">&nbsp;</td></tr>	 
	                <tr>
	            		<td colspan="3" align="center"><html:img page="/foreground/img/step3.jpg" alt=""/></td>
	            	</tr>
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">新密码：</td>
	                  <td width="35%" class="inputHeader">
	                  	<html:password property="password" styleClass="text width100"></html:password>
	                  </td>
	                  <td class="inputContent" id="name2"><font color="#CC0000">*请输入6-12位密码</font></td>
	                </tr>
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">确认新密码：</td>
	                  <td width="35%" class="inputHeader">
	                  	<input type="password" id="pwdConfirm" class="text width100">
	                  </td>
	                  <td class="inputContent" id="name2"><font color="#CC0000">*请再次输入密码</font></td>
	                </tr>                                
	                <tr>
	                  <td class="inputContent" align="center" colspan="3">
	                  	<html:submit styleClass="bt1" onclick="return check()">确定</html:submit>
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
