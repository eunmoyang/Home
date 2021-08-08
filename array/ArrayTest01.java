/* 
 * 배열 or 리스트 : 같은 타입의 변수를 하나의 묶음으로 다루는 것
 * [] : 배열, 리스트
 * {} : 영역, 범위
 * 선언 방식 1) int num[];		// 옛날 방식
 * 선언 방식 2) int[] score;		// 선언 : 공간은 만들어지지 않고 선언만 한 상태
 * score = new int[5]; 			// 생성 : 메모리에 공간 만들기
 * int[] score = new int[5]; 	// 선언 + 생성 : 공간 만들면서 선언을 한 상태
 */
package kr.co.job.array;

import java.util.Arrays;

public class ArrayTest01 {

	public static void main(String[] args) {
		// 배열에 랜덤으로 1부터 100까지의 수를 대입하기
		// 선언
		int[] score = new int[5];
		// 초기화 init() - 이렇게 초기화 하진 않음
//		for(int i=0; i<score.length; i++) {
//			score[i] = 0;
//		}
		// 입력		
		for(int i=0; i<score.length; i++) {
			score[i] = (int)(Math.random()*100)+1;
		}
		
		// 출력
		for(int i=0; i<score.length; i++) {
			System.out.println("score[" + i + "] = " + score[i]);
		}
		
		// 단순 배열의 값을 출력
		System.out.println(Arrays.toString(score));

	}

}
