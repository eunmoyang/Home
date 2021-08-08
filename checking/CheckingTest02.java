/*
 * 두 수를 키보드로 입력 받아서
 * 두 수의 값을 서로 교환(swap)하자.
 * 
 */
package kr.co.job.checking;

import java.util.Scanner;

public class CheckingTest02 {

	public static void main(String[] args) {
		// 선언
		Scanner scan = new Scanner(System.in);
		int n1 = 0;
		int n2 = 0;
		int tmp = 0;
		
		// 입력
		System.out.print("첫 번째 숫자 : ");
		n1 = scan.nextInt();
		System.out.print("두 번째 숫자 : ");		
		n2 = scan.nextInt();
		
		// 처리
		tmp = n1;
		n1 = n2;
		n2 = tmp;
		
		// 출력
		System.out.println("============교환 결과============");
		System.out.println("첫 번째 숫자 : " + n1 + ", 두 번째 숫자 : " + n2);
	}

}
