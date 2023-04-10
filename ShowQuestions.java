package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowQuestions {
	
public void showQuestions() throws SQLException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/velocity_java", "root", "Revati@18");
			
			 preparedStatement=connection.prepareStatement("select * from questiontable ");
			
			 resultSet=preparedStatement.executeQuery();
			 
			
			while(resultSet.next()) {
				
				String qno=resultSet.getString(1);
				System.out.println("--------------");
				System.out.println("Question number is  : "+qno);
				
				
				String question=resultSet.getString(2);
				System.out.println("Question is : "+question);
				
				String option1=resultSet.getString(3);
				System.out.println("The first option is : "+option1);
				
				String option2=resultSet.getString(4);
				System.out.println("The second option is : "+option2);
				
				String option3=resultSet.getString(5);
				System.out.println("The third option is : "+option3);
				
				String option4=resultSet.getString(6);
				System.out.println("The fourth option is : "+option4);
				
				//String correct_option=resultSet.getString(7);
				// System.out.println("The correct option is:"+correct_option);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
		
		
	}
	

}
