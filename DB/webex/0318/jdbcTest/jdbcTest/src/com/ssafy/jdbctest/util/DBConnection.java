package com.ssafy.jdbctest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3307/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DB_ID = "ssafy";
	private static final String DB_PASS = "369369";
	
	static {
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, DB_ID, DB_PASS);
	}
}
