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
    
    <title>My JSP 'pay_info.jsp' starting page</title>
    
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
    <td height="17"><a href="home.htm">主页</a> &raquo;确认邮寄信息 &raquo;确认支付方式</td>
  </tr>
</table>
<form action="" method="post" enctype="multipart/form-data" name="form1">
  <table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
    <tr valign="top">
      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td colspan="2">
            <html:form action="order.do?method=addOrder">
	            <table width="100%" border="1" cellpadding="0" cellspacing="0" class="inputTable">
	                <tr>
	                  <td colspan="3" class="inputTitle">请确认支付方式</td>
	                </tr>
	                <tr>
	                  <td width="35%" align="right" class="inputHeader">支付方式：</td>
	                  <td width="30%" class="inputHeader">
	                  	<html:radio property="pay_type" value="0">邮局汇款</html:radio>
	                  </td>
	                  <td class="inputHeader">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td align="left" class="inputHeader">&nbsp;</td>
	                  <td align="left" class="inputHeader">
	                  	<html:radio property="pay_type" value="1">网上银行转账</html:radio>
	                  </td>
	                  <td align="left" class="inputHeader">&nbsp;</td>
	                </tr>
	                <tr>
	                  <td colspan="3" align="center" class="inputHeader">
	                    <html:button property="" onclick="location='foreground/post_info.jsp'" styleClass="bt1">上一步</html:button>
	                    <html:button property="" onclick="location='foreground/huikuan_confirm.jsp'" styleClass="bt1">下一步</html:button>
	                  </td>
	                </tr>
	            </table>
            </html:form>
            </td>
          </tr>
        </table></td>
    </tr>
  </table>
</form>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html:html>
