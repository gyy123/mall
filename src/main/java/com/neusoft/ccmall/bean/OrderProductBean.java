/**
 * 这个类封装了订单-商品信息
 */
package com.neusoft.ccmall.bean;

public class OrderProductBean {
	
	// 商品ID
	private int id;
	// 商品名称
	private String name;
	// 大分类
	private int main_category;
	// 小分类
	private int sub_category;
	// 大分类名称
	private String main_value;
	// 小分类名称
	private String sub_value;
	// 单价
	private double price;
	// 购买量
	private int num;
	
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
	public int getMain_category() {
		return main_category;
	}
	public void setMain_category(int main_category) {
		this.main_category = main_category;
	}
	public int getSub_category() {
		return sub_category;
	}
	public void setSub_category(int sub_category) {
		this.sub_category = sub_category;
	}
	public String getMain_value() {
		return main_value;
	}
	public void setMain_value(String main_value) {
		this.main_value = main_value;
	}
	public String getSub_value() {
		return sub_value;
	}
	public void setSub_value(String sub_value) {
		this.sub_value = sub_value;
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
	
	
}
