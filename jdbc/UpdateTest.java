package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		// 업데이트 시 수정할 번호 -> 기본키
		// 나이, 비고 수정
		// 작성 절차 : 수정 데이터 입력 받기 -> 디비 연결 -> 질의문 작성 -> 실행 -> 성공/실패
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(scan.next());
		
		System.out.print("비고 : ");
		String etc = scan.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 성공");
			
			String sql = "UPDATE test01 SET `age`=?, `etc`=? where tno=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, etc);
			pstmt.setInt(3, 9);
			
			int result = pstmt.executeUpdate();
			
			if(result==0) {
				System.out.println("데이터 수정 실패");
			} else {
				System.out.println("데이터 수정 완료");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null && !conn.isClosed())
					conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
