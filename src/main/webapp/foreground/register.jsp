<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//取随机产生的认证码(4位数字)
String sRand = "";
for(int i=0;i<4;i++){
	String rand = String.valueOf(new Random().nextInt(10));
	sRand += rand;
}
// 将认证码放入session
session.setAttribute("s", sRand);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script type="text/javascript">
		function checkcode(){
			var code = document.userform.code.value;
			var s = <%=session.getAttribute("s")%>;
			if(code==null || code=="" || code!=s){
				alert("验证码输入有误，请重新输入！");
				document.forms[0].checkcode.focus();
				return false;
			}
		}
		
		function checkreg(){
			var uname = document.forms[0].username.value.replace(/(^\s*)|(\s*$)/g, "");
			if(uname==""||uname==null){
				alert("用户名不能为空或空格！");
				document.forms[0].username.focus();
				return false;
			}
			var pw = document.forms[0].password.value.replace(/(^\s*)|(\s*$)/g, "");
			if(pw==""||pw==null){
				alert("密码不能为空或空格！");
				document.forms[0].password.focus();
				return false;
			}
			var pw2 = document.forms[0].password2.value;
			if(pw!=pw2){
				alert("两次输入密码不一致，请重新输入！");
				document.forms[0].password.value="";
				document.forms[0].password2.value="";
				document.forms[0].password.focus();
				return false;
			}
			
		}
		
		var result = "<%=request.getAttribute("result")%>";
		if(result == 1){
			alert("恭喜，注册成功，点击【确定】即将跳转到首页...");
			window.open("foreground/home.jsp","_self");
		}
		if(result == 0){
			alert("对不起，注册失败，请重新注册！");
		}
	</script>
	
  </head>
  
  <body>
  <center>
<iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
  <tr>
    <td><a href="home.htm">主页</a>&raquo;新用户注册</td>
  </tr>
</table>
<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
  <tr valign="top">
    <td><html:form action="user.do?method=register">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputTable">
          <tr>
            <td class="inputTitle">新用户注册</td>
          </tr>
          <tr>
            <td class="inputTitle"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="inputbox">
                <tr>
                  <td width="30%" class="inputHeader" align="right">用户名：<br></td>
                  <td width="38%" class="inputContent"><html:text property="username" styleClass="text width100"></html:text>
                  <br></td>
                  <td class="inputContent" id="name2"><font color="#CC0000">*必填项</font><br></td>
                </tr>
                <tr>
                  <td width="30%"align="right" class="inputHeader">密码：<br></td>
                  <td  width="38%" class="inputContent"><html:password property="password" styleClass="text width100"></html:password>
                  <br></td>
                  <td class="inputContent" id="pw"><font color="#CC0000">*必填项</font><br></td>
                </tr>
                <tr>
                  <td width="30%" align="right" class="inputHeader">密码确认：<br></td>
                  <td  width="38%" class="inputContent"><input type="password2" name="password2" class="text width100"/>
                  <br></td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td width="30%" align="right" class="inputHeader">提示问题：</td>
                  <td width="38%" class="inputContent">
                      <html:select  property="question" styleClass="text width100"> 
                      	<html:option value="">--请选择密码提示问题，用于找回密码--</html:option>
	                    <html:option value="你的家乡是？">你的家乡是？</html:option>
	                    <html:option value="你的父亲姓名是？">你的父亲姓名是？ </html:option>
	                    <html:option value="你的母亲姓名是？">你的母亲姓名是？</html:option>
	                    <html:option value="你的电话号码是？">你的电话号码是？</html:option>
	                    <html:option value="你最喜欢的人是？">你最喜欢的人是？</html:option>
                   	  </html:select>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td width="30%" align="right" class="inputHeader">问题答案：</td>
                  <td width="38%" class="inputContent"><html:text styleClass="text width100" property="answer"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">真实姓名：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="truename"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">身份证号：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="id_card" value="" maxlength="18"></html:text>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必填项</font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">电子邮箱：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="email" value=""></html:text>
                  </td>
                  <td class="inputContent" id="email2"><font color="#CC0000">*必输项 </font></td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮政编码：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="postcode" value=""></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">邮寄地址：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="address" value=""></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">联系电话：</td>
                  <td class="inputContent"><html:text styleClass="text width100" property="phone" value=""></html:text>
                  </td>
                  <td class="inputContent">&nbsp;</td>
                </tr>
                <tr>
                  <td align="right" class="inputHeader">验证码：</td>
                  <td class="inputContent">
                  	<input type="text" name="code" maxlength="4" class="text" onblur="checkcode()">
                  	<img border=0 src="image.jsp" align="absmiddle"><a href="javascript:location.reload();">不清晰，换一张</a>
                  </td>
                  <td class="inputContent"><font color="#CC0000">*必输项 </font></td>
                </tr>
                <tr>
                  <td colspan="3" align="center" class="inputHeader">
                    <html:submit styleClass="bt1" onclick="return checkreg()">立即注册</html:submit>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>
      </html:form></td>
  </tr>
</table>
<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
</center>
  </body>
</html>
