package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.SalesStaticsBean;
import com.neusoft.ccmall.util.DBUtils;

public class SalesStaticsDao {

	public ArrayList<SalesStaticsBean> querySales(String main_type,String name,String issue_date_begin ,String issue_date_end){
		ArrayList<SalesStaticsBean> al = new ArrayList<SalesStaticsBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesStaticsBean s = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select orders.issue_date odate,products.product_seq seq,products.name pname,order_product.num num,order_product.num*products.price total from order_product,orders,products where order_product.order_seq=orders.order_seq and order_product.product_seq=products.product_seq and products.name Like ?";
			
			if(main_type != null&&!(main_type.equals(""))){
				
				sql +="and products.product_seq='"+main_type+"'";
				
			}
            
			if(issue_date_begin != null&&!(issue_date_begin.equals(""))){
				sql += "and orders.issue_date>=to_date('"+issue_date_begin+"','yyyy-mm-dd')" ;
				
			}
			
		    if(issue_date_end != null&&!(issue_date_end.equals(""))){
				sql += "and orders.issue_date<=to_date('"+ issue_date_end +"','yyyy-mm-dd')" ;
			}
			
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, '%'+name+'%');
			rs = pstmt.executeQuery();

			while(rs.next()) {
				s = new SalesStaticsBean();
				
				String date = rs.getString("odate");
				String product_type = rs.getString("seq");
				String product_name = rs.getString("pname");
				int num = Integer.parseInt(rs.getString("num"));
				double total = Double.parseDouble(rs.getString("total"));
				
				s.setDate(date);
				s.setProduct_type(product_type);
				s.setProduct_name(product_name);
				s.setNum(num);
				s.setTotal(total);
				al.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(conn, pstmt, rs);
		}
	
	   return  al;
	}



}
