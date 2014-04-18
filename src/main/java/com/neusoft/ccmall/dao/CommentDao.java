package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.CommentBean;
import com.neusoft.ccmall.util.DBUtils;

public class CommentDao {
	
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/**
	 * 显示特定商品的所有评论
	 * @param product_seq
	 * @return
	 */
	public ArrayList<CommentBean> showAllComments(int product_seq) {
		
		ArrayList<CommentBean> al = new ArrayList<CommentBean>();
		
		CommentBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select username,content,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from comments where product_seq=? order by issue_date desc";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, product_seq);
			rs = ps.executeQuery();
			while (rs.next()) {
				cb = new CommentBean();
				cb.setUsername(rs.getString("username"));
				cb.setContent(rs.getString("content"));
				cb.setIssue_date(rs.getString("issue_date"));
				al.add(cb);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		
		return al;
	}
	
	
	
	
	
	/**
	 * 注册用户添加商品评论
	 * @param cb
	 * @return
	 */
	public boolean addComment(CommentBean cb) {
		boolean b = false;
		
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "insert into comments(id,product_seq,content,username,issue_date) values(comments_seq.nextval,?,?,?,sysdate)";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, cb.getProduct_seq());
			ps.setString(2, cb.getContent());
			ps.setString(3, cb.getUsername());
			int i = ps.executeUpdate();
			if (1 == i) {
				b = true;
			}
			ct.commit();
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, null);
		}	
		
		return b;
	}
	

}
