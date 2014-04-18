package com.neusoft.ccmall.bean;

public class PageBean {
	
//"select * from (select t.*,rownum rn from () t where rownum<=pageNow*pageSize) where rn>=(pageNow-1)*pageSize+1" 分页语句
//pageCount = (rowCount%page.getPAGESIZE()==0)?(rowCount/page.getPAGESIZE()):(rowCount/page.getPAGESIZE()+1);	
	
	private int pageNow; // 当前是第几页（页面请求）
	
	private final int PAGESIZE = 3; // 每页包含多少条记录（自定义设置，默认10）
	
	private int rowCount; // 该表一共含有多少条记录（count(*)）
	
	private int pageCount; // 一共包含多少页（计算得出）
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}	

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPAGESIZE() {
		return PAGESIZE;
	}
	
	
}
