oM=new makeCM("oM"); oM.resizeCheck=1; oM.rows=1;  oM.onlineRoot="/";oM.offlineRoot=""; oM.pxBetween =0; 
oM.fillImg="cm_fill.gif"; oM.fromTop=42; oM.fromLeft=5; oM.wait=300; oM.zIndex=400;
oM.useBar=0; oM.barWidth="100%"; oM.barHeight="menu"; oM.barX=0;oM.barY="menu"; oM.barClass="clBar";
oM.barBorderX=0; oM.barBorderY=0;oM.openOnClick=1;oM.closeOnClick=0;
oM.level[0]=new cm_makeLevel(70,16,"clT","clTover",0,0,"clB",0,"bottom",0,0,0,0,0);
oM.level[1]=new cm_makeLevel(130,22,"clS","clSover",0,0,"clBS",0,"right",0,2,"../graphics/m_arrow.gif",10,15);
oM.level[2]=new cm_makeLevel(130,20,"clS2","clS2over");
oM.level[3]=new cm_makeLevel(90,20);


oM.makeMenu('m1','',' 首页','home.htm','',36);

oM.makeMenu('m2','','物流需求发布','','',114);	
/*	oM.makeMenu('m21','m2','物流项目录入','');
		oM.makeMenu('','m21','物流项目录入','release11.htm');
		oM.makeMenu('','m21','物流项目维护','release12.htm');
		oM.makeMenu('','m21','物流项目发布','release13.htm');
		oM.makeMenu('','m21','物流项目查询','release14.htm');
	oM.makeMenu('m22','m2','解决方案征询','');
		oM.makeMenu('','m22','解决方案录入','release21.htm');
		oM.makeMenu('','m22','解决方案维护','release22.htm');
		oM.makeMenu('','m22','解决方案发布','release23.htm');
		oM.makeMenu('','m22','解决方案查询','release24.htm');
*/
oM.makeMenu('m3','','物流解决方案','','',88);
/*	oM.makeMenu('m31','m3','整体解决方案展示','');
		oM.makeMenu('','m31','解决方案录入','solution11.htm');
		oM.makeMenu('','m31','解决方案维护','solution12.htm');
		oM.makeMenu('','m31','解决方案展示','solution13.htm');
	oM.makeMenu('m32','m3','区域解决方案展示','');
		oM.makeMenu('','m32','解决方案录入','solution21.htm');
		oM.makeMenu('','m32','解决方案维护','solution22.htm');
		oM.makeMenu('','m32','解决方案展示','solution23.htm');
	oM.makeMenu('m33','m3','行业解决方案展示','');
		oM.makeMenu('','m33','解决方案录入','solution31.htm');
		oM.makeMenu('','m33','解决方案维护','solution32.htm');
		oM.makeMenu('','m33','解决方案展示','solution33.htm');
*/
oM.makeMenu('m4','','物流企业园区','','',88);
/*	oM.makeMenu('','m4','企业信息录入','corp11.htm');
	oM.makeMenu('','m4','企业信息维护','corp12.htm');
	oM.makeMenu('','m4','企业信息查询','corp13.htm');
*/
oM.makeMenu('m5','','物流联盟论坛','','',88);
/*	oM.makeMenu('','m5','业务合作','forum11.htm');
	oM.makeMenu('','m5','技术支持','forum12.htm');
	oM.makeMenu('','m5','售后服务','forum13.htm');
	oM.makeMenu('','m5','投诉受理','forum14.htm');
	oM.makeMenu('','m5','意见反馈','forum15.htm');
*/		
oM.makeMenu('m6','','经销商申请','','',75);
/*	oM.makeMenu('','m6','经销商信息录入','supplierapply11.htm');
	oM.makeMenu('','m6','经销商信息维护','supplierapply12.htm');
	oM.makeMenu('','m6','经销商信息审批','supplierapply13.htm');
	oM.makeMenu('','m6','经销商信息查询','supplierapply14.htm');
*/
oM.makeMenu('m7','','物流运营数据分析系统','','',88);
/*	oM.makeMenu('m71','m7','在线计算','');
		oM.makeMenu('','m71','物流成本','calculator11.htm');
		oM.makeMenu('','m71','运行费用','calculator12.htm');
		oM.makeMenu('','m71','成本分析','calculator13.htm');
		oM.makeMenu('','m71','现金流分析','calculator14.htm');
		oM.makeMenu('','m71','资赁分析','calculator15.htm');
	oM.makeMenu('m72','m7','参数维护','');
		oM.makeMenu('','m72','运行参数维护','calculator21.htm');
		oM.makeMenu('','m72','产品参数维护','calculator22.htm');
*/
oM.makeMenu('m9','','GPS车辆跟踪','gps.htm','',84,'','','','','','');

oM.makeMenu('m10','','海关数据接口','ciq.htm','',88,'','','','','','');


/*菜单项属性
myCoolMenu.makeMenu(name, parent_name, text, link, target, width, height, regImage, overImage, regClass, overClass , align, rows, nolink, onclick, onmouseover, onmouseout)
*/

//var aaleft = "-1";
//oM.menuPlacement=new Array("2"+aaleft,"63"+aaleft,"124"+aaleft,"197"+aaleft,"258"+aaleft,"319"+aaleft,"440"+aaleft,"513"+aaleft,"574"+aaleft,"635"+aaleft,"696"+aaleft,"757"+aaleft,"818"+aaleft,"879"+aaleft,"940"+aaleft);
//oM.menuPlacement=0;
//var aaleft = "-2";
//oM.menuPlacement=new Array("2"+aaleft,"58"+aaleft,"114"+aaleft,"170"+aaleft,"226"+aaleft,"282"+aaleft,"338"+aaleft,"394"+aaleft,"450"+aaleft,"506"+aaleft,"562"+aaleft,"618"+aaleft,"674"+aaleft,"744"+aaleft,"814"+aaleft,"870"+aaleft,"926"+aaleft);
oM.menuPlacement=0;
oM.construct();

