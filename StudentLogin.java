package com.student.result;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.jdbc.JdbcConnection;
//import com.mysql.cj.jdbc.JdbcPreparedStatement;

public class StudentLogin {

	static int Stud_Id = 0;
	static String uid= null;
	static String pwd=null;

	public int getStudentlogin() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");
			System.out.println("***");
			preparedStatement=connection.prepareStatement("Select Username,Password from registration ");
		
			resultSet=preparedStatement.executeQuery();
			
		
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter the Username>>");
			String uid =scanner.next();
			System.out.println("Enter the Password>>");
		    String pwd=scanner.next();
		    
		    while(resultSet.next())	{
		    String Userid =resultSet.getString(1);
		   	String Pass	=resultSet.getString(2);
		   	
		   	if((uid.equals(Userid)) && (pwd.equals(Pass))){
		   		
		   		System.out.println("Start Quiz");
		   	}
		   	/*else
		   	{
		   		System.out.println("Invalid");
		   	}	*/
		   	
   }	   
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
		return Stud_Id;
		
	}	

}
