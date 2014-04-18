package com.neusoft.ccmall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CommentBean;
import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.bean.ProductForm;
import com.neusoft.ccmall.service.CategoryService;
import com.neusoft.ccmall.service.CommentService;
import com.neusoft.ccmall.service.ProductService;

public class ProductDispatchAction extends DispatchAction {
	
	/**
	 *
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryAllProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		ProductService ps = new ProductService();
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		al = ps.queryAllProducts();
		
		CategoryService cs = new CategoryService();
		al = cs.getCategoryName(al);
		
		request.setAttribute("allgoods", al);
		forward = mapping.findForward("all_goods");
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
	public ActionForward queryProductById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		ProductService ps = new ProductService();
		ProductBean pbe = new ProductBean();
		String goods_id = request.getParameter("a_pro");
		int id = Integer.parseInt(goods_id);
		
		System.out.println(id);
		
		pbe = ps.queryProductById(id);
		System.out.println(pbe.getName());
		request.setAttribute("goods_info", pbe);
		forward = mapping.findForward("goods_info");
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
	public ActionForward queryProductById_update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		ProductService ps = new ProductService();
		ProductBean pbe = new ProductBean();
		String goods_id = request.getParameter("b_pro");
		int id = Integer.parseInt(goods_id);
		
//		System.out.println(id+"22");
		
		pbe = ps.queryProductById(id);
//		System.out.println(pbe.getName()+"22");
		
		CategoryService cs = new CategoryService();
		pbe = cs.getCategoryName(pbe);
		
		request.setAttribute("goods_update", pbe);
		forward = mapping.findForward("goods_update");
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
	public ActionForward addProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		
		ProductForm pf = (ProductForm)form;
		String name = pf.getName();		
		String main_value=pf.getMain_value();
		String sub_value=pf.getSub_value();
		
		System.out.println(main_value);
		
		double price = pf.getPrice();
		String unit = pf.getUnit();
		int num = pf.getNum();
		String description = pf.getDescription();
		String image = pf.getImage();
		int recommend = pf.getRecommend();
		
		
	

		ProductBean pb = new ProductBean();
		pb.setName(name);
		pb.setMain_value(main_value);
		pb.setSub_value(sub_value);
		pb.setPrice(price);
		pb.setUnit(unit);
		pb.setNum(num);
		pb.setDescription(description);
		pb.setImage(image);
		pb.setRecommend(recommend);
		ProductService ps = new ProductService();
		boolean add = ps.addProduct(pb);
		
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		al = ps.queryAllProducts();
		request.setAttribute("allgoods", al);
		forward = mapping.findForward("add_succ");
			
		
		
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
	public ActionForward updateProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		
		ProductForm pf = (ProductForm)form;
		int product_id = pf.getProduct_id();		
		String name = pf.getName();

		double price = pf.getPrice();
		String unit = pf.getUnit();
		int num = pf.getNum();
		String description = pf.getDescription();
		String image = pf.getImage();
		int recommend = pf.getRecommend();
		String main_value = pf.getMain_value();
		
		System.out.println(main_value);//====
		
		String sub_value = pf.getSub_value();
		
		
		ProductBean pb = new ProductBean();
		pb.setProduct_SEQ(product_id);
		pb.setName(name);
		pb.setPrice(price);
		pb.setUnit(unit);
		pb.setNum(num);
		pb.setDescription(description);
		pb.setImage(image);
		pb.setRecommend(recommend);
		pb.setMain_value(main_value);
		pb.setSub_value(sub_value);
		
		ProductService ps = new ProductService();
		ps.updateProduct(pb);
		
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		al = ps.queryAllProducts();
		
		CategoryService cs = new CategoryService();
		al = cs.getCategoryName(al);
		
		
		request.setAttribute("allgoods", al);
		forward = mapping.findForward("success");

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
	public ActionForward deleteProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		ProductService ps = new ProductService();
		String goods_id = request.getParameter("c_pro");
		int id = Integer.parseInt(goods_id);
		
		System.out.println(id+"22");
		
		ps.deleteProduct(id);
		
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		al = ps.queryAllProducts();
		request.setAttribute("allgoods", al);
		forward = mapping.findForward("success");
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
	public ActionForward querySoldOutProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		ProductService ps = new ProductService();
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		al = ps.querySoldOutProduct();
		request.setAttribute("goods_sellout", al);
		forward = mapping.findForward("goods_sellout");
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
	public ActionForward queryProductByNameType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ActionForward forward= null;
		ProductForm pf=(ProductForm) form;
		String name=pf.getName();
		String main_value=pf.getMain_value();
		String sub_value=pf.getSub_value();		
		ProductService ps=new ProductService();
		al=ps.queryProductsByTypeName(name, main_value, sub_value);
		
		CategoryService cs = new CategoryService();
		al = cs.getCategoryName(al);

		//int main = pf.getMain_category();
		//int sub = pf.getSub_category();

		request.setAttribute("selectproduct", al);
		forward=mapping.findForward("item_search_list");

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
	public ActionForward queryProductDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int product_SEQ = Integer.parseInt(request.getParameter("product_SEQ"));
		
		ProductService ps = new ProductService();
		ProductBean pb = ps.getProduct(product_SEQ);
		// 
		CategoryService category = new CategoryService();
		pb = category.getCategoryName(pb);				
		
		CommentService cs = new CommentService();
		ArrayList<CommentBean> cb_list = cs.showAllComments(product_SEQ);
		request.setAttribute("cb_list", cb_list);		
		request.setAttribute("pb", pb);
		ActionForward forward = mapping.findForward("item_info");
		return forward;
	}
	
	
	
}
