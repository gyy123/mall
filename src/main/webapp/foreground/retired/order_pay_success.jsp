<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order_pay_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">

  </head>
  
 <body><center>
 	<logic:empty name="userbean">
		<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
	</logic:empty>
	<logic:notEmpty name="userbean">
		<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
	</logic:notEmpty>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
	  <tr>
	    <td><a href="cart_list.htm"></a> 购物车&raquo; <a href="order_confirm.htm">确认订单</a>&raquo;订单支付确认信息</td>
	  </tr>
	  <tr>
	      <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;<html:img page="/foreground/img/shop3.jpg" alt=""/></td>
  </tr>
	</table>
	<table width="770" border="1" cellpadding="0" cellspacing="0" class="main">
	  <tr valign="top">
	    <td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
			  <tr>
			    <td class="inputTitle">订单支付成功信息</td>
			  </tr>
			  <tr>
			    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr>
			          <td align="center" class="inputContent"><H3>您的订单已支付成功，请牢记您的订单号！</H3></td>
			        </tr>
			        <tr>
			          <td align="center" class="inputContent"><H3><FONT color="red"><bean:write name="order_SEQ"/></FONT></H3></td>
			        </tr>                
					<tr>
						<a href="foreground/home.jsp">
                        	<img src="foreground/img/jixugouwu.png" align="absmiddle" alt="继续购物" border="0">
                    	</a>
					</tr>
			   </table></td>
			  </tr>
			</table>
		</td>
	  </tr> 
	</table>	   
	<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
