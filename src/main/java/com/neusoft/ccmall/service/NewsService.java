/**
 * @author
 * @since
 * ��������Ҫ�����ǣ�
 * 1.�޸Ĺ���
 * 2.ɾ������
 * 3.������Ѷ
 * 4.�޸���Ѷ
 * 5.ɾ����Ѷ
 * 6.��ѯ��Ѷ
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.NewsBean;
import com.neusoft.ccmall.dao.NewsDao;

public class NewsService {


	/**
	 * ��ѯ����
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public String getPost1() {
	
		NewsDao nd=new NewsDao();
		
		String str=nd.getPost();
		
		return str;
	
	}

	/**
	 *�޸Ĺ���
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean updatePost(String content) {
		boolean flag = false;
		NewsDao nd=new NewsDao();
		nd.updatePost(content);
		return flag;
	}
	
	/**
	 * ɾ������
	 * @param id Ҫɾ������Ѷ�������ID
	 * @return trueɾ���ɹ� falseɾ��ʧ��
	 */
	public boolean deletePost() {
		boolean flag = false;
		NewsDao nd1=new NewsDao();
		nd1.deletePost();
		return flag;
	}
	
	/**
	 *�����Ѷ
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean addInformation(NewsBean nb) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.addInformation(nb);	
		return flag;
	}
	
	
	/**
	 * ��ѯ��Ѷ
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public ArrayList<NewsBean> getInformation() {
		NewsDao nd=new NewsDao();
		ArrayList<NewsBean> al=nd.getInformation();
		return al;
	
	}
	
	/**
	 *�޸���ѯ
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean updateInformation(String title,String content,int id) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.updateInformation(title, content, id);
		return flag;
	}
	

	/**
	 * ɾ����Ѷ
	 * @param id Ҫɾ������Ѷ�������ID
	 * @return trueɾ���ɹ� falseɾ��ʧ��
	 */
	public boolean deleteInformation(int id) {
		NewsDao nd=new NewsDao();
		boolean flag =nd.deleteIformation(id);
		return flag;
	}
	
	/**
	 * �鿴������Ѷ
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public NewsBean selectInformation(int id) {
		
		NewsDao nd=new NewsDao();
	    NewsBean nb=nd.selectInformation(id);
		return nb;
	
	}
	/**
	 *������Ѷ
	 * @param nb ��װ����ز���ֵ��NewsBean
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean updateStatus(int id) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.updateStatus(id);
		return flag;
	}
	
}
