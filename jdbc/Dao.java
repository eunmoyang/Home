package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Dao {
	// DAO -> db 연결 및 결과값 저장, 기능(조회-전체조회,순번조회,이름조회, 추가,수정,삭제)
	Scanner scan = new Scanner(System.in);
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root";
			String pw = "123456";
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Connected with the database.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find the driver.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("An error occurred ralated to SQL.");
			e.printStackTrace();
		} 
	}
	
	public int printFullMenu() {
		System.out.println("=====================MENU=====================");
		System.out.println("1. View 2. Insert 3. Update 4. Delete 5. Exit");
		System.out.println("==============================================");
		System.out.print("Input number : ");
		int num = Integer.parseInt(scan.next());
		return num;
		
	}
	
	public int printSearchMenu() {
		System.out.println("========================VIEW MENU========================");
		System.out.println("1. View All 2. Search by tno 3. Search by pname 4. Exit");
		System.out.println("=========================================================");
		System.out.print("Input number : ");
		int num = Integer.parseInt(scan.next());
		return num;
		
	}
	
	public void viewAll() {
		String sql = "SELECT * FROM test01";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("tno : " + rs.getInt(1) + ", pname : " + rs.getString(2) + ", age : " + rs.getInt(3) + ", etc : " + rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void SearchBy(int tno) {
		String sql = "SELECT * FROM test01 WHERE tno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("tno : " + rs.getInt(1) + ", pname : " + rs.getString(2) + ", age : " + rs.getInt(3) + ", etc : " + rs.getString(4));
			} else
				System.out.println("No results were found with the number you entered.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	
	public void SearchBy(String pname) {
		String sql = "SELECT * FROM test01 WHERE pname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("tno : " + rs.getInt(1) + ", pname : " + rs.getString(2) + ", age : " + rs.getInt(3) + ", etc : " + rs.getString(4));
			} else
				System.out.println("No results were found with the number you entered.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void Insert() {
		System.out.println("▶ Enter the information below to insert.");
		System.out.print("name : ");
		String pname = scan.next();
		
		System.out.print("age : ");
		int age = Integer.parseInt(scan.next());
		
		System.out.println("remarks : ");
		String etc = scan.next();
		
		try {
			String sql = "SELECT max(tno) FROM test01";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int tno = 0;
			if(rs.next()) {
				tno = (rs.getInt(1)) +1;				
			}
			
			String sql2 = "INSERT INTO test01(pname,age,etc,tno) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setString(3, etc);
			pstmt.setInt(4, tno);
			int result = pstmt.executeUpdate();
			
			if(result==0) {
				System.out.println("Failed to insert");
			} else {
				System.out.println("Succeed to insert");
				SearchBy(tno);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Update() {
		viewAll();
		System.out.println("▶ Enter the information below to update.");
		System.out.print("no : ");
		int tno = Integer.parseInt(scan.next());
		
		System.out.print("name : ");
		String pname = scan.next();
		
		System.out.print("age : ");
		int age = Integer.parseInt(scan.next());
		
		System.out.println("remarks : ");
		String etc = scan.next();
		
		String sql = "UPDATE test01 SET pname=?, age=?, etc=? where tno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			pstmt.setInt(2, age);
			pstmt.setString(3, etc);
			pstmt.setInt(4, tno);
			int result = pstmt.executeUpdate();
			
			if(result==0) {
				System.out.println("Failed to update");
			} else {
				System.out.println("Succeed to update");
				SearchBy(tno);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Delete() {
		viewAll();
		System.out.println("▶ Enter the information below to update.");
		System.out.print("no : ");
		int tno = Integer.parseInt(scan.next());
		
		String sql = "DELETE FROM test01 where tno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			int result = pstmt.executeUpdate();
			
			if(result==0) {
				System.out.println("Failed to delete");
			} else {
				System.out.println("Succeed to delete");
				viewAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Close() {
		try {
			if(conn != null && !conn.isClosed()) 
				conn.close();
			if(pstmt != null && !pstmt.isClosed())
				pstmt.close();
			System.out.println("Disconnected with the database.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
