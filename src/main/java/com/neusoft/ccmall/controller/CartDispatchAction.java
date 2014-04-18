package com.neusoft.ccmall.controller;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.bean.UserBean;
//import com.neusoft.ccmall.service.CartService;
//import com.neusoft.ccmall.service.ProductService;
//import com.neusoft.ccmall.bean.ProductBean;

public class CartDispatchAction extends DispatchAction {
	
	
	
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
/*	@SuppressWarnings("unchecked")
	public ActionForward showMyCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		//System.out.println(username); //
		
		// 
		CartService cs = new CartService();
		ArrayList<CartBean> db_cart = cs.getCart(username);
		
		ActionForward forward = null;
		
		// 
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		
		// ***
		if (mycart==null) {
			
			// 
			request.getSession().setAttribute("mycart", db_cart);
			// 
			forward = mapping.findForward("cart_list");
			
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
			
			// 
			forward = mapping.findForward("cart_list");
		}		
		
		return forward;
	}
*/

	
/*	@SuppressWarnings("unchecked")
	public ActionForward showMyCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		System.out.println(username); //
		
		// 
		CartService cs = new CartService();
		HashMap<String, String> db_mycart = cs.getCart(username);
		
		ActionForward forward = null;
		
		// 
		HashMap<String, String> mycart = (HashMap<String, String>)request.getSession().getAttribute("mycart");
		// ***
		if (mycart==null) {
			// 
			request.getSession().setAttribute("mycart", db_mycart);

			//
			ArrayList<ProductBean> al = new ArrayList<ProductBean>();
			Iterator<String> it = db_mycart.keySet().iterator();
			while (it.hasNext()) {
				int product_SEQ = Integer.parseInt(it.next());
				System.out.println(product_SEQ);
				ProductBean pb = new ProductService().getProduct(product_SEQ);
				al.add(pb);
			}		
			//
			request.setAttribute("mycartinfo", al);			
			
			// 
			forward = mapping.findForward("cart_list");
		} else { // **
			// 
			Iterator<String> it2 = db_mycart.keySet().iterator();
			while (it2.hasNext()) {
				String product_SEQ = it2.next(); // keyֵ
				String num = db_mycart.get(product_SEQ); // valueֵ
				// 
				if (mycart.get(product_SEQ)==null) {
					// 
					mycart.put(product_SEQ, num);
				} else {
					// 
					String newNum = (Integer.parseInt(mycart.get(product_SEQ)) + Integer.parseInt(num)) + "";
					mycart.put(product_SEQ, newNum);
				}				
			}
			// 
			request.getSession().setAttribute("mycart", mycart);
			

			// 
			ArrayList<ProductBean> al = new ArrayList<ProductBean>();
			Iterator<String> it = mycart.keySet().iterator();
			while (it.hasNext()) {
				int product_SEQ = Integer.parseInt(it.next());
				System.out.println(product_SEQ);
				ProductBean pb = new ProductService().getProduct(product_SEQ);
				al.add(pb);
			}		
			// 
			request.setAttribute("mycartinfo", al);
			
			
			// 
			forward = mapping.findForward("cart_list");
		}		
		
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
	@SuppressWarnings("unchecked")
	public ActionForward addToMyCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int productseq = Integer.parseInt(request.getParameter("productseq"));
		String productname = new String(request.getParameter("productname").getBytes("iso-8859-1"),"utf-8");
		System.out.println(productname);//
		double price = Double.parseDouble(request.getParameter("price"));
//		System.out.println(price);//
		// 
		CartBean cb = new CartBean();
		cb.setProductseq(productseq);
		cb.setProductname(productname);
		cb.setPrice(price);
		cb.setNum(1); // 
						
		
		// 
		UserBean ub = (UserBean)request.getSession().getAttribute("userbean");
		// 
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		
		if (ub == null) {
			// 
			
			// 
			if (mycart == null) {
				
				// 
				mycart = new ArrayList<CartBean>();
				mycart.add(cb);
				
				//
				request.getSession().setAttribute("mycart", mycart);
				
			} else { // 
				
				boolean flag = true;// 
				
				for (int i = 0; i < mycart.size(); i++) {
					if (mycart.get(i).getProductseq() == cb.getProductseq()) {
						//
						mycart.get(i).setNum(mycart.get(i).getNum()+1);
						flag = false;
						break;
					}
				}
				
				if (flag) {
					//
					mycart.add(cb);
				}
				
			}			
			
		} else { // 
			
			//
			boolean flag = true;// 
			
			for (int i = 0; i < mycart.size(); i++) {
				if (mycart.get(i).getProductseq() == cb.getProductseq()) {
					// 
					mycart.get(i).setNum(mycart.get(i).getNum()+1);
					flag = false;
					break;
				}
			}
			
			if (flag) {
				// 
				mycart.add(cb);
			}		
			
		}
		
		// 
		ActionForward forward = mapping.findForward("cart_list");
		
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
	public ActionForward deleteFromMyCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int productseq = Integer.parseInt(request.getParameter("productseq"));
//		System.out.println(productseq);
		
		// 
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		// 
		for (int i = 0; i < mycart.size(); i++) {
			CartBean cb = mycart.get(i);
			if (cb.getProductseq() == productseq) {
				mycart.remove(cb);
				break;
			}
		}
		
		
		// 
		ActionForward forward = mapping.findForward("cart_list");
		
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
	public ActionForward emptyMyCart(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// 
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		mycart.removeAll(mycart);
		
		ActionForward forward = mapping.findForward("cart_list");
		
		
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
	@SuppressWarnings("unchecked")
	public ActionForward addCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int productseq = Integer.parseInt(request.getParameter("productseq"));
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		for (int i = 0; i < mycart.size(); i++) {
			CartBean cb = mycart.get(i);
			if (cb.getProductseq() == productseq) {
				mycart.get(i).setNum(mycart.get(i).getNum()+1);
				break;
			}
		}		
		ActionForward forward = mapping.findForward("cart_list");
		return forward;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward cutCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int productseq = Integer.parseInt(request.getParameter("productseq"));
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");
		for (int i = 0; i < mycart.size(); i++) {
			CartBean cb = mycart.get(i);
			if (cb.getProductseq() == productseq) {
				mycart.get(i).setNum(mycart.get(i).getNum()-1);
				break;
			}
		}		
		ActionForward forward = mapping.findForward("cart_list");
		return forward;
	}
}
