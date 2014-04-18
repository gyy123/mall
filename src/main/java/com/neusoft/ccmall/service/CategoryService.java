/**
 * @author u_n
 * @since 2011-10-31
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.CategoryBean;
import com.neusoft.ccmall.bean.OrderProductBean;
import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.dao.CategoryDao;

public class CategoryService {
	
	
	
	public ArrayList<OrderProductBean> getOrderProductCategoryName(ArrayList<OrderProductBean> al){
		
		CategoryDao cd=new CategoryDao();
		al=cd.getOrderProductCategoryName(al);
		return al;
	}

	/**
	 * @return
	 */
	public ArrayList<ProductBean> getCategoryName(ArrayList<ProductBean> al){
		
		CategoryDao cd=new CategoryDao();
		al=cd.getCategoryName(al);
		return al;
	}
	
	public ProductBean getCategoryName(ProductBean pb){
		
		CategoryDao cd=new CategoryDao();
		return pb=cd.getCategoryName(pb);
		
	}
	
	
	/**
	 */
	public CategoryBean queryCategory_byId(int id) {
		CategoryBean cb = new CategoryBean();
		CategoryDao cd = new CategoryDao();
		cb = cd.queryCategory_byId(id);
		return cb;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CategoryBean> queryAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryDao cd = new CategoryDao();
		al = cd.queryAll();
		return al;
	}
	
	/**
	 */
	public ArrayList<CategoryBean> queryMainAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryDao cd = new CategoryDao();
		al = cd.queryAll();
		return al;
	}
	
	/**
	 */
	public ArrayList<CategoryBean> querySubAll() {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryDao cd = new CategoryDao();
		al = cd.queryAll();
		return al;
	}
	
	/**
	 */
	public ArrayList<CategoryBean> queryMainCategory(String s) {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryDao cd = new CategoryDao();
		al = cd.queryBigCategory(s);
		return al;
	}
	
	
	/**
	 */
	public ArrayList<CategoryBean> querySubCategory(int big_id, String s) {
		ArrayList<CategoryBean> al = new ArrayList<CategoryBean>();
		CategoryDao cd = new CategoryDao();
		al = cd.querySmallCategory(big_id, s);
		return al;
	}
	
	
	/**
	 */
	public boolean addMainCategory(String name) {
		boolean flag = false;
		CategoryDao cd = new CategoryDao();
		CategoryBean cbe = cd.queryByName(name);
		if(cbe == null){
			cd.insertBigCategory(name);
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 */
	public boolean addSubCategory(int big_id, String name) {
		boolean flag = false;
		CategoryDao cd = new CategoryDao();
		CategoryBean cbe = cd.queryByName(name);
		if(cbe == null){
			cd.insertSmallCategory(big_id, name);
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 */
	public boolean updateMainCategory(int id,String name) {
		boolean flag = false;
		CategoryDao cd = new CategoryDao();
		CategoryBean cbe = cd.queryByName(name);
		if(cbe == null){
			cd.updateBig(id, name);
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 */
	public boolean updateSubCategory(int id,String name) {
		boolean flag = false;
		CategoryDao cd = new CategoryDao();
		CategoryBean cbe = cd.queryByName(name);
		if(cbe == null){
			cd.updateBig(id, name);
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 */
	public void deleteCategory(int id) {
		CategoryDao cd = new CategoryDao();
		cd.delete(id);

	}

	/**
	 */
	public void updateCategory(String name,int id) {
		
		CategoryDao cd = new CategoryDao();
		cd.updateCategory(name,id);
		
	}
	

}
