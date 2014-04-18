<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
	<title>Admin</title>
     <script language="javascript" src="background/jquery.js"></script>
	 <script language="javascript" src="background/js/showo_page.js"></script>
	 <script src="background/js/calendar.js"></script>
	 <script language="javascript">alert("删除成功！");window.location.href="user.do?method=queryUsers";</script>
	
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body>
<div id="main">
	<div id="header">
		<a href="index.jsp" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li class="active"><span><span>管理员权限</span></span></li>
			<li><span><span><a href="goods_index.html">商品管理</a></span></span></li>
			<li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation">新闻管理</a></span></span></li>
			<li><span><span><a href="order.html">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			<h3><li ><a href="#" id="test1">普通管理员操作</a></li></h3>
            
            
	        <div id="test" style="width:150px; height:50px">
            <ul class="nav">
				
				<li class="last"><a href="background/index.jsp">查询用户信息</a></li>
			</ul> </div>
            
           
            
            
			
			
		</div>
	  <div id="center-column">
			<div class="top-bar">
				<a href="background/pasmodify.jsp" class="button">密码修改 </a>
				<h1>Contents：欢迎，您的权限为普通管理员</h1>
				<div class="breadcrumbs"><a href="index.html">管理员权限</a> / <a href="searchusers.html">查询用户信息</a></div>
			</div><br />
	   <div class="select-bar">
	      <html:form  action="user.do?method=queryUsers">
	        用户名 :&nbsp;&nbsp;&nbsp;<html:text property="username" ></html:text><br/>
			起始时间:
		    <html:text property="registerdate_begin" onclick="SelectDate(this,'yyyy-MM-dd')"  ></html:text>
			结束时间:
			<html:text property="registerdate_end" onclick="SelectDate(this,'yyyy-MM-dd')"  ></html:text>
		     
		    <html:image src="background/img/search.gif"></html:image>
		    
    	  </html:form>
        </div>
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table width="516" cellpadding="0" cellspacing="0" class="listing">
					<tr>
						<th class="first" width="121">用户名</th>
						<th width="129">真实姓名</th>
						<th width="129">联系电话</th>
						<th width="126">查看详细</th>
						<th width="138">删除</th>
					</tr>
					<logic:empty name="users">
	          	    <tr><td colspan="5">没有查询结果</td></tr>
	                </logic:empty>
					<logic:iterate id="user" name="users">
					<tr>
						<td class="first style1"><bean:write name="user" property="username"/></td>
						<td><bean:write name="user" property="truename"/></td>
						<td><bean:write name="user" property="phone"/></td>
						<td><html:link page="/user.do?method=userdetails" paramId="uname" paramName="user" paramProperty="username"><img src="background/img/login-icon.gif" width="16" height="16" alt="" /></html:link></td>
						<td><html:link page="/user.do?method=deleteUser" paramId="dname" paramName="user" paramProperty="username"><img src="background/img/hr.gif" onclick="return confirm('确认删除?')"  width="16" height="16" alt="" /></html:link></td>
					</tr>
					</logic:iterate>
			  </table>
				<Script Language=JavaScript >
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,4)
		</Script>
			</div>
	  </div>
		<div id="right-column">
			<strong class="h">日期</strong>
			<div class="box">今天是</div>
	  </div>
	</div>
	<div id="footer"></div>
</div>

<script language="javascript">
$("#test1").toggle(function(){$("#test").slideDown()},function(){$("#test").slideUp()})
$("#test2").toggle(function(){$("#testa").slideDown()},function(){$("#testa").slideUp()})
</script>
</body>
</html>
