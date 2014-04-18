<%@ page language="java" import="java.util.*,com.neusoft.ccmall.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<base href="<%=basePath%>"/>
	<title>Admin</title>
    <script language="javascript" src="background/jquery.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<style media="all" type="text/css">@import "background/css/all.css";</style>
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
	<script type="text/javascript">
        <%
          Connection ct = null;
          PreparedStatement ps = null;
          ResultSet rs = null;
          ct = DBUtils.getConnection();
          String sql = "select a.name as big_name ,b.name as small_name from category a,category b where a.id=b.upper_id";
          ps = ct.prepareStatement(sql);
          rs = ps.executeQuery();
          int i=0;
        %>
        var arrData=new Array();
        <% 
           while(rs.next()){
        %>
                arrData[<%=i%>]=new Array("<%=rs.getString("big_name")%>","<%=rs.getString("small_name")%>");
        <%                 
                i++;
	        }
	        DBUtils.closeDB(ct,ps,rs);
        %>
		function initSel() {
		   var optStr="";
		   for(var i=0;i<arrData.length;i++){
		      if(optStr.search("("+arrData[i][0]+")")<0){
		          optStr+="("+arrData[i][0]+")";
		          var oOptA=document.createElement("OPTION");
		          oOptA.value=arrData[i][0];
		          oOptA.innerHTML=arrData[i][0];
		          productform.main_value.appendChild(oOptA);         
		      }
		   }
		   chgSlave();
		}
		
		function chgSlave(){
		     productform.sub_value.options.length=0;
		     for(var i=0;i<arrData.length;i++){
		         if(arrData[i][0]==productform.main_value.value){
		              var oOptB=document.createElement("OPTION");
		              oOptB.value=arrData[i][1];
		              oOptB.innerHTML=arrData[i][1];
		              productform.sub_value.appendChild(oOptB);
		         }
		     }
		}
		</script>
</head>

<body onload="show(),showhead(),initSel()">
<html:form action="product.do?service=updateProduct">
<html:hidden property="product_id" value="${goods_update.product_SEQ}"></html:hidden>
<div id="main">
	<div id="header"><a href="background/index.jsp" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
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
			  <li ><a href="background/goods_index.jsp" id="test1">商品管理</a></li>
			</h3>
            
            
	        <div id="test" style="width:150px; height:50px">
            <ul class="nav">
				<li><a href="goods_add.jsp">增加新商品</a></li>
				<li><a href="goods_select.jsp">查询商品</a></li>
				<li class="last"><a href="goods_sellout.jsp">查询脱销商品</a></li>
			</ul> </div>                                    
      </div>
	  
	  <div id="center-column">
			<div class="top-bar">
			  <h1>修改商品</h1>
				<div class="breadcrumbs"><a href="goods_index.jsp">商品管理</a> / <a href="goods_update.jsp">修改商品</a></div>
			</div><br />
		  
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table class="listing" cellpadding="0" cellspacing="0">
					<tr>
						<th class="first" width="177">&nbsp;</th>
						<th class="last">&nbsp;</th>
					</tr>
					<tr>
						<td class="first style1">商品名称</td>
						<td>
							<html:text property="name" value="${goods_update.name}">
							</html:text>
						</td>
					</tr>
					<tr class="bg">
						<td class="first style1">改前分类</td>
						<td>
							`<bean:write name="goods_update" property="main_value"/>-
							<bean:write name="goods_update" property="sub_value"/>		
						</td>
					</tr>
					<tr>
						<td class="first style1">改后分类</td>
						<td>
							<html:select property="main_value" onchange="chgSlave()" styleClass="width:170px">
                      		   <html:option value="所有分类">所有分类</html:option>
                      		</html:select>
                      		<html:select property="sub_value" styleClass="width:170px">
                      			<html:option value=""></html:option>
                      		</html:select>
						</td>
					</tr>
					
					
					<tr class="bg">
						<td class="first style1">商品单价</td>
						<td>
							<html:text property="price" value="${goods_update.price}">
								
							</html:text>
						</td>
					</tr>
					<tr>
						<td class="first style1">计量单位</td>
						<td>
							<html:text property="unit" value="${goods_update.unit}">
								
							</html:text>
						</td>
					</tr>
					<tr class="bg">
						<td class="first style1">库存数量</td>
						<td>
							<html:text property="num" value="${goods_update.num}">
								
							</html:text>
						</td>
					</tr>
					<tr>
						<td class="first style1">商品描述</td>
						<td>
							<html:textarea property="description" value="${goods_update.description}" rows="3" cols="27">								
							</html:textarea>
						</td>
					</tr>
					<tr class="bg">
						<td class="first style1">商品图片</td>
						<td>
							<html:text property="image" value="${goods_update.image}">
								
							</html:text>
						</td>
					</tr>
					<tr>
						<td class="first style1">是否推荐</td>
						<td>
						  <html:select property="recommend">
						    <html:option value="1">是</html:option>
						    <html:option value="0">否</html:option>
					      </html:select></td>
						
					</tr>
					<tr align="center">
				  	  <td colspan="2" align="center" class="first style2" >
							<html:submit>提交</html:submit>
							<html:reset>重置</html:reset>
					  </td> 
					</tr>
				</table>
				
		  </div>
		  <div class="table">
		    <p>&nbsp;</p>
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
</html:form>
</body>
</html:html>

