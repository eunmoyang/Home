/* 1. 시스템 초기화
 * 2. 메뉴 구성
 * 3. 각 선택 메뉴별 기능
 *    - 회원가입, 회원 수정, 회원 삭제, 회원 조회(전체/개별)
 */
package kr.co.job.api;

import java.util.Scanner;

public class MemberControl {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 선언 
//		Member m1 = new Member(0, null, null, 0); 
		Member m1; // 회원 정보(속성)는 입력을 받아야 하기 때문에 생성하지 않고 우선 선언만 함
		
		// 입력
		System.out.println("회원가입을 시작합니다.");
		System.out.print("번호를 입력하세요 : ");
		int no = Integer.parseInt(scan.next());
		System.out.print("이름을 입력하세요 : ");
		String name = scan.next();
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.next();
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(scan.next());
		
		// m1의 필드값을 입력 받은 데이터로 초기화하여 생성
		m1 = new Member(no, id, name, age); // 위에서 다 입력 받았기 때문에 Member+ctrl+space 하면 매개변수 자동 완성됨
		System.out.println("▼ 회원가입이 완료되었습니다.");
		
		// 회원 정보 조회
		System.out.println(m1); // m1.toString 안해도 되고 그냥 m1만 쳐도 됨
		
		// 회원 정보 수정
		System.out.println("===============회원 정보 수정===============");
		System.out.println("1. 회원번호 2. 이름 3. 아이디 4. 나이 99. 종료");
		System.out.print("select number : ");
		int num = Integer.parseInt(scan.next());
		int no2 = 0;
		String name2 = null;
		String id2 = null;
		int age2 = 0;
		boolean change = true;
		while(change) {
			switch(num) {
			case 1 :
				editMember(no2, m1);
				break;
			case 2 :
				editMember(name2, m1);
				break;
			case 3 :
				editMember(id2, m1);
				break;
			case 4 :
				editMember(age2, m1);
				break;
			case 99 :
				System.out.println("회원 정보 수정을 마칩니다.");
				change = false;
				break;
			default :
				System.out.println("다시 입력하세요.");
			} // switch
		} // while

	}

	private static void editMember(String name2, Member m1) {
		System.out.print("* 수정할 사항을 입력하세요 : ");
		name2 = scan.next();
		m1.setName(name2);
		System.out.println("▼ 변경이 완료되었습니다.\n" + m1);
		
	}

	private static void editMember(int no2, Member m1) {
		System.out.print("* 수정할 사항을 입력하세요 : ");
		no2 = Integer.parseInt(scan.next());
		m1.setNo(no2);
		System.out.println("▼ 변경이 완료되었습니다.\n" + m1);
		
	}

}
