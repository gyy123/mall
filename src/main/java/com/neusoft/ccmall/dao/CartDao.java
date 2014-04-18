package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.util.DBUtils;

public class CartDao {
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	/**
	 * 在用户退出系统时，将购物车中的内容添加到数据库
	 * @param cb
	 */
	public boolean addCartToDB(CartBean cb) {
		boolean b = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "insert into cart values(cart_seq.nextval,?,?,?,?,?)";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, cb.getProductseq());
			ps.setInt(2, cb.getNum());
			ps.setString(3, cb.getUsername());
			ps.setDouble(4, cb.getPrice());
			ps.setString(5, cb.getProductname());
			ps.executeUpdate();
			ct.commit();
			b = true;
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				DBUtils.closeDB(ct, ps, null);
			}
		}
		return b;
	}
	
	
	
	/**
	 * 当订单提交成功时，要清空数据库中购物车的内容
	 * @return
	 */
	public boolean deleteAllCart(String username) {
		boolean flag = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "delete from cart where username=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			ct.commit();
			flag = true; // 严格地讲，首先要查出username对应的数据有多少条，然后与删除的条数对照，返回布尔值
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
	 * 从数据库中取得某个用户对应的商品编号和数量
	 * @param username
	 * @return
	 */
	public ArrayList<CartBean> getCart(String username) {
		ArrayList<CartBean> al = new ArrayList<CartBean>();
		CartBean cb = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "select productseq,productname,price,num from cart where username=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				cb = new CartBean();
				cb.setProductseq(rs.getInt("productseq"));
				cb.setProductname(rs.getString("productname"));
				cb.setPrice(rs.getDouble("price"));
				cb.setNum(rs.getInt("num"));
				al.add(cb);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
//	public HashMap<String, String> getCart(String username) {
//		HashMap<String, String> hm = new HashMap<String, String>();
//		try {
//			ct = DBUtils.getConnection();
//			String sql = "select product_seq,num from cart where username=?";
//			ps = ct.prepareStatement(sql);
//			ps.setString(1, username);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				String product_SEQ = rs.getInt("product_SEQ")+"";
//				String num = rs.getInt("num")+"";
//				hm.put(product_SEQ, num);
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtils.closeDB(ct, ps, rs);
//		}		
//		return hm;
//	}

}
