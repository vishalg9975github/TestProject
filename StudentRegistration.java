package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistration {

	public void getStudentData(String FName, String LName, String Uname, String Pwd, String city, int Mobileno)
			throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");
			preparedStatement = connection.prepareStatement(
					"insert into Registration(FirstName, LastName, Username, Password,City,MobileNumber)values(?,?,?,?,?,?)");
			preparedStatement.setString(1, FName);
			preparedStatement.setString(2, LName);
			preparedStatement.setString(3, Uname);
			preparedStatement.setString(4, Pwd);
			preparedStatement.setString(5, city);
			preparedStatement.setInt(6, Mobileno);

			int record = preparedStatement.executeUpdate();
			System.out.println("Record Inserted>>" + record);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

	public void getStudentDetails() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Students register for Quiz>>");
		// int num = scanner.nextInt();
		{
			System.out.println("Enter the first name>>");
			String FirstName = scanner.next();
			System.out.println("Enter the last name>>");
			String LastName = scanner.next();
			System.out.println("Enter the username>>");
			String Username = scanner.next();
			System.out.println("Enter the password>>");
			String Password = scanner.next();
			System.out.println("Enter the city");
			String City = scanner.next();
			System.out.println("Enter the mail id>>");
			String Mailid = scanner.next();
			System.out.println("Enter the mobile number>>");
			int Mobno = scanner.nextInt();
			StudentRegistration studentRegistration = new StudentRegistration();
			studentRegistration.getStudentData(FirstName, LastName, Username, Password, City, Mobno);
		}
	}
}
