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

public class StudentControl {
	Scanner scan = new Scanner(System.in);
	//학생정보를 담고있는 리스트
	ArrayList<Student> students = new ArrayList<Student>();
	//삭제된 정보를 담고있는 클래스의 객체 생성
	StudentExpel exp = new StudentExpel();
	
	//초기값
	void init() {
		// Student s = new Student("홍길동","22","1","영어");
		// students.add(s);
		// 어차피 배열에 들어갈거라서 객체명 필요없기 때문에 인스턴스명 정하지 않고 new 해줌 (+ 메모리 관리 목적)
		students.add(new Student("은모","31","20102923","관광경영"));
		students.add(new Student("선경","24","171041","관광경영"));
		students.add(new Student("지윤","25","2016240021","비서"));
		students.add(new Student("채연","26","151759","컴퓨터공학"));
		students.add(new Student("지수","30","20110000","시각디자인"));
	}
	
	// 기본 메뉴 출력 : 1.추가 2. 수정 3. 삭제 4. 보기, 99종료
	String menuView() {
		System.out.println("=================[학생관리]=================");
		System.out.println("1. 추가 2. 수정 3. 삭제 4. 조회 5. 종료");
		System.out.println("==========================================");
		System.out.print("select number : ");
		return scan.next();  // 입력된 데이터를 리턴. 공백까지만 입력받음
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
	
	// 수정메소드(1) updateView() : 검색 메소드와 updateStudent() 메소드 이용
	// ★★★ 이름, 나이, 전공은 중복값이 있을 수 있기 때문에 검색할 수 없음 (또는 중복값이면 다시 갈라주는 작업을 해야함!!) ★★★
	void updateView() {
		System.out.println("수정할 학생의 정보를 입력하세요. (이름 or 나이 or 학번 or 전공");
		String search = scan.next();
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getName().equals(search)) {
				// ★★★ int 변수 만들어서 i를 넣고 업데이트 메소드 불러올 때 int 변수를 만들어서 넣을 필요 없이 바로 메소드 매개변수에 i를 넣어주면 됨
//				int index = i;
				System.out.println("이름이 " + students.get(i).getName() + " 인 학생의 정보를 수정합니다.");
//				updateStudent(index);
				updateStudent(i);
				break;
			} else if(students.get(i).getAge().equals(search)) {
//				int index2 = i;
				System.out.println("나이가 " + students.get(i).getAge() + " 인 학생의 정보를 수정합니다.");
//				updateStudent(index2);
				updateStudent(i);
				break;
			} else if(students.get(i).getsNum().equals(search)) {
//				int index3 = i;
				System.out.println("학번이 " + students.get(i).getsNum() + " 인 학생의 정보를 수정합니다.");
				updateStudent(i);
//				updateStudent(index3);
				break;
			} else if(students.get(i).getMajor().equals(search)) {
//				int index4 = i;
				System.out.println("전공이 " + students.get(i).getMajor() + " 인 학생의 정보를 수정합니다.");
				updateStudent(i);
//				updateStudent(index4);
				break;
			} else {
				System.out.println("입력하신 정보의 학생이 없습니다.");
//				updateStudent(-1);
				// ★★★ 쌤이 이건 없어도 된다고 함
			}
		} 
	}
	
	// 수정메소드(2) updateStudent(int index) : 1.이름수정 2. 나이수정 3. 학번수정 4. 전공수정
	boolean updateStudent(int index) {
		// ★★★ 메뉴 선택 및 실행 후 초기 메뉴로 돌아가도록 while문을 없애는게 더 나을 수 있음
		boolean edit = true;
		while(edit) {
			// ★★★ 쌤이 이건 없어도 된다고 함
//			if(index==-1) {
//				return false;
//			}
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
				System.out.println("이름 변경이 완료되었습니다.");
				break;
			case 2:
				System.out.println("수정할 나이를 입력하세요 : ");
				String age = scan.next();
				students.get(index).setAge(age);;
				System.out.println("나이 변경이 완료되었습니다.");
				break;
			case 3:
				System.out.println("수정할 학번을 입력하세요 : ");
				String no = scan.next();
				students.get(index).setsNum(no);;
				System.out.println("학번 변경이 완료되었습니다.");
				break;
			case 4:
				System.out.println("수정할 전공을 입력하세요 : ");
				String major = scan.next();
				students.get(index).setMajor(major);;
				System.out.println("전공 변경이 완료되었습니다.");
				break;
			case 5:
				System.out.println("정보 수정을 마칩니다.");
				edit = false;
				break;
			default :
				System.out.println("다시 입력하세요.");	
			}
		}
		return edit;
		// ★★★ 리턴값을 edit으로 던지는게 아니라 수정메소드(1)에서 받을 값은 수정메소드(2)가 잘 실행됐는지 여부를 true/false로 받아줌으로써 프로그램 완성도를 높이기 위함임
	}
	

	//삭제메소드
	void deleteStudent() {
		System.out.println("======================================");
		for(int i=0; i<students.size(); i++) {
			System.out.println(i+1 + ". " + students.get(i));
		}
		System.out.print("삭제할 학생 번호를 입력하세요 : ");
		int num3 = Integer.parseInt(scan.next());
		
//		Student student = new Student();
//		student = students.get(num3-1);		
//		exp.addDelStudent(student);	
		exp.addDelStudent(students.get(num3-1));
		// ★★★ 스튜던트 타입 변수 새로 만들고 거기에 삭제한 학생 정보 넣고 메소드에 스튜던트 타입 변수를 넣을 필요 없이 바로 메소드에 삭제한 학생 정보를 넣으면 됨
	
		students.remove(num3-1);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	
	//보기메소드 1. 전체보기 2. 학번검색 3. 삭제정보   
	void studentView() {
		// ★★★ 메뉴 선택 및 실행 후 초기 메뉴로 돌아가도록 while문을 없애는게 더 나을 수 있음
		boolean view = true;
		while(view) {
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
				// ★★★ 검색한 학번에 맞는 학생이 없을 때는 명세서의 int searchStudent를 사용하여 예외 처리 해줘야 함
				System.out.print("학번으로 학생 정보를 검색합니다.");
				System.out.print("학번 입력 : ");
				String search = scan.next();
				for(int i=0; i<students.size(); i++) {
					if(students.get(i).getsNum().equals(search)) {
						System.out.println(students.get(i).toString());
					}
				}
				break;
			case 3 :
				// ★★★ 삭제한 학생이 없을 때는 아무것도 출력되지 않으므로 삭제한 학생이 없다고 안내 문구 달아줘야함
				for(int i=0; i<exp.delStudents.size(); i++) {
					System.out.println(i+1 + ". " + exp.delStudents.get(i));
				}
				break;
			case 4 :
				System.out.println("조회를 종료합니다.");
				view = false;
				break;
			default :
				System.out.println("다시 입력하세요.");
			} // switch
		} // while
	}

}
