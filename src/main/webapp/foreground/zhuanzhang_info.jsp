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
    
    <title>My JSP 'zhuanzhang_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script type="text/javascript">
		function checkForm(){
			var pay_cardId = document.getElementById("pay_cardId").value;
			var card_pw = document.getElementById("card_pw").value;
			var total = document.getElementById("total").value;
			var paid_cardId = document.getElementById("paid_cardId").value;
			var totalPrice = document.getElementById("totalPrice").value;
			if(pay_cardId==""){
				alert("付款人卡号不能为空，请输入！");
				document.getElementById("pay_cardId").focus();
				return false;
			}else if(card_pw==""){
				alert("卡号密码不能为空，请输入！");
				document.getElementById("card_pw").focus();
				return false;
			}else if(total==""){
				alert("付款金额不能为空，请输入！");
				document.getElementById("total").focus();
				return false;
			}else if(total!=totalPrice){
				alert("付款金额与订单金额不一致！");
				document.getElementById("total").value="";
				document.getElementById("total").focus();
				return false;
			}else if(paid_cardId==""){
				alert("收款人卡号不能为空，请输入！");
				document.getElementById("paid_cardId").focus();
				return false;
			}			
		}	
	</script>

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
    <td height="17"><a href="home.htm">主页</a>&raquo;确认邮寄支付信息&raquo;确认转账信息</td>
  </tr>
  <tr>
	      <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;<html:img page="/foreground/img/shop2.jpg" alt=""/></td>
  </tr>
</table>
  <table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
    <tr valign="top">
      <td>
	      <html:form action="order.do?method=updateOrder">
	      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	          <tr>
	            <td colspan="3" class="inputTitle">请确认转账信息</td>
	          </tr>
	          <tr>
	            <td width="35%" align="right" class="inputHeader">订单号：</td>
	            <td width="35%" class="inputHeader">
	            	<html:text property="order_SEQ" readonly="true" value="${order_SEQ}" styleClass="text width100"></html:text>
	            </td>
	            <td class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right" class="inputHeader">订单金额：</td>
	            <td align="left" class="inputHeader">
	            	<html:text property="total" styleId="totalPrice" readonly="true" value="${total}" styleClass="text width100"></html:text>
	            </td>
	            <td align="left" class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right" class="inputHeader">付款人卡号：</td>
	            <td align="left" class="inputHeader"><label>
	              <input class="text width100" type="text" name="pay_cardId" id="pay_cardId">
	              </label></td>
	            <td align="left" class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right" class="inputHeader">银行卡密码：</td>
	            <td align="left" class="inputHeader"><input class="text width100" type="password" name="card_pw" id="card_pw"></td>
	            <td align="left" class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right" class="inputHeader">付款金额：</td>
	            <td align="left" class="inputHeader"><input class="text width100" type="text" name="total" id="total"></td>
	            <td align="left" class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td align="right" class="inputHeader">收款人卡号：</td>
	            <td align="left" class="inputHeader"><input class="text width100" type="text" name="paid_cardId" id="paid_cardId"></td>
	            <td align="left" class="inputHeader">&nbsp;</td>
	          </tr>
	          <tr>
	            <td colspan="3" align="center" class="inputHeader">
	            	<html:submit onclick="return checkForm();" styleClass="bt1">确认转账</html:submit>
	            </td>
	          </tr>
	        </table>
	        </html:form>
       </td>
    </tr>
  </table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html:html>
