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
	 * 网上银行转账，修改订单状态为“已支付”
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
				
		System.out.println(order_SEQ); // 测试
		
		OrderService os = new OrderService();
		
		boolean isSuccess = os.updateOrder(order_SEQ);
		
		System.out.println(isSuccess); // test
		
		ActionForward forward = null;
		
		if (isSuccess) {
			request.setAttribute("order_SEQ", order_SEQ);
			// 订单状态成功修改为“已支付”订单
			forward = mapping.findForward("order_success");			
		} else {
			// 订单状态没有修改成功
			//System.out.println("失败啦————");
			forward = mapping.findForward("order_failed");
		}	
		
		return forward;
	}
	
	/**
	 * 添加新订单
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
		
		//System.out.println(username); // 测试
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
		
		// 调用OrderService的addOrder方法，返回order_SEQ值
		OrderService os = new OrderService();
		int order_SEQ = os.addOrder(ob);
		
		
		// 将购物车中的商品添加到order_product表中
		// id order_seq product_seq num
		ArrayList<CartBean> mycart = (ArrayList<CartBean>)request.getSession().getAttribute("mycart");

		OrderProductService ops = new OrderProductService();
		
		boolean isSuccess = ops.addOrderProduct(order_SEQ, mycart);		
		//System.out.println(isSuccess);
		
		ActionForward forward = null;
		if (0 != order_SEQ && isSuccess) {
			
			//-----------------------------------------------------------
			// 订单提交成功，清空当前session购物车中的内容
			request.getSession().removeAttribute("mycart");
			// 然后删除数据库中cart表中的内容
			CartService cs = new CartService();
			cs.deleteAllCart(username); // 这个地方严格地说要判断一下是否删除成功
			//------------------------------------------------------------
			
			request.setAttribute("order_SEQ", order_SEQ);
			
			if (0 == pay_type) { // 如果选择了邮局汇款
				forward = mapping.findForward("order_success"); // order_success.jsp
			} else { // 如果选择了网上银行转账
				request.setAttribute("total", total);
				forward = mapping.findForward("zhuanzhang_info"); // zhuanzhang_info.jsp
			}
			
		} else {
			// 订单号为0，说明订单没有添加到数据库中
			forward = mapping.findForward("order_failed");
		}
		
		return forward;
	}
	
	
	/**
	 * 查询个人订单
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
		// 获取用户输入的表单信息
		OrderForm of = (OrderForm)form;
		int order_SEQ = of.getOrder_SEQ();
		String fromDate = of.getFromDate();
		String toDate = of.getToDate();
		//System.out.println(order_SEQ+" "+fromDate+" "+toDate); // 测试
		
		// 获取用户账号
		UserBean ub = (UserBean)request.getSession().getAttribute("userbean");
		
		// 调用service层的方法
		OrderService os = new OrderService();
		
		ArrayList<OrderBean> al = null;
		
		// 如果是游客
		if (ub==null) {
			
			al = os.queryPersonalOrder(order_SEQ, fromDate, toDate);
			
		} else {// 如果是登录用户（分页只针对于该用户在不输入订单号查询订单的条件下才有意义）
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
			//System.out.println(fromDate+"XXX"+toDate);// 测试
			PageBean page = os.getPageInfo(username, order_SEQ, fromDate, toDate, pageNow);
			// 分页会用到两个date
			request.setAttribute("fromdate", fromDate);
			request.setAttribute("todate", toDate);
			request.setAttribute("page", page);			
			
			al = os.queryPersonalOrder(username, order_SEQ, fromDate, toDate, page);
			
		}		
		
		// 生成响应信息
		request.setAttribute("list", al);
		ActionForward forward = mapping.findForward("query_result");
		// 返回响应信息
		return forward;
	}
	
	
	/**
	 * 查询个人订单详情
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
		// 获得请求信息
		int order_SEQ = of.getOrder_SEQ();
		//System.out.println(order_SEQ); // 测试
		
		// 调用service层相应的方法处理请求信息
		OrderService os = new OrderService();
		
		// 订单信息
		OrderBean ob = new OrderBean();
		// 1、数据库订单表中的信息
		ob = os.queryPersonalOrderInfo(order_SEQ);
		// 2、订单中的ArrayList<OrderProductBean>
		ArrayList<OrderProductBean> list_opb = new OrderProductService().getOrderProducts(order_SEQ);
		
		// 为了在页面上输出中文类别名称，做了如下处理
		list_opb = new CategoryService().getOrderProductCategoryName(list_opb);
		
		ob.setList_opb(list_opb);
		//System.out.println(ob.getList_opb().get(0).getNum()); // 测试
		
		// 将响应信息封装到request中
		request.setAttribute("orderbean", ob);
		
		// 返回响应信息
		ActionForward forward = mapping.findForward("order_info");		
		return forward;
	}
	
	
	/**
	 * 页面初始化查询结果
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
				
		// 默认显示第一页
		int pageNow = 1;
		// 获得用户请求显示页号
		String sPageNow = request.getParameter("pageNow");
		if(sPageNow != null) {
			// 更改默认页号
			pageNow = Integer.parseInt(sPageNow);
		}
		
		// 调用service层获得pagebean信息
		PageBean page = os.getPageInfo(status, pageNow);
		
		request.setAttribute("page_pre", page);
		
		// 得到要显示的orderbean集合
		ArrayList<OrderBean> list = os.queryOrders(status, pageNow, page.getPAGESIZE());
		
		request.setAttribute("list", list);
		
		ActionForward forward = null;
		
		if (0 == status) {
			// 跳转到orser.jsp
			forward = mapping.findForward("bg_order");
		}
		if (1 == status) {
			// 跳转到order_update.jsp
			forward = mapping.findForward("bg_order_update");
		}
		if (4 == status) {
			// 跳转到order_delete.jsp
			forward = mapping.findForward("bg_order_delete");
		}		
		
		return forward;
	}
	
	
	
	
	/**
	 * 查询订单
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
//		System.out.println(order_SEQ); // 测试
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
	 * 修改订单状态前查询订单操作（只针对新订单和已支付订单）
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
//		System.out.println(order_SEQ); // 测试
//		System.out.println(status);
		
		// 解决对于查询结果分页的处理
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
	 * 修改订单状态
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
		// 获得页面传过来的参数值
		int order_SEQ = of.getOrder_SEQ();
		// 得到修改订单状态的原因
		String issue_cause = of.getIssue_cause();
		
		// 从session中获得管理员的名字
		String managername = (String)request.getSession().getAttribute("adminname");
		
		// 向order_record表中插入数据，记录某个管理员修改某个订单状态的原因
		OrderRecordService ors = new OrderRecordService();
		boolean flag = ors.addOrderRecord(order_SEQ, managername, issue_cause);
		
//		System.out.println(order_SEQ); // 测试
//		System.out.println(status);
		
//		System.out.println(request.getParameter("issue_cause"));		
		
		OrderService os = new OrderService();
		boolean isSuccess = os.updateOrderStatus(order_SEQ, status);
		
		ActionForward forward = null;
		if (isSuccess && flag) {
			request.setAttribute("result", "恭喜，修改成功！"); // 用于在jsp页面作为弹出对话框的标志位
			forward = mapping.findForward("bg_order_update");
		} else {
			request.setAttribute("result", "对不起，修改失败！");
			forward = mapping.findForward("bg_order_update");
		}
		
		return forward;
	}
	
	
	/**
	 * 删除订单状态前查询订单操作（只针对已作废订单）
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
		int status = 4; // 设定查询条件订单状态为“已作废订单”
//		System.out.println(order_SEQ); // 测试
		
		// 默认显示第一页
		int pageNow = 1;
		
		// 获得需要显示的第几页
		String sPageNow = request.getParameter("pageNow");
		// 如果页号不为空，则把用户希望显示的页号赋给pageNow
		if (sPageNow != null) {
			pageNow = Integer.parseInt(sPageNow);
		}		
		
		OrderService os = new OrderService();
		
		// 获得分页信息
		PageBean page = os.getPageInfo(order_SEQ, status, pageNow);
		request.setAttribute("page", page);
		
		ArrayList<OrderBean> list = os.queryAllOrders(order_SEQ, status, page);		
		request.setAttribute("list", list);
		
		ActionForward forward = mapping.findForward("bg_order_delete");
		
		return forward;
	}
	
	
	
	/**
	 * 删除订单
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
//		System.out.println(order_SEQ); // 测试
		
		ActionForward forward = null;
		
		OrderProductDao opd = new OrderProductDao();
		boolean flag = opd.deleteOrderProduct(order_SEQ);
		if (flag) {
			OrderService os = new OrderService();
			boolean isSuccess = os.deleteOrder(order_SEQ);
//			System.out.println(isSuccess); // 测试
			if (isSuccess) {
				request.setAttribute("result", "恭喜，删除成功");
				forward = mapping.findForward("bg_order_delete");
			}
		} else {
			request.setAttribute("result", "对不起，删除失败！");
			forward = mapping.findForward("bg_order_delete");
		}
		
		
		return forward;
	}
	
	
	
}
