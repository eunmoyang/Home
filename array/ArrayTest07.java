/*
		i : 행(줄) => 학생, j : 열(칸) => 국어,영어,수학
		for(int i=0; i<score.length; i++) { // score.length => 5 (행의 길이)
			System.out.println(i + "행 ==========");
			korSum += score[i][0];
			engSum += score[i][1];
			matSum += score[i][2];
			for(int j=0; j<score[i].length; j++) {
				System.out.print("  score[" + i + "][" + j + "] = " + score[i][j]);
			}
			System.out.println();
		}
 */
package kr.co.job.array;

public class ArrayTest07 {

	public static void main(String[] args) {
		// p.218 2차원 배열을 통해 학생 5명의 국어, 영어, 수학 점수 표 만들기
		int[][] score = {
//			 (열) 국어, 영어, 수학	(행)
				{100, 100, 100},// 학생 1 (0,0) (0,1) (0,2)
				{20, 20, 20},	// 학생 2 (1,0) (1,1) (1,2)
				{30, 30, 30},	// 학생 3 (2,0) (2,1) (2,2)
				{40, 40, 40},	// 학생 4 (3,0) (3,1) (3,2)
				{50, 50, 50},	// 학생 5 (4,0) (4,1) (4,2)
		};
		
		int korSum = 0;
		int engSum = 0;
		int matSum = 0;
		
		System.out.println("번호   국어  영어  수학   총점   평균");
		System.out.println("=============================");
				
		for(int i=0; i<score.length; i++) {
			korSum += score[i][0];
			engSum += score[i][1];
			matSum += score[i][2];
			System.out.printf("%3d", i+1);
			
			int sum = 0;
			float avg = 0.0f;
			
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			avg = sum/(float)score[i].length;
			System.out.printf("%5d %5.1f%n", sum, avg);
		}
		System.out.println("=============================");
		System.out.printf("총점  %3d  %3d  %3d", korSum, engSum, matSum);
		
	} // main

}
