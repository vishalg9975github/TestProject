package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AscendingScoreImpl implements AscendingScore {

	@Override
	public void getAscendingOrder() throws SQLException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");   //loading driver class
			
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");
			
			preparedStatement=connection.prepareStatement("select * from registration order by Score asc ;");
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				
				System.out.println("The Student name:"+resultSet.getString(2));
				System.out.println("The Student Last Name :"+resultSet.getString(3));
				System.out.println("The marks got:"+resultSet.getInt(8));
//					
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
