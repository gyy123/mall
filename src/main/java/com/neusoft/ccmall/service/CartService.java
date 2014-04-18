/**
 * @author
 * @since
 * ��������Ҫ���ܣ�
 * 1.���ﳵ�����Ʒ
 * 2.�鿴���ﳵ
 * 3.�޸Ĺ�����Ʒ������Ajax��
 * 4.�ӹ��ﳵɾ����Ʒ
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;
//import java.util.HashMap;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.dao.CartDao;

public class CartService {
	
	CartDao cd = new CartDao();
	
	
	/**
	 * �鿴���ݿ⹺�ﳵ�����е���Ʒ
	 * @param username �û���
	 * @return ����
	 */
//	public HashMap<String, String> getCart(String username) {
//		HashMap<String, String> hm = cd.getCart(username);
//		return hm;
//	}
	public ArrayList<CartBean> getCart(String username) {
		ArrayList<CartBean> al = cd.getCart(username);
		return al;
	}
	
	
	/**
	 * �����ݿ�Ĺ��ﳵ�������Ʒ
	 * @param cb
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean addCart(CartBean cb) {
		
		boolean flag = cd.addCartToDB(cb);
		
		return flag;
	}
	

		
	/**
	 * �����ݿ�Ĺ��ﳵ��ɾ�����е���Ʒ
	 * @return
	 */
	public boolean deleteAllCart(String username) {
		
		return cd.deleteAllCart(username);
	}

}
