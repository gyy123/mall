package com.neusoft.ccmall.bean;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ManagerForm extends ActionForm {

    private int id; //id编号
	
	private String name; //管理员账号(已经有的管理员账号，主要用于登陆查询)
	
	private String newname;//添加新管理员账号
	
	private String password; //密码
	
	private String newpassword;//添加新管理员密码
	
	private String passwordold;//旧密码
	
	private String passwordnew;//新密码
	
	private int priority; //管理员权限 0系统管理员 1普通管理员
	
	private int product_do; //管理产品的权限，默认为无0
	
	private int product_category_do; //管理产品分类的权限，默认为无0
	
	private int news_do; //管理新闻资讯的权限，默认为无0
	
	private int user_do; //管理用户的权限，默认为无0
	
	private int order_do; //管理订单的权限，默认为无0

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getProduct_do() {
		return product_do;
	}

	public void setProduct_do(int product_do) {
		this.product_do = product_do;
	}

	public int getProduct_category_do() {
		return product_category_do;
	}

	public void setProduct_category_do(int product_category_do) {
		this.product_category_do = product_category_do;
	}

	public int getNews_do() {
		return news_do;
	}

	public void setNews_do(int news_do) {
		this.news_do = news_do;
	}

	public int getUser_do() {
		return user_do;
	}

	public void setUser_do(int user_do) {
		this.user_do = user_do;
	}

	public int getOrder_do() {
		return order_do;
	}

	public void setOrder_do(int order_do) {
		this.order_do = order_do;
	}

	public String getPasswordold() {
		return passwordold;
	}

	public void setPasswordold(String passwordold) {
		this.passwordold = passwordold;
	}

	public String getPasswordnew() {
		return passwordnew;
	}

	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}	
	
}
