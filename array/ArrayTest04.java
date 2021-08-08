/*
 * 10개 배열을 생성하여 배열의 값을 0~9까지 순차적으로 초기화하고 해당 배열값을 섞어보기
 * 1) 임의의 인덱스값 추출 (n)
 * 2) 0번째 인덱스 배열을 tmp에 옮기고
 *    0번째 인덱스 배열에 추출된 n배열값을 대입
 *    n배열값에 tmp 대입
 * 3) 1)2)를 100번 정도 반복함
 */
package kr.co.job.array;

import java.util.Arrays;

public class ArrayTest04 {

	public static void main(String[] args) {
//		int n = 0;
//		int tmp = 0;
//		int[] numArr = new int[10];
//		
//		for(int i=0; i<numArr.length; i++) {
//			numArr[i] = i;
//			System.out.print(numArr[i]);
//		}
//		System.out.println();
//		for(int i=0; i<100; i++) {
//			n = (int)(Math.random()*10)+0;
//			tmp = numArr[0];
//			numArr[0] = numArr[n];
//			numArr[n] = tmp;
//		}
//		System.out.println(Arrays.toString(numArr));
//		=============================================================
		int n = 0;
		int tmp = 0;
		int[] numArr = new int[100];
		
		// 한줄당 10개씩 출력
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]+",");
			if(i%10==9) {
				System.out.println();
			}
		}
//		=============================================
		// 한줄당 10개씩 출력
		System.out.println();
		int cnt = 0;
		int line = 10;
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]+",");
			cnt++;
			if(cnt == line) {
				System.out.println();
				cnt=0;
			}
		}
//		=============================================
		System.out.println();
		for(int i=1; i<1000; i++) {
			n = (int)(Math.random()*100)+0;
			tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		// 한줄당 10개씩 출력
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i]+",");
			if(i%10==9) {
				System.out.println();
			}
		}
//		=============================================
		// 한줄당 10개씩 출력
		int cnt2 = 0;
		int line2 = 10;
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i]+",");
			cnt2++;
			if(cnt2 == line2) {
				System.out.println();
				cnt2=0;
			}
		}
		
		
	}

}
