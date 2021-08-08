/* 학생관리를 제어하는 클래스
 * 1. 초기값  : init()
 * 2. 화면메뉴 : menuView()
 *     // 1.추가 2. 수정 3. 삭제 4. 보기, 99종료
 *      
 * 3. 학생추가 : void addStudent()
 * 4. 학생수정 : updateStudent()
 *    - 1. 이름 2. 나이 3. 학번 4.전공
 * 5. 학번검색 : int searchStudent(학번)
 *             찾으면 index, 못찾으면 index=-1 return
 *   
 * 6. 학생삭제 :  deleteStudent()
 *    => 삭제된 학생을 StudentExpel클래스에서 저장
 *     
 * 7. 학생조회(출력) : studentView()
 *        1. 전체보기 2. 학번검색 3. 삭제정보    
 */
package kr.co.job.checking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentControl2 {
	Scanner scan = new Scanner(System.in);
	
	// 학생 정보를 담고 있는 리스트
	List<Student> students = new ArrayList<Student>();
	// 삭제된 학생 정보를 담고 있는 클래스의 객체 생성
	StudentExpel exp = new StudentExpel();
	
	// 초기값
	void init() {
		// Student s = new Student("홍길동","22","1","영어");
		students.add(new Student("은모","31","1","관광경영"));
		students.add(new Student("선경","24","2","관광경영"));
		students.add(new Student("지윤","25","3","비서"));
		students.add(new Student("채연","26","4","컴퓨터공학"));
		students.add(new Student("지수","30","5","시각디자인"));
	}
	
	// 기본 메뉴 출력 : 1.추가 2. 수정 3. 삭제 4. 보기, 99종료
	String menuView() {
		System.out.println("=================[학생관리]=================");
		System.out.println("1. 추가 2. 수정 3. 삭제 4. 조회 5. 종료");
		System.out.println("==========================================");
		System.out.print("select number : ");
		return scan.next();  // 입력된 데이터를 리턴, 공백까지만 입력받음
	}	
	
	// 전체 기능 구현 메소드 (StudentManager에 while문이 있기 때문에 switch부터 시작)
	void studentPlay(String sel) {
		switch(sel) {
		case "1" :
			addStudent();
			break;
		case "2" :
			updateView();
			break;
		case "3" :
			deleteStudent();
			break;
		case "4" :
			studentView();
			break;
		case "5" : 
			System.out.println("학생 관리 프로그램을 종료합니다.");
			break;
		default :
			System.out.println("다시 입력하세요.");
		} // switch
	} // end of void studentPlay(String sel)

	void addStudent() {
		System.out.println("추가할 학생 정보를 입력하세요.");
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("나이 : ");
		String age = scan.next();
		System.out.print("학번 : ");
		String no = scan.next();
		System.out.print("전공 : ");
		String major = scan.next();
		students.add(new Student(name, age, no, major));
		System.out.println("학생이 추가되었습니다.");
	}
	
	// 수정 메소드(1) : 검색 메소드와 updateStudent() 메소드 이용
	void updateView() {
		boolean find = false;
		System.out.println("수정할 학생의 학번을 입력하세요.");
		String search = scan.next();
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getsNum().equals(search)){
				updateStudent(i);
				find = true;
				break;
			}
		}
		if(!find) {
			System.out.println("입력하신 정보의 학생을 찾을 수 없습니다.");
		}
	}
	
	// 수정 메소드(2) : 1.이름수정 2. 나이수정 3. 학번수정 4. 전공수정
	boolean updateStudent(int index) {
		System.out.println("===============[정보수정]===============");
		System.out.println("1. 이름 2. 나이 3. 학번 4. 전공 5. 종료");
		System.out.println("======================================");
		System.out.println("select number : ");
		int num2 = Integer.parseInt(scan.next());
		
		switch(num2) {
		case 1:
			System.out.println("수정할 이름을 입력하세요 : ");
			String name = scan.next();
			students.get(index).setName(name);
			System.out.println("이름이 변경되었습니다.");
			break;
		case 2:
			System.out.println("수정할 나이를 입력하세요 : ");
			String age = scan.next();
			students.get(index).setAge(age);;
			System.out.println("나이가 변경되었습니다.");
			break;
		case 3:
			System.out.println("수정할 학번을 입력하세요 : ");
			String no = scan.next();
			students.get(index).setsNum(no);;
			System.out.println("학번이 변경되었습니다.");
			break;
		case 4:
			System.out.println("수정할 전공을 입력하세요 : ");
			String major = scan.next();
			students.get(index).setMajor(major);;
			System.out.println("전공이 변경되었습니다.");
			break;
		case 5:
			System.out.println("정보 수정을 마칩니다.");
			break;
		default :
			System.out.println("다시 입력하세요.");	
		}
		return true;
	}
	

	// 삭제 메소드
	void deleteStudent() {
		System.out.println("======================================");
		for(int i=0; i<students.size(); i++) {
			System.out.println(i+1 + ". " + students.get(i));
		}
		System.out.print("삭제할 학생 번호를 입력하세요 : ");
		int num3 = Integer.parseInt(scan.next());
		exp.addDelStudent(students.get(num3-1));
		students.remove(num3-1);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	
	// 보기 메소드 : 1. 전체보기 2. 학번검색 3. 삭제정보   
	void studentView() {
		System.out.println("===============[학생조회]===============");
		System.out.println("1. 전체조회 2. 학번검색 3. 삭제정보 4. 종료");
		System.out.println("======================================");
		System.out.print("select number : ");
		int num4 = Integer.parseInt(scan.next());
		switch(num4) {
		case 1 :
			System.out.println("===============[전체조회]===============");
			for(int i=0; i<students.size(); i++) {
				System.out.println(i+1 + ". " + students.get(i));
			}
			break;
		case 2 :
			System.out.println("===============[학번검색]===============");
			System.out.print("학번으로 학생 정보를 검색합니다.");
			System.out.print("학번 입력 : ");
			String search = scan.next();
			int searchStudent = -1;
			for(int i=0; i<students.size(); i++) {
				if(students.get(i).getsNum().equals(search)) {
					System.out.println(students.get(i).toString());
					searchStudent = 0;
				}
			}
			if(searchStudent==-1) {
				System.out.println("입력하신 학번의 학생을 찾을 수 없습니다.");
			}
			break;
		case 3 :
			System.out.println("===============[삭제명단]===============");
			Iterator<Student> iter = exp.delStudents.iterator();
			if(iter.hasNext()) {
				for(int i=0; i<exp.delStudents.size(); i++) {
					System.out.println(i+1 + ". " + exp.delStudents.get(i));
				}					
			} else {
				System.out.println("삭제된 학생 정보가 없습니다.");
			}
			break;
		case 4 :
			System.out.println("조회를 종료합니다.");
			break;
		default :
			System.out.println("다시 입력하세요.");
		} // switch
	}

}
