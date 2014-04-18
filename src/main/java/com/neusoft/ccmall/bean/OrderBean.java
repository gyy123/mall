package com.neusoft.ccmall.bean;

import java.util.ArrayList;

public class OrderBean {
	
	private int order_SEQ; //������ˮ��
	
	private String username; //�û���
	
	private String postcode; //�ʱ�
	
	private String address; //��ַ
	
	private String phone; //�绰
	
	private double total; //�ܼ�
	
	private int status; //����״̬
	
	private int post_type; //�ʼķ�ʽ
	
	private int pay_type; //֧����ʽ
	
	private String issue_date; //�µ�ʱ��
		
	private ArrayList<OrderProductBean> list_opb; //���OrderProductBean�ļ��ϣ�һ��������Ӧ�����Ʒ
	
	public int getOrder_SEQ() {
		return order_SEQ;
	}

	public void setOrder_SEQ(int order_SEQ) {
		this.order_SEQ = order_SEQ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPost_type() {
		return post_type;
	}

	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}

	public int getPay_type() {
		return pay_type;
	}

	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public ArrayList<OrderProductBean> getList_opb() {
		return list_opb;
	}

	public void setList_opb(ArrayList<OrderProductBean> list_opb) {
		this.list_opb = list_opb;
	}


}
