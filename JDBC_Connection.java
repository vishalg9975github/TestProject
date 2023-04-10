package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Connection {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	public Connection setJDBCConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/velocity_java", "root", "Revati@18");

		} catch (Exception e) {
			e.getStackTrace();
		}
		return connection;

	}

}
