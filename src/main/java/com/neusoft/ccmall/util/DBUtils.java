package com.neusoft.ccmall.util;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtils {
	
	/**
	 * �������ӳ��������ݿ⣬
	 * �õ����ݿ�����
	 * @return ���ݿ�����connection
	 */	
	public static Connection getConnection() {
		Connection ct = null; 
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");*/
			// �������ݿ����ӳ�����oracle���ݿ�			
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/ccmall");
			ct = ds.getConnection();
			// ������ӣ��������ӳ��Ƿ����ӳɹ�
			// System.out.println(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	
	
	/**
	 * �ر����ݿ���Դ
	 * @param ct
	 * @param ps
	 * @param rs
	 */
	public static void closeDB(Connection ct, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (ct != null) {
				ct.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
