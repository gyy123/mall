<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'item_search_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script language="javascript">
	function clear(){	
	document.form1.webUserEntity.name="";
	document.form1.webUserEntity.address="";
	document.form1.webUserEntity.postcode="";
	document.form1.webUserEntity.phone="";
	}
	</script>
	<script src="foreground/js/showo_page.js" type="text/javascript">
		var Startime,Endtime;
		var st=new Date();
		Startime=st.getTime();
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
    <td height="17"><a href="home.htm">主页</a>&raquo;商品搜索</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td><form action="" method="post" enctype="multipart/form-data" name="form1">
        <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable">
        
          <tr>
            <td class="inputTitle">搜索结果</td>
          </tr>
          <logic:iterate id="admin" name="selectproduct" indexId="index">
          <tr>
            <td class="inputHeader">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="10%" rowspan="5" align="center" class="inputHeader"><font color="#CC0000"><%=index+1 %></font></td>
                  <td width="15%" rowspan="5" align="center" class="inputHeader">
                  	<a href="product.do?service=queryProductDetail&product_SEQ=${admin.product_SEQ}">
                  		<img src="foreground/img/dxwl4.jpg" alt="大学物理第4册" width="69" height="100" border="0">
                  	</a>
                  </td>
                  <td width="10%"align="right" class="inputHeader">商品名称：</td>
                  <td><font color="#CC0000"><b><bean:write name="admin" property="name"/></b></font></td>
                </tr>
                <tr>
                  <td width="10%" align="right" class="inputHeader">商品价格：</td>
                  <td align="left" class="inputHeader"><bean:write name="admin" property="price"/></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">商品类别：</td>
                  <td align="left" class="inputHeader"><bean:write name="admin" property="main_value"/>-<bean:write name="admin" property="sub_value"/></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">库存量：</td>
                  <td align="left" class="inputHeader"><bean:write name="admin" property="num"/></td>
                </tr>
                <tr>
                  <td colspan="2" align="left" class="inputHeader">
                  	<a href="cart.do?method=addToMyCart&productseq=${admin.product_SEQ}&productname=${admin.name}&price=${admin.price}">
                  		<img src="foreground/img/pro_details_buyicon.jpg" alt="放入购物车" width="104" height="27" border="0">
                  	</a>
                  </td>
                </tr>                
               
              </table></td>
          </tr></logic:iterate>
        </table>
      </form></td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="130" scrolling="no"></iframe>
  </center></body>
</html>
