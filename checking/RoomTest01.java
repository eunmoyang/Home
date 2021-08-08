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

public class RoomTest01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] room = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] status = new int[12];
		boolean booking = true;
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		
		while(booking) {
			System.out.println("==========MENU==========");
			System.out.println("1. 방 예약\n2. 예약 취소\n3. 호실 확인\n99. 종료");
			System.out.println("========================");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("예약할 객실 번호를 입력하세요. (ex. 1) : ");
				num1 = scan.nextInt();
				if(num1>=1 && num1<=12) {
					if(status[num1-1]==0) {
						System.out.println(room[num1-1] + "호를 예약하셨습니다.");
						status[num1-1] = 1;
					} else {
						System.out.println(room[num1-1] + "호는 예약 마감되었습니다. 메뉴 3번을 선택하여 예약 현황을 확인하세요.");
					}
				} else {
					System.out.println("다시 입력하세요.");
				}
				break;
			case 2:
				System.out.println("예약하신 객실 번호를 입력하세요. : ");
				num2 = scan.nextInt();
				if(num2>=1 && num2<=12) {
					if(status[num2-1]==1) {
						System.out.println(room[num2-1] + "호 예약이 취소되었습니다.");
						status[num2-1] = 0;
					} else {
						System.out.println(room[num2-1] + "호는 예약되어 있지 않습니다.");
					}
				} else {
					System.out.println("다시 입력하세요.");
				}
				break;
			case 3:
				System.out.println("==========예약 현황==========");
				for(int i=0; i<room.length; i++) {
					System.out.println(room[i] + "호 : " + (status[i]==0 ? "예약 가능" : "예약 불가"));
				}
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

}
