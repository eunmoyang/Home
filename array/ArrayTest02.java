package kr.co.job.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest02 {

	public static void main(String[] args) {
		// 문자열 배열 5개를 선언한 후 5명의 이름을 키보드 입력 받으세요.
		Scanner scan = new Scanner(System.in);
		String[] name;
		name = new String[5];
		
		for(int i=0; i<name.length; i++) {
			System.out.println("Enter name : ");
			name[i] = scan.next();
		}

		for(int i=0; i<name.length; i++) {
			System.out.println("name[" + i + "]=" + name[i]);
		}

	}

}
