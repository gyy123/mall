/**
 * 这个类主要操作order/product/order_product三张数据库表
 */
package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.bean.OrderProductBean;
import com.neusoft.ccmall.util.DBUtils;

public class OrderProductDao {

	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean addOrderProduct(int order_SEQ, ArrayList<CartBean> mycart) {
		
		boolean flag = false;
		
		try {
			
			ct = DBUtils.getConnection();
			
			ct.setAutoCommit(false);
			
			int count = 0;
			
			for (int i = 0; i < mycart.size(); i++) {
				String sql = "insert into order_product values(order_product_seq.nextval,?,?,?)";
				
				ps = ct.prepareStatement(sql);
				
				ps.setInt(1, order_SEQ);
				
				ps.setInt(2, mycart.get(i).getProductseq());
				
				ps.setInt(3, mycart.get(i).getNum());
				
				ps.executeUpdate();
				
				count++;
			}
			
			if (count == mycart.size()) {
				flag = true;
			}
			
			ct.commit();
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}  finally {
			DBUtils.closeDB(ct, ps, null);
		}				
		
		return flag;
	}
	
	
	
	
	
	/**
	 * 删除谋定单号下的所包含的商品的记录数据
	 * @param order_SEQ
	 * @return
	 */
	public boolean deleteOrderProduct(int order_SEQ){
		 boolean flag = false;
		 int count = 0; // 接收1中的参数
		 int i = 0; // 接收2中的参数
			
		 try {
			ct = DBUtils.getConnection();
			String sql = "select count(*) from order_product where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count(*)");
				System.out.println(count); // 测试count
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		 
		 try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "delete from order_product where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			i = ps.executeUpdate();
//			System.out.println(i); // 测试i
			if (count == i) {
				flag = true;
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
		return flag;
	}
	
	/**
	 * 通过订单号查询该订单下的所有商品集合
	 * @param order_SEQ
	 * @return
	 */
	public ArrayList<OrderProductBean> getOrderProducts(int order_SEQ) {
		ArrayList<OrderProductBean> al_opb = new ArrayList<OrderProductBean>();
		OrderProductBean opb = null;		
		try {
			ct = DBUtils.getConnection();
			// 多表联合查询
			String sql = "SELECT op.product_SEQ,op.num,p.name,p.main_category,p.sub_category,p.price FROM order_product op,products p WHERE op.order_SEQ=? AND op.product_SEQ=p.product_SEQ";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			rs = ps.executeQuery();
			while (rs.next()) {
				opb = new OrderProductBean();
				opb.setId(rs.getInt("product_SEQ"));
				opb.setNum(rs.getInt("num"));
				opb.setName(rs.getString("name"));
				opb.setMain_category(rs.getInt("main_category"));
				opb.setSub_category(rs.getInt("sub_category"));
				opb.setPrice(rs.getDouble("price"));
				al_opb.add(opb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al_opb;
	}
	
	
}
