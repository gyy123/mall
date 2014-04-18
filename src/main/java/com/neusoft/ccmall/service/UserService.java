/**
 * ��������Ҫ���ܣ�
 * 1.��ͨ����Ա��ѯע���û���Ϣ
 * 2.��ͨ����Աɾ��ע���û���Ϣ
 * 3.�û�ע��
 * 4.�û���¼
 * 5.�û���ѯ������Ϣ
 * 6.�û��޸ĸ�����Ϣ
 * 7.�û��޸�����
 * 8.�û��һ�����
 * @author:
 * @since:
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.UserBean;

import com.neusoft.ccmall.dao.UserDao;

public class UserService {
	
	UserDao ud = new UserDao();
	
	/**
	 * ��ͨ����Ա����ע���û���ͨ���û�����ѯ�û���Ϣ
	 * @param username �û���
	 * @return UserBean��һ������
	 */
	public UserBean queryUser(String username) {
		
		UserBean ub = ud.getUserByName(username);
		
		return ub;
	}
	
		
	/**
	 * ��ͨ����Աɾ���û�
	 * @param ub UserBean��һ������
	 * @return boolean��trueɾ���ɹ���falseɾ��ʧ�ܣ�
	 */
//	public boolean deleteUser(String username) {
//		boolean flag = false;
//		UserDao ud = new UserDao();
//		if(ud.getOrderByName(username)==null){
//			flag = true;
//			
//			
//		}else{
//			
//		}
//		return flag;
//	}
	
	
	/**
	 * �û�ע��
	 * @param ub ��װ���û��������Ϣ
	 * @return trueע��ɹ� falseע��ʧ��
	 */
	public boolean register(UserBean ub) {
		boolean flag=false;
		//�ж��û��Ƿ����
		UserBean u=ud.getUserByName(ub.getUsername());
		//��������ڣ����û���Ϣ��ӵ����ݿ�
		if(u==null){
			flag=ud.addUser(ub);			
		}
		return flag;
	}
	
	
	
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return true��¼�ɹ� false��¼ʧ��
	 */
	public boolean login(String username,String password){
		boolean flag=false;
		//�ж��û��Ƿ����
		UserDao dao=new UserDao();
		UserBean user=dao.getUserByName(username);
		//����û����ڣ��ж�����͸��û����Ƿ�һ��
		if(user!=null){
			if(password.equals(user.getPassword())){
				flag=true;
			}
		}
		return flag;
	}
	public boolean ordered(String username){
		boolean flag=false;
		//�ж��û��Ƿ��ж���
		UserDao dao=new UserDao();
		OrderBean ob=dao.getOrderByName(username);
		//����û�û�ж���
		if(ob==null){
			    dao.deleteUser(username);
				flag=true;//����ɾ��
			
		}
		return flag;
	}
	
	/**
	 * ע���û��޸ĸ�����Ϣ
	 * @param ub ��װ���û��µĸ�����Ϣ
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public boolean updateUser(UserBean ub) {
		boolean flag = ud.updateUser(ub);		
		return flag;
	}
	
	
	
	/**
	 * ע���û��޸�����
	 * @param username �û���
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	public boolean updatePassword(String username, String newPassword) {
		boolean flag = ud.updatePassword(username, newPassword);		
		return flag;
	}
	
/*	
	*//**
	 * �һ������һ���������û�����Ӧ������
	 * @param username
	 * @return question == ""˵���û�������
	 * 		   question != ""˵���û����ڣ�����ȡ���û���Ӧ������
	 *//*
	public String getQuestion(String username) {
		String question = "";
		UserBean ub = ud.getUserByName(username);
		// ���ub��Ϊ�գ�˵���û����ڣ����ɵõ��û�Ԥ���趨������
		if (ub != null) {
			question = ub.getQuestion();
		}
		return question;
	}
	
	*//**
	 * �һ�����ڶ��������������Ӧ�Ĵ�
	 * @param username
	 * @return
	 *//*
	public String getAnswer(String username) {
		return ud.getUserByName(username).getAnswer();
	}
*/
	/**
	 * ��ͨ����Ա��ѯ���е��û���Ϣ
	 * @return ArrayList<UserBean> �����������û���ArrayList����
	 */
	public ArrayList<UserBean> queryUsers(String username,String registerdate_begin,String registerdate_end ) {
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		UserDao ud = new UserDao();
		al = ud.queryUsers(username,registerdate_begin,registerdate_end);
		
		return al;
	}
	
}
