/**
 * 这个类的主要功能：
 * 1.普通管理员查询注册用户信息
 * 2.普通管理员删除注册用户信息
 * 3.用户注册
 * 4.用户登录
 * 5.用户查询个人信息
 * 6.用户修改个人信息
 * 7.用户修改密码
 * 8.用户找回密码
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
	 * 普通管理员（已注册用户）通过用户名查询用户信息
	 * @param username 用户名
	 * @return UserBean的一个对象
	 */
	public UserBean queryUser(String username) {
		
		UserBean ub = ud.getUserByName(username);
		
		return ub;
	}
	
		
	/**
	 * 普通管理员删除用户
	 * @param ub UserBean的一个对象
	 * @return boolean（true删除成功，false删除失败）
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
	 * 用户注册
	 * @param ub 封装了用户的相关信息
	 * @return true注册成功 false注册失败
	 */
	public boolean register(UserBean ub) {
		boolean flag=false;
		//判断用户是否存在
		UserBean u=ud.getUserByName(ub.getUsername());
		//如果不存在，将用户信息添加到数据库
		if(u==null){
			flag=ud.addUser(ub);			
		}
		return flag;
	}
	
	
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return true登录成功 false登录失败
	 */
	public boolean login(String username,String password){
		boolean flag=false;
		//判断用户是否存在
		UserDao dao=new UserDao();
		UserBean user=dao.getUserByName(username);
		//如果用户存在，判断密码和该用户的是否一致
		if(user!=null){
			if(password.equals(user.getPassword())){
				flag=true;
			}
		}
		return flag;
	}
	public boolean ordered(String username){
		boolean flag=false;
		//判断用户是否有订单
		UserDao dao=new UserDao();
		OrderBean ob=dao.getOrderByName(username);
		//如果用户没有订单
		if(ob==null){
			    dao.deleteUser(username);
				flag=true;//可以删除
			
		}
		return flag;
	}
	
	/**
	 * 注册用户修改个人信息
	 * @param ub 封装了用户新的个人信息
	 * @return true修改成功 false修改失败
	 */
	public boolean updateUser(UserBean ub) {
		boolean flag = ud.updateUser(ub);		
		return flag;
	}
	
	
	
	/**
	 * 注册用户修改密码
	 * @param username 用户名
	 * @return true修改成功 false修改失败
	 */
	public boolean updatePassword(String username, String newPassword) {
		boolean flag = ud.updatePassword(username, newPassword);		
		return flag;
	}
	
/*	
	*//**
	 * 找回密码第一步，返回用户名对应的问题
	 * @param username
	 * @return question == ""说明用户不存在
	 * 		   question != ""说明用户存在，即可取到用户对应的问题
	 *//*
	public String getQuestion(String username) {
		String question = "";
		UserBean ub = ud.getUserByName(username);
		// 如果ub不为空，说明用户存在，即可得到用户预先设定的问题
		if (ub != null) {
			question = ub.getQuestion();
		}
		return question;
	}
	
	*//**
	 * 找回密码第二步，返回问题对应的答案
	 * @param username
	 * @return
	 *//*
	public String getAnswer(String username) {
		return ud.getUserByName(username).getAnswer();
	}
*/
	/**
	 * 普通管理员查询所有的用户信息
	 * @return ArrayList<UserBean> 包含了所有用户的ArrayList集合
	 */
	public ArrayList<UserBean> queryUsers(String username,String registerdate_begin,String registerdate_end ) {
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		UserDao ud = new UserDao();
		al = ud.queryUsers(username,registerdate_begin,registerdate_end);
		
		return al;
	}
	
}
