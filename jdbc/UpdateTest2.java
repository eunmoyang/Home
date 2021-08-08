package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest2 {

	public static void main(String[] args) {
		// 업데이트 시 수정할 번호 -> 기본키
		// 작성 절차 : 수정 데이터 입력 받기 -> 디비 연결 -> 질의문 작성 -> 실행 -> 성공/실패
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String pname = scan.next();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(scan.next());
		
		System.out.print("비고 : ");
		String etc = scan.next();
		
		System.out.print("순번 : ");
		int tno = Integer.parseInt(scan.next());
		
		// 데이터베이스 연동 드라이브 => 연결
//		Connection conn = null;
		DbConnection dbConn = new DbConnection();
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			dbConn.conn = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 성공");
			
			// update 질의문 작성
			String sql = "UPDATE test01 SET pname=?, age=?, etc=? where tno=?";
			
			pstmt = dbConn.conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setString(3, etc);
			pstmt.setInt(4, tno);
			
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
				if(dbConn.conn != null && !dbConn.conn.isClosed())
					dbConn.conn.close();
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
