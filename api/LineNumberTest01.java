package kr.co.job.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberTest01 {

	public static void main(String[] args) {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader("test.txt"));
			
			try {
				// getLineNumber : 행번호를 가져옴
				while(true) {
					String str = reader.readLine();
					if(str==null) { 
						break;
					}
					int lineNumber = reader.getLineNumber();
					System.out.println(lineNumber + " : " + str);
					
				}
				// 오류 코드
//				int i =1;
//				String str = "";
//				while(str != null) {
//					System.out.println("i:"+i);
//					i++;
//					str = reader.readLine();
//					int lineNumber = reader.getLineNumber();
//					System.out.println(lineNumber + " : " + str);
//				}
					
				// 좀더 간단히 출력
//				String str = null;
//				while((str = reader.readLine()) != null) {
//					System.out.println(str);
//				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
