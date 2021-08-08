/* 메뉴 (jdbc->select)
 * 1. 전체조회 - Statement or PreparedStatement 
 * 2. 검색조회(순번) - PreparedStatement
 * 3. 이름조회 - PreparedStatement
 * 4. 종료
 */
package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMulti {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("데이터베이스 연결 성공하였습니다.");	
			
			boolean start=true;
			
			while(start) {
				System.out.println("================menu================");
				System.out.println("1.전체조회 2.검색조회(순번) 3.이름조회 4.종료");
				System.out.println("====================================");
				System.out.print("input number : ");
				int num = Integer.parseInt(scan.next());
				
				switch(num) {
				case 1:
					viewAll(conn);
					break;
				case 2:
					searchByTno(conn);
					break;
				case 3:
					viewPname(conn);
					break;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					start = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		

	}

	private static void viewPname(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select pname from test01";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void searchByTno(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.print("조회할 순번 입력 : ");
		int num = Integer.parseInt(scan.next());
		
		String sql2 = "select tno,pname,age,etc from test01 where tno=?";
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(" 순번      이름     나이      비고");
				System.out.println("===============================");
				System.out.printf("%3d %8s %6d %8s%n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			} else {
				System.out.println("입력하신 순번으로 조회되는 결과가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void viewAll(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select tno,pname,age,etc from test01";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println(" 순번      이름     나이      비고");
			System.out.println("===============================");
			while(rs.next()) {
//				System.out.println("순번 : "+rs.getInt(1)+", 이름 : "+rs.getString(2)+", 나이 : "+rs.getInt(3)+", 비고 : "+rs.getString(4));
				System.out.printf("%3d %8s %6d %8s%n", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
