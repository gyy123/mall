package com.neusoft.ccmall.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.bean.UserForm;
import com.neusoft.ccmall.service.CartService;
import com.neusoft.ccmall.service.UserService;
import com.neusoft.ccmall.bean.UserBean;

public class UserDispatchAction extends DispatchAction {
	
	
	
	public ActionForward userdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		
		String uname = new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");//???--->
		//System.out.println(uname+"aaaaaa");
		UserService us = new UserService();
		UserBean ub = new UserBean();
		ub = us.queryUser(uname);
		request.setAttribute("duser", ub);
		
		
		
		forward = mapping.findForward("userdetails");
		
		
		return forward;
	}
	
	
	
	
	
	//
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		
		String uname = new String(request.getParameter("dname").getBytes("iso-8859-1"),"utf-8");//???--->
		//System.out.println(uname+"aaaaaa");
		    UserService us = new UserService();
		    boolean issuccess = us.ordered(uname);
		
			if(issuccess){
				UserForm uf = (UserForm)form;
				String username = uf.getUsername();
				String registerdate_begin = uf.getRegisterdate_begin();
				String registerdate_end = uf.getRegisterdate_end();
				
				
				ArrayList<UserBean> al = new ArrayList<UserBean>();
				al = us.queryUsers(username,registerdate_begin,registerdate_end);
				
				request.setAttribute("users", al);
				
				request.setAttribute("result", 0);
				forward = mapping.findForward("searchusers");			
				
				
			}else{
				UserForm uf = (UserForm)form;
				String username = uf.getUsername();
				String registerdate_begin = uf.getRegisterdate_begin();
				String registerdate_end = uf.getRegisterdate_end();
				
				
				ArrayList<UserBean> al = new ArrayList<UserBean>();
				al = us.queryUsers(username,registerdate_begin,registerdate_end);
				
				request.setAttribute("users", al);
				
				request.setAttribute("result", 1);
				forward = mapping.findForward("searchusers");			
				
				
			}			
			 
			return forward;
					
	}
	
	
	
	

	public ActionForward queryUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward forward = null;
		UserForm uf = (UserForm)form;
		String username = uf.getUsername();
		String registerdate_begin = uf.getRegisterdate_begin();
		String registerdate_end = uf.getRegisterdate_end();
		
		UserService us = new UserService();
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		al = us.queryUsers(username,registerdate_begin,registerdate_end);
		
		request.setAttribute("users", al);
		forward = mapping.findForward("searchusers");
		
		
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
	@SuppressWarnings("unchecked")
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 
		UserForm uf=(UserForm)form;
		String username=uf.getUsername();
		String password=uf.getPassword();
//		boolean rememberpw = uf.isRememberpw();

//		System.out.println(rememberpw);
//		System.out.print(username);
	    
		//
		UserService us=new UserService();
		boolean isSuccess=us.login(username,password);
		
		//
		ActionForward forward=null;
		if(isSuccess){
			// 
			UserBean ub = us.queryUser(username);
			request.getSession().setAttribute("userbean", ub);
			
			//===================================================
			// 
			CartService cs = new CartService();
			ArrayList<CartBean> db_cart = cs.getCart(username);
			
			// 
			ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
			
			// ***
			if (mycart==null) {
				
				// 
				request.getSession().setAttribute("mycart", db_cart);
				
				
			} else {// ***
				
				// 
				for (int i = 0; i < db_cart.size(); i++) {
					// 
					boolean flag = true;
					for (int j = 0; j < mycart.size(); j++) {
						if (db_cart.get(i).getProductseq() == mycart.get(j).getProductseq()) {
							// 
							mycart.get(j).setNum(mycart.get(j).getNum()+db_cart.get(i).getNum());
							flag = false;
							break;
						}
					}	
					if (flag) {
						// 
						mycart.add(db_cart.get(i));
					}
				}
				
			}
			
			
			//========================================================
			
			//
			request.setAttribute("result", "1");
			forward=mapping.findForward("login");			
		}
		else{
			// 
			request.setAttribute("result", "0");
			forward=mapping.findForward("login");		
		}
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
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf=(UserForm)form;
		String username=uf.getUsername();
		String password=uf.getPassword();
		String question=uf.getQuestion();
		String answer=uf.getAnswer();
		String truename=uf.getTruename();
		String id_card=uf.getId_card();
		String email=uf.getEmail();
		String postcode=uf.getPostcode();
		String address=uf.getAddress();
		String phone=uf.getPhone();
		
		UserBean ub=new UserBean();
		ub.setUsername(username);
		ub.setPassword(password);
		ub.setQuestion(question);
		ub.setAnswer(answer);
		ub.setTruename(truename);
		ub.setId_card(id_card);
		ub.setEmail(email);
		ub.setPostcode(postcode);
		ub.setAddress(address);
		ub.setPhone(phone);
		
		UserService us=new UserService();
		boolean isSuccess = us.register(ub);
