package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin_Login {

	public void getAdmin_Login(String Admin_Id , String Admin_Pwd) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");
			System.out.println("***");
			preparedStatement = connection.prepareStatement("select * from admin");

			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) {
				String id = resultSet.getString(4);
				String pwd = resultSet.getString(5);
				
				if((id == Admin_Id) && (pwd == Admin_Pwd))
				{
					System.out.println("Admin login scuccessfully ....");
					
				}
				else
				{
					System.out.println("Invalid Admin ....");
				}

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		finally
		{
			
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Admin_Login admin_Login = new Admin_Login();
		System.out.println("Enter Admin Id : ");
		
		String Admin_Id = scanner.next();

		System.out.println("Enter Admin Password : ");

		String Admin_Pwd = scanner.next();
		admin_Login.getAdmin_Login(Admin_Id , Admin_Pwd);
		
	}
	
}
