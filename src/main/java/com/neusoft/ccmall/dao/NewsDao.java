package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;



import com.neusoft.ccmall.bean.NewsBean;
import com.neusoft.ccmall.util.DBUtils;

public class NewsDao {

	

	//	
	public String getPost() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String post=null;
			try {
				conn = DBUtils.getConnection();
				String sql = "Select content From news Where Type=0";
				pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
				if(rs.next()) {
					post = rs.getString("content");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(conn, pstmt, rs);
			}
			return post;
		}

	//
	public void updatePost(String content){

			Connection conn = null;
			PreparedStatement pstmt = null;
			conn = DBUtils.getConnection();
			String sql="update news set content=? where type=0";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
				pstmt.executeUpdate();
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally{
				DBUtils.closeDB(conn, pstmt, null);	
			}
		}
	
	//
	public void deletePost(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			conn = DBUtils.getConnection();
			String sql="update news set content='   ' where type=0";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally{
				DBUtils.closeDB(conn, pstmt, null);	
			}

		}
	
	//
	public boolean deleteIformation(int id){
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConnection();
		String sql="delete from news where n_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int i=pstmt.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeDB(conn, pstmt, null);	
		}
		return flag;
	}
	
	//
	public boolean addInformation(NewsBean nb) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into news values(news_seq.nextval,?,0,?,sysdate,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nb.getTitle());
			pstmt.setString(2, nb.getContent());
			int i = pstmt.executeUpdate();
			if (1 == i) {
				flag = true;
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, null);
		}
		return flag;
	}
	
	//	
	public ArrayList<NewsBean> getInformation() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<NewsBean> al=null;
			NewsBean nb=null;
			try {
				conn = DBUtils.getConnection();
				String sql = "Select n_id,content,status,title From news Where Type=1";
				pstmt = conn.prepareStatement(sql);
				al=new ArrayList<NewsBean>();
                rs = pstmt.executeQuery();
				while(rs.next()) {
					nb=new NewsBean();
					
					String content=rs.getString("content");
					int status=rs.getInt("status");
					String title=rs.getString("title");
					if(status==1){
						nb.setStatus1("已发布");
					}
					else{
						nb.setStatus1("未发布");
					}
					nb.setContent(content);
					nb.setStatus(status);
					nb.setTitle(title);
					nb.setId(rs.getInt("n_id"));
					al.add(nb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(conn, pstmt, rs);
			}
			return al;
		}
	//
	public boolean updateInformation(String title,String content,int id){
		    boolean flag=true;
			Connection conn = null;
			PreparedStatement pstmt = null;
			conn = DBUtils.getConnection();
			String sql="update news set title=?,content=? where n_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3,id);
				pstmt.executeUpdate();
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally{
				DBUtils.closeDB(conn, pstmt, null);	
			}
			return flag;
		}
	//
	public NewsBean selectInformation(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewsBean nb=null;
		try {
			conn = DBUtils.getConnection();
			String sql = "Select n_id,title,status,content From news Where n_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
          
			if(rs.next()) {
				nb=new NewsBean();
				String title = rs.getString("title");
				int status = rs.getInt("status");
				String content = rs.getString("content");
				int id1=rs.getInt("n_id");
				if(status==1){
					nb.setStatus1("已发布");
				}
				else{
					nb.setStatus1("未发布");
				}
				nb.setTitle(title);
				//nb.setStatus(status);
				nb.setContent(content);
				nb.setId(id1);
//				System.out.println(nb.getId()); //
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
		return nb;
	}

	//
	public boolean updateStatus(int id){
		    boolean flag=true;
			Connection conn = null;
			PreparedStatement pstmt = null;
			conn = DBUtils.getConnection();
			String sql="update news set status=1 where n_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,id);
				pstmt.executeUpdate();
			} catch (SQLException e) {	
				e.printStackTrace();
			}finally{
				DBUtils.closeDB(conn, pstmt, null);	
			}
			return flag;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
