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
    
    <title>用户登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	
	<script type="text/javascript">
		var result = "<%=request.getAttribute("result")%>";
		if(result==1){
			alert("恭喜，登录成功！点击【确定】即将跳转。。。");
			window.open("foreground/home.jsp","_self");
		}
		if(result==0){
			alert("对不起，登录失败，请重新登录！");
		}
	</script>
	<script type="text/javascript">
		function checkIsNull(){
			var name=document.forms[0].username.value.replace(/(^\s*)|(\s*$)/g, "");
			if(name=="" || name==null){
				alert("用户名不能为空或空格！");
				document.forms[0].username.focus();
				return false;
			}
			var pw=document.forms[0].password.value.replace(/(^\s*)|(\s*$)/g, "");
			if(pw=="" || pw==null){
				alert("密码不能为空或空格！");
				document.forms[0].password.focus();
				return false;
			}
		}
	</script>

  </head>
  
  <body>
<center>
<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="home.htm">主页</a> &raquo;用户登录</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">用户登录</td>
          </tr>
          <tr>
            <td class="inputTitle">
            	<html:form action="user.do?method=login">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="35%" align="right" class="inputHeader">用户名：</td>
                  <td width="35%" align="center" class="inputContent"><html:text property="username" styleClass="text width100"></html:text></td>
                  <td align="center" class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                  <td align="center" class="inputContent"><html:password property="password" styleClass="text width100"></html:password></td>
                  <td align="center" class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="center" class="inputHeader">&nbsp;</td>
                  <td align="left" class="inputContent">
               		<html:checkbox property="remember" value="true">记住我</html:checkbox> 	
                  	<a href="foreground/pwd_findback.jsp"><font color="red">&nbsp;&nbsp;&nbsp;忘记密码？</font></a></td>
                  <td align="center" class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td colspan="3" align="center" class="inputHeader"><html:submit onclick="return checkIsNull()" value="登陆" styleClass="bt1"/></td>
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
 </center> 
 </body>
</html:html>
