<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'post_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script language="javascript" src="../js/checkform.js"></script>

  </head>
  
  <body><center>
<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td height="15"><a href="home.htm">主页</a>&raquo;确认邮寄信息</td>
  </tr>
</table>
  <table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
    <tr valign="top">
      <td>
      	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td colspan="2">
            <html:form action="order.do?method=addOrder">
            	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="inputTable">
                <tr>
                  <td colspan="3" class="inputTitle">请确认邮寄信息</td>
                </tr>
                <tr>
                  <td width="35%" align="right" class="inputHeader">收件人姓名：</td>
                  <td width="35%" class="inputHeader">
                  	<html:text property="username" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputHeader">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">收件人电话：</td>
                  <td class="inputHeader">
                  	<html:text property="phone" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputHeader">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄方式：</td>
                  <td class="inputHeader">
                  	<html:radio property="post_type" value="0">平邮</html:radio>
                  	<html:radio property="post_type" value="1">快递</html:radio>
                  </td>
                  <td class="inputHeader">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄地址：</td>
                  <td align="left" class="inputHeader">
                  	<html:text property="address" styleClass="text width100"></html:text>
                  </td>
                  <td align="left" class="inputHeader">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮编：</td>
                  <td class="inputHeader">
                  	<html:text property="postcode" styleClass="text width100"></html:text>
                  </td>
                  <td class="inputHeader">&nbsp;</td>
                </tr>
                <tr>
                  <td colspan="3" align="center" class="inputHeader">
                  	<html:button property="" onclick="location='foreground/cart_list.jsp'" styleClass="bt1">上一步</html:button>
                    <html:button property="" onclick="location='foreground/pay_info.jsp'" styleClass="bt1">下一步</html:button>
                  </td>
                </tr>
              	</table>
           	</html:form>
           	</td>
          </tr>
        </table></td>
    </tr>
  </table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html:html>
