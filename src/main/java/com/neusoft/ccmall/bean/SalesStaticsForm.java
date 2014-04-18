package com.neusoft.ccmall.bean;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class SalesStaticsForm extends ActionForm {

	private String main_type; //
	
	private String name; //
	
    private String issue_date_begin;//
	
	private String issue_date_end;//

	public String getMain_type() {
		return main_type;
	}

	public void setMain_type(String mainType) {
		main_type = mainType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssue_date_begin() {
		return issue_date_begin;
	}

	public void setIssue_date_begin(String issueDateBegin) {
		issue_date_begin = issueDateBegin;
	}

	public String getIssue_date_end() {
		return issue_date_end;
	}

	public void setIssue_date_end(String issueDateEnd) {
		issue_date_end = issueDateEnd;
	}
	
}
