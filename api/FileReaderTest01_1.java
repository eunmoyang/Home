package kr.co.job.api;

import java.util.*;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest01_1 {

	public static void main(String[] args) {
		String Number = "^[0-9]*$"; // 패턴 선언
		String Korean = "^[가-힣]*$";
		String English = "^[a-zA-Z]*$";
		
		String fwname = "output.txt"; // 쓰기 파일명
		
		// 문자 스트림
		FileReader reader = null; // 파일 읽는 클래스 선언 (코드 작성 중 파일이 필요할 때 new로 열어서 씀)
		FileWriter writer = null; // 파일 쓰는 클래스 선언
		
		try {
			reader = new FileReader("test.txt"); // 객체 생성 (파일 열기)
			writer = new FileWriter(fwname); // 객체 생성 (파일 쓰기)

			while (true) {
				try {
					int data = reader.read(); // 파일 읽기 (파일이 아스키코드(숫자)로 작성되어있기 때문에 파일 내용을 담을 변수 타입은 int)

					if (data == -1) { // 내용이 없으면
						break; // break : while문을 벗어남
					}

//					if(contents>=65 && contents<122) { // 영어(소문자 or 대문자)가 있으면 무시
//						continue; // continue : 뒤쪽 실행문 실행하지 않고 while문 처음으로 돌아감
//			        }
					
					char ch = (char) data; // int 타입으로 읽어온 내용을 문자로 변환
					String str = Character.toString(ch); // match 메소드는 문자열 타입만 사용 가능하므로 문자(숫자가 변환된)를 문자열로 변환
					boolean regex = Pattern.matches(English, str); // str의 패턴이 영어라면 regex가 true, 패턴이 같지 않으면 false
//		            System.out.println(regex);
					if (regex) { // regex가 true라면 무시(뒤쪽 실행문 실행하지 않고 while문 처음으로 돌아감) = 내용 중 영어를 제외하고 읽어옴
						continue;
					}
					System.out.print(str); // 영어가 제외된 내용을 출력
					
					writer.write(ch); // 파일 쓰기
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("read - 파일을 읽어오는 중 오류 발생(파일 손상)");
				}
			}
		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			System.out.println("new FileReader(파일명) - 파일을 찾을 수 없습니다.");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("new FileReader(파일명) - 파일이 손상되었습니다.");
			ioe.printStackTrace();
		} catch (Exception e) {
			System.out.println("new FileReader(파일명) - filenotfoundexception 및 ioexception이 아닌 기타 예외 발생");
			e.printStackTrace();
		}
		try {
			reader.close(); // 닫기
			writer.close(); // 닫기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 닫습니다.");
			e.printStackTrace();
		}

	}

}
