/**
 * @author
 * @since
 * 这个类的主要作用是：
 * 1.修改公告
 * 2.删除公告
 * 3.发布资讯
 * 4.修改资讯
 * 5.删除资讯
 * 6.查询资讯
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.NewsBean;
import com.neusoft.ccmall.dao.NewsDao;

public class NewsService {


	/**
	 * 查询公告
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true修改成功 false修改失败
	 */
	public String getPost1() {
	
		NewsDao nd=new NewsDao();
		
		String str=nd.getPost();
		
		return str;
	
	}

	/**
	 *修改公告
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true添加成功 false添加失败
	 */
	public boolean updatePost(String content) {
		boolean flag = false;
		NewsDao nd=new NewsDao();
		nd.updatePost(content);
		return flag;
	}
	
	/**
	 * 删除公告
	 * @param id 要删除的资讯、公告的ID
	 * @return true删除成功 false删除失败
	 */
	public boolean deletePost() {
		boolean flag = false;
		NewsDao nd1=new NewsDao();
		nd1.deletePost();
		return flag;
	}
	
	/**
	 *添加资讯
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true添加成功 false添加失败
	 */
	public boolean addInformation(NewsBean nb) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.addInformation(nb);	
		return flag;
	}
	
	
	/**
	 * 查询资讯
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true修改成功 false修改失败
	 */
	public ArrayList<NewsBean> getInformation() {
		NewsDao nd=new NewsDao();
		ArrayList<NewsBean> al=nd.getInformation();
		return al;
	
	}
	
	/**
	 *修改咨询
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true添加成功 false添加失败
	 */
	public boolean updateInformation(String title,String content,int id) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.updateInformation(title, content, id);
		return flag;
	}
	

	/**
	 * 删除资讯
	 * @param id 要删除的资讯、公告的ID
	 * @return true删除成功 false删除失败
	 */
	public boolean deleteInformation(int id) {
		NewsDao nd=new NewsDao();
		boolean flag =nd.deleteIformation(id);
		return flag;
	}
	
	/**
	 * 查看单条资讯
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true修改成功 false修改失败
	 */
	public NewsBean selectInformation(int id) {
		
		NewsDao nd=new NewsDao();
	    NewsBean nb=nd.selectInformation(id);
		return nb;
	
	}
	/**
	 *发布资讯
	 * @param nb 封装了相关参数值的NewsBean
	 * @return true添加成功 false添加失败
	 */
	public boolean updateStatus(int id) {
		NewsDao nd=new NewsDao();
		boolean flag = nd.updateStatus(id);
		return flag;
	}
	
}
