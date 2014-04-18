/**
 * @author
 * @since
 * 这个类的主要功能是：
 * 1.发表评论
 * 2.显示特定商品所有评论
 * 3.删除特定商品的特定评论
 * 4.删除特定商品的所有评论
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.CommentBean;
import com.neusoft.ccmall.dao.CommentDao;

public class CommentService {

	CommentDao cd = new CommentDao();
	
	/**
	 * 注册用户对商品发表评论
	 * @param cb 封装了评论相关信息的CommentBean
	 * @return true评论成功 false评论失败
	 */
	public boolean addComment(CommentBean cb) {
		
		boolean flag = cd.addComment(cb);
		
		return flag;
	}
	
	
	/**
	 * 普通管理员在查看商品详细信息时显示该商品的所有评论
	 * @param id 商品的ID编号
	 * @return 包含了所有对该商品的评论的ArrayList集合
	 */
	public ArrayList<CommentBean> showAllComments(int product_seq) {
		
		ArrayList<CommentBean> al = cd.showAllComments(product_seq);
		
		return al;
	}
	
	
	/**
	 * 普通管理员删除特定商品的特定评论
	 * @param id 商品的ID编号
	 * @return true删除成功 false删除失败
	 */
	public boolean deleteComment(int id) {
		boolean flag = false;
		
		return flag;
	}
	
	
	/**
	 * 普通管理员删除特定商品的所有评论
	 * @param id 特定商品的ID编号
	 * @return true删除成功 false删除失败
	 */
	public boolean deleteAllComments(int id) {
		boolean flag = false;
		
		return flag;
	}
	
}
