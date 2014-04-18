<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head> <base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/jquery.js"></script>
	<script language="javascript" src="background/js/showo_page.js"></script>
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
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body onload="showhead();show();">
<div id="main">
	<div id="header">
		<a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
		<ul id="top-navigation">
            <li><span><span><a href="background/welcome.jsp" >首页</a></span></span></li>
			<li><span><span><a href="background/index.jsp" onclick="return user_doPri();" >用户管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/product.do?service=queryAllProduct" onclick="return product_doPri();">商品管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/category.do?service=queryAll" onclick="return product_category_doPri();">商品分类管理</a></span></span></li>
			<li class="active"><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation" onclick="return news_doPri();">新闻管理</a></span></span></li>
			<li><span><span><a href="background/order.jsp" onclick="return orderPri();">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
  	</div>
	<div id="middle">
	  
	  <div id="left-column">
			<h3>
			  <li ><a href="news.html" id="test1">新闻管理</a></li>
			</h3>           
            
	        <div id="test" style="width:150px; height:50px">
              <ul class="nav">
                <li><a href="news.do?post=queryInformation">资讯管理</a></li>
                <li><a href="news.do?post=queryPost"> 公告管理</a></li>                
              </ul>
        </div>
	  </div>
	  
	  <div id="center-column">
			<div class="top-bar">
			  <h1>资讯管理</h1>
				<div class="breadcrumbs"><a href="news.html">新闻管理</a> / <a href="information.html">资讯管理</a></div>
			</div><br />
		  
		<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="179">资讯</th>
						<th width="148">资讯类型</th>
						<th width="90">查看</th>
						<th width="90">修改</th>
						<th width="90" class="last">删除</th>
					</tr>
					<logic:iterate id="admin" name="information">
					<tr>
						<td class="first style1"><bean:write name="admin" property="title"/></td>
						<td class="first style1"><bean:write name="admin" property="status1"/></td>
						<td><a href="news.do?post=selectInformation&id=${admin.id }"><img src="background/img/login-icon.gif" width="16" height="16" alt="" /></a></td>
						<td><a href="news.do?post=updateInformation&id=${admin.id }"><img src="background/img/edit-icon.gif" width="16" height="16" alt="" /></a></td>
						<td class="last">
							<a onclick="return confirm('你确定要删除这条资讯吗？')" href="news.do?post=deleteInformation&id=${admin.id }">
							<img src="background/img/hr.gif" width="16" height="16" alt="删除" />
							</a>
						</td>
					</tr>
					</logic:iterate>
					<tr>
						<td colspan="5">
							<input type="button" value="添加" onclick="location='background/information_add.jsp'"/>
						</td>
					</tr>
					
				</table>
				
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
