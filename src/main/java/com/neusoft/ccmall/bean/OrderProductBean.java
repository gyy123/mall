/**
 * ������װ�˶���-��Ʒ��Ϣ
 */
package com.neusoft.ccmall.bean;

public class OrderProductBean {
	
	// ��ƷID
	private int id;
	// ��Ʒ����
	private String name;
	// �����
	private int main_category;
	// С����
	private int sub_category;
	// ���������
	private String main_value;
	// С��������
	private String sub_value;
	// ����
	private double price;
	// ������
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
