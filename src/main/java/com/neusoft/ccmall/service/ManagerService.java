/**
 * @author:
 * @since:
 * ��������Ҫ���ܣ�
 * 1.����Ա��¼
 * 2.����Ա�����޸�
 * 3.��ӹ���Ա
 * 4.��ѯ����Ա
 * 5.�޸Ĺ���ԱȨ��
 * 6.ɾ������Ա
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.ManagerBean;
import com.neusoft.ccmall.dao.ManagerDao;

public class ManagerService {
	
	/**
	 * ����Ա��¼
	 * @param manager_name ����Ա�˺�
	 * @param password ����Ա����
	 * @return true��¼�ɹ� false��¼ʧ��
	 */
	public boolean login(String manager_name, String password) {
		boolean flag = false;
		ManagerDao md = new ManagerDao();
		ManagerBean mb = md.getAdminByName(manager_name);
		if(mb!=null){
			if(password.equals(mb.getPassword())){
				flag = true;
			}
			
		}else{
			
		}
		
       return flag;
		
		
	}
	//����ԱȨ���ж�
	public int confirmPri(String manager_name){
		ManagerBean mb = new ManagerBean();
		ManagerDao md = new ManagerDao();
		mb = md.getAdminByName(manager_name);
		int priority = mb.getPriority();
		
		return priority;
	}
	
	
	/**
	 * ��ͨ����Ա�޸��Լ�������
	 * @param manager_name ����Ա�˺�
	 * @return true�����޸ĳɹ� false�����޸�ʧ��
	 */
	public boolean updatePassword(String manager_name,String password,String passwordnew) {
		boolean flag = false;
		ManagerDao md = new ManagerDao();
		
		if(password.equals(md.adminPassword(manager_name))){
			
			 md.updatepas(manager_name, passwordnew);
			 flag = true;
			
			
		}else{
			
			
		}
		
		
		return flag;
	}
	
	
	/**
	 * ϵͳ����Ա�����ͨ����Ա
	 * @param mb ��װ�˹���Ա����Ϣ
	 * @return true��ӳɹ� false���ʧ��
	 */
	public boolean addManager(ManagerBean mb) {
		boolean flag = false;
		ManagerDao md = new ManagerDao();
		ManagerBean mba = md.getAdminByName(mb.getName());
		if(mba==null){
			md.addadmin(mb);
			flag = true;
			
			
		}else{
			
			
		}
		
		return flag;
	}
	
	
	/**
	 * ϵͳ����Ա��ѯ���е���ͨ����Ա
	 * @return ArrayList<ManagerBean> ������������ͨ����Ա��ArrayList����
	 */
	public ArrayList<ManagerBean> queryAllManagers() {
		ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
		ManagerDao md = new ManagerDao();
		al = md.queryManagers();
		
		return al;
	}
	
	//��ѯ����Ա��Ϣ
	public ManagerBean queryManagerDo(String manager_name) {
		
		ManagerDao md = new ManagerDao();
		ManagerBean mb = new ManagerBean();
		mb = md.queryadmin(manager_name);
		return mb;	
	}
	
	
	/**
	 * ϵͳ����Ա�޸���ͨ����Ա��Ȩ��
	 * @param manager_name ��ͨ����Ա���˺�
	 * @return true�޸ĳɹ� false�޸�ʧ��
	 */
	
	
	
	public ManagerBean updateManagerDo(ManagerBean mb) {
		
		ManagerDao md = new ManagerDao();
		ManagerBean mba = new ManagerBean();
		mba = md.adminprimodify(mb);
		return mba;
			
	}
	
	/**
	 * ϵͳ����Աɾ����ͨ����Ա
	 * @param manager_name ��ͨ����Ա���˺�
	 * @return true ɾ���ɹ� falseɾ��ʧ��
	 */
	public void deleteManager(String manager_name) {
		
		ManagerDao md = new ManagerDao();
		md.deleteAdmin(manager_name);
		
	}
}
