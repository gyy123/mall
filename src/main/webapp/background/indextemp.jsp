<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head> <base href="<%=basePath%>"/>
    
	<title>Admin</title>
    <script language="javascript" src="background/js/jquerynew.js"></script>
	<script language="javascript" src="background/js/showo_page.js"></script>
	<script src="background/js/calendar.js"></script>
	
	<style media="all" type="text/css">@import "background/css/all.css";</style>
	<script language="javascript">alert("修改成功！")</script>
</head>
<body>
<div id="main">
  <div id="header">
    <ul id="top-navigation">
      <li class="active"><span><span>管理员权限</span></span></li>
      <li><span><span><a href="goods_index.html">商品管理</a></span></span></li>
      <li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
      <li><span><span><a href="news.html">新闻管理</a></span></span></li>
      <li><span><span><a href="order.html">订单管理</a></span></span></li>
      <li><span><span><a href="total.html">销售统计</a></span></span></li>
    </ul>
    <a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a></div>
  <div id="middle">
    <div id="left-column">
      <h3>
        <li ><a href="#" id="test1">普通管理员操作</a></li>
      </h3>
      <div id="test" style="width:150px; height:50px">
        <ul class="nav">
          <li><a href="background/searchusers.jsp">查询用户信息</a></li>
        </ul>
      </div>
    </div>
    <div id="center-column">
      <div class="top-bar"> <a href="background/pasmodify.jsp" class="button"> 密码修改</a>
        <h1>Contents：欢迎，您的权限为普通管理员</h1>
        <div class="breadcrumbs"><a href="background/index.jsp">管理员权限</a> / <a href="background/searchusers.jsp">查询用户信息</a></div>
      </div>
      <br />
      <div class="select-bar">
        <form id="form1" name="form1" method="post" action="">
          用户名:&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="text" name="textfield" />
          <br/>
          起始时间:
          <input  type="text" name="month2" onclick="SelectDate(this,'yyyy-MM-dd')"  readonly="readonly" />
          结束时间:
          <input  type="text" name="month2" onclick="SelectDate(this,'yyyy-MM-dd')"  readonly="readonly" />
          <img src="background/img/search.gif" width="60" height="22" align="absmiddle" />
        </form>
      </div>
      <div class="table"> <img src="background/img/bg-th-left.gif" width="8" height="7" alt="" class="left" /> <img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
        <table width="516" cellpadding="0" cellspacing="0" class="listing">
          <tr>
            <th class="first" width="121">用户名</th>
            <th width="129">真实姓名</th>
            <th width="129">联系电话</th>
            <th width="126">查看详细</th>
            <th width="138">删除</th>
          </tr>
          <tr>
            <td class="first style1">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="background/userdetails.jsp"><img src="background/img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#" onclick="return confirm('确定删除?')"><img src="background/img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr class="bg">
            <td class="first style2">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr>
            <td class="first style3">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr class="bg">
            <td class="first style1">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr>
            <td class="first style2">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr class="bg">
            <td class="first style3">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
          <tr>
            <td class="first style4">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><a href="userdetails.html"><img src="img/login-icon.gif" width="16" height="16" alt="" /></a></td>
            <td><a href="#"onclick="return confirm('确定删除?')"><img src="img/hr.gif" width="16" height="16" alt="" /></a></td>
          </tr>
        </table>
        <Script Language=JavaScript >
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,4)
		</Script>
      </div>
    </div>
    <div id="right-column"> <strong class="h">日期</strong>
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
