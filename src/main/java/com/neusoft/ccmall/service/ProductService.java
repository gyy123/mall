/**
 * @author u_n
 * @since 2011-10-30
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;

import com.neusoft.ccmall.bean.ProductBean;
import com.neusoft.ccmall.dao.ProductDao;

public class ProductService {
	
	
	
	/**
	 * 
	 * @param product_SEQ
	 * @return
	 */
	public ProductBean getProduct(int product_SEQ) {
		ProductDao pd = new ProductDao();
		ProductBean pb = pd.getProduct(product_SEQ);		
		return pb;
	}
	
	
	
	/**
	 * 
	 * @param pb
	 * @return true
	 */
	public boolean addProduct(ProductBean pb) {
		boolean flag = false;
		ProductDao pd = new ProductDao();
		ProductBean pbe =pd.getProductByName(pb.getName());
		
		System.out.println(pb.getName());
		
		if(pbe == null){
			pd.addProduct(pb);
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	/**
	 *
	 */
	public ArrayList<ProductBean> queryAllProducts() {
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductDao pd = new ProductDao();
		al = pd.getAllProduct();
		return al;
	}
	
	/**
	 * 
	 */
	public ArrayList<ProductBean> queryAllProductsByType(String main_type,String sub_type) {
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductDao pd = new ProductDao();
		al = pd.getProductByType(main_type,sub_type);
		return al;
	}
	
	
	/**
	 * 
	 */
	public ProductBean queryProductById(int id) {
		ProductBean pb = new ProductBean();
		ProductDao pd = new ProductDao();
		pb = pd.getProduct(id);
		return pb;
	}
	
	/**
	 * 
	 */
	public void updateProduct(ProductBean pb) {

		ProductDao pd = new ProductDao();
		
//		System.out.println(pb.getNum()+"ser");
		
		pd.updateProduct(pb);
		}
	
	
	/**
	 * 
	 */
	public void deleteProduct(int id) {
		ProductDao pd = new ProductDao();
		pd.deleteProduct(id);
	}
		
	
	/**
	 * 
	 */
	public ArrayList<ProductBean> querySoldOutProduct() {
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductDao pd = new ProductDao();
		al = pd.querySellout();
		return al;
	}
	
	/**
	 * 
	 */
	public ArrayList<ProductBean> queryProductsByTypeName(String name,String main_value,String sub_value) {
		ArrayList<ProductBean> al = new ArrayList<ProductBean>();
		ProductDao pd = new ProductDao();
		al = pd.getProductByNameType(name, main_value, sub_value);
		return al;
	}

}
