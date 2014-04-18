<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home_nologin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="foreground/css/styles.css">
	

  </head>
  
  <body>
  <center>
    <iframe src="foreground/top_nologin.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="123" scrolling="no"></iframe>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="yrh">
	  <tr>
	    <td><a href="foreground/home.jsp">主页</a></td>
	  </tr>
	</table>
	<table width="770" border="0" cellpadding="0" cellspacing="0" class="main">
	  <tr valign="top">
	    <td width="770"><form action="" method="post" enctype="multipart/form-data" name="form1">
	        <table width="100%" border="0" cellpadding="2" cellspacing="1" class="inputTable">
	          <tr>
	            <td class="inputTitle">商品目录</td>
	          </tr>
	          <tr>
	            <td class="inputHeader"><table width="100%" border="0" cellpadding="0" cellspacing="1" class="inputbox">
	                <tr>
	                  <td width="21%" valign="top"><table width="100%" border="0" bordercolor="#CCCCCC" cellpadding="0" cellspacing="0">
	                      <tr>
	                        <td height="28" colspan="2" class="inputHeader"><font color="#CC0000">图书音像</font></td>
	                      </tr>
	                      <tr>
	                        <td width="50%" align="left" class="inputHeader"><a href="#" class="menuLink">外语</a></td>
	                        <td width="50%" align="left" class="inputHeader"><a href="item_list.htm" class="menuLink">教材</a></td>
	                      </tr>
	                      <tr>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">公务员考试</a></td>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">考研用书</a></td>
	                      </tr>
	                      <tr>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">音乐</a></td>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">影视</a></td>
	                      </tr>
	                      <tr>
	                        <td height="28" colspan="2" class="inputHeader"><font color="#CC0000">时尚生活</font></td>
	                      </tr>
	                      <tr>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">护肤</a></td>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">首饰</a></td>
	                      </tr>
	                      <tr>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">服装</a></td>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">箱包</a></td>
	                      </tr>
	                      <tr>
	                        <td height="28" colspan="2" class="inputHeader"><font color="#CC0000">数码产品</font></td>
	                      </tr>
	                      <tr>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">数码相机</a></td>
	                        <td align="left" class="inputHeader"><a href="#" class="menuLink">mp3</a></td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader">数码录音笔</td>
	                        <td class="inputHeader">数码配件</td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader">硬盘</td>
	                        <td class="inputHeader">耳机</td>
	                      </tr>
	                      <tr>
	                        <td height="28"  colspan="2" class="inputHeader"><font color="#CC0000">鲜花速递</font></td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader"><a href="#" class="menuLink">玫瑰</a></td>
	                        <td class="inputHeader"><a href="#" class="menuLink">百合</a></td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader"><a href="#" class="menuLink">康耐馨</a></td>
	                        <td class="inputHeader"><a href="#" class="menuLink">太阳花</a></td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader"><a href="#" class="menuLink">菊花</a></td>
	                        <td class="inputHeader"><a href="#" class="menuLink">郁金香</a></td>
	                      </tr>
	                      <tr>
	                        <td height="28" colspan="2" class="inputHeader"><font color="#CC0000">酒店预订</font></td>
	                      </tr>
	                      <tr>
	                        <td class="inputHeader"><a href="#" class="menuLink">折扣酒店</a></td>
	                        <td class="inputHeader"><a href="#" class="menuLink">推荐酒店</a></td>
	                      </tr>
	                    </table>
	                    <table>
	                      <tr>
	                        <td colspan="2">
	                        	<a href="cart_list.htm">
	                        		<img src="foreground/img/buycart_nav.jpg" width="154" height="66" border="0">
	                        	</a>
	                        </td>
	                      </tr>
	                      <tr>
	                        <td width="72" align="center">item:</td>
	                        <td width="81">3</td>
	                      </tr>
	                      <tr>
	                        <td align="center">total:</td>
	                        <td>3000.00</td>
	                      </tr>
	                    </table>
	                    <table width="174">
	                      <tr>
	                        <td width="175">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td><img src="foreground/img/news.jpg" width="167" height="28"></td>
	                      </tr>
	                      <tr>
	                        <td>网站系统于昨晚已成功升级！</td>
	                      </tr>
	                      <tr>
	                        <td>&nbsp;</td>
	                      </tr>
	                    </table>
	                    <table width="174">
	                      <tr>
	                        <td width="175">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td><img src="foreground/img/zx.jpg" width="167" height="28"></td>
	                      </tr>
	                      <tr>
	                        <td>节日大酬宾，所有商品9.5折</td>
	                      </tr>
	                      <tr>
	                        <td>&nbsp;</td>
	                      </tr>
	                    </table></td>
	                  <td width="79%" valign="top"><table width="585"  border="0" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" class="inputbox">
	                      <tr>
	                        <td width="4" rowspan="28">&nbsp;</td>
	                        <td width="131" height="30" class="inputHeaderGrey STYLE1">推荐商品</td>
	                        <td width="129" height="30" class="inputHeaderGrey STYLE1">&nbsp;</td>
	                        <td height="30" class="inputHeaderGrey STYLE1">&nbsp;</td>
	                        <td width="109">&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td ><a href="foreground/item_info.jsp"><img src="foreground/img/dxwl4.jpg" border="0" width="94" height="134"></a></td>
	                        <td><img src="foreground/img/wj.jpg" width="102" height="134"></td>
	                        <td width="118"><img src="foreground/img/ssbs.jpg" width="98" height="134"></td>
	                        <td width="109"><img src="foreground/img/mm.jpg" width="98" height="134"></td>
	                        <td width="102"><img src="foreground/img/baihe.jpg" width="102" height="135"></td>
	                      </tr>
	                      <tr>
	                        <td  align="center"><span class="inputHeader ">大学物理学.第四册：波动与光学(第2版)<br>
	                          <font color="#CC0000"><strong>￥8.50</strong> </font>85折</span></td>
	                        <td align="center">美瑞贝尔皇冠★最新韩版丝麻质感围巾<br>
	                          <font color="#CC0000"><strong>￥33.00 </strong></font> 75折</td>
	                        <td align="center">时尚芭莎(2007年12月号 总第162期)<br>
	                          <font color="#CC0000"><strong> ￥16.00 </strong></font> 80折</td>
	                        <td align="center">晶冻啤酒酵母晚安冻膜60ML<br>
	                          <font color="#CC0000"><strong>￥54.99 </strong></font> 80折</td>
	                        <td align="center">百媚千娇<br>
	                          香水百合*黄莺<br>
	                          <font color="#CC0000"><strong>￥168.00 </strong></font> 90折</td>
	                      </tr>
	                      <tr>
	                        <td height="30" ><span class="inputHeaderGrey STYLE1">图书音像</span></td>
	                        <td>&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td rowspan="7"><img src="foreground/img/xydydxt.jpg" width="96" height="141"></td>
	                        <td rowspan="7"><img src="foreground/img/yxqygl.jpg" width="96" height="141"></td>
	                        <td height="21" colspan="3"><a href="item_info.htm" target="_blank"><span class="inputHeader ">大学物理学.第四册：波动与光学（第2版）<font color="#CC0000"><strong>￥8.50</strong></font></span></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3"><a href="#">下一代移动系统 <font color="#CC0000"><strong>￥13.60</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3"><a href="#">联邦快递的生意经:伟大的企业是这样诞生的 <font color="#CC0000"><strong>￥22.40</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3"><a href="#">玛蒂娜的朋友们在森林里 <font color="#CC0000"><strong>￥4.06</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="16" colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td height="11" colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td height="30"><span class="inputHeaderGrey STYLE1">时尚生活</span></td>
	                        <td>&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td rowspan="6" ><img src="foreground/img/sssh.gif" width="109" height="141"></td>
	                        <td rowspan="6"><img src="foreground/img/dzh.jpg" width="109" height="141"></td>
	                        <td height="21" colspan="3" class="inputHeader "><a href="#"> 台湾广源良新版小黄瓜嫩肤水120ml <font color="#CC0000"><strong>￥39.99 </strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3" class="inputHeader "><a href="#">D2478 花形紫水晶吊坠 <font color="#CC0000"><strong>￥129.90 </strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3" class="inputHeader "><a href="#">SWATCH2007春夏超薄系列SFK285G 浮华背后 <font color="#CC0000"><strong>￥570.00</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td height="21" colspan="3" class="inputHeader "><a href="#">瑞丽613# 经典双排扣大衣 <font color="#CC0000"><strong>￥105.00</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="3" class="inputHeader ">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td colspan="3" class="inputHeader ">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td height="30" ><span class="inputHeaderGrey STYLE1">数码产品</span></td>
	                        <td>&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td rowspan="5" ><img src="foreground/img/jsq.jpg" width="109" height="141"></td>
	                        <td rowspan="5"><img src="foreground/img/ykb.jpg" width="109" height="141"></td>
	                        <td height="21" colspan="3"><a href="#">无线遥控激光笔*演讲会议培训 <font color="#CC0000"><strong>￥54.99 </strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="3"  height="21"><a href="#">日本气化迷你USB加湿器 <font color="#CC0000"><strong>￥36.00</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="3"  height="21"><a href="#">IBM清洁套装5件套 <font color="#CC0000"><strong>￥13.70</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="3"  height="21"><a href="#">索尼DSC-T2数码相机 <font color="#CC0000"><strong>￥2400.00</strong></font></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td >&nbsp;</td>
	                        <td>&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                      <tr>
	                        <td>&nbsp;</td>
	                        <td>&nbsp;</td>
	                        <td colspan="3">&nbsp;</td>
	                      </tr>
	                    </table></td>
	                </tr>
	              </table></td>
	          </tr>
	        </table>
	      </form></td>
	  </tr>
	</table>
	<iframe src="foreground/bottom.jsp" frameborder="0" marginheight="0" marginwidth="0" width="770" height="100" scrolling="no"></iframe>
  </center>
  </body>
</html>
