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
	
	<title>订单删除页面</title>
    
	<style media="all" type="text/css">@import "background/css/all.css";</style>
	
	<script language="javascript" src="background/jquery.js"></script>
	<script language="javascript" src="background/js/showo_page.js"></script>
	<script type="text/javascript">
		var result = "<%=request.getAttribute("result")%>";
		if(result!="null" && result!=""){
			alert(result);
			window.open("order.do?method=queryOrders&status=1","_self");
		}
	</script>
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
  <div id="header"> <a href="background/index.jsp" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
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
        <h1>订单删除</h1>
        <div class="breadcrumbs"><a href="background/index.jsp">管理员权限</a> </div>
      </div>
      <div class="select-bar">
      	<html:form action="order.do?method=deleteQueryOrder">请输入订单号：
      		<html:text property="order_SEQ" value=""></html:text>
        	<html:submit>查询</html:submit>
        	<html:button property="" onclick="window.back()">返回</html:button>
        </html:form>
      </div>
      <div class="table"><img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" /> <img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
        <logic:present name="list">
        	<table width="516" cellpadding="0" cellspacing="0" class="listing">
	          <tr>
	            <th width="35%">订单号</th>
	            <th width="35%">订单状态</th>
	            <th>删除订单</th>
	          </tr>
	          <logic:empty name="list">
	          	<tr><td colspan="3">没有查询结果</td></tr>
	          </logic:empty>
	          <logic:notEmpty name="list">
	          	<logic:iterate id="o" name="list" indexId="index">
	          		<tr<%=(index.intValue()%2==0)?" class='bg'":"" %>>
			            <td><bean:write name="o" property="order_SEQ"/></td>
			            <td>已作废</td>
			            <td>
			            	<html:link onclick="return confirm('您确定要删除吗？')" page="/order.do?method=deleteOrder" paramId="order_SEQ" paramName="o" paramProperty="order_SEQ">
			            		<html:image page="/background/img/hr.gif" alt="删除"></html:image>
			            	</html:link>
			            </td>
		            </tr>
        		</logic:iterate>
        		<tr><td colspan="3">
        		
        		<logic:notEmpty name="page_pre">
        			<%	PageBean pb=(PageBean)request.getAttribute("page_pre");
        				if(pb.getPageNow()!=1){
        			%>
        			<a href="order.do?method=queryOrders&status=4&pageNow=<%=pb.getPageNow()-1 %>"><img src="background/img/pre-page.jpg" border="0" align="absmiddle"/></a>&nbsp;
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
        			<a href="order.do?method=queryOrders&status=4&pageNow=<%=pb.getPageNow()+1 %>"><img src="background/img/next-page.jpg" border="0" align="absmiddle"/></a>
        			<%	}else{
        			%>
        			<img src="background/img/next-page.jpg" border="0" align="absmiddle"/>
        			<%
        			}
        			%>
        		</logic:notEmpty>
        		
        		<logic:notEmpty name="page">
        			<%	PageBean pb=(PageBean)request.getAttribute("page");
        				if(pb.getPageNow()!=1){
        			%>
        			<a href="order.do?method=deleteQueryOrder&pageNow=<%=pb.getPageNow()-1 %>"><img src="background/img/pre-page.jpg" border="0"/></a>&nbsp;
        			<%
        				}else{
        			%>
        			<img src="background/img/pre-page.jpg" border="0"/>
        			<%
        				}
       				%>
           			<font color="red"><%=pb.getPageNow() %>/<%=pb.getPageCount() %>页</font>
           			<%
        				if(pb.getPageNow()!=pb.getPageCount()){
        			%>
        			<a href="order.do?method=deleteQueryOrder&pageNow=<%=pb.getPageNow()+1 %>"><img src="background/img/next-page.jpg" border="0"/></a>
        			<%	}else{
        			%>
        			<img src="background/img/next-page.jpg" border="0"/>
        			<%
        			}
        			%>
        		</logic:notEmpty>
        		</td></tr>
	          </logic:notEmpty>	          
	        </table>
        </logic:present>
        <logic:notPresent name="list"></logic:notPresent>
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
