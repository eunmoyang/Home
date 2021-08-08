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

public class DbConnection {

	Connection conn;
	
	DbConnection() {
		conn= null;
		
		try {			
			// 오라클일때
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName("com.mysql.jdbc.Driver");   7.0이하
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pass = "123456";
			
			conn = DriverManager.getConnection(url, id, pass);
			
			System.out.println("연결성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();  // 연결드라이브가 없습니다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}