<%@ page language="java" import="java.util.*,com.neusoft.ccmall.bean.*" pageEncoding="UTF-8"%>
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
	
	<title>订单查询页面</title>
	
	<style media="all" type="text/css">@import "background/css/all.css";</style>
	
    <script language="javascript" src="background/jquery.js"></script>
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
  <div id="header"><a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="logo" /></a>
    <ul id="top-navigation">
            <li><span><span><a href="background/welcome.jsp" >首页</a></span></span></li>
			<li><span><span><a href="background/index.jsp" onclick="return user_doPri();" >管理员权限</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/product.do?service=queryAllProduct" onclick="return product_doPri();">商品管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/category.do?service=queryAll" onclick="return product_category_doPri();">商品分类管理</a></span></span></li>
			<li><span><span><a href="/ccMall_gj3_g9/news.do?post=queryInformation" onclick="return news_doPri();">新闻管理</a></span></span></li>
			<li class="active"><span><span><a href="background/order.jsp" onclick="return orderPri();">订单管理</a></span></span></li>
			<li><span><span><a href="background/total.jsp">销售统计</a></span></span></li>
		</ul>
  </div>
  <div id="middle">
    <div id="left-column">
      <h3>
        <li><a href="#" id="test1">订单管理</a></li>
      </h3>
      <div id="test" style="width:150px; height:50px">
        <ul class="nav">
          <li class="last"><a href="order.do?method=queryOrders&status=0">订单查询</a></li>
          <li class="last"><a href="order.do?method=queryOrders&status=1">订单修改</a></li>
          <li class="last"><a href="order.do?method=queryOrders&status=4">订单删除</a></li>
        </ul>
      </div>
    </div>
    <div id="center-column">
      <div class="top-bar">
        <h1>订单查询</h1>
        <div class="breadcrumbs"><a href="index.html">管理员权限</a> </div>
      </div>
      <br />
      <div class="select-bar">
        <html:form action="order.do?method=queryAllOrders">请输入订单号：
        	<html:text property="order_SEQ" value=""></html:text>
          	<html:select property="status">
	          	<html:option value="1">新订单</html:option>
	          	<html:option value="2">已支付订单</html:option>
	          	<html:option value="3">已发货订单</html:option>
	          	<html:option value="4">已作废订单</html:option>
          	</html:select>
          	<html:submit>查询</html:submit>
          	<html:button property="" onclick="window.back()">返回</html:button>
        </html:form>        
      </div>
      <div class="table">
      	<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
      	<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
       	<table width="500" cellpadding="0" cellspacing="0" class="listing">
        	<logic:present name="list" scope="request">
	          <tr>
	            <th width="20%">订单号</th>
	            <th width="20%">订单用户</th>
	            <th width="15%">订单金额</th>
	            <th width="15%">订单状态</th>
	            <th>下订单时间</th>
	          </tr>
	          <logic:empty name="list">
	          	<tr><td colspan="5">没有查询结果</td></tr>
	          </logic:empty>
	          <logic:notEmpty name="list">
		          <logic:iterate id="o" name="list" indexId="index">
		          <tr<%=(index.intValue()%2==0)?" class='bg'":"" %>>
		            <td><bean:write name="o" property="order_SEQ"/></td>
		            <td><bean:write name="o" property="username"/></td>
		            <td><bean:write name="o" property="total"/></td>
		            <logic:equal name="o" property="status" value="1"><td>新订单</td></logic:equal>
		            <logic:equal name="o" property="status" value="2"><td>已支付订单</td></logic:equal>
		            <logic:equal name="o" property="status" value="3"><td>已发货订单</td></logic:equal>
		            <logic:equal name="o" property="status" value="4"><td>已作废订单</td></logic:equal>
		            <td><bean:write name="o" property="issue_date"/></td>
		          </tr>
		          </logic:iterate>
		          
		          <tr><td colspan="5">
        		
        		<logic:notEmpty name="page_pre">
        			<%	PageBean pb=(PageBean)request.getAttribute("page_pre");
        				if(pb.getPageNow()!=1){
        			%>
        			<a href="order.do?method=queryOrders&status=0&pageNow=<%=pb.getPageNow()-1 %>"><img src="background/img/pre-page.jpg" border="0" align="absmiddle"/></a>&nbsp;
        			<%
        				}else{
        			%>
        			<img src="background/img/pre-page.jpg" border="0" align="absmiddle"/>
        			<%
        				}
        			%>
        			<font color="red"><%=pb.getPageNow() %>/<%=pb.getPageCount() %>页</font>
        			<%
        				if(pb.getPageNow()!=pb.getPageCount()){
        			%>
        			<a href="order.do?method=queryOrders&status=0&pageNow=<%=pb.getPageNow()+1 %>"><img src="background/img/next-page.jpg" border="0" align="absmiddle"/></a>
        			<%	}else{
        			%>
        			<img src="background/img/next-page.jpg" border="0" align="absmiddle"/>
        			<%
        			}
        			%>
        		</logic:notEmpty>
		        
		        <logic:notEmpty name="page">
	      			<%	int status = Integer.parseInt(request.getAttribute("status")+"");
	      				PageBean pb=(PageBean)request.getAttribute("page");
        				if(pb.getPageNow()!=1){
        			%>
        			<a href="order.do?method=queryAllOrders&status=<%=status %>&pageNow=<%=pb.getPageNow()-1 %>"><img src="background/img/pre-page.jpg" border="0" align="absmiddle"/></a>&nbsp;
        			<%
        				}else{
        			%>
        			<img src="background/img/pre-page.jpg" border="0" align="absmiddle"/>
        			<%
        				}
        			%>
        			<font color="red"><%=pb.getPageNow() %>/<%=pb.getPageCount() %>页</font>
        			<%
        				if(pb.getPageNow()!=pb.getPageCount()){
        			%>
        			<a href="order.do?method=queryAllOrders&status=<%=status %>&pageNow=<%=pb.getPageNow()+1 %>"><img src="background/img/next-page.jpg" border="0" align="absmiddle"/></a>
        			<%	}else{
        			%>
        			<img src="background/img/next-page.jpg" border="0" align="absmiddle"/>
        			<%
        			}
        			%>
	      		</logic:notEmpty>
		        
	          </logic:notEmpty>
          	</logic:present>
          	<logic:notPresent name="list" scope="request"></logic:notPresent>
        </table>
        <table width="500" cellpadding="0" cellspacing="0">
        	<tr><td align="center">
        	</td></tr>
        </table>
      </div>
    </div>
    <div id="right-column"> <strong class="h">日期</strong>
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
