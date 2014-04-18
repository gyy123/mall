package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neusoft.ccmall.bean.OrderBean;
import com.neusoft.ccmall.bean.PageBean;
import com.neusoft.ccmall.util.DBUtils;
public class OrderDao {
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	/**
	 * 管理员删除订单
	 * @param order_SEQ
	 * @return
	 */
	public boolean deleteOrder(int order_SEQ) {
		boolean isSuccess = false;
		
		try {			
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "delete from orders where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			int i2 = ps.executeUpdate();
			// 如果orders表中的数据删除成功
			if (1 == i2) {
				isSuccess = true;
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
				
		// 4.如果isSuccess==true，说明1 2 3执行成功，再向order_record表中插入记录
		/*if (isSuccess) {
			try {
				ct = DBUtils.getConnection();
				ct.setAutoCommit(false);
				String sql = "insert into order_record values(order_record_SEQ.nextval,?,?,sysdate,?)";
				ps = ct.prepareStatement(sql);
				ps.setInt(1, order_SEQ); // 订单号 
				ps.setInt(2, manager_id); // 管理员账号
				ps.setString(3, issue_cause); // 原因
				int i3 = ps.executeUpdate();
				ct.commit();
			} catch (Exception e) {
				ct.rollback();
				e.printStackTrace();
			} finally {
				DBUtils.closeDB(ct, ps, null);
			}			
		}*/
		
//		System.out.println(isSuccess); // 测试
		return isSuccess;
	}
	
	
	
	/**
	 * 管理员更新订单状态
	 * @param order_SEQ
	 * @param status
	 * @return
	 */
	public boolean updateOrderStatus(int order_SEQ, int status) {
		boolean isSuccess = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "update orders set status=? where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, order_SEQ);
			int i = ps.executeUpdate();
			ct.commit();
			if (1 == i) {
				isSuccess = true;
			}
		} catch (Exception e) {
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}		
		return isSuccess;
	}
	
	
	/**
	 * 这个pagebean对应初始化页面查询
	 * @param status
	 * @param pageNow
	 * @return
	 */
	public PageBean getPageInfo(int status, int pageNow) {
		PageBean page = new PageBean();
		int rowCount = 0;
		
		StringBuffer sql = new StringBuffer("select count(*) from orders");
		if (status == 0) {
			// 所有订单
			sql.append("");
		}
		if (status == 1) {
			// 新订单和已支付订单查询
			sql.append(" where status=1 or status=2 ");
		}
		if (status == 4) {
			// 已作废订单查询
			sql.append(" where status=4 ");
		}
		
		try {
			ct = DBUtils.getConnection();
			ps = ct.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
			int pageCount = (rowCount%page.getPAGESIZE()==0)?(rowCount/page.getPAGESIZE()):(rowCount/page.getPAGESIZE()+1);
			
			page.setRowCount(rowCount);
			page.setPageNow(pageNow);
			page.setPageCount(pageCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		
		return page;
	}
	
	
	
	/**
	 * 初始化页面查询
	 * @param status
	 * @return
	 */
	public ArrayList<OrderBean> queryOrders(int status, int pageNow, int pageSize) {
		ArrayList<OrderBean> al = new ArrayList<OrderBean>();
		OrderBean ob = null;
		try {
			ct = DBUtils.getConnection();
			StringBuffer sql = new StringBuffer("select * from (select t.*,rownum rn from(" +
					"select order_SEQ,username,total,status,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders ");						
			if (status == 0) {
				// 所有订单
				sql.append("");
			}
			if (status == 1) {
				// 新订单和已支付订单查询
				sql.append("where status=1 or status=2 ");
			}
			if (status == 4) {
				// 已作废订单查询
				sql.append("where status=4 ");
			}
			sql.append("order by order_SEQ)t where rownum<=?) where rn>=?");				
			ps = ct.prepareStatement(sql.toString());
			ps.setInt(1, pageNow*pageSize);
			ps.setInt(2, (pageNow-1)*pageSize+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob = new OrderBean();
				ob.setOrder_SEQ(rs.getInt("order_SEQ"));
				ob.setUsername(rs.getString("username"));
				ob.setTotal(rs.getDouble("total"));
				ob.setStatus(rs.getInt("status"));
				ob.setIssue_date(rs.getString("issue_date"));
				//System.out.println(ob.getIssue_date()); // 测试sql:date--->java:String to_char函数调用前：2011-10-31 21:56:29.0调用后：2011-10-31 21:56:29
				al.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}
	
	
	
	/**
	 * 这个pagebean对应查询所有订单
	 * @param order_SEQ
	 * @param status
	 * @param pageNow
	 * @return
	 */
	public PageBean getPageInfo(int order_SEQ, int status, int pageNow) {
		PageBean page = new PageBean();
		int rowCount = 0;
		StringBuffer sql = new StringBuffer("select count(*) from orders");
		// 如果订单号不为空，而订单状态为空
		if (order_SEQ != 0 && status == 0) {
			sql.append(" where order_SEQ="+order_SEQ);
		}
		// 如果订单号为空，而订单状态不为空
		if (order_SEQ == 0 && status != 0) {
			sql.append(" where status="+status);
		}
		// 如果订单号和订单状态都不为空
		if (order_SEQ != 0 && status != 0) {
			sql.append(" where order_SEQ="+order_SEQ+" and status="+status);
		}
		try {
			ct = DBUtils.getConnection();
			ps = ct.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
			int pageCount = (rowCount%page.getPAGESIZE()==0)?(rowCount/page.getPAGESIZE()):(rowCount/page.getPAGESIZE()+1);
			
			page.setRowCount(rowCount);
			page.setPageNow(pageNow);
			page.setPageCount(pageCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		
		return page;
	}
	
	
	
	/**
	 * 查询所有订单
	 * @param order_SEQ
	 * @param status
	 * @return
	 */
	public ArrayList<OrderBean> queryAllOrders(int order_SEQ, int status ,PageBean page) {
		ArrayList<OrderBean> al = new ArrayList<OrderBean>();
		OrderBean ob = null;
		try {
			ct = DBUtils.getConnection();
			//"select * from (select t.*,rownum rn from () t where rownum<=pageNow*pageSize) where rn>=(pageNow-1)*pageSize+1" 分页语句
			StringBuffer sql = new StringBuffer("select * from (select t.*,rownum rn from (select order_SEQ,username,total,status,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders ");
			// 如果订单号不为空，而订单状态为空
			if (order_SEQ != 0 && status == 0) {
				sql.append("where order_SEQ="+order_SEQ);
			}
			// 如果订单号为空，而订单状态不为空
			if (order_SEQ == 0 && status != 0) {
				sql.append("where status="+status);
			}
			// 如果订单号和订单状态都不为空
			if (order_SEQ != 0 && status != 0) {
				sql.append("where order_SEQ="+order_SEQ+" and status="+status);
			}
			sql.append(") t where rownum<=?) where rn>=?");
			ps = ct.prepareStatement(sql.toString());
			ps.setInt(1, page.getPageNow()*page.getPAGESIZE());
			ps.setInt(2, (page.getPageNow()-1)*page.getPAGESIZE()+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob = new OrderBean();
				ob.setOrder_SEQ(rs.getInt("order_SEQ"));
				ob.setUsername(rs.getString("username"));
				ob.setTotal(rs.getDouble("total"));
				ob.setStatus(rs.getInt("status"));
				ob.setIssue_date(rs.getString("issue_date"));
				//System.out.println(ob.getIssue_date()); // 测试sql:date--->java:String to_char函数调用前：2011-10-31 21:56:29.0调用后：2011-10-31 21:56:29
				al.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return al;
	}	
	
	
	/**
	 * 网上银行转账，修改订单状态为“已支付”
	 * @param order_SEQ
	 * @return
	 */
	public boolean updateOrder(int order_SEQ) {
		boolean isSuccess = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "update orders set status=2 where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			int i = ps.executeUpdate();
			System.out.println("1==="+isSuccess);
			if (1 == i) {
				isSuccess = true;
			}
			System.out.println("2==="+isSuccess);
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
		return isSuccess;
	}
	
	
	
	/**
	 * 添加个人新订单
	 * @param ob
	 * @return
	 */
	public int addOrder(OrderBean ob) {
		int order_SEQ = 0;
		try {
			ct = DBUtils.getConnection();
			// 设置数据库不允许自动提交
			ct.setAutoCommit(false);
			String sql = "insert into orders values(ORDERS_SEQ.nextval,ORDER_SEQ.nextval,?,?,?,?,?,default,?,?,SYSDATE)";
			ps = ct.prepareStatement(sql);
			ps.setString(1, ob.getUsername());
			ps.setString(2, ob.getPostcode());
			ps.setString(3, ob.getAddress());
			ps.setString(4, ob.getPhone());
			ps.setDouble(5, ob.getTotal());
			ps.setInt(6, ob.getPost_type());
			ps.setInt(7, ob.getPay_type());
			// 如果添加成功，返回一个int值1
			int i = ps.executeUpdate();
			ct.commit();
			if (1 == i) {
				// 得到刚插入的订单序列号并返回
				String s_sql = "select ORDER_SEQ.currval from orders";
				ps = ct.prepareStatement(s_sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					order_SEQ = rs.getInt("currval");
				} 
			}
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
		return order_SEQ;
	}
		
	
	/**
	 * 查询个人订单详情
	 * @param order_SEQ 订单号
	 * @return
	 */
	public OrderBean queryPersonalOrderInfo(int order_SEQ) {
		OrderBean ob = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "select order_SEQ,username,postcode,address,phone,total,status,post_type,pay_type,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders where order_SEQ=?";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			rs = ps.executeQuery();
			if (rs.next()) {
				ob = new OrderBean();
				ob.setOrder_SEQ(rs.getInt("order_SEQ"));
				ob.setUsername(rs.getString("username"));
				ob.setPostcode(rs.getString("postcode"));
				ob.setAddress(rs.getString("address"));
				ob.setPhone(rs.getString("phone"));
				ob.setTotal(rs.getDouble("total"));
				ob.setStatus(rs.getInt("status"));
				ob.setPost_type(rs.getInt("post_type"));
				ob.setPay_type(rs.getInt("pay_type"));
				ob.setIssue_date(rs.getString("issue_date")); // -->to_char(不需要)
				//System.out.println(ob.getIssue_date()); // 2011-10-31 21:56:29.0
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return ob;		
	}	
	
	
	
	/**
	 * 查询订单信息（对于游客订单号不可以为空===所以，可以唯一确定游客的订单）
	 * @param order_SEQ 订单号
	 * @param fromDate 
	 * @param toDate
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(int order_SEQ, String fromDate, String toDate) {
		ArrayList<OrderBean> al = new ArrayList<OrderBean>();
		OrderBean ob = null;
		try {
			ct = DBUtils.getConnection();
			String sql = "select order_SEQ,username,postcode,address,phone,total,status,post_type,pay_type,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders where order_SEQ=? and issue_date between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_SEQ);
			ps.setString(2, fromDate);
			ps.setString(3, toDate);			
			rs = ps.executeQuery();
			while (rs.next()) {
				ob = new OrderBean();
				ob.setOrder_SEQ(rs.getInt("order_SEQ"));
				ob.setUsername(rs.getString("username"));
				ob.setPostcode(rs.getString("postcode"));
				ob.setAddress(rs.getString("address"));
				ob.setPhone(rs.getString("phone"));
				ob.setTotal(rs.getDouble("total"));
				ob.setStatus(rs.getInt("status"));
				ob.setPost_type(rs.getInt("post_type"));
				ob.setPay_type(rs.getInt("pay_type"));
				ob.setIssue_date(rs.getString("issue_date"));//-->to_char
				al.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
	
	/**
	 * 查询订单信息（对于注册用户订单号可以为空）
	 * @param order_SEQ 订单号
	 * @param fromDate 
	 * @param toDate
	 * @return
	 */
	public ArrayList<OrderBean> queryPersonalOrder(String username, int order_SEQ, String fromDate, String toDate, PageBean page) {
		ArrayList<OrderBean> al = new ArrayList<OrderBean>();
		OrderBean ob = null;
		try {
			ct = DBUtils.getConnection();
			// 判读订单号是否为空，如果订单号不为空
			if (0 != order_SEQ) {
				String sql = "select * from (select t.*,rownum rn from (" +
						"select order_SEQ,username,postcode,address,phone,total,status,post_type,pay_type,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders where username=? and order_SEQ=? and issue_date between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')" +
						") t where rownum<=?) where rn>=?";
				ps = ct.prepareStatement(sql);
				ps.setString(1, username);
				ps.setInt(2, order_SEQ);
				ps.setString(3, fromDate);
				ps.setString(4, toDate);
				ps.setInt(5, page.getPageNow()*page.getPAGESIZE());
				ps.setInt(6, (page.getPageNow()-1)*page.getPAGESIZE()+1);
			} else {// 订单号为空
				String sql = "select * from (select t.*,rownum rn from (" +
						"select order_SEQ,username,postcode,address,phone,total,status,post_type,pay_type,to_char(issue_date,'yyyy-mm-dd hh24:mi:ss') issue_date from orders where username=? and issue_date>=to_date(?,'yyyy-mm-dd') and issue_date<=to_date(?,'yyyy-mm-dd')" +
						") t where rownum<=?) where rn>=?"; // 经常报出“格式字符串不匹配”的错误
				ps = ct.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, fromDate);
				ps.setString(3, toDate);
				ps.setInt(4, page.getPageNow()*page.getPAGESIZE());
				ps.setInt(5, (page.getPageNow()-1)*page.getPAGESIZE()+1);
			}			
			rs = ps.executeQuery();
			while (rs.next()) {
				ob = new OrderBean();
				ob.setOrder_SEQ(rs.getInt("order_SEQ"));
				ob.setUsername(rs.getString("username"));
				ob.setPostcode(rs.getString("postcode"));
				ob.setAddress(rs.getString("address"));
				ob.setPhone(rs.getString("phone"));
				ob.setTotal(rs.getDouble("total"));
				ob.setStatus(rs.getInt("status"));
				ob.setPost_type(rs.getInt("post_type"));
				ob.setPay_type(rs.getInt("pay_type"));
				ob.setIssue_date(rs.getString("issue_date"));//-->to_char
				al.add(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}		
		return al;
	}
	
	
	/**
	 * 对于注册用户，订单信息可能过多，需要分页显示
	 * @return
	 */
	public PageBean getPageInfo(String username, int orderseq, String fromdate, String todate, int pageNow) {
		PageBean page = new PageBean();
		int rowCount = 0;
		try {
			ct = DBUtils.getConnection();
			if (0 != orderseq) {// 订单号惟一确定了查询结果只有一条记录或者没有记录
				String sql = "select count(*) from orders where username=? and order_SEQ=?";
				ps = ct.prepareStatement(sql);
				ps.setString(1, username);
				ps.setInt(2, orderseq);				
			} else {// 订单号为空
				String sql = "select count(*) from orders where username=? and issue_date between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
				ps = ct.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, fromdate);
				ps.setString(3, todate);					
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt("count(*)");
			}
			int pageCount = (rowCount%page.getPAGESIZE()==0)?(rowCount/page.getPAGESIZE()):(rowCount/page.getPAGESIZE()+1);			
			page.setRowCount(rowCount);
			page.setPageNow(pageNow);
			page.setPageCount(pageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeDB(ct, ps, rs);
		}
		return page;		
	}

}
