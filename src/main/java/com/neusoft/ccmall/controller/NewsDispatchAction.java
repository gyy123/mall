package com.neusoft.ccmall.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.neusoft.ccmall.bean.NewsBean;
import com.neusoft.ccmall.bean.NewsForm;
import com.neusoft.ccmall.service.NewsService;

public class NewsDispatchAction extends DispatchAction {

	/**
	 * �����Ѷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addInformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		
		NewsForm nf = (NewsForm) form;
		String title = nf.getTitle();
		String content = nf.getContent();
		
		NewsBean nb = new NewsBean();
		nb.setTitle(title);
		nb.setContent(content);
		NewsService ns = new NewsService();
        boolean flag = ns.addInformation(nb);
        if(flag){
        	request.setAttribute("result", 1);
        	forward=mapping.findForward("information_add");
        }else{
        	request.setAttribute("result", 0);
        	forward=mapping.findForward("information_add");
        }  
        
        return forward;
	}

	/**
	 * �鿴������Ѷ��ϸ��Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward selectInformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		NewsService ns=new NewsService();
		NewsBean nb=ns.selectInformation(id);
		request.setAttribute("Information1",nb);
		ActionForward forward = mapping.findForward("information_details");
		return forward;
	}
	
	/**
	 * ������Ѷ״̬����������Ѷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ActionForward forward = null;
		NewsService ns=new NewsService();
		ns.updateStatus(id);
	    ArrayList<NewsBean> al=ns.getInformation();
	    
	    //-----------
	    
	    request.getSession().setAttribute("information", al);
	    //-----------
	    request.setAttribute("information", al);
	    forward=mapping.findForward("getinformation");
		
		return forward;
	}

	/**
	 * �޸���Ѷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateInformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		NewsService ns=new NewsService();
		NewsBean nb=ns.selectInformation(id);
//		System.out.println(nb.getId()); //����
		request.setAttribute("Information1",nb);
		ActionForward forward = mapping.findForward("information_modify");
		return forward;
	}
	
	/**
	 * �����޸�ҳ������ύ��ť�޸���Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateInformation2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//System.out.println(request.getParameter("id")); //
		int id = Integer.parseInt(request.getParameter("id"));
		
		NewsForm nf = (NewsForm) form;
		String title = nf.getTitle();
		String content = nf.getContent();
		//System.out.println(title); //
		//System.out.println(content); //
		
		NewsBean nb = new NewsBean();
		nb.setTitle(title);
		nb.setContent(content);
		nb.setId(id);
		
		NewsService ns=new NewsService();
		boolean b = ns.updateInformation(title, content, id);
		
		ActionForward forward = null;
		if (b) {
			request.setAttribute("result", 1);
			forward = mapping.findForward("information_modify");
		} else {
			request.setAttribute("result", 0);
			forward = mapping.findForward("information_modify");
		}
		return forward;
	}

	/**
	 * ɾ����Ѷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward deleteInformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		ActionForward forward = null;
        NewsService ns=new NewsService();
        boolean flag=ns.deleteInformation(id);
        
        if (flag) {
        	// ��������Ѷ��session��ɾ����ǰ̨������ʾ����Ѷ
//        	ArrayList<NewsBean> list = (ArrayList<NewsBean>)request.getSession().getAttribute("information");
//        	for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).getId()==id) {
//					list.remove(i);
//				}
//			}
        	
        	ArrayList<NewsBean> al=ns.getInformation();
        	
        	request.getSession().setAttribute("information", al);
        	
            request.setAttribute("information", al);
            forward=mapping.findForward("getinformation");
		} else {
			// ɾ��ʧ��
			
		}       
        
		return forward;
	}

	/**
	 * ��ѯ��Ѷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryInformation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
        NewsService ns=new NewsService();
        ArrayList<NewsBean> al=ns.getInformation();
        request.setAttribute("information", al);
        forward=mapping.findForward("getinformation");
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
	public ActionForward queryPost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		NewsService ns = new NewsService();
		String aa = ns.getPost1();
		request.setAttribute("ppa", aa);
		forward = mapping.findForward("getpost");
		return forward;
	}
	
	
	/**
	 * ��ѯ���棬����޸Ĺ��水ť�������޸�ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward queryPost1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		NewsService ns1 = new NewsService();
		String bb = ns1.getPost1();
		request.setAttribute("ppb", bb);

		forward = mapping.findForward("getpost1");

		return forward;
	}

	/**
	 * �����ť��ȷ���޸Ĺ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = null;
		NewsForm nf = (NewsForm) form;
		String content = nf.getContent();
		NewsService ns = new NewsService();
	    ns.updatePost(content);
	    String aa = ns.getPost1();
		request.setAttribute("ppa", aa);
		// update success, put in session
		request.getSession().setAttribute("post", aa);
		
		forward = mapping.findForward("getpost");

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
	public ActionForward deletePost(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
        NewsService ns=new NewsService();
        ns.deletePost();
        String aa = ns.getPost1();
		request.setAttribute("ppa", aa);
		
		// delete success, out of session
		request.getSession().removeAttribute("post");
		
		forward = mapping.findForward("getpost");
		return forward;
	}
	
	
}
