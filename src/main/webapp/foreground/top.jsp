<%@ page language="java" import="java.util.*,com.neusoft.ccmall.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");//防止url地址包含中文，传到底层产生乱码
// 从session中取出UserBean
//UserBean ub = (UserBean)session.getAttribute("userbean");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'top.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	<script type="text/javascript">   
		function show(){   
		    var date=new Date();   
		    var now="";   
		    now=date.getFullYear()+"年";   
		    now=now+date.getMonth()+"月";   
		    now=now+date.getDate()+"日";   
		    now=now+date.getHours()+"时";   
		    now=now+date.getMinutes()+"分";   
		    now=now+date.getSeconds()+"秒";   
//		    document.getElementById("its").innerHTML=now;   
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
  
  <body onload="initSel(),show()" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
     <table width="770" border="0" cellpadding="0" cellspacing="0" class="pagetop">
       <tr>
         <td>
           <table width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
              <tr>
               <td width="381"><img src="foreground/img/logo.jpg" width="368" height="94"></td>
               <td width="10" align="right" valign="top" class="help">&nbsp;</td>
               <td width="384" align="right" valign="top" class="help"><br/>
               <br/>
                 <b><div id="it"></div></b>
               <br/>
               <bean:write name="userbean" property="username"/>&nbsp;已登录&nbsp;|&nbsp;
               <a href="foreground/user_info_update.jsp" target="_parent">修改信息</a>&nbsp;|&nbsp;            
               <a href="foreground/pwd_update.jsp" target="_parent">修改密码</a>&nbsp;|&nbsp;
               <a onClick="return confirm('你确定要退出吗？');" href="user.do?method=exit" target="_parent">退出</a>&nbsp;</td>
             </tr>
           </table>
           
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td class="menuMain"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td class="menuMain1"><table width="767" border="0" cellpadding="0" cellspacing="0">
                    <tr align="center">
                      <td width="60" height="25" class="menuLinkbg"><a href="foreground/home.jsp" class="menuLink" target="_parent">首页</a></td>
                      <td width="60" class="menuLinkbg">
                      	<a href="foreground/user_info.jsp" class="menuLink" target="_parent">我的信息</a></td>
                      <td width="60" class="menuLinkbg">
                      	<a href="foreground/personal_order_query.jsp" class="menuLink" target="_parent">我的订单</a></td>
                      <td width="70" class="menuLinkbg">
                      	<a href="foreground/cart_list.jsp" class="menuLink" target="_parent">我的购物车</a></td>
                      <td align="right" class="menuLinkbg">
                                            	
                      	<html:form action="product.do?service=queryProductByNameType" target="_parent">
                      		<html:text property="name" styleClass="selecttextwidth"></html:text>
                      		<html:select property="main_value" onchange="chgSlave()" styleClass="selectwidth">
                      		   <html:option value="所有分类">所有分类</html:option>
                      		</html:select>
                      		<html:select property="sub_value" styleClass="selectwidth">
                      			<html:option value=""></html:option>
                      		</html:select>
                            <html:image src="foreground/img/search.gif" align="absmiddle"></html:image>
                        </html:form>
                        
                      </td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
   </table>
</body>

</html:html>
