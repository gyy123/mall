package com.neusoft.ccmall.service;

import com.neusoft.ccmall.dao.OrderRecordDao;

public class OrderRecordService {

	/**
	 * ����Ա���޸Ķ���״̬ʱ����Ҫ������¼���ĸ�����Ա��ʲôʱ����Ϊʲô�޸����ĸ�������
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
