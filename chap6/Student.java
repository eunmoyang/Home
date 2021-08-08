/* 객체 지향 - 모델링(틀) : 재사용성, 용이성, 상속성(확장 extends), 다형성, 캡슐화, 정보 은닉
 * 
 * [클래스의 다형성] - 클래스끼리의 형변환(크기가 작은 타입에서 큰 타입으로 형변환 할 때는 자동/생략 가능, 크기가 큰 타입에서 작은 타입으로 형변환 할때는 캐스트 연산자 써야함/생략 불가) 
 * - List -(하위)- ArrayList, LinkedList
 * ArrayList list = new ArrayList(); => ArrayList만 쓸 수 있음
 * List list2 = new ArrayList(); => 대빵 클래스를 참조한 상태로 선언하면 대빵 클래스의 다른 하위 클래스(LinkedList)로 전환(캐스트) 가능
 * 
 * 학생 클래스 => student
 * [속성, 멤버변수, 필드]
 * 학생명, 학과, 학번, 나이
 * [생성자]
 * 
 * Bean Class, VO, DTO
 * 
 * [클래스 다이어그램 보는 방법] 자바 UML
 * (+) 			public : 			어떤 클래스의 객체에서든 접근 가능
 * (~비어있음) 	default(package) : 	동일 패키지에 있는 클래스의 객체들만 접근 가능
 * (*) 			protected : 		이 클래스와 동일 패키지에 있거나 상속 관계에 있는 하위 클래스의 객체들만 접근 가능
 * (-마이너스) 	private : 			이 클래스에서 생성된 객체들만 접근 가능
 * 
 * 차수(계층적 구조/depth) : 부모 클래스(슈퍼 클래스) - 자식 클래스(서브 클래스)
 * ex. 바둑, 장기 등 경로 찾는 게임을 할 때 초/중/고급이 나눠져있으면 고급으로 갈수록 경우의 수(차수)를 짧게 함 
 */
package kr.co.job.chap6;

public class Student {
	// 클래스 변수
	static int cnt; // 객체의 변수가 아니라 클래스의 변수, static으로 선언해야됨 (전역 변수 같은 느낌/객체마다 호출해도 값이 다 똑같음/거의 횟수를 세야할때만 사용&감소는 잘 안시킴) 
	// static 필드 사용 시 : Student.cnt (== obj1.cnt == obj100.cnt)
	
	// 필드,멤버변수,속성,property,attribute
	private String name;
	private String major;
	private String sNo;
	private int age;

	// 생성자
	public Student() {
		cnt++; // 학생 수 증가 (사실 모든 생성자에 들어가야함)
		System.out.println("학생 생성");
	}
	
	public Student(String name, String major, String sNo, int age) {
		super();
		this.name = name;
		this.major = major;
		this.sNo = sNo;
		this.age = age;
	}

	public Student(String name, String major, String sNo) {
		super();
		this.name = name;
		this.major = major;
		this.sNo = sNo;
	}
	
	// getter setter
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMajor() {
			return major;
		}

		public void setMajor(String major) {
			this.major = major;
		}

		public String getsNo() {
			return sNo;
		}

		public void setsNo(String sNo) {
			this.sNo = sNo;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", sNo=" + sNo + ", age=" + age + "]";
	}
	
	
	
}
