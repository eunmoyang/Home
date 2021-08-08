/* 방 예약 : 12개 방
 * =====[메뉴]=====
 * 1. 방 예약 2. 예약 취소 3. 호실 확인 99. 종료
 * 
 * int[] room = {0,};
 * room[3]   => 0 // 예약 가능
 * room[3]   => 1 // 예약 불가
 */
package kr.co.job.checking;

import java.util.Scanner;

public class RoomTest2 {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String[] room = {"101호", "102호", "103호", "104호", "105호", "106호", "107호", "108호", "109호", "110호", "111호", "112호"};
		int[] status = new int[12];
		boolean booking = true;
		int num = 0;
		
		while(booking) {
			printMenu();
			num = scan.nextInt();
			
			switch(num) {
			case 1:
				runMenu1(room, status);
				break;
			case 2:
				runMenu2(room, status);
				break;
			case 3:
				runMenu3(room, status);
				break;
			case 99:
				System.out.println("예약 프로그램을 종료합니다.");
				booking = false;
				break;
			default:
				System.out.println("다시 입력하세요.");
			} // switch
		} // while
	} // main

	private static void runMenu3(String[] room, int[] status) {
		System.out.println("==========예약 현황==========");
		for(int i=0; i<room.length; i++) {
			System.out.println(room[i] + " : " + (status[i]==0 ? "예약 가능" : "예약 불가"));
		}
	}

	private static void runMenu2(String[] room, int[] status) {
		System.out.println("예약하신 객실 번호를 입력하세요. : ");
		int num2 = scan.nextInt();
		if(num2>=1 && num2<=12) {
			if(status[num2-1]==1) {
				System.out.println(room[num2-1] + " 예약이 취소되었습니다.");
				status[num2-1] = 0;
			} else {
				System.out.println(room[num2-1] + "는 예약되어 있지 않습니다.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
	}

	private static void runMenu1(String[] room, int[] status) {
		System.out.print("예약할 객실 번호를 입력하세요. (ex. 1) : ");
		int num1 = scan.nextInt();
		if(num1>=1 && num1<=12) {
			if(status[num1-1]==0) {
				System.out.println(room[num1-1] + "를 예약하셨습니다.");
				status[num1-1] = 1;
			} else {
				System.out.println(room[num1-1] + "는 예약 마감되었습니다. 메뉴 3번을 선택하여 예약 현황을 확인하세요.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
	}

	private static void printMenu() {
		System.out.println("==========MENU==========");
		System.out.println("1. 방 예약\n2. 예약 취소\n3. 호실 확인\n99. 종료");
		System.out.println("========================");
		System.out.print("번호 입력 : ");	
	}

}
