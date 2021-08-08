package kr.co.job.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {

	public static void main(String[] args) {
//		FileReader reader = new FileReader("poem.txt");
		FileReader reader = null; // 선언
		try {
			reader = new FileReader("poem.txt"); // 파일 열기
			while (true) {
				int data = 0;
				try {
					data = reader.read(); // 파일 읽기
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("파일 내에 손상된 내용이 있습니다.");
					e.printStackTrace();
				}
				if (data == 1) {
					break;
				}
				char ch = (char) data;
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("파일이 손상되었습니다.");
			e1.printStackTrace();
		} catch (Exception e2) {
			System.out.println("기타 예외");
			e2.printStackTrace();
		}
		try {
			reader.close(); // 파일 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}