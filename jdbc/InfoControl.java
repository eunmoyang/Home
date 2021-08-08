package kr.co.job.jdbc;

import java.util.Scanner;

public class InfoControl {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Control -> 실제 기능 (전체조회, 검색조회, 이름조회)
		InfoDao dao = new InfoDao();
		boolean start = true;
		
		while(start) {
			int num = dao.printMenu();
			switch(num) {
			case 1:
				dao.viewAll();
				break;
			case 2:
				System.out.print("Enter the tno to search for : ");
				int tno = Integer.parseInt(scan.next());
				dao.SearchBy(tno);
				break;
			case 3:
				System.out.print("Enter the pname to search for : ");
				String pname = scan.next();
				dao.SearchBy(pname);
				break;
			case 4:
				dao.Close();
				System.out.println("Exit the program.");
				start = false;
				break;
			default:
				System.out.println("Wrong input, please try again.");
			}
		}
		

	}

}
