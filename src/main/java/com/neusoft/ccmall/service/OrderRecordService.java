package com.neusoft.ccmall.service;

import com.neusoft.ccmall.dao.OrderRecordDao;

public class OrderRecordService {

	/**
	 * 管理员在修改订单状态时，需要做个记录（哪个管理员在什么时间因为什么修改了哪个订单）
	 * @param product_seq
	 * @param mangername
	 * @param issue_cause
	 * @return
	 */
	public boolean addOrderRecord(int order_seq, String managername, String issue_cause) {
		boolean b = new OrderRecordDao().addOrderRecord(order_seq, managername, issue_cause);
		return b;
	}
	
}
