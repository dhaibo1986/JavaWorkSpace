package com.dyf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private DBConn() {
	}
	
	private static Connection conn = null;
	
	public  static Connection getConnection() throws Exception {
		if (conn == null || conn.isClosed()) {
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String dbURL = "jdbc:sqlserver://127.0.0.1:1433;instance=MSSQLSERVER;DatabaseName=test;integratedSecurity=true";
			String userName = "sa";  
			String userPwd = "12345678"; 
			Connection dbConn; 
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userName, userPwd); 
		}
		return conn;
	}
	
	public static void closeConnection() throws Exception {
		if (conn != null && !conn.isClosed())
			conn.close();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		conn=getConnection();
		System.out.println(conn);
		
	}

}
