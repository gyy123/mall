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
    
    <title>My JSP 'user_info_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	
	<script type="text/javascript">
		var result = "<%=request.getAttribute("result")%>";
		if(result == 1){
			alert("恭喜，修改成功，点击【确定】即将跳转到个人信息查看页面...");
			window.open("foreground/user_info.jsp","_self");
		}
		if(result == 0){
			aler("对不起，修改失败，请重新修改！");
		}
	</script>

  </head>
  
  <body><center>
<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="foreground/home.jsp">主页</a>&raquo;修改个人信息</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr><td class="inputTitle" >修改个人信息</td></tr>
          <tr>
            <td class="inputTitle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
              <html:form action="user.do?method=updateUser">
                <tr>
                  <td width="35%" class="inputHeader" align="right">用户名：</td>
                  <td width="35%" class="inputContent">
                  	<html:text property="username" value="${userbean.username}" readonly="true" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent" id="name2"><font color="#CC0000">*不可改</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">真实姓名：</td>
                  <td class="inputContent">
                  	<html:text property="truename" value="${userbean.truename}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项 </font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">身份证号：</td>
                  <td class="inputContent">
                  	<html:text property="id_card" value="${userbean.id_card}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">电子邮箱：</td>
                  <td class="inputContent">
                  	<html:text property="email" value="${userbean.email}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent" id="email2"><font color="#CC0000">*必填项 </font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮政编码：</td>
                  <td class="inputContent">
                  	<html:text property="postcode" value="${userbean.postcode}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄地址：</td>
                  <td class="inputContent">
                  	<html:text property="address" value="${userbean.address}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">联系电话：</td>
                  <td class="inputContent">
                  	<html:text property="phone" value="${userbean.phone}" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td colspan="3" align="center" class="inputHeader">
                  	<html:submit onclick="checkform()" styleClass="bt1">确定</html:submit>
                  </td>
                </tr>
              </html:form></table>
            </td>
          </tr>
        </table>
      </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
