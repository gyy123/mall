package com.neusoft.ccmall.bean;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class OrderForm extends ActionForm {	
	
	private int order_SEQ; //订单流水号
	
	private String fromDate; //起始时间
	
	private String toDate; //结束时间
	
	private String username; //用户名
	
	private String postcode; //邮编
	
	private String address; //地址
	
	private String phone; //电话
	
	private double total; //总价
	
	private int status; //订单状态
	
	private int post_type; //邮寄方式
	
	private int pay_type; //支付方式
	
	private String issue_date; //下单时间
	
	private String issue_cause; //修改订单状态的原因
		
	public String getIssue_cause() {
		return issue_cause;
	}

	public void setIssue_cause(String issue_cause) {
		this.issue_cause = issue_cause;
	}

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

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	
}
