/*
 * 삭제된 학생정보를 저장하는 클래스
 */
package kr.co.job.checking;

import java.util.ArrayList;
import java.util.List;

public class StudentExpel {
	List<Student> delStudents;
	
	StudentExpel(){  // 삭제클래스 생성될때 공간확보
		delStudents = new ArrayList<Student>();
	}	
	//삭제저장소에 삭제할 학생정보를 저장하는 메소드 생성
	public void addDelStudent(Student student) {
		delStudents.add(student);
	}
	
}
