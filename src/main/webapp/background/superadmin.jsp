<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script type="text/javascript">
 	var result = "<%=request.getAttribute("result")%>";
      if(result == 1){
      	alert("修改成功！点击【确定】即将跳转...");
      	// location.reload("news.do?post=queryInformation","_self");
      	window.location.href="background/superadmin.jsp";
      }
      if(result==0){
      	alert("修改失败，原密码错误！");
      	window.location.href="background/superpasmodify.jsp?name=${adminname}";
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
        
			<li class="active"><span><span>管理员权限</span></span></li>
			
		</ul>
  </div>
	<div id="middle">
		<div id="left-column">
			
            <h3><li ><a href="#" id="test2">系统管理员操作</a></li></h3>
            
            
	        <div id="testa" style="width:150px; height:49px">
            <ul class="nav">
				<li><a href="background/addadmin.jsp"> 添加管理员</a></li>
				<li><a href="/ccMall_gj3_g9/admin.do?service=queryAllManagers">查询管理员</a></li>
				<li class="last"><a href="/ccMall_gj3_g9/admin.do?service=exit">退出</a></li>
			</ul> </div>
            
            
			
			
		</div>
        
	  <div id="center-column">
			<div class="top-bar">
				<a href="background/superpasmodify.jsp?name=${adminname}" class="button">修改密码</a>
				<h1>欢迎${adminname}，您的权限为系统管理员</h1>
				<div class="breadcrumbs"><a href="superadmin.jsp">管理员权限</a> / <a href="searchadmins.html">查询管理员</a></div>
			</div><br />
			<div class="table">
				<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
				<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
				<table width="516" cellpadding="0" cellspacing="0" class="listing">
					<tr>
						<th class="first" width="121">管理员序号</th>
						<th width="129">管理员账号</th>
						<th width="129">查看详细</th>
						<th width="126">修改权限</th>
						<th class="last" width="138">删除</th>
					</tr>
					
					
					<tr>
						<td class="first style1"></td>
						<td></td>
						<td><img src="background/img/login-icon.gif" width="16" height="16" alt="" /></td>
						<td><img src="background/img/edit-icon.gif" width="16" height="16" alt="" /></td>
						<td><img src="background/img/hr.gif" onclick="return confirm('确认删除?')"  width="16" height="16" alt="" /></td>
					</tr>
					
					
			  
			  </table>
			  <Script Language=JavaScript >
		ShowoPage("","","页次:<font color='red'>","</font>/","<font color='red'>","</font>页&nbsp;","&nbsp;每页<font color='red'>","</font>条&nbsp;","&nbsp;共<font color='red'>","</font>个记录&nbsp;&nbsp;","首页","上一页","下一页","尾页","&nbsp;&nbsp;跳转:","<font color='red'>","</font>","[<font color='red'>","</font>]","","","&nbsp;","&nbsp;",9999,99,4)
		</Script>
				
			  
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
</html>
