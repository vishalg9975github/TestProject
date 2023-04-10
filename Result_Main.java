package com.student.result;

import java.sql.SQLException;
import java.util.Scanner;

public class Result_Main {

	public static void main(String[] args) throws SQLException {

		

		Result_By_ID result_By_ID = new Result_By_ID();

		Question question = new Question();
		
		
		System.out.println("  Welcome to Quiz based application \n: ");
		System.out.println("\n User Operation :  \n");
		System.out.println(" 	1. Student Registration : ");
		System.out.println(" 	2. Student Login : ");
		System.out.println(" 	3. Display the list of questions : ");
		System.out.println(" 	4. Store Quiz result into database : ");
		System.out.println(" 	5. Display Quiz result : ");
		System.out.println("\n Admin Operation :  \n");
		System.out.println(" 	6. Display all students score as per ascending order : ");
		System.out.println(" 	7. Fetch student score by using id : ");
		System.out.println(" 	8. Add question with 4 options into database : ");
		System.out.println(" \n ");


		System.out.println("\n Enter your choice : ");
		Scanner scanner = new Scanner(System.in);
		int ch = scanner.nextInt();

		switch (ch) {
		case 1:
			System.out.println("Student Registration : \n");
			StudentRegistration studentRegistration = new StudentRegistration();
			studentRegistration.getStudentDetails();
			break;
			
		case 2:
			StudentLogin studentLogin = new StudentLogin();
			System.out.println("Student Login : \n");
			studentLogin.getStudentlogin();
			break;
			
		case 3:
			System.out.println("Display the list of questions");
			ShowQuestions showQuestions = new ShowQuestions();
			showQuestions.showQuestions();
			break;

		case 4:

			System.out.println("Store the Quiz result into database with score");
			question.setQuestioPaper();
			break;

		case 5:
			System.out.println("Display Quiz result   ");
			System.out.println("Student Result is ");
			
			Diplay_Result diplay_Result = new Diplay_Result();
			diplay_Result.getDisplayResult();
			break;
			
		case 6:
			System.out.println("Display all students score as per ascending order  ");
			AscendingScoreImpl ascendingOrder= new AscendingScoreImpl();
			ascendingOrder.getAscendingOrder();
			break;

		case 7:

			System.out.println("Fetch student score by using id : ");
			System.out.println("Enter User id : ");
			String id = scanner.next();
			result_By_ID.getResult_By_ID(id);
			break;

		case 8:
			System.out.println("Add question with 4 options into database");
			Add_Questions add_Questions = new Add_Questions();
			add_Questions.setQuestions();

		}

	}

}
