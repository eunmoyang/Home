/* DB 연결 : Connection 클래스, DriverManagement 클래스
 * 질의문 작성(저장->실행) : Statement 클래스
 * 실행 결과 저장 : ResultSet 클래스
 * 
 */
package kr.co.job.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbConnTest2 {

	public static void main(String[] args) {
		Connection conn = null; // 데이터베이스 연결
		Statement stmt = null; // 질의문 작성 -> 실행
		ResultSet rs = null; // 결과값 보관
		ArrayList<Test01> db = new ArrayList<Test01>();
		
		try {
			// JDBC 라이브러리 찾기 mysql 드라이버 찾기(jar 내부에 구동 드라이브.class가 있음!!!)
			// com.mysql.cj.jdbc.Driver 클래스를 찾는 것!
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest?serverTimezone=UTC";
			String id = "root"; // 유저네임
			String pw = "123456";
			
			try {
				conn = DriverManager.getConnection(url, id, pw);
				
				System.out.println("연결 성공");
				
				// 질의문 작성
				String sql = "select tno, pname, age, etc from test01";
				
				// 작성한 질의문을 stmt에 새로 생성한 후 실행
				stmt = conn.createStatement(); // 질의문이 가능한 stmt 생성
				rs = stmt.executeQuery(sql); // 질의문 실행(mysql의 ctrl+enter)한 결과값을 rs에 저장
				// executeQuery는 리턴값으로 실행결과를 가지고, execute는 실행결과가 있는지 true.false만 가짐
				System.out.println("결과값 조회");
				
//				while(rs.next()) {
//					System.out.print("번호 : " + rs.getString(1)); // int지만 string으로도 받아짐
//					// rs.getString("tno");
//					// getString에서 컬럼인덱스로 가져올 수도 있고, 컬럼라벨(필드명)으로 가져올 수도 있음
//					// 컬럼인덱스는 자바랑 다르게 0부터 시작하지 않고 1부터 시작함!!
//					System.out.print("이름 : " + rs.getString(2));
//					System.out.print("나이 : " + rs.getInt(3));
//					System.out.print("비고 : " + rs.getString(4) + "\n");
//				}
				
				// rs를 list에 보관
				Test01 tvo = null;
				
				while(rs.next()) {
//					// 필드명 다 가진 생성자가 없을 때
//					tvo = new Test01();
//					int tno = rs.getInt(1);
//					String pname = rs.getString(2);
//					int age = rs.getInt(3);
//					String etc = rs.getString(4);
//					
//					tvo.setTno(tno);
//					tvo.setPname(pname);
//					tvo.setAge(age);
//					tvo.setEtc(etc);
					
					// 필드값 4개 다 가지는 생성자 있을 때 1
					int tno = rs.getInt(1);
					String pname = rs.getString(2);
					int age = rs.getInt(3);
					String etc = rs.getString(4);
					tvo = new Test01(tno, pname, age, etc);
					
					db.add(tvo); // 어레이리스트에 추가
				}
				
				// 필드값 4개 다 가지는 생성자 있을 때 2
				for(int i=1; rs.next(); i++) {
					db.add(new Test01(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
				}
				
				System.out.println("순번, 이름, 나이, 비고");
				for(Test01 t:db) {
					System.out.print(t.getTno() + ",  ");
					System.out.print(t.getPname() + ", ");
					System.out.print(t.getAge() + ", ");
					System.out.print(t.getEtc() + "\n");
				}
				
//				System.out.println(db.get(0));
//				System.out.println(db.get(1));
//				System.out.println(db.toString());
				
				System.out.println("End!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			conn.close();
		}

	}

}
