package com.neusoft.ccmall.bean;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class UserForm extends ActionForm {


	private String registerdate_begin;
	
	private String registerdate_end;
	
	private String username; 
	
	private String password; 
	
	private String password2; 
	
	private String truename; 
	
	private String id_card; 
	
	private String email; 
	
	private String postcode; 
	
	private String address;
	
	private String phone; 
	
	private String question; 
	
	private String answer; 
	
	private String registerdate; 
	
	private boolean remember; 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRememberpw(boolean remember) {
		this.remember = remember;
	}

	public String getRegisterdate_begin() {
		return registerdate_begin;
	}

	public void setRegisterdate_begin(String registerdate_begin) {
		this.registerdate_begin = registerdate_begin;
	}

	public String getRegisterdate_end() {
		return registerdate_end;
	}

	public void setRegisterdate_end(String registerdate_end) {
		this.registerdate_end = registerdate_end;
	}

	

	
}
