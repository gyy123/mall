/**
 * @author bigben
 * @since 2011-10-28
 * 这个类的主要功能是：
 * 1.个人查询特定订单的信息
 * 2.个人查询特定订单的详细信息，即打印订单
 * 3.普通管理员查询订单
 * 4.普通管理员修改订单状态
 * 5.普通管理员删除订单
 * 6.个人订单生成
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.PageBean;
import com.neusoft.ccmall.dao.OrderDao;

public class OrderService {
	
	
	/**
	 * 个人订单查询
	 * @param order_SEQ 订单号（游客订单号必填）
	 * @param from_date 时间段条件
	 * @param to_date 时间段条件
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(int order_SEQ, String fromDate, String toDate) {
		// 调用DAO层
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryPersonalOrder(order_SEQ, fromDate, toDate);		
		return al;
	}
	
	/**
	 * 个人订单查询
	 * @param order_SEQ 订单号（注册用户订单号可为空）
	 * @param from_date 时间段条件
	 * @param to_date 时间段条件
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(String username, int order_SEQ, String fromDate, String toDate, PageBean page) {
		// 调用DAO层
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryPersonalOrder(username, order_SEQ, fromDate, toDate, page);		
		return al;
	}
	public PageBean getPageInfo(String username, int orderseq, String fromdate, String todate, int pageNow) {
		PageBean page = new OrderDao().getPageInfo(username, orderseq, fromdate, todate, pageNow);
		return page;
	}
	
	/**
	 * 个人打印订单（查询个人订单详情）
	 * @param order_SEQ 订单号
	 * @return 封装了订单详细信息的OrderBean
	 */
	public OrderBean queryPersonalOrderInfo(int order_SEQ) {		
		OrderBean ob = new OrderDao().queryPersonalOrderInfo(order_SEQ);		
		return ob;
	}
	
	/**
	 * 页面初始化查询（点击链接分页）
	 * @param order_SEQ
	 * @param status
	 * @param pageNow
	 * @return
	 */
	public PageBean getPageInfo(int status, int pageNow) {
		PageBean page = new OrderDao().getPageInfo(status, pageNow);
		return page;
	}
	
	
	/**
	 * 具体的查询分页（点击“查询”按钮后的分页）
	 * @param order_SEQ
	 * @param status
	 * @param pageNow
	 * @return
	 */
	public PageBean getPageInfo(int order_SEQ, int status, int pageNow) {
		PageBean page = new OrderDao().getPageInfo(order_SEQ, status, pageNow);
		return page;
	}
	
	
	
	/**
	 * 普通管理员查询订单
	 * @param order_SEQ 订单流水号
	 * @param status 订单状态
	 * @return 返回包含所有符合条件的订单集合
	 */
	public ArrayList<OrderBean> queryAllOrders(int order_SEQ, int status, PageBean page) {
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryAllOrders(order_SEQ, status, page);		
		return al;
	}
	
	
	/**
	 * 页面初始化查询订单
	 * @param status
	 * @return
	 */
	public ArrayList<OrderBean> queryOrders(int status, int pageNow, int pageSize) {
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryOrders(status, pageNow, pageSize);		
		return al;
	}
	
	
	/**
	 * 普通管理员修改订单状态（只能修改为是否已支付，是否已发货，是否已作废）
	 * @param order_SEQ 订单流水号
	 * @return true修改成功 false修改失败
	 */
	public boolean updateOrderStatus(int order_SEQ, int status) {
		OrderDao od = new OrderDao();
			
		boolean flag = od.updateOrderStatus(order_SEQ, status);
		
		return flag;
	}
	
	
	/**
	 * 普通管理员删除订单（只能删除已作废订单）
	 * @param order_SEQ 订单流水号
	 * @return true删除成功 false删除失败
	 */
	public boolean deleteOrder(int order_SEQ) {
		boolean flag = new OrderDao().deleteOrder(order_SEQ);		
		return flag;
	}
	
	
	/**
	 * 个人新订单生成
	 * @param ob 封装了订单详细信息的OrderBean
	 * @return 订单号
	 */
	public int addOrder(OrderBean ob) {
		OrderDao od = new OrderDao();
		int order_SEQ = od.addOrder(ob);
		return order_SEQ;
	}
	
	
	/**
	 * 网上银行转账，修改订单状态为“已支付”
	 * @param order_SEQ
	 * @return
	 */
	public boolean updateOrder(int order_SEQ) {
		OrderDao od = new OrderDao();
		boolean flag = od.updateOrder(order_SEQ);
		return flag;		
	}
	
}
