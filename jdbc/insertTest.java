package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insertTest {

	public static void main(String[] args) {
		// test01 테이블 값을 추가
		// 콘솔에 입력 받아서 질의문 실행 종료
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String pname = scan.next();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(scan.next());
		
		System.out.print("비고 : ");
		String etc = scan.next();
		
		// DAO 연결, 질의문
		Connection conn = null;
		PreparedStatement pstmt = null; // 질의문 작성 및 실행
		String mySqlDriver = "com.mysql.cj.jdbc.Driver";
//		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(mySqlDriver);
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			conn = DriverManager.getConnection(url, id, pw);
						
			System.out.println("연결 성공");
			
			// insert 질의문 작성
			String sql = "insert into test01(pname,age,etc) values(?,?,?)";
			// pstmt에 생성하면서 질의문 들어감
			pstmt = conn.prepareStatement(sql);
			// ??? 작성
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setString(3, etc);
			
			int result = pstmt.executeUpdate(); // 실행 : executeUpdate 메소드의 리턴타입이 int임 실행하면 1, 안되면 0이하
			
			if(result==0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("1개의 데이터 추가 성공");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
