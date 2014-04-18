package com.neusoft.ccmall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CategoryBean;
import com.neusoft.ccmall.bean.CategoryForm;
import com.neusoft.ccmall.service.CategoryService;

public class CategoryDispatchAction extends DispatchAction {

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryCategory_byId(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		String goods_id = request.getParameter("a_cate");
		int id = Integer.parseInt(goods_id);
		
		System.out.println(id);
		
		CategoryBean cb = new CategoryBean();
		cb = cs.queryCategory_byId(id);
		request.setAttribute("details", cb);
		forward = mapping.findForward("details");
		return forward;
	}
	
	/**
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("all", al);
		forward = mapping.findForward("all");
		return forward;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryMainAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		
		System.out.println(s);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainCategory(s);
		request.setAttribute("main_sel", al);
		forward = mapping.findForward("main_sel");
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
	public ActionForward querySubAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		
		System.out.println(s);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainCategory(s);
		request.setAttribute("sub_sel", al);
		forward = mapping.findForward("sub_sel");
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
	public ActionForward queryMainAll_up(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		
		System.out.println(s);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainCategory(s);
		request.setAttribute("main_up", al);
		forward = mapping.findForward("main_up");
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
	public ActionForward querySubAll_up(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		
		System.out.println(s);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainCategory(s);
		request.setAttribute("sub_up", al);
		forward = mapping.findForward("sub_up");
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
	public ActionForward queryMainAll_add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		CategoryForm cf = (CategoryForm)form;
		String s = cf.getName();
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainAll();
		request.setAttribute("main_all_add", al);
		forward = mapping.findForward("main_all_add");
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
	public ActionForward querySubAll_add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainAll();
		request.setAttribute("sub_all_add", al);
		forward = mapping.findForward("sub_all_add");
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
	public ActionForward queryMainAll_del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		
		System.out.println(s);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryMainCategory(s);
		request.setAttribute("main_all_del", al);
		forward = mapping.findForward("main_all_del");
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
	public ActionForward querySubAll_del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String s = cf.getName();
		int big = cf.getId();
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.querySubCategory(big, s);
		request.setAttribute("sub_all_del", al);
		forward = mapping.findForward("sub_all_del");
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
	public ActionForward queryMainCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		String s = cf.getName();
		al = cs.queryMainCategory(s);
		request.setAttribute("main_all", al);
		forward = mapping.findForward("category_main");
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
	public ActionForward querySubCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		
		String s = request.getParameter("string");
		String big_id = request.getParameter("main_id");
		int id = Integer.parseInt(big_id);
		
		al = cs.querySubCategory(id, s);
		request.setAttribute("category_sub", al);
		forward = mapping.findForward("category_sub");
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
	public ActionForward addMainCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		String cname = cf.getName();
		
		System.out.println(cname);
		
		cs.addMainCategory(cname);
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("all", al);
		forward = mapping.findForward("all");
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
	public ActionForward addSubCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryForm cf = (CategoryForm)form;
		CategoryService cs = new CategoryService();
		
		String name = cf.getName();
		String big_id = request.getParameter("main_id");
		int id = Integer.parseInt(big_id);
		
		cs.addSubCategory(id,name);
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("all", al);
		forward = mapping.findForward("all");
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
	public ActionForward updateCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		CategoryForm cf = (CategoryForm)form;
		int id = cf.getId();
		String name = cf.getName();
		
		cs.updateCategory(name, id);
//		System.out.println(id+"00s");
//		System.out.println(name+"00s");
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("all", al);
		forward = mapping.findForward("all");
		return forward;
	}
	
	
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		String goods_id = request.getParameter("b_cate");
		int id = Integer.parseInt(goods_id);
		System.out.println(id);
		cs.deleteCategory(id);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("all", al);
		forward = mapping.findForward("all");
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
	public ActionForward deleteCategory_big(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		String goods_id = request.getParameter("b_cate");
		int id = Integer.parseInt(goods_id);
		System.out.println(id);
		cs.deleteCategory(id);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("main_all_del", al);
		forward = mapping.findForward("main_all_del");
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
	public ActionForward deleteCategory_small(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		CategoryService cs = new CategoryService();
		String goods_id = request.getParameter("b_cate");
		int id = Integer.parseInt(goods_id);
		System.out.println(id);
		cs.deleteCategory(id);
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		al = cs.queryAll();
		request.setAttribute("sub_all_del", al);
		forward = mapping.findForward("sub_all_de");
		return forward;
	}
}
