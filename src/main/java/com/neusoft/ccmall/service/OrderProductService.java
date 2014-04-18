package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.bean.OrderProductBean;
import com.neusoft.ccmall.dao.OrderProductDao;

public class OrderProductService {
	
	
	/**
	 * 添加订单商品记录
	 * @param order_SEQ
	 * @param mycart
	 * @return
	 */
	public boolean addOrderProduct(int order_SEQ, ArrayList<CartBean> mycart) {
		boolean flag = new OrderProductDao().addOrderProduct(order_SEQ, mycart);
		return flag;
	}
	
	
	/**
	 * 调用dao层方法获得订单下的商品集合
	 * @param order_SEQ
	 * @return
	 */
	public ArrayList<OrderProductBean> getOrderProducts(int order_SEQ) {
		ArrayList<OrderProductBean> list_opb = new OrderProductDao().getOrderProducts(order_SEQ);
		return list_opb;
	}
	
	/**
	 * 删除订单商品记录
	 * @param order_SEQ
	 * @return
	 */
	public boolean deleteOrderProduct(int order_SEQ) {
		boolean flag = new OrderProductDao().deleteOrderProduct(order_SEQ);
		return flag;
	}

}
