package com.neusoft.ccmall.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.neusoft.ccmall.bean.ManagerBean;
import com.neusoft.ccmall.util.DBUtils;

public class ManagerDao {
	
	public ManagerBean getAdminByName(String manager_name){
		ManagerBean mb = null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM manager WHERE manager_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new ManagerBean();
				int manager_id = rs.getInt("manager_id");
				String name = rs.getString("manager_name");
				String pas = rs.getString("password");
				int priority = rs.getInt("priority");
				int product_do = rs.getInt("product_do");
				int product_category_do = rs.getInt("product_category_do");
				int news_do = rs.getInt("news_do");
				int user_do = rs.getInt("user_do");
				int order_do = rs.getInt("order_do");
				
				mb.setId(manager_id);
				mb.setName(name);
				mb.setPassword(pas);
				mb.setPriority(priority);
				mb.setProduct_do(product_do);
				mb.setProduct_category_do(product_category_do);
				mb.setNews_do(news_do);
				mb.setUser_do(user_do);
				mb.setOrder_do(order_do);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
		return mb;
	}
	public String adminPassword(String manager_name){
		String str = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			String sql = "SELECT password FROM manager WHERE manager_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				
				String pas = rs.getString("password");
				str = pas;
				
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
		
		
		
		return str;
		
	}
	public void updatepas(String manager_name,String passwordnew){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConnection();
		
		String sql="update manager set password=?where manager_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwordnew);
			pstmt.setString(2, manager_name);
			
			pstmt.executeUpdate();
			
			//System.out.println("���³ɹ�2");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtils.closeDB(conn, pstmt, null);
			
		}
	
		
		
		
		
		
		
	}
	public void addadmin(ManagerBean mb){
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConnection();

		String sql="insert into manager values(manager_id.nextval,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getName());
			pstmt.setString(2, mb.getPassword());
			pstmt.setInt(3, 1);
			pstmt.setInt(4, mb.getProduct_do());
			pstmt.setInt(5, mb.getProduct_category_do());
			pstmt.setInt(6, mb.getNews_do());
			pstmt.setInt(7, mb.getUser_do());
			pstmt.setInt(8, mb.getOrder_do());
			
			pstmt.executeUpdate();
			
			//System.out.println("���³ɹ�2");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtils.closeDB(conn, pstmt, null);
			
		}
	}
		
		
    public ManagerBean adminprimodify(ManagerBean mb){
			Connection conn = null;
			PreparedStatement pstmt = null;
			conn = DBUtils.getConnection();
            
			String sql="update manager set product_do=? ,product_category_do=?,news_do=?,user_do=?,order_do=? where manager_name=?";
			try {
				pstmt = conn.prepareStatement(sql);
				
				
				pstmt.setInt(1, mb.getProduct_do());
				
				pstmt.setInt(2, mb.getProduct_category_do());
				pstmt.setInt(3, mb.getNews_do());
				pstmt.setInt(4, mb.getUser_do());
				pstmt.setInt(5, mb.getOrder_do());
				pstmt.setString(6, mb.getName());
				
				
				//System.out.println(mb.getProduct_do()+"??");
				//System.out.println(mb.getProduct_category_do()+"??");
				//System.out.println(mb.getNews_do()+"??");
				//System.out.println(mb.getUser_do()+"??");
				//System.out.println(mb.getOrder_do()+"??");
				//System.out.println(mb.getName()+"??");
				pstmt.executeUpdate();
				
				//System.out.println("���³ɹ�2");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				DBUtils.closeDB(conn, pstmt, null);
				
			}
		
		
		
		
		return mb;
		
		
	}
	public ArrayList<ManagerBean> queryManagers(){
		ArrayList<ManagerBean> al = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManagerBean mb = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM manager where manager_name<>1000 order by manager_id";
			pstmt = conn.prepareStatement(sql);
			al = new ArrayList<ManagerBean>();
			rs = pstmt.executeQuery();

			while(rs.next()) {
				mb = new ManagerBean();
				int id = rs.getInt("manager_id");
				String name = rs.getString("manager_name");
				int product_do = rs.getInt("product_do");
				int product_category_do = rs.getInt("product_category_do");
				int news_do = rs.getInt("news_do");
				int user_do = rs.getInt("user_do");
				int order_do = rs.getInt("order_do");
				
				mb.setId(id);
				mb.setName(name);
				mb.setProduct_do(product_do);
				mb.setProduct_category_do(product_category_do);
				mb.setNews_do(news_do);
				mb.setUser_do(user_do);
				mb.setOrder_do(order_do);
				
				al.add(mb);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
	
	   return  al;
		
		
		
	}

	public ManagerBean queryadmin(String manager_name){
		ManagerBean mb = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM manager WHERE manager_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_name);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				mb = new ManagerBean();
				int id = rs.getInt("manager_id");
				String name = rs.getString("manager_name");
				int product_do = rs.getInt("product_do");
				int product_category_do = rs.getInt("product_category_do");
				int news_do = rs.getInt("news_do");
				int user_do = rs.getInt("user_do");
				int order_do = rs.getInt("order_do");
				
				mb.setId(id);
				mb.setName(name);
				mb.setProduct_do(product_do);
				mb.setProduct_category_do(product_category_do);
				mb.setNews_do(news_do);
				mb.setUser_do(user_do);
				mb.setOrder_do(order_do);
				
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
		
		
		
		return mb;
		
	}
public void deleteAdmin(String manager_name){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConnection();
		
		String sql="delete from manager where manager_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, manager_name);
			
			pstmt.executeUpdate();
			
			//System.out.println("���³ɹ�2");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtils.closeDB(conn, pstmt, null);
			
		}
	
	
}
	

}
