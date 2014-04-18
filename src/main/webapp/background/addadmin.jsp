<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script language="javascript" src="background/js/jquerynew.js"></script>

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
    		<script>    
            function r1(){
           var div = document.getElementById("uid");
           div.innerHTML ="<font color='red' >请输入6位以上的密码</font>";
		   }
		   function r2(){
           var div = document.getElementById("pid");
           div.innerHTML ="<font color='red' >请再次输入</font>";
		   }
		   
		   
		   
		   
		   
		   
		   
		   function check(){
		   var persId = /^\d{15}|\d{18}|\d{17}[x X]$/;
		   var flag = true;
		 
		   if(document.adminform.newname.value==""){
		   document.getElementById("id1").innerHTML="<font color='red' >编号不能为空</font>";
		   flag = false;
		   
		   }
		   
		  if(document.adminform.newpassword.value==""){
		  document.getElementById("uid").innerHTML="<font color='red'>密码不能为空</font>";
		  flag = false;
		   
		   }
		   
		   
		   
		   if((document.adminform.newpassword.value)!=(document.adminform.pas2.value)){
		   
           document.getElementById("pid").innerHTML ="<font color='red'>俩次输入不一致</font>";
		   flag=false;
		   }
		  
		   if(flag == true){
		   document.adminform.submit();
		   
		   }
		   
		   return flag;
		   
		
  }
		   
</script>
	<style media="all" type="text/css">@import "background/css/all.css";</style>
</head>
<body onload="showhead();show();">
<html:form action="admin.do?service=addManager">
<div id="main">
	<div id="header"><a href="index.html" class="logo"><img src="background/img/logo.jpg" width="160" height="50" alt="" /></a>
	  <ul id="top-navigation">
        
			<li class="active"><span><span>管理员权限</span></span></li>
			
	  </ul>
	</div>
	<div id="middle">
		
			<div id="left-column">
			
            
            <h3><li><a href="#" id="test2">系统管理员操作</a></li></h3>
            
            
	        <div id="testa" style="width:150px; height:49px">
            <ul class="nav">
				<li><a href="background/addadmin.jsp"> 添加管理员</a></li>
				<li><a href="/ccMall_gj3_g9/admin.do?service=queryAllManagers">查询管理员</a></li>
				<li class="last"><a href="/ccMall_gj3_g9/admin.do?service=exit">退出</a></li>
			</ul> </div>
            
            
			
			
		</div>
		<div id="center-column">

			<div class="top-bar">
				
                                
				<h1>欢迎${adminname}，您的权限为系统管理员</h1>
				<div class="breadcrumbs"><a href="background/superadmin.jsp">管理员权限</a> / <a href="addadmin.html">添加管理员</a></div>
			</div><br />
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<div class="select-bar">
				<table class="listing form" cellpadding="0" cellspacing="0">
					<tr>
						<th class="full" colspan="2">添加管理员信息</th>
					</tr>
					<tr>
						<td class="first style1" width="172"><strong>管理员账号：</strong></td>
						<td class="last"><html:text property="newname"></html:text></td>
					</tr>
					<tr class="bg">
						<td class="first style1"><strong>管理员密码：</strong></td>
						<td class="last"><html:text property="newpassword"></html:text></td>
					</tr>
					<tr>
						<td class="first style1""><strong>重 复 密 码：</strong></td>
						<td class="last"><input type="text"  /></td>
					</tr>
					<tr class="bg">
						<td class="first style1"><strong>管理员权限：</strong></td>
						<td class="last"><html:checkbox value="1" property="product_do">商品的增加、删除、修改、查询</html:checkbox><br/>
						                 <html:checkbox value="1" property="product_category_do">商品分类的增、删、改、查</html:checkbox><br/>
						                 <html:checkbox value="1" property="news_do">首页公告的修改，咨询的管理</html:checkbox><br/>
						                 <html:checkbox value="1" property="user_do">用户密码和详细资料的查询，删除用户</html:checkbox><br/>
						                 <html:checkbox value="1" property="order_do">对历史订单的查询，修改</html:checkbox><br/>
						
						                
										 
						</td>
					</tr>
					<tr>

						<td  colspan="3"><html:image src="background/img/dd1.png" onclick="return check()"></html:image></td>


					</tr>
				</table>
				</div>
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
