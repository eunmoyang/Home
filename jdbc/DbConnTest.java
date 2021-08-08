/* 데이터베이스 연결테스트 : mySql8.0
 * jar파일 : mysql-connector-java-버전.jar
 * 
 * DriverManager클래스
 * Connection 클래스 이용해서 연결함
 * url, port, id,pass
 * 
 */
package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			try {
				conn = DriverManager.getConnection(url, id, pw);
				
				System.out.println("연결 성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		

	}

}