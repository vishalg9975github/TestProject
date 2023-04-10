package com.student.result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_Ans {

	public void setoreResult(int Stud_Id,int ans ,int q_id, int c_ans) throws SQLException {

		Connection connection1 = null;
		PreparedStatement preparedStatement = null;

		try {

			JDBC_Connection result_JDBC = new JDBC_Connection();

			connection1 = result_JDBC.setJDBCConnection();

			Class.forName("com.mysql.jdbc.Driver");

			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Revati@18");

			// update result set user_answer=? where Qno=?
			
			preparedStatement = connection1.prepareStatement(" insert into result (Studentid, User_Ans ,Qno ,Correct_Ans ) values (? , ?, ? , ?)  ");

			preparedStatement.setInt(1, Stud_Id);
			preparedStatement.setInt(2,ans );
			preparedStatement.setInt(3,q_id );
			preparedStatement.setInt(4, c_ans);

			int a = preparedStatement.executeUpdate();

			System.out.println("Record Inserted Successfully : " + a);

		} catch (Exception e) {
			e.getStackTrace();
		}

		finally {
			connection1.close();
			preparedStatement.close();

		}

	}

}
