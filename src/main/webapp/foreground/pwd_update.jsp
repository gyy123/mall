<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwd_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	
	<script type="text/javascript">
		function checkpw(){
			var password = "${userbean.password}";
			var pw = document.userform.password.value;
			var pw2 = document.userform.password2.value;
			var pw2Confirm = document.userform.password2Confirm.value;
			if(pw == null || pw == ""){
				alert("原密码不能为空！");
				document.userform.password.focus();
				return false;
			}
			if(password != pw){
				alert("原密码输入有误，请重新输入！");
				document.userform.password.value="";
				document.userform.password.focus();
				return false;
			}
			if(pw2 == null || pw2 == ""){
				alert("新密码不能为空！");
				document.userform.password2.focus();
				return false;
			}
			if(pw2Confirm == null || pw2Confirm == ""){
				alert("确认新密码不能为空！");
				document.userform.password2Confirm.focus();
				return false;
			}
			if(pw2 != pw2Confirm){
				alert("两次输入密码不一致，请重新输入！");
				document.userform.password2.value="";
				document.userform.password2Confirm.value="";
				document.userform.password2.focus();
				return false;
			}
		}
		
		var result = '<%=request.getAttribute("result")%>';
		if(result == 1){
			alert("恭喜，密码修改成功，点击【确定】请重新登录...");
			window.open("foreground/login.jsp","_self");
		}
		if(result === 0){
			alert("对不起，密码修改失败，请重新操作！");
		}
	</script>

  </head>
  
  <body><center>
<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="home.htm">主页</a>&raquo;修改密码</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">修改密码</td>
          </tr>
          <tr>
            <td class="inputTitle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
              <html:form action="user.do?method=updatePassword">
                <tr>
                  <td width="35%" align="right" class="inputHeader">用户名：</td>
                  <td width="30%" class="inputContent">
                  	<html:text property="username" value="${userbean.username}" readonly="true" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*不可更改</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">原密码：</td>
                  <td class="inputContent">
                  	<input type="password" name="password" class="text width100"/>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*请输入原密码</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">新密码：</td>
                  <td class="inputContent">
                  	<html:password property="password2"  styleClass="text width100"></html:password>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*请输入6-12位新密码</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">确认新密码：</td>
                  <td class="inputContent">
                  	<input type="password" name="password2Confirm" class="text width100"/>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*请再次输入新密码</font></td>
                </tr>
                <tr>
                  <td colspan="3" align="center" class="inputHeader">
                  	<html:submit styleClass="bt1" onclick="return checkpw()">确定</html:submit>
                  </td>
                </tr>
              </html:form>
            </table></td>
          </tr>
        </table>
    </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
