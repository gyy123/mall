package com.neusoft.ccmall.service;

import java.util.ArrayList;


import com.neusoft.ccmall.bean.SalesStaticsBean;

import com.neusoft.ccmall.dao.SalesStaticsDao;

public class SalesStaticsService {
	public ArrayList<SalesStaticsBean> querySales(String main_type,String name,String issue_date_begin ,String issue_date_end) {
		ArrayList<SalesStaticsBean> al = new ArrayList<SalesStaticsBean>();
		SalesStaticsDao sd = new SalesStaticsDao();
	    al = sd.querySales(main_type, name, issue_date_begin, issue_date_end);
		return al;
	}

}
