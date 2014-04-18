<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>Admin</title>
    <script language="javascript" src="js/showo_page.js"></script>
	<script language="javascript" src="js/jquery.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "css/all.css";</style>
</head>
<body>
<div id="main">
	<div id="header"><a href="index.html" class="logo"><img src="img/logo.jpg" width="160" height="50" alt="" /></a>
	  <ul id="top-navigation">
        
			<li><span><span><a href="index.html">管理员权限</a></span></span></li>
			<li class="active"><span><span><a href="goods_index.html">商品管理</a></span></span></li>
			<li><span><span><a href="goodstype_index.html">商品分类管理</a></span></span></li>
			<li><span><span><a href="news.html">新闻管理</a></span></span></li>
			<li><span><span><a href="order.html">订单管理</a></span></span></li>
			<li><span><span><a href="total.html">销售统计</a></span></span></li>
	  </ul>
  </div>
	<div id="middle">
	  
	  <div id="left-column">
			<h3>
			  <li ><a href="goods_index.html" id="test1">商品管理</a></li>
			</h3>
            
            
	        <div id="test" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="goods_add.html">增加新商品</a></li>
				<li><a href="goods_select.html">查询商品</a></li>
				<li class="last"><a href="goods_sellout.html">查询脱销商品</a></li>
			</ul> </div>                                    
      </div>
	  
	  <div id="center-column">
			<div class="top-bar">
			  <h1>查询结果</h1>
				<div class="breadcrumbs"><a href="goods_index.html">商品管理</a> / <a href="goods_result.html">查询结果</a></div>
			</div><br />
		  
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="177">商品名称</th>
						<th>商品大分类</th>
						<th>商品单价</th>
						<th>库存数量</th>
						<th>查看信息</th>
						<th>修改</th>
						<th class="last">删除</th>
					</tr>
					<tr>
						<td class="first style1">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr class="bg">
						<td class="first style2">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr>
						<td class="first style3">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr class="bg">
						<td class="first style1">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr>
						<td class="first style2">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr class="bg">
						<td class="first style3">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
					<tr>
						<td class="first style4">- Lorem Ipsum </td>
						<td>1</td>
						<td>1</td>
						<td>1</td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_info.html'"/></td>
						<td><img src="img/edit-icon.gif" width="16" height="16" alt="" onclick="location='goods_update.html'" /></td>
						<td class="last"><img src="img/hr.gif" width="16" height="16" alt="" onclick="return confirm('Are you sure?')" /></td>
					</tr>
				</table>
				<center>
				<Script Language=JavaScript>
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,2)
		</Script>
				</center>
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
