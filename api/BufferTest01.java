/* 문자기반
 * FileReader 클래스, BufferedReader 클래스
 * FileWriter 클래스
 */
package kr.co.job.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferTest01 {

	public static void main(String[] args) {
		FileReader fr = null; // 주 읽기(1)
		BufferedReader br = null; // 보조 읽기(1)
		
		try {
			fr = new FileReader("poem.txt");
			br = new BufferedReader(fr);
//			br = new BufferedReader(new FileReader("poem.txt"));
			
			String str = br.readLine(); // readLine 한줄 읽기 (메소드 반환 타입이 스트링이기 때문에 스트링 타입 변수에 담아줌)
			System.out.println(str);
			
			// 위에서 한줄을 이미 읽었기 때문에 while문에서는 자동으로 2번째 줄부터 읽음
			while(true) {
				int data = br.read(); // 하나의 문자 읽어 들이기
				if(data<0) {
					break;
				}
				System.out.print((char)data);
			}
			
			
			
			
			// 파일 내용을 문자열으로 저장
			String str2 = "";
			while(true) {
				String tmp = br.readLine();
				str2 = str2 + tmp;
				if(tmp==null)
					break;
				System.out.println(str2);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
			ioe.printStackTrace();
		}
		try {
			fr.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
