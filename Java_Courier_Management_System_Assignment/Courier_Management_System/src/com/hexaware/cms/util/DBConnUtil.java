package com.hexaware.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/cms";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection connection = null;
	
	private DBConnUtil() {
		
	}

	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		return connection;
	}
}
