package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student_Score {
	
	public void setStudent_Score( int Stud_Id ,int score )
	{
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");
			//jdbc:mysql://localhost:3306/project", "root", "Revati@18
			  preparedStatement= connection.prepareStatement("update registration set Score =?  where Studentid =? ");
			  preparedStatement.setInt(1, Stud_Id );
			  preparedStatement.setInt(2,score );
			  
			 int a = preparedStatement.executeUpdate();
			 
			 System.out.println(Stud_Id + " : This Student Score is Updated " + a  );
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}

}
