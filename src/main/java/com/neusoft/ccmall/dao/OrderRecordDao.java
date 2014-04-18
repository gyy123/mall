package com.neusoft.ccmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.ccmall.util.DBUtils;

public class OrderRecordDao {
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/**
	 * 管理员在修改订单状态时，需要做个记录（哪个管理员在什么时间因为什么修改了哪个订单）
	 * @param product_seq
	 * @param mangername
	 * @param issue_cause
	 * @return
	 */
	public boolean addOrderRecord(int order_seq, String managername, String issue_cause) {
		boolean b = false;
		try {
			ct = DBUtils.getConnection();
			ct.setAutoCommit(false);
			String sql = "insert into order_record values(order_record_seq.nextval,?,?,sysdate,?)";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, order_seq);
			ps.setString(2, managername);
			ps.setString(3, issue_cause);
			int i = ps.executeUpdate();
			if (1 == i) {
				b = true;
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
		return b;
	}

}
