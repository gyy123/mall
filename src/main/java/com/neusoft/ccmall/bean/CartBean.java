package com.neusoft.ccmall.bean;


public class CartBean {
	
	private int productseq;
	private String productname;
	private double price;
	private int num;
	private String username;
	
	public int getProductseq() {
		return productseq;
	}
	public void setProductseq(int productseq) {
		this.productseq = productseq;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
