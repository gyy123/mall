package com.neusoft.ccmall.bean;

public class PageBean {
	
//"select * from (select t.*,rownum rn from () t where rownum<=pageNow*pageSize) where rn>=(pageNow-1)*pageSize+1" ��ҳ���
//pageCount = (rowCount%page.getPAGESIZE()==0)?(rowCount/page.getPAGESIZE()):(rowCount/page.getPAGESIZE()+1);	
	
	private int pageNow; // ��ǰ�ǵڼ�ҳ��ҳ������
	
	private final int PAGESIZE = 3; // ÿҳ������������¼���Զ������ã�Ĭ��10��
	
	private int rowCount; // �ñ�һ�����ж�������¼��count(*)��
	
	private int pageCount; // һ����������ҳ������ó���
	
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
