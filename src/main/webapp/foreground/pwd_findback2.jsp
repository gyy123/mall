<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
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
		function check(){
			var answer = document.getElementById("answer").value;
			if(answer == null || answer == ""){
				alert("答案不可以为空！");
				document.getElementById("answer").focus();
				return false;
			}
			var answer_db = "${userbean.answer}";
			if(answer != answer_db){
				alert("对不起，问题答案不正确，请重新输入！");
				return false;
			}else{
				window.open("foreground/pwd_findback3.jsp?username=${userbean.username}","_self");
			}			
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
            <td class="inputTitle">找回密码——第二步</td>
          </tr>
          <tr>
            <td class="inputTitle">
	            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	            	<tr><td colspan="3">&nbsp;</td></tr>	 
	                <tr>
	            		<td colspan="3" align="center"><html:img page="/foreground/img/step2.jpg" alt=""/></td>
	            	</tr>
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">提示问题：</td>
	                  <td width="35%" class="inputHeader">
	                  	<bean:write name="userbean" property="question"/>
	                  </td>
	                  <td class="inputContent" id="name2"><font color="#CC0000">&nbsp;</font></td>
	                </tr>
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">问题答案：</td>
	                  <td width="35%" class="inputHeader">
	                  	<input type="text" id="answer" class="text width100"/>
	                  </td>
	                  <td class="inputContent" id="name2"><font color="#CC0000">&nbsp;</font></td>
	                </tr>                                
	                <tr>
	                  <td class="inputContent" align="center" colspan="3">
	                  	<button class="bt1" onclick="return check()">下一步</button>
	                  </td>
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
</html:html>
