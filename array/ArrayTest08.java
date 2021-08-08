package kr.co.job.array;

import java.util.Scanner;

public class ArrayTest08 {

	public static void main(String[] args) {
		// p.220 좌표에 x표 치기
		final int SIZE = 10; // final 변수 고정, 변경 불가
		int x = 0;
		int y = 0;
		
		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = {
//				 1 2 3 4 5 6 7 8 9
				{0,0,0,0,0,0,1,0,0}, //1
				{1,1,1,1,0,0,1,0,0}, //2
				{0,0,0,0,0,0,1,0,0}, //3
				{1,1,1,1,1,1,1,1,1}, //4
				{0,0,0,0,0,0,0,0,0}, //5
				{0,1,0,1,0,1,0,1,0}, //6
				{1,0,1,0,1,0,1,0,1}, //7
				{1,1,1,1,0,0,0,0,1}, //8
				{0,0,0,1,1,1,0,0,0}, //9
		};
		
		for(int i=1; i<SIZE; i++) {
			board[0][i] = board[i][0] = (char)(i+'0');
		}
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("좌표를 입력하세요. (종료는 00)> ");
			String input = scan.nextLine();
			
			if(input.length()==2) {
				x = input.charAt(0)-'0';
				y = input.charAt(1)-'0';
				
				if(x==0 && y==0) {
					break;
				}
			}
			
			if(input.length()!=2 || x<=0 || x>=SIZE || y<=0 || y>=SIZE) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			board[x][y] = shipBoard[x-1][y-1]==1 ? 'O' : 'X';
			
			for(int i=0; i<SIZE; i++) {
				System.out.println(board[i]);
			}
			System.out.println();
			
		} // while

	} // main

}
