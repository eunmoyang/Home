/* 방 예약 : 12개 방
 * =====[메뉴]=====
 * 1. 방 예약 2. 예약 취소 3. 호실 확인 99. 종료
 * 
 * int[] room = {0,};
 * room[3]   => 0 // 예약 가능
 * room[3]   => 1 // 예약 불가
 */
//		String[] room = {"Standard1", "Standard2", "Standard3", "Deluxe1", "Deluxe2", "Deluxe3", "Family1", "Family2", "Family3", "Suite1", "Suite2", "Suite3"};
//		int[] status = new int[12];
//		String[] name = new String[12];
//		int[] max = {2, 2, 2, 4, 4, 4, 6, 6, 6, 4, 4, 4}; //
//		int[] party = new int[12];
//		String[] phone = new String[12];
//		String[] pw = new String[12];

// int[3][12] : int[0] status, int[1] max, int[2] party
// String[4][12] : String[0] room, String[1] name, String[3] phone, String[4] pw
package kr.co.job.checking;

import java.util.*;

public class RoomTest6 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String[][] info = {
			{"Standard1", "Standard2", "Standard3", "Deluxe1", "Deluxe2", "Deluxe3", "Family1", "Family2", "Family3", "Suite1", "Suite2", "Suite3"}, // 객실 이름
			{"", "", "", "", "", "", "", "", "", "", "", ""}, // 예약자명
			{"", "", "", "", "", "", "", "", "", "", "", ""}, // 예약자 휴대전화 번호
			{"", "", "", "", "", "", "", "", "", "", "", ""}}; // 예약자 비밀번호
		
		int[][] number = {
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 예약 여부
				{2, 2, 2, 4, 4, 4, 6, 6, 6, 4, 4, 4}, // 최대 인원
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} // 예약 인원
		};
		

		boolean booking = true;
		int num = 0;
		
		while(booking) {
			num = printMenu(); // 초기 메뉴 출력
			
			switch(num) {
			case 1:
				roomStatus(info, number); // 실시간 예약 현황
				break;
			case 2:
				reservation(info, number); // 객실 예약
				break;
			case 3:
				cancelation(info, number); // 예약 취소
				break;
			case 4:
				confirmation(info, number); // 예약 확인
				break;
			case 99:
				System.out.println("예약 프로그램을 종료합니다.");
				booking = false;
				break;
			default:
				System.out.println("다시 입력하세요.");
			}
		}
		

	}

	private static int printMenu() { // 초기 메뉴 출력 및 입력 받기
		System.out.println("==========호텔 예약==========");
		System.out.println("1. *실시간 예약 현황*\n2. 객실 예약\n3. 예약 취소\n4. 예약 확인\n99. 종료");
		System.out.println("===========================");
		System.out.print("번호 입력 : ");
		return scan.nextInt();
		
	}

	private static void roomStatus(String[][] info, int[][] number) { // 실시간 예약 현황
			int count = 0;
			int line = 3;
			System.out.println("==========예약 현황==========");
			System.out.println("☆ : 예약 가능\n★ : 예약 불가");
			System.out.println("===========================");
			for(int i=0; i<info[0].length; i++) {
				// 객실 번호. 객실 이름(최대이름) : 예약 가능 여부(☆ or ★) 형태로 출력 
				System.out.printf("%2d. %10s (최대%1d명) : %2s ", i+1, info[0][i], number[1][i], ((number[0][i]==0) ? "☆" : "★"));
				count++;
				if(count==line) { // 예약 현황 출력 시 3개 입력될 때마다 줄바꿈
					System.out.println();
					count = 0;
				}
			}
			
		}

	private static void reservation(String[][] info, int[][] number) { // 객실 예약
		roomStatus(info, number); // 실시간 예약 현황 출력
		System.out.println("=========================");
		System.out.print("* 예약하실 객실 번호를 입력하세요. (이전 단계 : 99) : ");
		int num2 = 0;
		num2 = scan.nextInt();
		if(num2==99) {
			System.out.println("초기 메뉴로 돌아갑니다.");
		} else if(num2>=1 && num2<=12) { // 객실 번호가 1~12 사이이고,
				if(number[0][num2-1]==0) { // 해당 객실이 예약 가능할 경우 예약 인원 입력 받음
					System.out.print("* 예약인원 (ex. 2) : ");
					int party2 = scan.nextInt();
					if(party2>number[1][num2-1]) { // 예약 인원이 해당 객실의 최대 인원보다 클 경우 초기 메뉴로 돌아감
						System.out.println("최대 인원을 초과하였습니다.");
					} else { // 예약 인원이 해당 객실의 최대 인원보다 크지 않을 경우 예약 인원 배열값에 저장한 후 예약자명, 휴대전화, 비밀번호 입력 받아서 배열값에 저장
						number[2][num2-1] = party2;
						System.out.print("* 예약자명 (ex. 홍길동) : ");
						info[1][num2-1] = scan.next();
						System.out.print("* 휴대전화 (ex. 000-0000-0000) : ");
						info[2][num2-1] = scan.next();
						System.out.print("* 비밀번호 (ex. 0000) : ");
						info[3][num2-1] = scan.next();
						number[0][num2-1] = 1; // 예약 불가로 변경
						System.out.println("========================");
						System.out.println("예약자명 : " + info[1][num2-1]);
						System.out.println("예약인원 : " + number[2][num2-1]);
						System.out.println("휴대전화 : " + info[2][num2-1]);
						System.out.println("예약객실(★) : " + info[0][num2-1]);
					}
			} else {
				System.out.println(info[0][num2-1] + "객실은 예약 마감되었습니다. 예약 현황을 확인하신 후 다시 시도해주세요.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
		
	}

	private static void cancelation(String[][] info, int[][] number) {
		roomStatus(info, number);
		System.out.println("예약 취소하실 객실 번호를 입력하세요. (이전 단계 : 99) : ");
		int num3 = scan.nextInt();
		if(num3==99) {
			System.out.println("초기 메뉴로 돌아갑니다.");
		}
		else if(num3>=1 && num3<=12) {
				if(number[0][num3-1]==1) {
				System.out.print("비밀번호 (ex. 0000) : ");
				String pw3 = scan.next();
				if(pw3.equals(info[3][num3-1])) {
					number[0][num3-1] = 0;
					info[1][num3-1] = "";
					info[2][num3-1] = "";
					info[3][num3-1] = "";
					System.out.println("========================");
					System.out.println("예약자명 : " + info[1][num3-1]);
					System.out.println("예약인원 : " + number[2][num3-1]);
					System.out.println("휴대전화 : " + info[2][num3-1]);
					System.out.println("취소객실(☆) : " + info[0][num3-1]);
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			} else {
				System.out.println(info[0][num3-1] + "는 예약되어 있지 않습니다.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
		
	}

	private static void confirmation(String[][] info, int[][] number) {
		boolean check = true;
		while(check) {
			System.out.println("==========예약 확인==========");
			System.out.println("1. 예약자명으로 찾기\n2. 휴대전화 번호로 찾기\n3. 취소");
			System.out.println("==========================");
			System.out.print("* 번호 입력 : ");
			int num4 = scan.nextInt();
			
			if(num4==3) {
				System.out.println("초기 메뉴로 돌아갑니다.");
				check = false;
			} else if(num4==1) {
				System.out.print("* 예약자명 : (ex. 홍길동) (이전 메뉴 : 취소) : ");
				String name4 = scan.next();
				if(name4.equals("취소")) {
					System.out.println("이전 메뉴로 돌아갑니다.");
				} else {
					boolean searchName = false;
					int i=0;
					for(; i<info[0].length; i++) {
						if(name4.equals(info[1][i])) {
							searchName = true;
							break;
						}	
					}
					if(searchName) {
						System.out.print("* 비밀번호 (ex. 0000) : ");
						String pw4 = scan.next();
						boolean searchPw = false;
						int j = 0;
						for(; j<info[3].length; j++) {
							if(pw4.equals(info[3][j])) {
								searchPw = true;
								break;
							} 
						}
						if(searchPw) {
							System.out.println("=========================");
							System.out.println("예약자명 : " + info[1][j] + "\n예약인원 : " + number[2][j] + "\n휴대전화 : " + info[2][j] + "\n예약객실(★) : " + info[0][j]);
							break;
						} else {
							System.out.println("비밀번호가 틀렸습니다.");
							break;
						}
						
					} else {
						System.out.println("입력하신 예약자명으로 예약된 객실이 없습니다.");
					}
				}
			} else if(num4==2) {
				System.out.println("* 휴대전화 (ex. 010-0000-0000) (이전 메뉴 : 취소) : ");
				String phone4 = scan.next();
				if(phone4.equals("취소")) {
					System.out.println("이전 메뉴로 돌아갑니다.");
				} else {
					boolean searchPhone = false;
					int i=0;
					for(; i<info[2].length; i++) {
						if(phone4.equals(info[2][i])) {
							searchPhone = true;
							break;
						}	
					}
					if(searchPhone) {
						System.out.print("* 비밀번호 (ex. 0000) : ");
						String pw4_1 = scan.next();
						boolean searchPw2 = false;
						int j = 0;
						for(; j<info[3].length; j++) {
							if(pw4_1.equals(info[3][j])) {
								searchPw2 = true;
								break;
							}
						}
						if(searchPw2) {
							System.out.println("=========================");
							System.out.println("예약자명 : " + info[1][j] + "\n예약인원 : " + number[2][j] + "\n휴대전화 : " + info[2][j] + "\n예약객실(★) : " + info[0][j]);
							break;
						} else {
							System.out.println("비밀번호가 틀렸습니다.");
							break;
						}
					}
					else {
						System.out.println("입력하신 휴대전화 번호로 예약된 객실이 없습니다.");
					}
				}
			}
		}
		
		
	}

}
