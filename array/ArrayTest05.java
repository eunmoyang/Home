package kr.co.job.array;

import java.util.Scanner;

public class ArrayTest05 {

	public static void main(String[] args) {
//		int size = 5; 
//		final int size = 5; // final 고정 : 변경 불가
		final int SIZE = 5; // 고정된 변수는 대문자로 씀
		String[] name = new String[SIZE];
		Scanner scan = new Scanner(System.in);
		
		// 이름 입력 받기
		for(int i=0; i<name.length; i++) {
			System.out.print("Enter name: ");
			name[i] = scan.next();
		}
		// 이름 배열 출력
//		for(int i=0; i<name.length; i++) {
//			System.out.println("name[" + i + "]=" + name[i]);
//		}
		
		// 배열값 하나 출력하기 (랜덤)
		int n = (int)(Math.random()*SIZE)+0;
		System.out.println("one of the names in the [name] array: " + name[n]);
	}

}
