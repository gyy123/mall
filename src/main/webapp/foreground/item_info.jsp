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
    
    <title>My JSP 'item_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script language="javascript">
		function checkform(){
			var username = "${userbean.username}";
			if(username==null || username==""){
				alert("对不起，您还没有登录，不能参与评论！");
				return false;
			}
			var content = document.forms[0].content.value;
			if(content==null || content==""){
				alert("评论内容不能为空！");
				document.forms[0].content.focus();
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
	    <td><a href="home.htm">主页</a> &raquo;商品详细信息</td>
	  </tr>
	</table>
	<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
	  <tr>
	    <td>
	        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	          <tr>
	            <td align="left" class="inputHeader"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	                <tr>
			          <td class="inputTitle" colspan="3">商品信息</td>
			        </tr>
	                <tr>
	                  <td width="20%" rowspan="6" align="center" class="inputHeader"><img src="foreground/img/dxwl4.jpg" alt="大学物理第四册" width="138" height="200" hspace="0" vspace="0" border="0"></td>
	                  <td width="20%" align="right" class="inputHeader"><font color="#CC0000"><b>商品名称：</b></font></td>
	                  <td align="left" class="inputHeader"><bean:write name="pb" property="name"/></td>
	                </tr>
	                <tr>
	                  <td align="right" class="inputHeader"><font color="#CC0000"><b>商品类别：</b></font></td>
	                  <td align="left" class="inputHeader"><bean:write name="pb" property="main_value"/>-<bean:write name="pb" property="sub_value"/></td>
	                </tr>
	                <tr>
	                  <td align="right" class="inputHeader"><font color="#CC0000"><b>商品价格：</b></font></td>
	                  <td align="left" class="inputHeader">￥<bean:write name="pb" property="price"/></td>
	                </tr>
	                <tr>
	                  <td align="right" class="inputHeader"><font color="#CC0000"><b>库存量：</b></font></td>
	                  <td align="left" class="inputHeader"><bean:write name="pb" property="num"/></td>
	                </tr>	                
	                <tr>
	                  <td align="right" class="inputHeader"><font color="#CC0000"><b>商品描述：</b></font></td>
	                  <td align="left" valign="top" class="inputHeader"><bean:write name="pb" property="description"/></td>
                  </tr>
	                
	                <tr>
	                  <td align="right" class="inputHeader">
	                  	<a href="cart.do?method=addToMyCart&productseq=${pb.product_SEQ}&productname=${pb.name}&price=${pb.price}">
               		  <img src="foreground/img/pro_details_buyicon.jpg" alt="放入购物车" border="0">	                  	</a>	                  </td>
                      <td align="left" class="inputHeader">&nbsp;</td>
	                </tr>
	              </table>
	            </td>
	          </tr>
	        </table>
	    </td>
	  </tr>
	  <tr>
	  	<td>
	        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	          <tr>
	            <td class="inputTitle">商品评论</td>
	          </tr>
	          <tr>
	            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
	            <logic:empty name="cb_list">
	            	<tr>
	            		<td>您是第一位评论此商品的人哦O(∩_∩)O</td>
	            	</tr>
	            </logic:empty>
	            <logic:notEmpty name="cb_list">
		            <logic:iterate id="cb_list" name="cb_list">
		                <tr>
		                  <td width="10%" class="titlegrey">会员：</td>
		                  <td width="25%" class="titlegrey"><bean:write name="cb_list" property="username"/></td>
		                  <td width="10%" class="titlegrey">发表时间：</td>
		                  <td width="20%" class="titlegrey"><bean:write name="cb_list" property="issue_date"/></td>
		                  <td class="titlegrey">&nbsp;</td>
		                </tr>
		                <tr>
		                  <td colspan="7" align="left" class="inputContent"><bean:write name="cb_list" property="content"/></td>
		                </tr>
		             </logic:iterate>
	             </logic:notEmpty>	                
	             </table></td>
	          </tr>
	        </table>
	     </td>
	  </tr>
	  
	  <tr>
	    <td>
	    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
	    		<tr class="inputTable">
				    <td class="inputTitle">添加评论</td>
				</tr>
				<tr>
					<td><html:form action="comment.do?method=addComment">
						<html:hidden property="product_seq" value="${pb.product_SEQ}"/>
						<html:hidden property="username" value="${userbean.username}"/>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">  
					        <tr>
					          <td width="5%" class="inputHeader">评论</td>
					          <td colspan="6" class="inputHeader">
					          	<html:textarea property="content" styleClass="text width100"></html:textarea>
					          </td>
					        </tr>
				        </table>
				        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="inputbox">
					        <tr>
					          <td align="center" class="inputContent">
					          	<html:submit onclick="return checkform()" styleClass="bt2">提交</html:submit>
					          </td>
					        </tr>
				       </table></html:form>
					</td>
				</tr>
	    	</table>
	    </td>
	  </tr>
	</table>
	<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center></body>
</html>
