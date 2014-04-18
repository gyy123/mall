<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("total",request.getParameter("totalPrice"));
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
	<script type="text/javascript">
		function checkForm(){
			var name = document.forms[0].username.value.replace(/(^\s*)|(\s*$)/g, "");
			if(name==""||name==null){
				alert("收件人姓名不能为空！");
				document.forms[0].username.focus();
				return false;
			}
			var phone = document.forms[0].phone.value.replace(/(^\s*)|(\s*$)/g, "");
			if(phone==""||phone==null){
				alert("电话不能为空！");
				document.forms[0].phone.focus();
				return false;
			}
			var address = document.forms[0].address.value.replace(/(^\s*)|(\s*$)/g, "");
			if(address==""||address==null){
				alert("邮寄地址不能为空！");
				document.forms[0].address.focus();
				return false;
			}
			var postcode = document.forms[0].postcode.value.replace(/(^\s*)|(\s*$)/g, "");
			if(postcode==""||postcode==null){
				alert("邮政编码不能为空！");
				document.forms[0].postcode.focus();
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
    <td height="15"><a href="foreground/home.jsp">主页</a>&raquo;<a href="foreground/cart_list.jsp">我的购物车</a>&raquo;确认邮寄支付信息</td>
  </tr>
  <tr>
	      <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;<html:img page="/foreground/img/shop2.jpg" alt=""/></td>
  </tr>
</table>
  <table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
    <tr valign="top">
      <td>
      	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td colspan="2">
            <html:form action="order.do?method=addOrder&total=${total}">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td colspan="3" class="inputTitle">请确认邮寄支付信息</td>
                </tr>
                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                <logic:empty name="userbean">
                <tr height="20">
                  <td width="35%" align="right" class="inputHeader">收件人姓名：</td>
                  <td width="35%">
                  	<html:text property="username" styleClass="text width100"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right">收件人电话：</td>
                  <td>
                  	<html:text property="phone" styleClass="text width100" maxlength="15"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right" class="inputHeader">邮寄地址：</td>
                  <td align="left">
                  	<html:text property="address" styleClass="text width100"></html:text>
                  </td>
                  <td align="left">&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right">邮政编码：</td>
                  <td>
                  	<html:text property="postcode" styleClass="text width100" maxlength="6"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>                
                <tr height="20">
                  <td align="right" class="inputHeader">邮寄方式：</td>
                  <td>
                  	<html:radio property="post_type" value="0">平邮</html:radio>
                  	<html:radio property="post_type" value="1">快递</html:radio>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                </logic:empty>
                
                <logic:notEmpty name="userbean">
                <tr height="20">
                  <td width="35%" align="right" class="inputHeader">收件人姓名：</td>
                  <td width="35%">
                  	<html:text property="username" value="${userbean.username}" styleClass="text width100"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right" class="inputHeader">收件人电话：</td>
                  <td>
                  	<html:text property="phone" value="${userbean.phone}" styleClass="text width100" maxlength="15"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right" class="inputHeader">邮寄地址：</td>
                  <td align="left">
                  	<html:text property="address" value="${userbean.address}" styleClass="text width100"></html:text>
                  </td>
                  <td align="left">&nbsp;</td>
                </tr>
                <tr height="20">
                  <td align="right" class="inputHeader">邮政编码：</td>
                  <td>
                  	<html:text property="postcode" value="${userbean.postcode}" styleClass="text width100" maxlength="6"></html:text>
                  </td>
                  <td>&nbsp;</td>
                </tr>                
                <tr height="20">
                  <td align="right" class="inputHeader">邮寄方式：</td>
                  <td>
                  	<html:radio property="post_type" value="0">平邮</html:radio>
                  	<html:radio property="post_type" value="1">快递</html:radio>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                </logic:notEmpty>                
                
                <tr height="20">
                  <td width="35%" align="right">支付方式：</td>
                  <td width="30%">
                  	<html:radio property="pay_type" value="0">邮局汇款</html:radio>
                  	<html:radio property="pay_type" value="1">网上银行转账</html:radio>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                </table>
				<tr>
				  <td colspan="2"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
				      <tr>
						<td colspan="4" class="inputTitle">商品清单</td>
					  </tr>
				      <tr class="titlegrey" height="25">
				        <td width="20%" align="center">商品编号</td>
				        <td width="40%" align="center">商品名称</td>
				        <td width="20%" align="center">购买单价</td>
				        <td align="center">购买数量</td>
				      </tr>
				      
				      <logic:iterate id="p" name="mycart" indexId="index">
				      <tr>
				        <td align="center" class="inputHeader"><bean:write name="p" property="productseq"/></td>
				        <td align="center" class="inputHeader">
				        	<a href="product.do?service=queryProductDetail&product_SEQ=${p.productseq}">
				        		<FONT color="red"><bean:write name="p" property="productname"/></FONT>
				        	</a>
				        </td>
				        <td align="center" class="inputHeader">￥<bean:write name="p" property="price"/></td>
				        <td align="center" class="inputContent">1<bean:write name="p" property="num"/></td>
				      </tr>
				      </logic:iterate>
				      
				      <tr height="30">
				        <td colspan="3" align="right"><font color="#CC0000"><b>您一共需要支付：</b></font></td>
				        <td align="center"><font color="#CC0000"><b>￥<%=request.getParameter("totalPrice") %></b></font></td>
				      </tr>
				    </table></td>
				</tr>				                
                <tr>
                  <td colspan="3" align="center" class="inputHeader">
                  	<a href="javascript:window.back()"><img src="foreground/img/pre.png" alt="上一步" border="0" align="top"/></a>
                  	<html:submit onclick="return checkForm()" styleClass="bt1">确认订单</html:submit>
                  </td>
                </tr>
           	</html:form>
           	</td>
          </tr>
        </table></td>
    </tr>
  </table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html:html>
