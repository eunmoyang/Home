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

public class RoomTest4 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] room = {"Standard1", "Standard2", "Standard3", "Deluxe1", "Deluxe2", "Deluxe3", "Family1", "Family2", "Family3", "Suite1", "Suite2", "Suite3"};
		int[] status = new int[12];
		String[] name = new String[12];
		int[] max = {2, 2, 2, 4, 4, 4, 6, 6, 6, 4, 4, 4}; //
		int[] party = new int[12];
		String[] phone = new String[12];
		String[] pw = new String[12];

		boolean booking = true;
		int num = 0;
		
		while(booking) {
			num = printMenu();
			
			switch(num) {
			case 1:
				roomStatus(room, max, status);
				break;
			case 2:
				reservation(room, max, status, party, name, phone, pw);
				break;
			case 3:
				cancelation(room, max, status, party, name, phone, pw);
				break;
			case 4:
				confirmation(room, max, status, party, name, phone, pw);
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

	private static void confirmation(String[] room, int[] max, int[] status, int[] party, String[] name, String[] phone, String[] pw) {
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
					for(; i<name.length; i++) {
						if(name4.equals(name[i])) {
							searchName = true;
							break;
						}	
					}
					if(searchName) {
						System.out.print("* 비밀번호 (ex. 0000) : ");
						String pw4 = scan.next();
						boolean searchPw = false;
						int j = 0;
						for(; j<pw.length; j++) {
							if(pw4.equals(pw[j])) {
								searchPw = true;
								break;
							} 
						}
						if(searchPw) {
							System.out.println("=========================");
							System.out.println("예약자명 : " + name[j] + "\n예약인원 : " + party[j] + "\n휴대전화 : " + phone[j] + "\n예약객실(★) : " + room[j]);
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
					for(; i<phone.length; i++) {
						if(phone4.equals(phone[i])) {
							searchPhone = true;
							break;
						}	
					}
					if(searchPhone) {
						System.out.print("* 비밀번호 (ex. 0000) : ");
						String pw4_1 = scan.next();
						boolean searchPw2 = false;
						int j = 0;
						for(; j<pw.length; j++) {
							if(pw4_1.equals(pw[j])) {
								searchPw2 = true;
								break;
							}
						}
						if(searchPw2) {
							System.out.println("=========================");
							System.out.println("예약자명 : " + name[j] + "\n예약인원 : " + party[j] + "\n휴대전화 : " + phone[j] + "\n예약객실(★) : " + room[j]);
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

	private static void cancelation(String[] room, int[] max, int[] status, int[] party, String[] name, String[] phone, String[] pw) {
		roomStatus(room, max, status);
		System.out.println("예약 취소하실 객실 번호를 입력하세요. (이전 단계 : 99) : ");
		int num3 = scan.nextInt();
		if(num3==99) {
			System.out.println("초기 메뉴로 돌아갑니다.");
		}
		else if(num3>=1 && num3<=12) {
				if(status[num3-1]==1) {
				System.out.print("비밀번호 (ex. 0000) : ");
				String pw3 = scan.next();
				if(pw3.equals(pw[num3-1])) {
					status[num3-1] = 0;
					name[num3-1] = "";
					phone[num3-1] = "";
					pw[num3-1] = "";
					System.out.println("========================");
					System.out.println("예약자명 : " + name[num3-1]);
					System.out.println("예약인원 : " + party[num3-1]);
					System.out.println("휴대전화 : " + phone[num3-1]);
					System.out.println("예약취소(☆) : " + room[num3-1]);
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

	private static void reservation(String[] room, int[] max, int[] status, int[] party, String[] name, String[] phone, String[] pw) {
		roomStatus(room, max, status);
		System.out.println("=========================");
		System.out.print("* 예약하실 객실 번호를 입력하세요. (이전 단계 : 99) : ");
		int num2 = 0;
		num2 = scan.nextInt();
		if(num2==99) {
			System.out.println("초기 메뉴로 돌아갑니다.");
		} else if(num2>=1 && num2<=12) {
				if(status[num2-1]==0) {
					System.out.print("* 예약인원 (ex. 2) : ");
					int party2 = scan.nextInt();
					if(party2>max[num2-1]) {
						System.out.println("최대 인원을 초과하였습니다.");
					} else {
						party[num2-1] = party2;
						System.out.print("* 예약자명 (ex. 홍길동) : ");
						name[num2-1] = scan.next();
						System.out.print("* 휴대전화 (ex. 000-0000-0000) : ");
						phone[num2-1] = scan.next();
						System.out.print("* 비밀번호 (ex. 0000) : ");
						pw[num2-1] = scan.next();
						status[num2-1] = 1;
						System.out.println("========================");
						System.out.println("예약자명 : " + name[num2-1]);
						System.out.println("예약인원 : " + party[num2-1]);
						System.out.println("휴대전화 : " + phone[num2-1]);
						System.out.println("예약객실(★) : " + room[num2-1]);
					}
			} else {
				System.out.println(room[num2-1] + "는 예약 마감되었습니다. 예약 현황을 확인하신 후 다시 시도해주세요.");
			}
		} else {
			System.out.println("다시 입력하세요.");
		}
		
	}

	private static void roomStatus(String[] room, int[] max, int[] status) {
		int count = 0;
		int line = 3;
		System.out.println("==========예약 현황==========");
		System.out.println("☆ : 예약 가능\n★ : 예약 불가");
		System.out.println("==========================");
		for(int i=0; i<room.length; i++) {
//			System.out.print(i+1 + ". " + room[i] + "(" + max[i] + "명) : " + ((status[i]==0) ? "☆" : "★"));
			System.out.printf("%2d. %10s (최대%1d명) : %2s ", i+1, room[i], max[i], ((status[i]==0) ? "☆" : "★"));
			count++;
			if(count==line) {
				System.out.println();
				count = 0;
			}
		}
		
	}

	private static int printMenu() {
		System.out.println("==========MENU==========");
		System.out.println("1. *실시간 예약 현황*\n2. 객실 예약\n3. 예약 취소\n4. 예약 확인\n99. 종료");
		System.out.println("========================");
		System.out.print("번호 입력 : ");
		return scan.nextInt();
		
	}

}
