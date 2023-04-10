package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Result_By_ID {

	public void getResult_By_ID(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			JDBC_Connection result_JDBC = new JDBC_Connection();

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");

			preparedStatement = connection.prepareStatement("select * from registration where Username =? ");
			preparedStatement.setString(1, id);
			//preparedStatement.setString(2, x);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int a= resultSet.getInt(8);
				System.out.println(id+" >> This Student score is :  " + a);
			}

			
		} catch (Exception e) {
			e.getStackTrace();
		}

		finally {
			connection.close();
			preparedStatement.close();

		}
	}

}
