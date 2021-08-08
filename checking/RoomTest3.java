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

public class RoomTest3 {
	static Scanner scan = new Scanner(System.in);
	static String[] room = {"standard1", "standard2", "standard3", "deluxe1", "deluxe2", "deluxe3", "family1", "family2", "family3", "suite1", "suite2", "suite3"};
	static int[] status = new int[12];
	static String[] name = new String[12];
	static String[] phone = new String[12];
	static String[] pw = new String[12];
	
	public static void main(String[] args) {
		boolean booking = true;
		int num = 0;
		
		while(booking) {
			num = printMenu();
			
			switch(num) {
			case 1:
				roomStatus();
				break;
			case 2:
				reservation();
				break;
			case 3:
				cancelation();
				break;
			case 4:
				confirmation();
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

	private static void confirmation() {
		boolean check = true;
		while(check) {
			System.out.println("==========예약 확인==========");
			System.out.println("1. 이름으로 찾기\n2. 핸드폰 번호로 찾기\n3. 취소");
			System.out.println("==========================");
			int num4 = scan.nextInt();
			
			if(num4==3) {
				System.out.println("취소하셨습니다.");
				check = false;
			} else if(num4==1) {
				System.out.println("이름 입력 (ex. 홍길동, 이전 메뉴 : 취소) : ");
				String name4 = scan.next();
				if(name4.equals("취소")) {
					System.out.println("취소하셨습니다.");
				} else {
					boolean search = false;
					int i=0;
					for(; i<name.length; i++) {
						if(name4.equals(name[i])) {
							search =true;
							break;
						}	
					}
					if(search) {
						System.out.println(name4 + "님, " + room[i] + " 예약되어 있습니다.");
					} else {
						System.out.println("입력하신 이름으로 예약된 객실이 없습니다.");
					}
				}
			} else if(num4==2) {
				System.out.println("핸드폰 번호 입력 (ex. 010-6342-2680, 이전 메뉴 : 취소) : ");
				String phone4 = scan.next();
				if(phone4.equals("취소")) {
					System.out.println("취소하셨습니다.");
				} else {
					boolean search = false;
					int i=0;
					for(; i<phone.length; i++) {
						if(phone4.equals(phone[i])) {
							search =true;
							break;
						}	
					}
					if(search) {
						System.out.println(phone4 + "번으로 " + room[i] + " 예약되어 있습니다.");
					}
					else {
						System.out.println("입력하신 번호로 예약된 객실이 없습니다.");
					}
				}
			}
		}
		
		
	}

	private static void cancelation() {
		System.out.println("예약 취소할 객실 번호 입력 (ex. 101호 : 1, 102호 : 2, 취소 : 99) : ");
		int num3 = scan.nextInt();
		if(num3==99) {
			System.out.println("취소하셨습니다.");
		}
		else if(num3>=1 && num3<=12) {
				if(status[num3-1]==1) {
				System.out.print("비밀번호 입력 : ");
				String pw3 = scan.next();
				if(pw3.equals(pw[num3-1])) {
					System.out.println(name[num3-1] + "님, " + room[num3-1] + " 예약이 취소되었습니다.");
					status[num3-1] = 0;
					name[num3-1] = "";
					phone[num3-1] = "";
					pw[num3-1] = "";
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			} else {
				System.out.println(room[num3-1] + "는 예약되어 있지 않습니다.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
		
	}

	private static void reservation() {
		System.out.print("예약할 객실 번호 (ex. 101호 : 1, 102호 : 2, 취소 : 99) : ");
		int num2 = 0;
		num2 = scan.nextInt();
		if(num2==99) {
			System.out.println("취소하셨습니다.");
		} else if(num2>=1 && num2<=12) {
				if(status[num2-1]==0) {
				System.out.print("이름 입력 (ex. 홍길동) : ");
				name[num2-1] = scan.next();
				System.out.print("핸드폰 번호 입력 (ex. 000-0000-0000) : ");
				phone[num2-1] = scan.next();
				System.out.print("비밀번호 입력 (ex. 0000) : ");
				pw[num2-1] = scan.next();
				System.out.println("========================");
				System.out.println("이름 : " + name[num2-1]);
				System.out.println("핸드폰 번호 : " + phone[num2-1]);
				System.out.println("비밀번호 : " + pw[num2-1]);
				System.out.println(name[num2-1] + "님, " + room[num2-1] + " 예약되었습니다.");
				status[num2-1] = 1;
			} else {
				System.out.println(room[num2-1] + "는 예약 마감되었습니다. 메뉴 3번을 선택하여 예약 현황을 확인하세요.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
		
	}

	private static void roomStatus() {
		System.out.println("==========예약 현황==========");
		for(int i=0; i<room.length; i++) {
			System.out.println(room[i] + " : " + (status[i]==0 ? "예약 가능" : "예약 불가"));
		}
		
	}

	private static int printMenu() {
		System.out.println("==========MENU==========");
		System.out.println("1. *실시간 예약 현황*\n2. 객실 예약\n3. 예약 취소\n4. 예약 확인\n99. 종료");
		System.out.println("========================");
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		return num;
		
	}

}
