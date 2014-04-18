<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'huikuan_confirm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	

  </head>
  
  <body><center>
<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td height="15">
    	<a href="foreground/home.jsp">主页</a>&raquo;
    	<a href="foreground/cart_list.jsp">我的购物车</a>&raquo;
      确认邮寄支付信息&raquo;
      确认订单</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">商品清单</td>
          </tr>
          <tr>
            <td class="inputHeader"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="14%" class="inputHeader">商品编号</td>
                  <td width="35%" align="center" class="inputHeader">&nbsp;商品名</td>
                  <td width="14%" align="center" class="inputContent">单价</td>
                  <td width="14%" align="center" class="inputContent">购买数量</td>
                  <td align="center" class="inputContent">您的价格</td>
                </tr>
                <tr>
                  <td align="center" class="inputHeader"><font color="#CC0000"><b>1</b></font></td>
                  <td align="center" class="inputHeader"><a href="item_info.htm">大学物理学.第四册：波动与光学（第2版）</a></td>
                  <td align="center" class="inputHeader">￥10.00</td>
                  <td align="center" class="inputContent">1</td>
                  <td align="center" class="inputHeader">￥8.50</td>
                </tr>
                <tr>
                  <td align="center" class="inputHeader"><font color="#CC0000"><b>2</b></font></td>
                  <td align="center" class="inputHeader">大学物理学.第一册：力学（第2版）</td>
                  <td align="center" class="inputHeader">￥16.00</td>
                  <td align="center" class="inputContent">1</td>
                  <td align="center" class="inputHeader">￥13.60</td>
                </tr>
                <tr>
                  <td align="center" class="inputHeader">总价：</td>
                  <td colspan="4" align="left" class="inputHeader"><font color="#CC0000"><b>商品价格:￥22.10 + 送货费:￥5.00 = ￥25.10</b></font></td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td class="inputTitle">邮寄信息</td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="40%" align="right" class="inputHeader">收货人姓名：</td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">收货人地址：</td>
                  <td class="inputContent">北京市海淀区翠微路甲5号</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">收货人电话：</td>
                  <td class="inputContent">13812345678</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">收货人邮编：</td>
                  <td class="inputContent">066004</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄方式：</td>
                  <td class="inputContent">顺风快递</td>
                </tr>
                <tr>
                  <td height="22" align="right" class="inputHeader">支付方式：</td>
                  <td class="inputContent">邮局汇款</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td align="right" class="inputContent"> 请仔细核查信息，确定无误后请点击：
                    <button onClick="location='personal_order_success.htm'" class="bt1">确认</button></td>
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