//		System.out.println(isSuccess); // 
		
		ActionForward forward = null;
		if(isSuccess){
			ub = us.queryUser(username);
			request.getSession().setAttribute("userbean", ub);
			request.setAttribute("result", "1");
			forward=mapping.findForward("register");
		}
		else{
			request.setAttribute("result", "0");
			forward=mapping.findForward("register");
		}
		
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
/*	public ActionForward queryUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		System.out.println(username); //???--->
		
		UserService us = new UserService();
		UserBean ub = us.queryUser(username);
		*//**
		 * 
		 *//* 
		request.setAttribute("userbean", ub);
		ActionForward forward = mapping.findForward("user_info");
		
		return forward;
	}
*/	
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm)form;
		UserBean ub = new UserBean();
		ub.setUsername(uf.getUsername());
		ub.setTruename(uf.getTruename());
		ub.setId_card(uf.getId_card());
		ub.setEmail(uf.getEmail());
		ub.setPostcode(uf.getPostcode());
		ub.setAddress(uf.getAddress());
		ub.setPhone(uf.getPhone());
		
		UserService us = new UserService();
		boolean isSuccess = us.updateUser(ub);
				
		ActionForward forward = null;
		if (isSuccess) {
			request.setAttribute("result", 1);
			forward = mapping.findForward("user_info_update");
		} else {
			request.setAttribute("result", 0);
			forward = mapping.findForward("user_info_update");
		}
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
	public ActionForward updatePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm)form;
		String username = uf.getUsername();
		String newPassword = uf.getPassword2();
		
		UserService us = new UserService();
		boolean isSuccess = us.updatePassword(username, newPassword);
				
		ActionForward forward = null;
		if (isSuccess) {
			request.setAttribute("result", 1);
			forward = mapping.findForward("pwd_update");
		} else {
			request.setAttribute("result", 0);
			forward = mapping.findForward("pwd_update");
		}
		return forward;
	}
	
	
	/**
	 *
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
/*	public ActionForward findBackPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm)form;
		int type = Integer.parseInt(request.getParameter("type"));
		String username = uf.getUsername();
		String answer = uf.getAnswer();
		
		UserService us = new UserService();
		
		ActionForward forward = null;
		
		System.out.println(type); //
		if (1 == type) {
			// 
			String question = us.getQuestion(username);
			System.out.println(question); // 
			if (!question.equals("")) {
				request.setAttribute("question", question);
				request.setAttribute("username", username);
				forward = mapping.findForward("pwd_findback2"); //
			} else {
				request.setAttribute("result", 0);
				forward = mapping.findForward("pwd_findback"); //
			}
		}
		// 
		if (2 == type) {
			String answer_db = us.getAnswer(username);
			// 
			if (answer_db.equals(answer)) {
				forward = mapping.findForward("pwd_findback3");
			} else {
				request.setAttribute("result", 0);
				forward = mapping.findForward("pwd_findback2");
			}
		}
		// 
		if (3 == type) {
			
		}		
		
		return forward;
	}
*/	
	
	
	public ActionForward findBackPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm)form;
		String username = uf.getUsername();
		
		UserService us = new UserService();
		UserBean ub = us.queryUser(username);		
		
		ActionForward forward = null;
		
		if (ub != null) {
			request.setAttribute("userbean", ub);
			forward = mapping.findForward("pwd_findback2");
		} else {
			request.setAttribute("result", 0);
			forward = mapping.findForward("pwd_findback");
		}
		
		return forward;
	}
	
	
	public ActionForward findBackPassword2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm uf = (UserForm)form;
		String username = uf.getUsername();
//		System.out.println(username);
		String newPassword = uf.getPassword();
//		System.out.println(newPassword);
		
		UserService us = new UserService();
		boolean isSuccess = us.updatePassword(username, newPassword);
				
		ActionForward forward = null;
		
		if (isSuccess) {
			request.setAttribute("result", 1);
			forward = mapping.findForward("pwd_findback3");
		} else {
			request.setAttribute("result", 0);
			forward = mapping.findForward("pwd_findback3");
		}
		
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
	@SuppressWarnings("unchecked")
	public ActionForward exit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 用户退出
		
		// 1.查看session中购物车内容是否为空，如果不为空，首先把购物车的内容存放到数据库cart表中，以供下次登录调用
		ArrayList<CartBean> list = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				CartService cs = new CartService();
				cs.addCart(list.get(i));
			}
		}
		
		// 2.清除session中mycart的信息
		request.getSession().removeAttribute("mycart");		
		
		// 3.清除session中userbean的信息
		request.getSession().removeAttribute("userbean");
		
		ActionForward forward=mapping.findForward("home");
		return forward;
	}
	
}
