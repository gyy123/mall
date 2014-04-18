package com.neusoft.ccmall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.OrderForm;
import com.neusoft.ccmall.bean.OrderProductBean;
import com.neusoft.ccmall.bean.PageBean;
import com.neusoft.ccmall.bean.UserBean;
import com.neusoft.ccmall.dao.OrderProductDao;
import com.neusoft.ccmall.service.CartService;
import com.neusoft.ccmall.service.CategoryService;
import com.neusoft.ccmall.service.OrderProductService;
import com.neusoft.ccmall.service.OrderRecordService;
import com.neusoft.ccmall.service.OrderService;

public class OrderDispatchAction extends DispatchAction {
	
	
	/**
	 * ��������ת�ˣ��޸Ķ���״̬Ϊ����֧����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
				
		System.out.println(order_SEQ); // ����
		
		OrderService os = new OrderService();
		
		boolean isSuccess = os.updateOrder(order_SEQ);
		
		System.out.println(isSuccess); // test
		
		ActionForward forward = null;
		
		if (isSuccess) {
			request.setAttribute("order_SEQ", order_SEQ);
			// ����״̬�ɹ��޸�Ϊ����֧��������
			forward = mapping.findForward("order_success");			
		} else {
			// ����״̬û���޸ĳɹ�
			//System.out.println("ʧ������������");
			forward = mapping.findForward("order_failed");
		}	
		
		return forward;
	}
	
	/**
	 * ����¶���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward addOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		OrderForm of = (OrderForm)form;
		String username = of.getUsername();
		String phone = of.getPhone();
		String address = of.getAddress();
		String postcode = of.getPostcode();
		int post_type = of.getPost_type();
		int pay_type = of.getPay_type();
		double total = Double.valueOf(request.getParameter("total"));
		
		//System.out.println(username); // ����
//		System.out.println(post_type);
		//System.out.println(pay_type);
//		System.out.println(total);
		
		OrderBean ob = new OrderBean();
		ob.setUsername(username);
		ob.setPhone(phone);
		ob.setAddress(address);
		ob.setPostcode(postcode);
		ob.setPost_type(post_type);
		ob.setPay_type(pay_type);
		ob.setTotal(total);
		
		// ����OrderService��addOrder����������order_SEQֵ
		OrderService os = new OrderService();
		int order_SEQ = os.addOrder(ob);
		
		
		// �����ﳵ�е���Ʒ��ӵ�order_product����
		// id order_seq product_seq num
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");

		OrderProductService ops = new OrderProductService();
		
		boolean isSuccess = ops.addOrderProduct(order_SEQ, mycart);		
		//System.out.println(isSuccess);
		
		ActionForward forward = null;
		if (0 != order_SEQ && isSuccess) {
			
			//-----------------------------------------------------------
			// �����ύ�ɹ�����յ�ǰsession���ﳵ�е�����
			request.getSession().removeAttribute("mycart");
			// Ȼ��ɾ�����ݿ���cart���е�����
			CartService cs = new CartService();
			cs.deleteAllCart(username); // ����ط��ϸ��˵Ҫ�ж�һ���Ƿ�ɾ���ɹ�
			//------------------------------------------------------------
			
			request.setAttribute("order_SEQ", order_SEQ);
			
			if (0 == pay_type) { // ���ѡ�����ʾֻ��
				forward = mapping.findForward("order_success"); // order_success.jsp
			} else { // ���ѡ������������ת��
				request.setAttribute("total", total);
				forward = mapping.findForward("zhuanzhang_info"); // zhuanzhang_info.jsp
			}
			
		} else {
			// ������Ϊ0��˵������û����ӵ����ݿ���
			forward = mapping.findForward("order_failed");
		}
		
		return forward;
	}
	
	
	/**
	 * ��ѯ���˶���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryPersonalOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ��ȡ�û�����ı���Ϣ
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
		String fromDate = of.getFromDate();
		String toDate = of.getToDate();
		//System.out.println(order_SEQ+" "+fromDate+" "+toDate); // ����
		
		// ��ȡ�û��˺�
		UserBean ub = (UserBean)request.getSession().getAttribute("userbean");
		
		// ����service��ķ���
		OrderService os = new OrderService();
		
		ArrayList<OrderBean> al = null;
		
		// ������ο�
		if (ub==null) {
			
			al = os.queryPersonalOrder(order_SEQ, fromDate, toDate);
			
		} else {// ����ǵ�¼�û�����ҳֻ����ڸ��û��ڲ����붩���Ų�ѯ�����������²������壩
			String username = ub.getUsername();
			
			int pageNow = 1;
			String sPageNow = request.getParameter("pageNow");
			if (sPageNow != null) {
				pageNow = Integer.parseInt(sPageNow);
			}
			if (fromDate == null) {
				fromDate = request.getParameter("fromdate");
			}
			if (toDate == null) {
				toDate = request.getParameter("todate");
			}
			//System.out.println(fromDate+"XXX"+toDate);// ����
			PageBean page = os.getPageInfo(username, order_SEQ, fromDate, toDate, pageNow);
			// ��ҳ���õ�����date
			request.setAttribute("fromdate", fromDate);
			request.setAttribute("todate", toDate);
			request.setAttribute("page", page);			
			
			al = os.queryPersonalOrder(username, order_SEQ, fromDate, toDate, page);
			
		}		
		
		// ������Ӧ��Ϣ
		request.setAttribute("list", al);
		ActionForward forward = mapping.findForward("query_result");
		// ������Ӧ��Ϣ
		return forward;
	}
	
	
	/**
	 * ��ѯ���˶�������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryPersonalOrderInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		// ���������Ϣ
		int order_SEQ = of.getOrder_SEQ();
		//System.out.println(order_SEQ); // ����
		
		// ����service����Ӧ�ķ�������������Ϣ
		OrderService os = new OrderService();
		
		// ������Ϣ
		OrderBean ob = new OrderBean();
		// 1�����ݿⶩ�����е���Ϣ
		ob = os.queryPersonalOrderInfo(order_SEQ);
		// 2�������е�ArrayList<OrderProductBean>
		ArrayList<OrderProductBean> list_opb = new OrderProductService().getOrderProducts(order_SEQ);
		
		// Ϊ����ҳ�����������������ƣ��������´���
		list_opb = new CategoryService().getOrderProductCategoryName(list_opb);
		
		ob.setList_opb(list_opb);
		//System.out.println(ob.getList_opb().get(0).getNum()); // ����
		
		// ����Ӧ��Ϣ��װ��request��
		request.setAttribute("orderbean", ob);
		
		// ������Ӧ��Ϣ
		ActionForward forward = mapping.findForward("order_info");		
		return forward;
	}
	
	
	/**
	 * ҳ���ʼ����ѯ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryOrders(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int status = Integer.parseInt(request.getParameter("status"));
		
		OrderService os = new OrderService();		
				
		// Ĭ����ʾ��һҳ
		int pageNow = 1;
		// ����û�������ʾҳ��
		String sPageNow = request.getParameter("pageNow");
		if(sPageNow != null) {
			// ����Ĭ��ҳ��
			pageNow = Integer.parseInt(sPageNow);
		}
		
		// ����service����pagebean��Ϣ
		PageBean page = os.getPageInfo(status, pageNow);
		
		request.setAttribute("page_pre", page);
		
		// �õ�Ҫ��ʾ��orderbean����
		ArrayList<OrderBean> list = os.queryOrders(status, pageNow, page.getPAGESIZE());
		
		request.setAttribute("list", list);
		
		ActionForward forward = null;
		
		if (0 == status) {
			// ��ת��orser.jsp
			forward = mapping.findForward("bg_order");
		}
		if (1 == status) {
			// ��ת��order_update.jsp
			forward = mapping.findForward("bg_order_update");
		}
		if (4 == status) {
			// ��ת��order_delete.jsp
			forward = mapping.findForward("bg_order_delete");
		}		
		
		return forward;
	}
	
	
	
	
	/**
	 * ��ѯ����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryAllOrders(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
		int status = of.getStatus();
//		System.out.println(order_SEQ); // ����
//		System.out.println(status);
		
		String s_status = request.getParameter("status");
		if (s_status != null) {
			status = Integer.parseInt(s_status);
		}		
		request.setAttribute("status", status);
		
		OrderService os = new OrderService();
		
		int pageNow = 1;
		String sPageNow = request.getParameter("pageNow");
		if (sPageNow != null) {
			pageNow = Integer.parseInt(sPageNow);
		}
		
		PageBean page = os.getPageInfo(order_SEQ, status, pageNow);
		request.setAttribute("page", page);
		
		ArrayList<OrderBean> list = os.queryAllOrders(order_SEQ, status, page);		
		request.setAttribute("list", list);
		
		ActionForward forward = mapping.findForward("bg_order");
		
		return forward;
	}
	
	
	/**
	 * �޸Ķ���״̬ǰ��ѯ����������ֻ����¶�������֧��������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateQueryOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
		int status = of.getStatus();
//		System.out.println(order_SEQ); // ����
//		System.out.println(status);
		
		// ������ڲ�ѯ�����ҳ�Ĵ���
		String s_status = request.getParameter("status");
		if (s_status != null) {
			status = Integer.parseInt(s_status);
		}
		
		
		OrderService os = new OrderService();
		
		int pageNow = 1;
		String sPageNow = request.getParameter("pageNow");
		if (sPageNow != null) {
			pageNow = Integer.parseInt(sPageNow);
		}
		PageBean page = os.getPageInfo(order_SEQ, status, pageNow);
		request.setAttribute("page", page);
		
		ArrayList<OrderBean> list = os.queryAllOrders(order_SEQ, status, page);		
		request.setAttribute("list", list);
		
		
		request.setAttribute("status", status);
		ActionForward forward = mapping.findForward("bg_order_update");
		
		return forward;
	}
	
	
	
	/**
	 * �޸Ķ���״̬
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateOrderStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		int status = of.getStatus();
		// ���ҳ�洫�����Ĳ���ֵ
		int order_SEQ = of.getOrder_SEQ();
		// �õ��޸Ķ���״̬��ԭ��
		String issue_cause = of.getIssue_cause();
		
		// ��session�л�ù���Ա������
		String managername = (String)request.getSession().getAttribute("adminname");
		
		// ��order_record���в������ݣ���¼ĳ������Ա�޸�ĳ������״̬��ԭ��
		OrderRecordService ors = new OrderRecordService();
		boolean flag = ors.addOrderRecord(order_SEQ, managername, issue_cause);
		
//		System.out.println(order_SEQ); // ����
//		System.out.println(status);
		
//		System.out.println(request.getParameter("issue_cause"));		
		
		OrderService os = new OrderService();
		boolean isSuccess = os.updateOrderStatus(order_SEQ, status);
		
		ActionForward forward = null;
		if (isSuccess && flag) {
			request.setAttribute("result", "��ϲ���޸ĳɹ���"); // ������jspҳ����Ϊ�����Ի���ı�־λ
			forward = mapping.findForward("bg_order_update");
		} else {
			request.setAttribute("result", "�Բ����޸�ʧ�ܣ�");
			forward = mapping.findForward("bg_order_update");
		}
		
		return forward;
	}
	
	
	/**
	 * ɾ������״̬ǰ��ѯ����������ֻ��������϶�����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteQueryOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
		int status = 4; // �趨��ѯ��������״̬Ϊ�������϶�����
//		System.out.println(order_SEQ); // ����
		
		// Ĭ����ʾ��һҳ
		int pageNow = 1;
		
		// �����Ҫ��ʾ�ĵڼ�ҳ
		String sPageNow = request.getParameter("pageNow");
		// ���ҳ�Ų�Ϊ�գ�����û�ϣ����ʾ��ҳ�Ÿ���pageNow
		if (sPageNow != null) {
			pageNow = Integer.parseInt(sPageNow);
		}		
		
		OrderService os = new OrderService();
		
		// ��÷�ҳ��Ϣ
		PageBean page = os.getPageInfo(order_SEQ, status, pageNow);
		request.setAttribute("page", page);
		
		ArrayList<OrderBean> list = os.queryAllOrders(order_SEQ, status, page);		
		request.setAttribute("list", list);
		
		ActionForward forward = mapping.findForward("bg_order_delete");
		
		return forward;
	}
	
	
	
	/**
	 * ɾ������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteOrder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int order_SEQ = Integer.parseInt(request.getParameter("order_SEQ"));
//		System.out.println(order_SEQ); // ����
		
		ActionForward forward = null;
		
		OrderProductDao opd = new OrderProductDao();
		boolean flag = opd.deleteOrderProduct(order_SEQ);
		if (flag) {
			OrderService os = new OrderService();
			boolean isSuccess = os.deleteOrder(order_SEQ);
//			System.out.println(isSuccess); // ����
			if (isSuccess) {
				request.setAttribute("result", "��ϲ��ɾ���ɹ�");
				forward = mapping.findForward("bg_order_delete");
			}
		} else {
			request.setAttribute("result", "�Բ���ɾ��ʧ�ܣ�");
			forward = mapping.findForward("bg_order_delete");
		}
		
		
		return forward;
	}
	
	
	
}
