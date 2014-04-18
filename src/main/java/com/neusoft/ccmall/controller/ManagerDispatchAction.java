package com.neusoft.ccmall.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.ManagerBean;
import com.neusoft.ccmall.bean.ManagerForm;
import com.neusoft.ccmall.dao.ManagerDao;
import com.neusoft.ccmall.service.ManagerService;

public class ManagerDispatchAction extends DispatchAction {

	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		ManagerForm mf =(ManagerForm)form;
		String name = mf.getName();
		String password = mf.getPassword();
		//System.out.println(name);
		//System.out.println(password);
		ManagerService ms = new ManagerService();
		boolean issuccess = ms.login(name, password);
		ManagerBean mb = new ManagerBean();
		ManagerDao md = new ManagerDao();
		if(issuccess){
			request.getSession().setAttribute("adminname", name);
			//request.setAttribute("adminname", name);
			request.getSession().setAttribute("time", new Date());
			if(ms.confirmPri(name)==0){
				
			forward = mapping.findForward("superlogsuccess");
			
			}else{
			
				 mb = md.getAdminByName(name);
				 request.getSession().setAttribute("pri", mb);
			forward = mapping.findForward("logsuccess");
			}
			
		}else{
			request.setAttribute("result", 1);
			forward = mapping.findForward("logfail");
		}
		
		
		
		
		return forward;
	}
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modifypas(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		ManagerForm mf = (ManagerForm)form;
		String name = request.getParameter("adname");
		String passwordold = mf.getPasswordold();
		String passwordnew = mf.getPasswordnew();
		
		System.out.println(name);
		System.out.println(passwordold);
		ActionForward forward = null;
		ManagerService ms = new ManagerService();
		
		
		boolean success = ms.updatePassword(name, passwordold, passwordnew);
		
		if(success){
			if(ms.confirmPri(name)==0){
				request.setAttribute("result", 1);
				forward = mapping.findForward("superupsuccess");
				
				}else{
				
				
				request.setAttribute("result", 1);
				forward = mapping.findForward("upsuccess");
				}
			
		}
		else{
            if(ms.confirmPri(name)==0){
            	request.setAttribute("result", 0);
				forward = mapping.findForward("superupfail");
				
				}else{
				
				request.setAttribute("result", 0);
				forward = mapping.findForward("upfail");
				}
			
			
			
			
		}

		return forward;
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = null;
		ManagerForm mf = (ManagerForm)form;
		String newname = mf.getNewname();
		String newpassword = mf.getNewpassword();
		int product_do = mf.getProduct_do();
		int product_category_do = mf.getProduct_category_do();
		int news_do = mf.getNews_do();
		int user_do = mf.getUser_do();
		int order_do = mf.getOrder_do();
		//System.out.println(product_do);
		//System.out.println(product_category_do);
		//System.out.println(news_do);
		ManagerBean mb = new ManagerBean();
		mb.setName(newname);
		mb.setPassword(newpassword);
		mb.setProduct_do(product_do);
		mb.setProduct_category_do(product_category_do);
		mb.setNews_do(news_do);
		mb.setUser_do(user_do);
		mb.setOrder_do(order_do);
		
		ManagerService ms = new ManagerService();
		ms.addManager(mb);
		
		
			
			ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
			al = ms.queryAllManagers();
			request.setAttribute("alladmin", al);
			forward = mapping.findForward("adminresult");
			
			
			
		
		
		return forward;
	}
	
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		String name = request.getParameter("cname");
		ManagerService ms = new ManagerService();
		ms.deleteManager(name);
		
		ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
		al = ms.queryAllManagers();
		request.setAttribute("alladmin", al);
		forward = mapping.findForward("adminresult");
		return forward;
		
		
		
		
	}
	
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryAllManagers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		ManagerService ms = new ManagerService();
		ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
		al = ms.queryAllManagers();
		request.setAttribute("alladmin", al);
		forward = mapping.findForward("adminresult");
		return forward;
	}
	
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		
		
		
		return forward;
	}
	
	
	/**Ȩ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePriority(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		ManagerForm mf = (ManagerForm)form;
		int id = mf.getId();
		
		String name = request.getParameter("name");
		int product_do = mf.getProduct_do();
		int product_category_do = mf.getProduct_category_do();
		int news_do = mf.getNews_do();
		int user_do = mf.getUser_do();
		int order_do = mf.getOrder_do();
		//System.out.println(name);
		//System.out.println(product_do);
		//System.out.println(product_category_do);
		//System.out.println(news_do);
		//System.out.println(user_do);
		//System.out.println(order_do);
		ManagerBean mb = new ManagerBean();
		mb.setId(id);
		mb.setName(name);	
		mb.setProduct_do(product_do);
		mb.setProduct_category_do(product_category_do);
		mb.setNews_do(news_do);
		mb.setUser_do(user_do);
		mb.setOrder_do(order_do);
		
		ManagerService ms = new ManagerService();
		//updateManagerDo
		ms.updateManagerDo(mb);
		
		
		ArrayList<ManagerBean> al = new ArrayList<ManagerBean>();
		al = ms.queryAllManagers();
		request.setAttribute("alladmin", al);
		forward = mapping.findForward("adminresult");
		
		
		
		
		return forward;
	}
	public ActionForward queryPriority(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		ManagerBean mb = new ManagerBean();
		String name=request.getParameter("aname");
		System.out.println(name);
		ManagerService ms = new ManagerService();
		mb = ms.queryManagerDo(name);
		request.setAttribute("query", mb);
		forward = mapping.findForward("admindetails");
		
		
		return forward;
	}
	public ActionForward queryPrioritytemp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		ManagerBean mb = new ManagerBean();
		String name=request.getParameter("bname");
		//System.out.println(name);
		ManagerService ms = new ManagerService();
		mb = ms.queryManagerDo(name);
		request.setAttribute("querytemp", mb);
		forward = mapping.findForward("admindetailstemp");
		
		
		return forward;
	}
	
	public ActionForward exit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.getSession().removeAttribute("adminname");
		ActionForward forward=mapping.findForward("logfail");
		return forward;
	}


}
