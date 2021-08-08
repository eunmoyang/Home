package kr.co.job.jdbc;

import java.util.Scanner;

public class Control {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Control -> 실제 기능 (전체조회, 검색조회, 이름조회)
		Dao dao = new Dao();
		boolean start = true;
		
		while(start) {
			int num = dao.printFullMenu();
			switch(num) {
			case 1: // 조회
				int num1 = dao.printSearchMenu();
				switch(num1) {
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
					System.out.println("Exit view mode");
					break;
				default:
					System.out.println("Wrong input, please try again");
				}
				break;
			case 2: // 추가
				dao.Insert();
				break;
			case 3: // 수정
				dao.Update();
				break;
			case 4: // 삭제
				dao.Delete();
				break;
			case 5:
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
