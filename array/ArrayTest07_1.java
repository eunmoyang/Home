package kr.co.job.array;

import java.util.Arrays;

public class ArrayTest07_1 {

	public static void main(String[] args) {
		int[][] score = new int[5][3];
		
//		for(int i=0; i<score.length; i++) {
//			for(int j=0; j<score[i].length; j++) {
//				score[0][j] = 100;
//				score[1][j] = 100;
//				score[2][j] = 100;
//				score[3][j] = 100;
//				score[4][j] = 100;
//			}
//		}
		
		for(int i=0; i<score[1].length; i++) {
			score[0][i] = 100;
			score[1][i] = 100;
			score[2][i] = 100;
			score[3][i] = 100;
			score[4][i] = 100;
		}
		
		System.out.println(Arrays.deepToString(score));

	}

}
