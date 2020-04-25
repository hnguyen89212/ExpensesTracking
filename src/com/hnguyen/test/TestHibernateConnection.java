package com.hnguyen.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestHibernateConnection {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/ExpensesTrackingSystem?useSSL=false";
		String user = "root";
		String password = "passWORD";
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println("Connection is successful.");
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("Program exits normally...");
		}
	}

}
