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
    
    <title>My JSP 'personal_order_info.jsp' starting page</title>
    
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
    <td height="17"><a href="home.htm">主页</a>&raquo;<a href="personal_order_query.html">订单查询</a>&raquo;订单详情</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">配送信息</td>
          </tr>
          <tr>
            <td class="inputTitle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="15%" align="right" class="inputHeader">订单号：</td>
                  <td width="35%" class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="order_SEQ"/></td>
                  <td width="15%" align="right" class="inputHeader">收货人姓名：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="username"/></td>
                </tr>
                <tr bgcolor="#ECECEC">
                  <td width="8%" align="right" class="inputHeader">订单金额：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="total"/></td>
                  <td align="right" class="inputHeader">收货人地址：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="address"/></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">下单时间：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="issue_date"/></td>
                  <td align="right" class="inputHeader">收货人邮编：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="postcode"/></td>
                </tr>
                <tr bgcolor="#ECECEC">
                  <td width="8%" align="right" class="inputHeader">订单状态：</td>
                  <logic:equal name="orderbean" property="status" value="1">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;新订单</td>
                  </logic:equal>
                  <logic:equal name="orderbean" property="status" value="2">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;已支付订单</td>
                  </logic:equal>
                  <logic:equal name="orderbean" property="status" value="3">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;已发货订单</td>
                  </logic:equal>
                  <logic:equal name="orderbean" property="status" value="4">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;已作废订单</td>
                  </logic:equal>
                  <td align="right" class="inputHeader">联系电话：</td>
                  <td class="inputHeader">&nbsp;&nbsp;&nbsp;<bean:write name="orderbean" property="phone"/></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄方式：</td>
                  <logic:equal name="orderbean" property="post_type" value="0">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;平邮</td>
                  </logic:equal>
                  <logic:equal name="orderbean" property="post_type" value="1">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;快递</td>
                  </logic:equal>                  
                  <td align="right" class="inputHeader">支付方式：</td>
                  <logic:equal name="orderbean" property="pay_type" value="0">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;邮局汇款</td>
                  </logic:equal>
                  <logic:equal name="orderbean" property="pay_type" value="1">
                  	<td class="inputHeader">&nbsp;&nbsp;&nbsp;网上银行转账</td>
                  </logic:equal>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td class="inputTitle">商品信息</td>
          </tr>
          <tr>
            <td class="inputTitle">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	                <tr>
	                  <td width="15%" align="center" class="titlegrey">商品编号</td>
	                  <td width="35%" align="center" class="titlegrey">商品名称</td>
	                  <td width="15%" align="center" class="titlegrey">商品类别</td>
	                  <td width="20%" align="center" class="titlegrey">商品单价</td>
	                  <td align="center" class="titlegrey">数量</td>
	                </tr>
	               	
	                <logic:iterate id="p" name="orderbean" property="list_opb">
		                <tr>
		                  <td align="center" class="inputContent"><bean:write name="p" property="id"/></td>
		                  <td align="center" class="inputContent"><bean:write name="p" property="name"/></td>
		                  <td align="center" class="inputContent">
		                  	<bean:write name="p" property="main_value"/>-
		                  	<bean:write name="p" property="sub_value"/>	
		                  </td>
		                  <td align="center" class="inputContent">￥<bean:write name="p" property="price"/></td>
		                  <td align="center" class="inputContent"><bean:write name="p" property="num"/></td>
		                </tr>
	                </logic:iterate>
              </table>
            </td>
          </tr>
          <tr>
            <td align="center">
            	<a href="javascript:window.back()"><img src="foreground/img/back.gif" border="0" alt="返回"/></a>
            </td>
          </tr>
        </table>
      </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
</center></body>
</html>
