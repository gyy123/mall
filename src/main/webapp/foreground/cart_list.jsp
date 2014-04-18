<%@ page language="java" import="java.util.*,com.neusoft.ccmall.bean.CartBean" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// 从session中取出购物车
ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
// 遍历集合，统计所有商品的总价
double totalPrice = 0;
if(mycart != null){
	for(int i=0; i<mycart.size(); i++){
		CartBean cb = mycart.get(i);
		// 单价
		double price = cb.getPrice();
		// 数量
		double num = cb.getNum();
		// 算出总价，加到totalPrice上
		totalPrice += price*num;
	}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	
	<script language="javascript" src="../js/checkform.js">
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
    <td height="17"><a href="home.htm">主页</a>&raquo;购物车</td>
  </tr>
  <tr>
	      <td  align="left">&nbsp;&nbsp;&nbsp;&nbsp;<html:img page="/foreground/img/shop1.jpg" alt=""/></td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">我的购物车</td>
          </tr>
          
          
          <logic:empty name="mycart">
          	<tr>
	            <td class="inputTitle">
	            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	            		<tr>
	            			<td rowspan="3" width="30%" align="center"><img src="foreground/img/nogoods.jpg" alt="购物车中没有商品"></td>
	            			<td class="inputHeader"><b>您的购物车还是空的，赶紧行动吧！您可以选择：</b></td>
	            		</tr>
	            		<tr>
	            			<td class="inputHeader">①如果您还未登录，可能导致购物车为空，请马上<a href="foreground/login.jsp" class="menuLinkSel">登录</a></td>
	            		</tr>
	            		<tr>
	            			<td class="inputHeader">②马上去<a href="foreground/home.jsp" class="menuLinkSel">挑选商品</a></td>
	            		</tr>
	            	</table>
	            </td>
	          </tr>
          </logic:empty>
          
          
          <logic:notEmpty name="mycart">        
          <tr>
            <td class="inputTitle">
              <html:form action="cart.do?method=emptyMyCart">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="15%" align="center" class="titlegrey">商品编号</td>
                  <td width="35%" align="center" class="titlegrey">商品名称</td>
                  <td width="15%" align="center" class="titlegrey">商品单价</td>
                  <td width="20%" align="center" class="titlegrey">购买数量</td>
                  <td align="center" class="titlegrey">删除</td>
                </tr>
                <logic:iterate id="p" name="mycart" indexId="index">
                <tr bgcolor="<%=(index.intValue()%2==0)?"":"#ECECEC" %>">
                  <td align="center" class="inputHeader"><bean:write name="p" property="productseq"/></td>
                  <td align="center" class="inputHeader">
                  	<a href="foreground/item_info.jsp">
                  		<font color="#CC0000"><b><bean:write name="p" property="productname"/></b></font>
                  	</a>
                  </td>
                  <td align="center" class="inputHeader">￥<bean:write name="p" property="price"/></td>
                  <td align="center" class="inputHeader">
                  	<a href="cart.do?method=cutCount&productseq=${p.productseq}" onclick="checkIsOne()">
                  		<img src="foreground/img/decrease.jpg" align="absmiddle" border="0" alt="-"/>
                  	</a>
                  	<html:text property="${p.productseq}" value="${p.num}" size="5"></html:text>
                    <a href="cart.do?method=addCount&productseq=${p.productseq}">
                    	<img src="foreground/img/increase.jpg" align="absmiddle" border="0" alt="+"/>
                    </a>
                  </td>
                  <td align="center" class="inputHeader">
                  	<a onClick="return confirm('您确定要取消购买吗？')" href="cart.do?method=deleteFromMyCart&productseq=${p.productseq}">
                  		<img src="foreground/img/delete.png" width="15" height="15" border="0" alt="取消购买">
                  	</a>
                  </td>
                </tr>
                </logic:iterate>
                <tr>
                  <td colspan="6" align="left" class="inputHeader"><table width="100%" border="0">
                      <tr>
                        <td width="30%">
                        	<a href="foreground/home.jsp">
                        		<img src="foreground/img/jixugouwu.png" align="absmiddle" alt="继续购物" border="0">
                        	</a>
                        </td>
                        <td width="30%" align="center"><html:submit styleClass="bt1" value="清空"></html:submit>
                        </td>
                        <td align="right">
                        	<b>您一共选择了价值<font color="red">￥<%=totalPrice %></font>的商品</b>&nbsp;&nbsp;&nbsp;
                        	<a href="foreground/order_info.jsp?totalPrice=<%=totalPrice %>">
                        		<img src="foreground/img/pay.png" align="absmiddle" alt="结算" border="0">
                        	</a>
                        </td>
                      </tr>
                  </table></td>
                </tr>
              	</table>
             </html:form>
            </td>
          </tr>
          </logic:notEmpty>
          
          
        </table>
    </td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
