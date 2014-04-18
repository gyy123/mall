package com.neusoft.ccmall.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.SalesStaticsBean;
import com.neusoft.ccmall.bean.SalesStaticsForm;
import com.neusoft.ccmall.service.SalesStaticsService;



public class SalesStaticsDispatchAction extends DispatchAction {
	public ActionForward salesTotal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		SalesStaticsForm sf = (SalesStaticsForm)form;
		String main_type = sf.getMain_type();
		String name = sf.getName();
	    String issue_date_begin = sf.getIssue_date_begin();
		String issue_date_end  = sf.getIssue_date_end();
		System.out.println(main_type);
		System.out.println(name);
		System.out.println(issue_date_begin);
		System.out.println(issue_date_end);
		SalesStaticsService ss = new SalesStaticsService();
		ArrayList<SalesStaticsBean> al = new ArrayList<SalesStaticsBean>();
		al = ss.querySales(main_type, name, issue_date_begin, issue_date_end);
		request.setAttribute("sales", al);
		forward = mapping.findForward("sales");
		return forward;
		
		
		
		
	}

}
