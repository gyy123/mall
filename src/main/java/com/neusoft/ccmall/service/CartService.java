/**
 * @author
 * @since
 * 这个类的主要功能：
 * 1.向购物车添加商品
 * 2.查看购物车
 * 3.修改购买商品数量（Ajax）
 * 4.从购物车删除商品
 */
package com.neusoft.ccmall.service;

import java.util.ArrayList;
//import java.util.HashMap;

import com.neusoft.ccmall.bean.CartBean;
import com.neusoft.ccmall.dao.CartDao;

public class CartService {
	
	CartDao cd = new CartDao();
	
	
	/**
	 * 查看数据库购物车里所有的商品
	 * @param username 用户名
	 * @return 集合
	 */
//	public HashMap<String, String> getCart(String username) {
//		HashMap<String, String> hm = cd.getCart(username);
//		return hm;
//	}
	public ArrayList<CartBean> getCart(String username) {
		ArrayList<CartBean> al = cd.getCart(username);
		return al;
	}
	
	
	/**
	 * 向数据库的购物车里添加商品
	 * @param cb
	 * @return true添加成功 false添加失败
	 */
	public boolean addCart(CartBean cb) {
		
		boolean flag = cd.addCartToDB(cb);
		
		return flag;
	}
	

		
	/**
	 * 从数据库的购物车里删除所有的商品
	 * @return
	 */
	public boolean deleteAllCart(String username) {
		
		return cd.deleteAllCart(username);
	}

}
