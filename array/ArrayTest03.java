
package kr.co.job.array;

import java.util.Arrays;

public class ArrayTest03 {

	public static void main(String[] args) {
		// 
//		int sum = 0;
//		float avg = 0f;
//		
//		int[] score = {100, 88, 100, 100, 90};
//		
//		// 합 구하기
//		for(int i=0; i<score.length; i++) {
//			sum += score[i];
//		}
//		
//		// 평균 구하기
//		avg = (float)sum/score.length;
//		
//		System.out.println("총점 : " + sum);
//		System.out.println("평균 : " + avg);
//		==============================================================
//		int max = 0;
//		int min = 0;
//		
//		int[] score = {55, 88, 96, 100, 90, 85, 75, 11, 5};
//		// 해당 배열에서 최대값과 최소값을 구하세요.
//		
//		for(int i=0; i<score.length; i++) {
//			if(max<score[i]) {
//				max = score[i];
//			}
//		}
//		System.out.println("maximum : " + max);
//		
//		for(int i=0; i<score.length; i++) {
//			min = max;
//			if(min>score[i]) {
//				min = score[i];
//			}
//		}
//		System.out.println("minimum : " + min);
//		==============================================================
		int[] score = {55, 88, 96, 100, 90, 85, 75, 11, 5};
		// 해당 배열에서 최대값과 최소값을 구하세요.
		
		int max = score[0];
		int min = score[0];
		
		for(int i=0; i<score.length; i++) {
			if(max<score[i]) {
				max = score[i];
			}
		}
		System.out.println("maximum : " + max);
		
		for(int i=0; i<score.length; i++) {
			if(min>score[i]) {
				min = score[i];
			}
		}
		System.out.println("minimum : " + min);
//		==============================================================
//		int max2 = 0;
//		Arrays.sort(score);
//		min = score[0];
//		max2 = score[score.length-1];

	}

}
