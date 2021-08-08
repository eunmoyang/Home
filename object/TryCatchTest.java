/*
 * 
 */
package kr.co.job.object;

import java.util.Scanner;

public class TryCatchTest {

	// throws 흘러가게 하자
	// open/close 개념이 있는 경우에는 try/catch를 쓰는게 좋고, 나머지 경우는 throws declaration 달아주기
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// 선언부
		int n1 = 5, n2 = 0;
		Cal c = new Cal();
		
		// 두 수를 더하시오
		System.out.println("두 수의 합 : " + c.sum(n1, n2));
		
		// 두 수를 나누시오
//		System.out.println("두 수를 나누기 : " + c.div(n1, n2));
		try {
			System.out.println("두 수를 나누기 : " + c.div(n1, n2));
		} catch(Exception e) {
			System.out.println("산술 오류");
			e.printStackTrace();
		} finally {
			System.out.println("5");
		}
		c.div(n1, n2);
		System.out.println("End");

	}

}
