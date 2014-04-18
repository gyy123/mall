<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head> <base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/jquery.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body>
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
        
			<li><span><span><a href="index.html">管理员权限</a></span></span></li>
			<li><span><span><a href="goods_index.html">商品管理</a></span></span></li>
			<li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
			<li class="active"><span><span><a href="news.html">新闻管理</a></span></span></li>
			<li><span><span><a href="order.html">订单管理</a></span></span></li>
			<li><span><span><a href="total.html">销售统计</a></span></span></li>
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			<h3><li><a href="#" id="test1">新闻管理</a></li></h3>         
            <div id="test" style="width:150px; height:50px">
            <ul class="nav">
            	<li><a href="information.html">资讯管理</a></li>
				<li><a href="post.html"> 公告管理</a></li>
			</ul> </div>
         </div>
     <div id="center-column">
	    <div class="top-bar">
          <h1>新闻管理</h1>
	      <div class="breadcrumbs"><a href="news.html">新闻管理</a>/<a href="information.html">资讯管理</a>/<a href="information_details.html">查看</a></div>
        </div>
	    <br />
	    <div class="table"><img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" /> <img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
            <table width="248" cellpadding="0" cellspacing="0" class="listing">
              <tr>
                <th>资讯名称</th>
                <th>资讯类型</th>
                <th>资讯内容</th>
              </tr>
              <tr>
                <td><bean:write name="Information1" property="title"/></td>                
                <td><bean:write name="Information1" property="status1"/></td>
                <td><bean:write name="Information1" property="content"/></td>
              </tr>
              <tr>
                <td colspan="3">
                	<a href="news.do?post=updateStatus&id=${Information1.id }"><img src="background/img/fabu.png" alt="发布" border="0"/></a>
                	<a href="javascript:window.back()"><img src="background/img/back.png" alt="返回" border="0"/></a>                	
                </td>
              </tr>
            </table>
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
