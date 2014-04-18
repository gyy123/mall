package com.neusoft.ccmall.bean;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class NewsForm extends ActionForm {

	private int id; //ID
	
	private String title; //标题
	
	private int status; //状态 0未发布 1已发布
	
	private String content; //内容
	
	private String issue_date; //发布日期
	
	private int type; //0公告 1资讯

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
