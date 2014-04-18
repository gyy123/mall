/**
 * @author
 * @since
 * ��������Ҫ�����ǣ�
 * 1.��������
 * 2.��ʾ�ض���Ʒ��������
 * 3.ɾ���ض���Ʒ���ض�����
 * 4.ɾ���ض���Ʒ����������
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.CommentBean;
import com.neusoft.ccmall.dao.CommentDao;

public class CommentService {

	CommentDao cd = new CommentDao();
	
	/**
	 * ע���û�����Ʒ��������
	 * @param cb ��װ�����������Ϣ��CommentBean
	 * @return true���۳ɹ� false����ʧ��
	 */
	public boolean addComment(CommentBean cb) {
		
		boolean flag = cd.addComment(cb);
		
		return flag;
	}
	
	
	/**
	 * ��ͨ����Ա�ڲ鿴��Ʒ��ϸ��Ϣʱ��ʾ����Ʒ����������
	 * @param id ��Ʒ��ID���
	 * @return ���������жԸ���Ʒ�����۵�ArrayList����
	 */
	public ArrayList<CommentBean> showAllComments(int product_seq) {
		
		ArrayList<CommentBean> al = cd.showAllComments(product_seq);
		
		return al;
	}
	
	
	/**
	 * ��ͨ����Աɾ���ض���Ʒ���ض�����
	 * @param id ��Ʒ��ID���
	 * @return trueɾ���ɹ� falseɾ��ʧ��
	 */
	public boolean deleteComment(int id) {
		boolean flag = false;
		
		return flag;
	}
	
	
	/**
	 * ��ͨ����Աɾ���ض���Ʒ����������
	 * @param id �ض���Ʒ��ID���
	 * @return trueɾ���ɹ� falseɾ��ʧ��
	 */
	public boolean deleteAllComments(int id) {
		boolean flag = false;
		
		return flag;
	}
	
}
