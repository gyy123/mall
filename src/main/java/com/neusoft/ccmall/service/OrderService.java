/**
 * @author bigben
 * @since 2011-10-28
 * ��������Ҫ�����ǣ�
 * 1.���˲�ѯ�ض���������Ϣ
 * 2.���˲�ѯ�ض���������ϸ��Ϣ������ӡ����
 * 3.��ͨ����Ա��ѯ����
 * 4.��ͨ����Ա�޸Ķ���״̬
 * 5.��ͨ����Աɾ������
 * 6.���˶�������
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.PageBean;
import com.neusoft.ccmall.dao.OrderDao;

public class OrderService {
	
	
	/**
	 * ���˶�����ѯ
	 * @param order_SEQ �����ţ��οͶ����ű��
	 * @param from_date ʱ�������
	 * @param to_date ʱ�������
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(int order_SEQ, String fromDate, String toDate) {
		// ����DAO��
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryPersonalOrder(order_SEQ, fromDate, toDate);		
		return al;
	}
	
	/**
	 * ���˶�����ѯ
	 * @param order_SEQ �����ţ�ע���û������ſ�Ϊ�գ�
	 * @param from_date ʱ�������
	 * @param to_date ʱ�������
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(String username, int order_SEQ, String fromDate, String toDate, PageBean page) {
		// ����DAO��
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryPersonalOrder(username, order_SEQ, fromDate, toDate, page);		
		return al;
	}
	public PageBean getPageInfo(String username, int orderseq, String fromdate, String todate, int pageNow) {
		PageBean page = new OrderDao().getPageInfo(username, orderseq, fromdate, todate, pageNow);
		return page;
	}
	
	/**
	 * ���˴�ӡ��������ѯ���˶������飩
	 * @param order_SEQ ������
	 * @return ��װ�˶�����ϸ��Ϣ��OrderBean
	 */
	public OrderBean queryPersonalOrderInfo(int order_SEQ) {		
		OrderBean ob = new OrderDao().queryPersonalOrderInfo(order_SEQ);		
		return ob;
	}
	
	/**
	 * ҳ���ʼ����ѯ��������ӷ�ҳ��
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
	 * ����Ĳ�ѯ��ҳ���������ѯ����ť��ķ�ҳ��
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
	 * ��ͨ����Ա��ѯ����
	 * @param order_SEQ ������ˮ��
	 * @param status ����״̬
	 * @return ���ذ������з��������Ķ�������
	 */
	public ArrayList<OrderBean> queryAllOrders(int order_SEQ, int status, PageBean page) {
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryAllOrders(order_SEQ, status, page);		
		return al;
	}
	
	
	/**
	 * ҳ���ʼ����ѯ����
	 * @param status
	 * @return
	 */
	public ArrayList<OrderBean> queryOrders(int status, int pageNow, int pageSize) {
		OrderDao od = new OrderDao();
		ArrayList<OrderBean> al = od.queryOrders(status, pageNow, pageSize);		
		return al;
	}
	
	
	/**
	 * ��ͨ����Ա�޸Ķ���״̬��ֻ���޸�Ϊ�Ƿ���֧�����Ƿ��ѷ������Ƿ������ϣ�
	 * @param order_SEQ ������ˮ��
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public boolean updateOrderStatus(int order_SEQ, int status) {
		OrderDao od = new OrderDao();
			
		boolean flag = od.updateOrderStatus(order_SEQ, status);
		
		return flag;
	}
	
	
	/**
	 * ��ͨ����Աɾ��������ֻ��ɾ�������϶�����
	 * @param order_SEQ ������ˮ��
	 * @return trueɾ���ɹ� falseɾ��ʧ��
	 */
	public boolean deleteOrder(int order_SEQ) {
		boolean flag = new OrderDao().deleteOrder(order_SEQ);		
		return flag;
	}
	
	
	/**
	 * �����¶�������
	 * @param ob ��װ�˶�����ϸ��Ϣ��OrderBean
	 * @return ������
	 */
	public int addOrder(OrderBean ob) {
		OrderDao od = new OrderDao();
		int order_SEQ = od.addOrder(ob);
		return order_SEQ;
	}
	
	
	/**
	 * ��������ת�ˣ��޸Ķ���״̬Ϊ����֧����
	 * @param order_SEQ
	 * @return
	 */
	public boolean updateOrder(int order_SEQ) {
		OrderDao od = new OrderDao();
		boolean flag = od.updateOrder(order_SEQ);
		return flag;		
	}
	
}
