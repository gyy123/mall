<%@ page language="java" import="java.util.*,com.neusoft.ccmall.bean.PageBean" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'personal_order_query.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script type="text/javascript" src="foreground/js/calendar.js"></script>
	<script type="text/javascript">
		function checkIsNull(){
			var user = "${userbean}";
			var id = document.forms[0].order_SEQ.value.replace(/(^\s*)|(\s*$)/g, "");
			var fromdate = document.forms[0].fromDate.value;
			var todate = document.forms[0].toDate.value;
			if(user==""){
				if(id==""){
					alert("订单号不能为空！");
					document.forms[0].order_SEQ.focus();
					return false;
				}
				if(fromdate==""){
					alert("起始时间不能为空！");
					document.forms[0].fromDate.focus();
					return false;
				}
				if(todate==""){
					alert("结束时间不能为空！");
					document.forms[0].toDate.focus();
					return false;
				}
			}else{
				if(fromdate==""){
					alert("起始时间不能为空！");
					document.forms[0].fromDate.focus();
					return false;
				}
				if(todate==""){
					alert("结束时间不能为空！");
					document.forms[0].toDate.focus();
					return false;
				}
			}			
		}		
	</script>
  </head>
  
  <body>
  <center>
  	<logic:empty name="userbean">
		<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
	</logic:empty>
	<logic:notEmpty name="userbean">
		<iframe src="foreground/top.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
	</logic:notEmpty>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
	  <tr>
	    <td height="17"><a href="home.htm">主页</a> &raquo;订单查询</td>
	  </tr>
	</table>
	<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
	  <tr valign="top">
	    <td>
	        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	          <tr>
	            <td class="inputTitle">历史交易查询</td>
	          </tr>
	          <tr>
	            <td class="inputTitle">	            
	           		<html:form action="order.do?method=queryPersonalOrder">
		            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
		            	<tr>
		                  <td width="35%" align="right" class="inputHeader">订单号：</td>
		                  <td width="40%" class="inputContent">
		                  	<html:text property="order_SEQ" value="" styleClass="text width100"></html:text>
		                  </td>
		                  <td class="inputContent">&nbsp;</td>
		                </tr>
		                <tr>
		                  <td width="30%" align="right" class="inputHeader">起始时间：</td>
		                  <td width="36%" class="inputContent">
		                  	<html:text property="fromDate" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="true" styleClass="text width100"></html:text>
		                  </td>
		                  <td width="30%" class="inputContent">&nbsp;</td>
		                </tr>
		                <tr>
		                  <td align="right" class="inputHeader">结束时间：</td>
		                  <td class="inputContent">
		                  	<html:text property="toDate" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="true" styleClass="text width100"></html:text>
		                  </td>
		                  <td class="inputContent">&nbsp;</td>
		                </tr>
		                <tr>
		                  <td colspan="4" align="center" class="inputHeader">
		                  	<html:submit onclick="return checkIsNull()" styleClass="bt1">查询</html:submit>
		                  </td>
		                </tr>
		             </table>
	             </html:form>	             
	             </td>
	          </tr>
	        </table>
	      </td>
	  </tr>
	</table>
	<logic:present name="list">
	<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
	  <tr valign="top">
	    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	        <tr>
	          <td class="inputTitle">查询结果</td>
	        </tr>
	        <tr>
	          <td class="inputTitle">
	          	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	              <tr height="20" bgcolor="#ECECEC">
	                <td width="30%" align="center" class="titlegrey">订单号</td>
	                <td width="15%" align="center" class="titlegrey">订单金额</td>
	                <td width="15%" align="center" class="titlegrey">订单状态</td>
	                <td width="25%" align="center" class="titlegrey">下订单时间</td>
	                <td align="center" class="titlegrey">查看订单详情</td>
	              </tr>
	              <logic:empty name="list">
	              	<tr><td colspan="5" align="center">没有查询结果</td></tr>
	              </logic:empty>
	              	              
	              <logic:iterate id="order" name="list" indexId="index">
	              <tr bgcolor="<%=(index.intValue()%2==0)?"":"#ECECEC" %>">
	                <td align="center" class="inputHeader"><bean:write name="order" property="order_SEQ"/></td>
	                <td align="center" class="inputHeader"><bean:write name="order" property="total"/></td>
		                <logic:equal name="order" property="status" value="1">
		                	<td align="center" class="inputHeader">新订单</td>
		                </logic:equal>
		                <logic:equal name="order" property="status" value="2">
		                	<td align="center" class="inputHeader">已支付订单</td>
		                </logic:equal>
		                <logic:equal name="order" property="status" value="3">
		                	<td align="center" class="inputHeader">已发货订单</td>
		                </logic:equal>
		                <logic:equal name="order" property="status" value="4">
		                	<td align="center" class="inputHeader">已作废订单</td>
		                </logic:equal>
	                <td align="center" class="inputHeader"><bean:write name="order" property="issue_date"/></td>
	                <td align="center" class="inputContent">
	                	<html:link page="/order.do?method=queryPersonalOrderInfo" paramId="order_SEQ" paramName="order" paramProperty="order_SEQ">
	                		<html:img page="/foreground/img/xq.gif" alt="详情" width="25" height="20" border="0"/>
	                	</html:link>
	                </td>
	              </tr>
	              </logic:iterate>
	              <tr height="30"><td align="center" colspan="5">
	              		<logic:notEmpty name="page">
		        			<%	PageBean pb=(PageBean)request.getAttribute("page");
		        				if(pb.getPageNow()!=1){
		        			%>
		        			<a href="order.do?method=queryPersonalOrder&pageNow=<%=pb.getPageNow()-1 %>&fromdate=${fromdate }&todate=${todate }">
		        				<img src="foreground/img/pre-page.jpg" border="0" align="absmiddle"/></a>&nbsp;
		        			<%
		        				}else{
		        			%>
		        			<img src="foreground/img/pre-page.jpg" border="0" align="absmiddle"/>
		        			<%
		        				}
		       				%>
		           			<font color="red"><%=pb.getPageNow() %>/<%=pb.getPageCount() %>页</font>
		           			<%
		        				if(pb.getPageNow()!=pb.getPageCount()){
		        			%>
		        			<a href="order.do?method=queryPersonalOrder&pageNow=<%=pb.getPageNow()+1 %>&fromdate=${fromdate }&todate=${todate }">
		        				<img src="foreground/img/next-page.jpg" border="0" align="absmiddle"/></a>
		        			<%	}else{
		        			%>
		        			<img src="foreground/img/next-page.jpg" border="0" align="absmiddle"/>
		        			<%
		        			}
		        			%>
		        		</logic:notEmpty>
	              </td></tr>
	          	</table>
	          </td>
	        </tr>
	      </table></td>
	  </tr>
	</table></logic:present>
	<logic:notPresent name="list"></logic:notPresent>
	<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center>
  </body>
</html:html>
