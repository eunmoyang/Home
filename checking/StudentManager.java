/*
 * 동작 구현
 */
package kr.co.job.checking;

public class StudentManager {

	public static void main(String[] args) {
		StudentControl2 stu = new StudentControl2();
		String sel ="";				
		stu.init();   //초기화
		while(!sel.equals("5")) { 		//5누르면 종료
				sel = stu.menuView();				
				stu.studentPlay(sel);
		}		

	}
}
