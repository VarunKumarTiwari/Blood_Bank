package com.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/Blood_Bank?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
//	private static final String PASSWORD = "admin";
	private static final String PASSWORD = "root";
	static Connection initiate_db_conn() {
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			
				try {
					if(!conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	
	}
}
