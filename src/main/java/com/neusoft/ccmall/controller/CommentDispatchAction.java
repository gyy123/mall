package com.neusoft.ccmall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CommentBean;
import com.neusoft.ccmall.bean.CommentForm;
import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.service.CategoryService;
import com.neusoft.ccmall.service.CommentService;
import com.neusoft.ccmall.service.ProductService;

public class CommentDispatchAction extends DispatchAction {

	
	/**
	 * 发表评论
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addComment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommentForm cf = (CommentForm)form;
		int product_seq = cf.getProduct_seq();
		String username = cf.getUsername();
		String content = cf.getContent();
		
		// 测试
//		System.out.println(product_seq);
//		System.out.println(username);
//		System.out.println(content);
		
		CommentBean cb = new CommentBean();
		cb.setProduct_seq(product_seq);
		cb.setContent(content);
		cb.setUsername(username);		
		
		CommentService cs = new CommentService();
		boolean isSuccess= cs.addComment(cb);

		ActionForward forward = null;
		
		// 为防止返回页面的时候，报出这样的异常：Cannot find bean pb in any scope
		ProductService ps = new ProductService();
		ProductBean pb = ps.getProduct(product_seq);
		// for chinese category
		CategoryService category = new CategoryService();
		pb = category.getCategoryName(pb);
		
		request.setAttribute("pb", pb);
		
		if (isSuccess) {
			
			// 调用service层的显示评论方法
			ArrayList<CommentBean> cb_list = cs.showAllComments(product_seq);
			
			request.setAttribute("cb_list", cb_list);
			
			// 评论成功
			forward = mapping.findForward("item_info");
			
		} else {
			// 评论失败
			request.setAttribute("result", 0);
			forward = mapping.findForward("item_info");
		}
		
		
		return forward;
	}
	
	
	/**
	 * 删除特定商品的特定评论
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteComment(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		
		return forward;
	}
	
	
	/**
	 * 删除特定商品的所有评论
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteAllComments(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		
		return forward;
	}
}
