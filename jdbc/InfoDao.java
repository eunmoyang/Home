package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoDao {
	// DAO -> db 연결 및 결과값 저장?
	Scanner scan = new Scanner(System.in);
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<InfoDto> list;
	InfoDto dto;
	
	public InfoDao() {
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
	
	public int printMenu() {
		System.out.println("==========================MENU==========================");
		System.out.println("1. View All 2. Search by tno 3. Search by pname 4. Exit");
		System.out.println("========================================================");
		System.out.print("Input number : ");
		int num = Integer.parseInt(scan.next());
		return num;
		
	}
	
	public void viewAll() {
		String sql = "SELECT * FROM test01";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<InfoDto>();
			
			while(rs.next()) {
				InfoDto info = new InfoDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(info);
			}
			
			for (InfoDto i : list) {
				System.out.println(i);
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

			list = new ArrayList<InfoDto>();

			if (rs.next()) {
				InfoDto info = new InfoDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(info);

				for (InfoDto i : list) {
					System.out.println(i);
				}
			} else
				System.out.println("No results were found with the tno you entered.");
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

			list = new ArrayList<InfoDto>();

			if (rs.next()) {
				InfoDto info = new InfoDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(info);

				for (InfoDto i : list) {
					System.out.println(i);
				}
			} else
				System.out.println("No results were found with the pname you entered.");
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
