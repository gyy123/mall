package com.neusoft.ccmall.bean;

public class ProductBean {
	
	private int product_SEQ; 
	
	private String name;
	
	private String description; 
	
	private int main_category; 
	
	private int sub_category; 

	private String main_value;
	 
	private String sub_value;
	
	private String unit; //

	private double price; 
	
	private int num; 
	
	private int recommend; 
	
	private String image; //
	
	


	public int getProduct_SEQ() {
		return product_SEQ;
	}

	public void setProduct_SEQ(int product_SEQ) {
		this.product_SEQ = product_SEQ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

}
