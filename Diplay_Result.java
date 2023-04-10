package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Diplay_Result {
	
	static int Stud_Id =0;
	static int score = 0;
	static int ques = 0;

	public void getDisplayResult() throws SQLException {
		Connection connection1 = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2=null;
		Student_Score student_Score = new Student_Score();

		try {
			JDBC_Connection result_JDBC = new JDBC_Connection();

			connection1 = result_JDBC.setJDBCConnection();

			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");

			preparedStatement = connection1.prepareStatement("select * from result ");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				 Stud_Id = resultSet.getInt(1);
				int U_ans = resultSet.getInt(3);
				int C_ans = resultSet.getInt(4);

				if (U_ans == C_ans) {
					score++;

				}

			}
			
			Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/velocity_java", "root", "Revati@18");

			
			 preparedStatement2= connection2.prepareStatement("Select * from questiontable");
			 ResultSet resultSet2= preparedStatement2.executeQuery();
			 
			 while(resultSet2.next())
			 {
				 ques++;
				 resultSet2.getInt(1);
			 }
			 

			System.out.println("No of Questions are : " + ques);
			System.out.println("Wrong answers are : " + (ques - score));
			System.out.println("\nYour score is : " + score);
			
			student_Score.setStudent_Score(Stud_Id, score);

		} catch (Exception e) {
			e.getStackTrace();
		}

		finally {
			connection1.close();
			preparedStatement.close();

		}
	}

}
