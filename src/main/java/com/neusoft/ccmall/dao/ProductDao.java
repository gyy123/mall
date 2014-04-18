package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.util.DBUtils;

public class ProductDao {
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	
	/**
	 *
	 * @return
	 */
	public ArrayList<ProductBean> getAllProduct(){
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products order by product_SEQ";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));	
				al.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}
	
	/**
	 * 
	 * @param product_SEQ
	 * @return
	 */
	public ProductBean getProduct(int product_SEQ) {
		ProductBean pb = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from products where product_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1,product_SEQ);
			rs = ps.executeQuery();
			if (rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return pb;		
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public ProductBean getProductByName(String name){
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products WHERE name=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			if (rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return pb;
	}
	
	/**
	 * 
	 * @param name
	 * @param main_type
	 * @param sub_type
	 * @return
	 */
	
	public ArrayList<ProductBean> getProductByNameAndType(String name,int main_category,int sub_category){
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products where name like ?";
			

			if(main_category != 0){
				sql += " and main_type='"+main_category+"'" ;
			}

			if(sub_category != 0){
				sql += " and main_type='"+sub_category+"'" ;
			}
			sql += "order by product_seq";
			ps = ct.prepareStatement(sql);
		    ps.setString(1, "'%"+name+"%'");
			rs = ps.executeQuery();

			while(rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
				
				al.add(pb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}
	
	/**
	 * 
	 * @param main_type
	 * @param sub_type
	 * @return
	 */
	
	public ArrayList<ProductBean> getProductByType(String main_category,String sub_category){
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products where 1=1";
			ps = ct.prepareStatement(sql);
			if(main_category != null){
				sql += " and main_type='"+main_category+"'" ;
			}
			if(sub_category != null){
				sql += " and main_type='"+sub_category+"'" ;
			}
			rs = ps.executeQuery();

			while(rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
				
				al.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}
	
	
	/**
	 *
	 * @param pb
	 * @return
	 */
	public void addProduct(ProductBean pb) {
		
		
		try {
			ct = DBUtils.getConnection();
			String sql = "insert into products values(product_SEQ.nextval,?,?,(select id from category where name=? and type=1),(select id from category where name=? and type=2),?,?,?,?,?,products_seq.nextval)";
			ps = ct.prepareStatement(sql);
			ps.setString(1,pb.getName());
			ps.setString(2,pb.getDescription());
			ps.setString(3,pb.getMain_value());
			ps.setString(4,pb.getSub_value());
			ps.setString(5,pb.getUnit());
			ps.setDouble(6, pb.getPrice());
			ps.setInt(7,pb.getNum());
			ps.setInt(8,pb.getRecommend());
			ps.setString(9,pb.getImage());
			
			System.out.println(pb.getRecommend());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			DBUtils.closeDB(ct, ps, rs);
		}				
	}
	
	/**
	 * 
	 * @param pb
	 * @return
	 */
	public void updateProduct(ProductBean pb) {
		
//		System.out.println(pb.getNum()+"dao");
//		System.out.println(pb.getProduct_SEQ()+"dao");
		try {
			ct = DBUtils.getConnection();
			String sql = "update products set name=?,description=?,main_category=?,sub_category=?,unit=?,price=?,num=?,recommend=?,image=? where product_SEQ=?";
			ps = ct.prepareStatement(sql);
			
			ps.setString(1,pb.getName());
			ps.setString(2,pb.getDescription());
			ps.setInt(3,pb.getMain_category());
			ps.setInt(4,pb.getSub_category());
			ps.setString(5,pb.getUnit());
			ps.setDouble(6, pb.getPrice());
			ps.setInt(7,pb.getNum());
			ps.setInt(8,pb.getRecommend());
			ps.setString(9,pb.getImage());
			ps.setInt(10,pb.getProduct_SEQ());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			DBUtils.closeDB(ct, ps, rs);
		}
		
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void deleteProduct(int id){
		try {
			ct = DBUtils.getConnection();
			String sql = "delete products where product_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			DBUtils.closeDB(ct, ps, rs);
		}
	}
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public ArrayList<ProductBean> querySellout(){
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products WHERE num=0";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
				
				al.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}	
	
//	/**
//	 * 
//	 * @param name
//	 * @param main_type
//	 * @param sub_type
//	 * @return
//	 */
//	
//	public ArrayList<ProductBean> getProductByNameType(String name,int main_category,int sub_category){
//		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
//		ProductBean pb = null;
//		try{
//			ct = DBUtils.getConnection();
//			String sql = "SELECT * FROM products where name like ?";
//			
//
//			if(main_category != 0){
//				sql += " and main_type='"+main_category+"'" ;
//			}
//
//			if(sub_category != 0){
//				sql += " and main_type='"+sub_category+"'" ;
//			}
//			sql += "order by product_seq";
//			ps = ct.prepareStatement(sql);
//		    ps.setString(1, "'%"+name+"%'");
//			rs = ps.executeQuery();
//
//			while(rs.next()) {
//				pb = new ProductBean();
//				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
//				pb.setName(rs.getString("name"));
//				pb.setDescription(rs.getString("description"));
//				pb.setMain_category(rs.getInt("main_category"));
//				pb.setSub_category(rs.getInt("sub_category"));
//				pb.setUnit(rs.getString("unit"));
//				pb.setPrice(rs.getDouble("price"));
//				pb.setNum(rs.getInt("num"));
//				pb.setRecommend(rs.getInt("recommend"));
//				pb.setImage(rs.getString("image"));
//				
//				al.add(pb);
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtils.closeDB(ct, ps, rs);
//		}
//		return al;
//	}
	
	//
	public String getPost() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String post=null;
			try {
				conn = DBUtils.getConnection();
				String sql = "Select content From category Where Type=0";
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
	
	/**
	 * @param name
	 * @param main_type
	 * @param sub_type
	 * @return
	 */
	
	public ArrayList<ProductBean> getProductByNameType(String name,String main_value,String sub_value){
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductBean pb = null;
		try{
			ct = DBUtils.getConnection();
			String sql = "SELECT * FROM products where name like ?";

			if(!(main_value.equals("所有分类"))){
				sql += " and main_category=(select id from category where name='"+main_value+"')";
			}

			if(sub_value!=null){
				sql += " and sub_category=(select id from category where name='"+sub_value+"')";
			}
			sql +=" order by product_seq";
			ps = ct.prepareStatement(sql);
		    ps.setString(1, '%'+name+'%');
			rs = ps.executeQuery();

			while(rs.next()) {
				pb = new ProductBean();
				pb.setProduct_SEQ(rs.getInt("product_SEQ"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setMain_category(rs.getInt("main_category"));
				pb.setSub_category(rs.getInt("sub_category"));
				pb.setUnit(rs.getString("unit"));
				pb.setPrice(rs.getDouble("price"));
				pb.setNum(rs.getInt("num"));
				pb.setRecommend(rs.getInt("recommend"));
				pb.setImage(rs.getString("image"));
				
				al.add(pb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}
	
}
