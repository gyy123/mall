package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.CategoryBean;
import com.neusoft.ccmall.bean.OrderProductBean;
import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.util.DBUtils;

public class CategoryDao {
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	
	/**
	 * @return
	 */
	public void updateCategory(String name,int id){
		try {
			ct = DBUtils.getConnection();
			String sql = "update category set name=? where id=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}

	}
	
	
	
	

	//--------------------
//	sql = "select a.Name As main_value,b.Name As sub_value from category a,category b Where a.Id=? And b.Id=?";
//	ps = ct.prepareStatement(sql);
//	ps.setInt(1, pb.getMain_category());
//	ps.setInt(2, pb.getSub_category());
//	rs = ps.executeQuery();
//	if(rs.next()){
//		pb.setMain_value(rs.getString("main_value"));
//		pb.setSub_value(rs.getString("sub_value"));
//	}				
//	System.out.println(pb.getMain_value());
//	System.out.println(pb.getSub_value());
	//--------------------
	public ArrayList<OrderProductBean> getOrderProductCategoryName(ArrayList<OrderProductBean> al){
		
		for (int i = 0; i < al.size(); i++) {
			try {
				ct = DBUtils.getConnection();
				String sql = "select a.Name As main_value,b.Name As sub_value from category a,category b Where a.Id=? And b.Id=?";
				ps = ct.prepareStatement(sql);
				ps.setInt(1, al.get(i).getMain_category());
				ps.setInt(2, al.get(i).getSub_category());
				rs = ps.executeQuery();
				if(rs.next()){
					al.get(i).setMain_value(rs.getString("main_value"));
					al.get(i).setSub_value(rs.getString("sub_value"));
				}		
				
			} catch (Exception e) { 
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(ct, ps, rs);
			}	
			
		}
		
		return al;
	}
	
	
	
	
	
	
	public ArrayList<ProductBean> getCategoryName(ArrayList<ProductBean> al){
		
		for (int i = 0; i < al.size(); i++) {
			try {
				ct = DBUtils.getConnection();
				String sql = "select a.Name As main_value,b.Name As sub_value from category a,category b Where a.Id=? And b.Id=?";
				ps = ct.prepareStatement(sql);
				ps.setInt(1, al.get(i).getMain_category());
				ps.setInt(2, al.get(i).getSub_category());
				rs = ps.executeQuery();
				if(rs.next()){
					al.get(i).setMain_value(rs.getString("main_value"));
					al.get(i).setSub_value(rs.getString("sub_value"));
				}		
				
			} catch (Exception e) { 
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(ct, ps, rs);
			}	
			
		}
		
		return al;
	}
	
	
	/**
	 *
	 * @param pb
	 * @return
	 */
	public ProductBean getCategoryName(ProductBean pb){
		
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select a.Name As main_value,b.Name As sub_value from category a,category b Where a.Id=? And b.Id=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, pb.getMain_category());
			ps.setInt(2, pb.getSub_category());
			rs = ps.executeQuery();
			if(rs.next()){
				pb.setMain_value(rs.getString("main_value"));
				pb.setSub_value(rs.getString("sub_value"));
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
	 * @return
	 */
	public ArrayList<CategoryBean> queryAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category order by id";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setType(rs.getInt("type"));
				cb.setUpper_id(rs.getInt("upper_id"));
				al.add(cb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CategoryBean> queryMainAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where type=0 order by category_id";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("category_id"));
				cb.setName(rs.getString("cname"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("cupper_id"));
				al.add(cb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CategoryBean> querySubAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where type=1 order by category_id";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("category_id"));
				cb.setName(rs.getString("cname"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("cupper_id"));
				al.add(cb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
	
	/**
	 * 
	 * @return
	 */
	public CategoryBean queryByName(String name) {
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where name like ?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, '%'+name+'%');
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("upper_id"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}		
		return cb;
	}
	
	/**
	 * 
	 * @param big 
	 * @return
	 */
	public ArrayList<CategoryBean> queryBigCategory(String big) {
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where name like ? order by id";
			ps = ct.prepareStatement(sql);
			ps.setString(1, '%'+big+'%');
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("upper_id"));
				al.add(cb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}
		
		
		return al;
		
	}
	
	/**
	 * 
	 */
	public ArrayList<CategoryBean> querySmallCategory(int big_id,String small) {
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where cname like '%?%'";
			ps = ct.prepareStatement(sql);
			ps.setString(1, small);
			if(big_id != 0){
				sql += " and cupper_id='"+big_id+"'" ;
			}
			sql += "order by category_id";
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("category_id"));
				cb.setName(rs.getString("cname"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("cupper_id"));
				al.add(cb);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
		
	}
	
	/**
	 * 
	 */
	public ArrayList<CategoryBean> insertBigCategory(String big) {
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		try {
			ct = DBUtils.getConnection();
			String sql_2 = "insert into category values(category_seq.nextval,?,null,1)";
			ps = ct.prepareStatement(sql_2);
			ps.setString(1, big);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
		
	}	
	
	/**
	 *
	 */
	public ArrayList<CategoryBean> insertSmallCategory(int big_id,String small) {
		
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryBean cb = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "insert into category value(category_id.nextval,?,big_id,1)";
			ps = ct.prepareStatement(sql);
			ps.setString(1, small);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
		
	}	
	
	/**
	 *
	 */
	public void updateBig(int id,String name){
		try {
			ct = DBUtils.getConnection();
			String sql = "update category set cname=? where category_id=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}

	}
	/**
	 * 
	 */
	public void updateSmall(int big_id,String name){
		try {
			ct = DBUtils.getConnection();
			String sql = "update category set cname=? where category_id=?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,big_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}

	}
	/**
	 * 
	 */
	public void delete(int id){
		try {
			ct = DBUtils.getConnection();
			String sql = "delete from category where id=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}

	}


	public CategoryBean queryCategory_byId(int id) {
		CategoryBean cb = null;
		
		try {
			ct = DBUtils.getConnection();
			String sql = "select * from category where id=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()){
				cb = new CategoryBean();
				cb.setId(rs.getInt("id"));
				cb.setName(rs.getString("name"));
				cb.setType(rs.getInt("type"));
				cb.setId(rs.getInt("upper_id"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtils.closeDB(ct, ps, rs);
		}		
		return cb;
			
			
	}
}
	

