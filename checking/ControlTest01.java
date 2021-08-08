/*
 * 프로그램의 기본 흐름 구조 설계하기
 * ==== 메뉴 ====
 * 1. 두 수의 합 2. 구구단 3. 입력 받은 수까지의 합 99. 종료
 * =============
 * select number :
 * 범위가 아니라 조건을 따질 때는 while이 for보다 훨씬 편함
 * 범위가 있을 때는 if / 정해져 있는 값이 있을 때는 switch
 */
package kr.co.job.checking;

import java.util.Scanner;

public class ControlTest01 {

	public static void main(String[] args) {

		int num = 0;
		Scanner scan = new Scanner(System.in);
		boolean done = true;
		
		while(done) {
			System.out.println("===== [Menu] =====");
			System.out.println("1. 2. 3. 99. 종료");
			System.out.println("==================");
			System.out.print("메뉴 선택 : ");
			num = scan.nextInt();
			
			switch(num) {
			case 1:
				System.out.println("===== [두 수의 합] =====");
				
				System.out.print("첫 번째 숫자 : ");
				int num1 = Integer.parseInt(scan.next());
				System.out.print("두 번째 숫자 : ");
				int num2 = Integer.parseInt(scan.next());
				
				int sum = num1 + num2;
				System.out.println("두 수의 합은 " + sum + "입니다.\n");				
				break;
				
			case 2:
				System.out.println("===== [구구단] =====");
				
				System.out.print("몇 단?");
				int dan = Integer.parseInt(scan.next());
				
				for(int i=1; i<=9; i++) {
					int result = dan * i;
					System.out.println(dan + "*" + i + "=" + result);
				}
				System.out.println();
				break;
				
			case 3:
				System.out.println("===== [입력 받은 수까지의 합] =====");
				
				System.out.print("1 이상의 숫자를 입력하세요 : ");
				int num3 = Integer.parseInt(scan.next());
				
				int sum2 = 0;
				for(int i=1; i<=num3; i++) {
					sum2 = sum2 + i;
				}
				System.out.println("1부터 " + num3 + "까지의 합은 " + sum2 + "입니다.\n");
				break;
				
			case 99:
				System.out.println("===== [종료] =====");
				done = false;
				break;
				
			default:
				System.out.println("다시 입력해주세요!\n");	
			}
		}

	}

}
