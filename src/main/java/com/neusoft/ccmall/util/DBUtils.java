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
	 * 采用连接池连接数据库，
	 * 得到数据库连接
	 * @return 数据库连接connection
	 */	
	public static Connection getConnection() {
		Connection ct = null; 
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");*/
			// 采用数据库连接池连接oracle数据库			
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/ccmall");
			ct = ds.getConnection();
			// 输出连接，测试连接池是否连接成功
			// System.out.println(ct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	
	
	/**
	 * 关闭数据库资源
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
