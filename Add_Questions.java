package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_Questions {

	public void setQuestions() throws SQLException {
		System.out.println("Hi THis Is Yash");
		Add_Questions add_Questions = new Add_Questions();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Number of question to be added:");
		int n = scanner.nextInt();

		if (n <= 10) {
			for (int i = 1; i <= n; i++) {

//			System.out.println("Enter the question no:");
//			Scanner scanner1 = new Scanner(System.in);
//			int Qno = scanner1.nextInt();

				System.out.println("Enter the Question:");
				Scanner scanner2 = new Scanner(System.in);
				String Question = scanner2.nextLine();

				System.out.println("Enter the First Option:");
				Scanner scanner3 = new Scanner(System.in);
				String Option_1 = scanner3.nextLine();

				System.out.println("Enter the Second_Option:");
				Scanner scanner4 = new Scanner(System.in);
				String Option_2 = scanner4.nextLine();

				System.out.println("Enter the Third Option:");
				Scanner scanner5 = new Scanner(System.in);
				String Option_3 = scanner5.nextLine();

				System.out.println("Enter the Fourth Option:");
				Scanner scanner6 = new Scanner(System.in);
				String Option_4 = scanner6.nextLine();

				System.out.println("Enter the Correct Option Number:");
				Scanner scanner7 = new Scanner(System.in);
				String Correct_Option = scanner7.nextLine();

				add_Questions.getQuestions(Question, Option_1, Option_2, Option_3, Option_4, Correct_Option);

			}
		} else {
			System.out.println("Maximum questions allowed are 10 only");
		}

	}

	public void getQuestions(String Question, String Option_1, String Option_2, String Option_3, String Option_4,
			String Correct_Option) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			// Step 1- Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// Step 2- Establishing connection with DB
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/velocity_java", "root", "Revati@18");
			// Step 3- prepared statements
			preparedStatement = connection.prepareStatement(
					"insert into questiontable(Question,Option_1,Option_2,Option_3,Option_4,Correct_Option)values(?,?,?,?,?,?)");
			// Step 4- result set
			// preparedStatement.setInt(1, Qno);
			preparedStatement.setString(1, Question);
			preparedStatement.setString(2, Option_1);
			preparedStatement.setString(3, Option_2);
			preparedStatement.setString(4, Option_3);
			preparedStatement.setString(5, Option_4);
			preparedStatement.setString(6, Correct_Option);

			preparedStatement.executeUpdate();
			System.out.println("File Loaded Succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();

		}

	}

}
