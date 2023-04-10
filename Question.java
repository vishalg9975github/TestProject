package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question {
	
	public void setQuestioPaper() throws SQLException
	{
		
		User_Ans user_Ans = new User_Ans();
		Scanner scanner = new Scanner(System.in);
		StudentLogin studentLogin = new StudentLogin();
		
		Connection connection1 = null;
		PreparedStatement preparedStatement = null;

		try {
			
			
			JDBC_Connection result_JDBC = new JDBC_Connection();

			connection1 = result_JDBC.setJDBCConnection();

			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/velocity_java", "root", "Revati@18");


			preparedStatement = connection1.prepareStatement("select *  from questiontable ");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			int Stud_Id = studentLogin.getStudentlogin();
			while (resultSet.next()) {
				
				int Q_id = resultSet.getInt(1);
				
				System.out.println("Question  : " + resultSet.getString(2));
				System.out.println("Option 1 : " + resultSet.getString(3) );
				System.out.println("Option 2 : " + resultSet.getString(4) );
				System.out.println("Option 3 : " + resultSet.getString(5) );
				System.out.println("Option 4 : " + resultSet.getString(6) );
				int C_ans = resultSet.getInt(7);
												
				System.out.println("Enter your answer : ");
				int a = scanner.nextInt();

				user_Ans.setoreResult(Stud_Id,a, Q_id, C_ans);	

			}

		
	}catch (Exception e) {
		e.getStackTrace();
	}

	finally {
		connection1.close();
		preparedStatement.close();

	}

	}	

}
