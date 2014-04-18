/**
 * @author:
 * @since:
 * 这个类的主要功能：
 * 1.管理员登录
 * 2.管理员密码修改
 * 3.添加管理员
 * 4.查询管理员
 * 5.修改管理员权限
 * 6.删除管理员
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.ManagerBean;
import com.neusoft.ccmall.dao.ManagerDao;

public class ManagerService {
	
	/**
	 * 管理员登录
	 * @param manager_name 管理员账号
	 * @param password 管理员密码
	 * @return true登录成功 false登录失败
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
	//管理员权限判断
	public int confirmPri(String manager_name){
		ManagerBean mb = new ManagerBean();
		ManagerDao md = new ManagerDao();
		mb = md.getAdminByName(manager_name);
		int priority = mb.getPriority();
		
		return priority;
	}
	
	
	/**
	 * 普通管理员修改自己的密码
	 * @param manager_name 管理员账号
	 * @return true密码修改成功 false密码修改失败
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
	 * 系统管理员添加普通管理员
	 * @param mb 封装了管理员的信息
	 * @return true添加成功 false添加失败
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
	 * 系统管理员查询所有的普通管理员
	 * @return ArrayList<ManagerBean> 包含了所有普通管理员的ArrayList集合
	 */
	public ArrayList<ManagerBean> queryAllManagers() {
		ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
		ManagerDao md = new ManagerDao();
		al = md.queryManagers();
		
		return al;
	}
	
	//查询管理员信息
	public ManagerBean queryManagerDo(String manager_name) {
		
		ManagerDao md = new ManagerDao();
		ManagerBean mb = new ManagerBean();
		mb = md.queryadmin(manager_name);
		return mb;	
	}
	
	
	/**
	 * 系统管理员修改普通管理员的权限
	 * @param manager_name 普通管理员的账号
	 * @return true修改成功 false修改失败
	 */
	
	
	
	public ManagerBean updateManagerDo(ManagerBean mb) {
		
		ManagerDao md = new ManagerDao();
		ManagerBean mba = new ManagerBean();
		mba = md.adminprimodify(mb);
		return mba;
			
	}
	
	/**
	 * 系统管理员删除普通管理员
	 * @param manager_name 普通管理员的账号
	 * @return true 删除成功 false删除失败
	 */
	public void deleteManager(String manager_name) {
		
		ManagerDao md = new ManagerDao();
		md.deleteAdmin(manager_name);
		
	}
}
