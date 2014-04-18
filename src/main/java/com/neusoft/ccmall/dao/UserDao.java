package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.UserBean;
import com.neusoft.ccmall.util.DBUtils;

public class UserDao {
	
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	UserBean u=null;
	
		
	
	/**
	 * �޸ĸ�������
	 * @param username
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(String username, String newPassword) {
		boolean flag = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "update users set password=? where username=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);
			int i = ps.executeUpdate();
			ct.commit();
			if (1 == i) {
				flag = true;
			}
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
		return flag;
	}	
	
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param ub
	 * @return
	 */
	public boolean updateUser(UserBean ub) {
		boolean flag = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			/**
			 * ��ν�����SQL��update���ĳ�Oracle�����
			 * update table1 set f1=b.f1,f2=b.f2,f3=b.f3 from table1 a,bable2 b where a.id=b.id
			 * --->
			 * update table1 a set (f1,f2,f3)=(select f1,f2,f3 from bable2 b where a.id=b.id)
			 * �����Ӳ�ѯ��where�޶�����д�ɣ�
			 * where exist(select 1 from bable2 b,table1 a where a.id=b.id)
			 */
			String sql = "update users set truename=?,id_card=?,email=?,postcode=?,address=?,phone=? where username=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, ub.getTruename());
			ps.setString(2, ub.getId_card());
			ps.setString(3, ub.getEmail());
			ps.setString(4, ub.getPostcode());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getPhone());
			ps.setString(7, ub.getUsername());
			int i = ps.executeUpdate();
			ct.commit();
			if (1 == i) {
				flag = true;
			}			
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
		return flag;
	}
	
	
	
	/**
	 * ͨ���û����õ��û���Ϣ
	 * @param username
	 * @return
	 */  
	public UserBean getUserByName(String username){
						
       try {
			ct = DBUtils.getConnection();
			String sql = "select id,username,password,truename,id_card,email,postcode,address,phone,question,answer,to_char(registerdate,'yyyy-mm-dd hh24:mi:ss') registerdate"
					+ " from users where username=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new UserBean();
                int id = rs.getInt("id");
				String name = rs.getString("username");
				String password = rs.getString("password");
				String truename = rs.getString("truename");
				String id_card = rs.getString("id_card");
				String email = rs.getString("email");
				String postcode = rs.getString("postcode");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String registerdate = rs.getString("registerdate");
                
				u.setId(id);
				u.setUsername(name);
				u.setPassword(password);
				u.setTruename(truename);
				u.setId_card(id_card);
				u.setEmail(email);
				u.setPostcode(postcode);
				u.setAddress(address);
				u.setPhone(phone);
				u.setQuestion(question);
				u.setAnswer(answer);
				u.setRegisterdate(registerdate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return u;
	}
	//��ѯ�û��Ƿ��ж���
	public OrderBean getOrderByName(String username){
		    OrderBean ob = null;
	       try {
				ct = DBUtils.getConnection();
				String sql = "select * from orders where username=?";
				ps = ct.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
				while (rs.next()) {
					ob = new OrderBean();
					ob.setOrder_SEQ(rs.getInt("order_SEQ"));
					ob.setUsername(rs.getString("username"));
					ob.setPostcode(rs.getString("postcode"));
					ob.setAddress(rs.getString("address"));
					ob.setPhone(rs.getString("phone"));
					ob.setTotal(rs.getDouble("total"));
					ob.setStatus(rs.getInt("status"));
					ob.setPost_type(rs.getInt("post_type"));
					ob.setPay_type(rs.getInt("pay_type"));
					ob.setIssue_date(rs.getString("issue_date"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(ct, ps, rs);
			}
			return ob;
		}
	
	
	
	//�û�ע��
	public boolean addUser(UserBean user){
		boolean flag = false;
		
		try {

			ct = DBUtils.getConnection();
			// �����Զ��ύΪfalse
			ct.setAutoCommit(false);
			String sql = "insert into users (id,username,password,question,answer,truename,id_card,email,postcode,address,phone,registerdate)"
					+ "values(users_seq.Nextval,?,?,?,?,?,?,?,?,?,?,sysdate)";

			ps = ct.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getQuestion());
			ps.setString(4, user.getAnswer());
			ps.setString(5, user.getTruename());
			ps.setString(6, user.getId_card());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPostcode());
			ps.setString(9, user.getAddress());
			ps.setString(10, user.getPhone());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
			// ����û���Ϣ�ɹ����ύ
			ct.commit();
		} catch (SQLException e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, null);
		}
		return flag;
	}
	public ArrayList<UserBean> queryUsers(String username,String registerdate_begin,String registerdate_end){
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean u = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM users where username Like ?";
			
			
			if(registerdate_begin != null&&!(registerdate_begin.equals(""))){
				sql += " and registerdate>=to_date('"+registerdate_begin+"','yyyy-mm-dd')" ;
				
			}
			
		    if(registerdate_begin != null&&!(registerdate_end.equals(""))){
				sql +="and registerdate<=to_date('"+ registerdate_end +"','yyyy-mm-dd')" ;
			}
			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+username+'%');
			rs = pstmt.executeQuery();

			while(rs.next()) {
				u = new UserBean();
				
				String name = rs.getString("username");
				String password = rs.getString("password");
				String truename = rs.getString("truename");
				String id_card = rs.getString("id_card");
				String email = rs.getString("email");
				String postcode = rs.getString("postcode");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String registerdate = rs.getString("registerdate");
				
				u.setUsername(name);
				u.setPassword(password);
				u.setTruename(truename);
				u.setId_card(id_card);
				u.setEmail(email);
				u.setPostcode(postcode);
				u.setAddress(address);
				u.setPhone(phone);
				u.setQuestion(question);
				u.setAnswer(answer);
				u.setRegisterdate(registerdate);

				al.add(u);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
	
	   return  al;
		
		
		
	}
public void deleteUser(String username){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtils.getConnection();
		
		String sql="delete from users where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, username);
			
			pstmt.executeUpdate();
			
			//System.out.println("���³ɹ�2");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtils.closeDB(conn, pstmt, null);
			
		}
	
	
}
	
}
