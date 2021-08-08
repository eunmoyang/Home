package kr.co.job.chap6;

public class AccountTest01 {

	public static void main(String[] args) {
		// Account 클래스를 객체로 생성
		Account obj = new Account(); // 생성만 하고 필드값은 없는 상태
		// 필드값 넣어주기
		obj.accNo = "123-23-2324";
		obj.name = "홍길동";
		obj.balance = 10000;
		// 개념을 잡기 위해 대입연산자로 필드값을 넣어줬지만 정보 보안 때문에 이렇게 하면 안됨
		// 필드값을 private으로 캡슐화 해서 다른 곳에서 값을 볼 수 없도록 해야 함
		// 그래서 메서드 getter/setter를 이용해서 값을 불러오거나 넣어줌
		
		// 객체 생성과 동시에 필드값 넣어주기
		Account obj2 = new Account("장길산");
		// obj2.name = "장길산";
		Account obj3 = new Account("홍길동", "203902-04-104934", 100);
		// ex. 통장을 가져와서 예금주명,계좌번호,잔액을 하나씩 찍는게 아니라
		// 통장 만들 때부터 예금주명,계좌번호,잔액이 찍혀있도록 하는 것
		
		// 메소드 호출
		// 만원 입금
		obj.deposit(10000);
		
		// 오천원 출금
//		obj.withdraw(5000);
		
		// 어카운트 클래스의 withdraw에 예외 발생 시켰기 때문에 try/catch로 묶어줌
		try {
			obj.withdraw(5000); // 5만원 넣고 실행 시 "잔액이 부족합니다" 출력 후, 예외 발생 시킨 클래스의 라인과 현재 클래스의 오류 발생한 라인 표시 해줌(printStackTrace)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("여기는 무조건 거쳐간다."); // try를 해도 catch를 해도 마지막으로 들르게 됨, 보통 close로 씀
		}
		
		System.out.println("예금주명 : " + obj.name);
		System.out.println("계좌번호 : " + obj.accNo);
		System.out.println("잔액 : " + obj.balance);
		
//		System.out.println("예금주명 : " + obj2.name);
//		System.out.println("계좌번호 : " + obj2.accNo);
//		System.out.println("잔액 : " + obj2.balance);
//		
//		System.out.println("예금주명 : " + obj3.name);
//		System.out.println("계좌번호 : " + obj3.accNo);
//		System.out.println("잔액 : " + obj3.balance);
		
		printAccount(obj);
		printAccount(obj2);
		printAccount(obj3);

	}

	private static void printAccount(Account obj) {
		System.out.println("예금주명 : " + obj.name);
		System.out.println("계좌번호 : " + obj.accNo);
		System.out.println("잔액 : " + obj.balance);
		
	}

}
