/* 모델링(기획->설계)
 * 회원 : 순번, 아이디, 이름, 나이, 취미, 종교 ...
 * - 속성 : 작성할 때 필수 데이터 / 선택 데이터 구분
 * - 생성자 : 객체를 인스턴스할 때 필드값을 초기화 한다.
 * - 기능 : 회원 조회(전체/선택), 가입하기, 수정하기, 삭제하기 ... => 회원(속성)에 대한 작업이 아니라 제어하기 위한 메인(Control)에서 필요한 것들 
 */
package kr.co.job.api;

public class Member {
	private int no;
	private String id;
	private String name;
	private int age;
	
	// 생성자
	public Member() {
		
	}
	
	public Member(int no, String id, String name, int age) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	// 필드가 private이기 때문에 getter, setter 필요 (우클릭-source-generate getters and setters)
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "회원번호 : " + no + "\n이름 : " + name + "\n아이디 : " + id + "\n나이 : " + age;
	}
	
	
	

}
