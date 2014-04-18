<%@ page language="java" import="java.util.*,com.neusoft.ccmall.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="js/showo_page.js"></script>
	<script language="javascript" src="js/jquery.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "css/all.css";</style>
	<script type="text/javascript">
	  function user_doPri(){
           var pri= ${pri.user_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
	  function product_doPri(){
           var pri= ${pri.product_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function product_category_doPri(){
           var pri= ${pri.product_category_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function news_doPri(){
           var pri= ${pri.news_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
           function orderPri(){
           var pri= ${pri.order_do};
           if(pri==0){
            alert("对不起,您没有这种权限");
            return false;
           }
           else{
           return true;
           }
           }
  </script>
 
 <script type="text/javascript">  
     function showhead(){   
		    var date=new Date();   
		    var now="";   
		    now=date.getFullYear()+"年";   
		    now=now+date.getMonth()+"月";   
		    now=now+date.getDate()+"日";
		    document.getElementById("ithead").innerHTML=now;   
		    setTimeout("showhead()",1000);   
		       
		}   
     
       function showdetail(){   
		    
		    document.getElementById("itdetail").innerHTML="<br/>";   
		     
		       
		}   
      
		function show(){   
		    var date=new Date();   
		    var now="";   
		    now=now+date.getHours()+"时";   
		    now=now+date.getMinutes()+"分";   
		    now=now+date.getSeconds()+"秒";   
		    document.getElementById("it").innerHTML=now;   
		    setTimeout("show()",1000);   
		       
		}   
	</script>
</head>
<body onload="showhead();show();">

<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
            <li><span><span><a href="background/welcome.jsp" >首页</a></span></span></li>
			<li><span><span><a href="background/index.jsp" onclick="return user_doPri();" >管理员权限</a></span></span></li>
			<li   class="active"><span><span><a href="/ccMall_gj3_g9/product.do?service=queryAllProduct" onclick="return product_doPri();">商品管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/category.do?service=queryAll" onclick="return product_category_doPri();">商品分类管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation" onclick="return news_doPri();">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp" onclick="return orderPri();">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
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
			  <h1>商品评论信息</h1>
				<div class="breadcrumbs"><a href="goods_index.html">商品管理</a> / <a href="goods_mess.html">商品评论信息</a></div>
			</div><br />
		  
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="100">评论者名字</th>
						<th width="270">评论内容</th>
						<th>日期时间</th>
						<th>删除</th>
					</tr>
					<tr>
						<td class="first style1">
							<html:hidden property="product_SEQ" value="${pro_com.product_SEQ}"></html:hidden>
							<html:hidden property="id" value="${pro_com.id}"></html:hidden>
							
							<bean:write name="pro_com" property="username"/>
						</td>
						<td>
							<bean:write name="pro_com" property="content"/>
						</td>
						<td>
							<bean:write name="pro_com" property="issue_date"/>
						</td>
						<td>
							<a href="/ccMall_gj3_g9/comment.do?method=deleteComment&${pro_com.id}&${pro_com.product_SEQ}"><img src="background/img/hr.gif" width="16" height="16" alt=""/></a>
						</td>
					</tr>
					
					<tr>
						<td colspan="4" >
							<a href="/ccMall_gj3_g9/comment.do?method=deleteAllComments" >删除全部</a>
						</td>
						
					</tr>
				</table>
				
		  </div>
		  <div class="table">
		    <center>
				<Script Language=JavaScript>
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,2)
		</Script>
				</center>
		  </div>
	  </div>
		
		<div id="right-column">
			<strong class="h">日期</strong>
			<div class="box"><font color="#FF7A00">北京时间：</font><div id="ithead"></div><div id="itdetail"></div><div id="it"></div></div>
	  </div>
	</div>
	<div id="footer"></div>
</div>

<script language="javascript">
$("#test1").toggle(function(){$("#test").slideDown()},function(){$("#test").slideUp()})
$("#test2").toggle(function(){$("#testa").slideDown()},function(){$("#testa").slideUp()})
</script>

</body>
</html:html>

