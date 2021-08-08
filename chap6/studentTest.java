package kr.co.job.chap6;

public class studentTest {

	public static void main(String[] args) {
		Student stu; // 선언
		stu = new Student("홍길동", "컴공", "20210503", 21); // 인스턴스화 (객체 생성)
		System.out.println(stu); // Student 클래스 내에 toString 메서드를 만들어놔야 원하는 방식으로 출력됨 (안 만들어져 있으면 주소값 출력됨)
		
		// 컴공->미대
//		stu.major = "미대"; // 필드가 private이기 때문에 not visible -> getter/setter 이용하여 값을 바꿔줘야함
		stu.setMajor("미대");
		System.out.println("당신의 학과 : " + stu.getMajor());
		
		
//		Thread.sleep(1000); // 1000이 1초의 의미
//		1) add throws declaration : main 클래스에 throws InterruptedException 넣어줌
//		2) surround with try/catch : try 실행되면 다음 문장으로 넘어감, catch 실패하면 추적해서 잡아줌
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // 여기까지 자동 생성
		} catch (Exception e) { // 작은 범위부터 큰 범위로 가야함 (InterruptedException -> Exception)
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		
		System.out.println("1초 후 출력됨");

	}

}
