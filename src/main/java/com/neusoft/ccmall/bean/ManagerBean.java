package com.neusoft.ccmall.bean;

public class ManagerBean {

	private int id; //id���
	
	private String name; //����Ա�˺�
	
	private String password; //����
	
	private int priority; //����ԱȨ�� 0ϵͳ����Ա 1��ͨ����Ա
	
	private int product_do; //�����Ʒ��Ȩ�ޣ�Ĭ��Ϊ��0
	
	private int product_category_do; //�����Ʒ�����Ȩ�ޣ�Ĭ��Ϊ��0
	
	private int news_do; //����������Ѷ��Ȩ�ޣ�Ĭ��Ϊ��0
	
	private int user_do; //�����û���Ȩ�ޣ�Ĭ��Ϊ��0
	
	private int order_do; //��������Ȩ�ޣ�Ĭ��Ϊ��0

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
	
}
