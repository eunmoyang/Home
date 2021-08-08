/*
 * 은행 계좌 클래스
 * - 속성 : 계좌번호, 예금주명, 잔액
 * - 기능 : 입금한다, 출금한다, (new21.07.26)잔액확인
 * 
 * 생성자 : 모든 클래스는 하나의 생성자가 필요함
 * 클래스에서 정의하지 않으면 기본 생성자(디폴트 생성자)가 자동 발생
 * 인스턴스 시 필드의 값(속성)을 초기화하는 작업이 필요할 때 생성자 작성
 * => 매개변수 생성자
 */
package kr.co.job.chap6;

public class Account {
//public abstract class Account { => 추상 클래스화 (더이상 객체 생성 불가)
	
	// 필드(==속성==멤버변수==프로퍼티)
	public String accNo;
	public String name;
	public int balance;
	
	// 생성자
	Account() {} // 디폴트 생성자
	// 생성자를 따로 만들어주지 않았을 때는 디폴트 생성자를 따로 만들어주지 않아도 자동 생성됨
	// 아래와 같이 생성자를 따로 작성해줬을 때는 디폴트 생성자가 자동 생성되지 않음
	
	// 생성 시 이름
	Account(String name) {
		this.name = name; // 디스 생성자 메서드
	}
	
	// 생성 시 이름과 계좌번호
	Account(String name, String accNo) {
//		this.name = name;
		this(name);
		this.accNo = accNo;
	}
	
	// 생성 시 이름과 계좌번호와 잔액
	Account(String name, String accNo, int balance) {
//		this.name = name;
//		this.accNo = accNo;
		this(name,accNo); // 무조건 첫 줄에 this() 사용해야 함
		this.balance = balance;
	}
	
	// 메소드(기능)
	public void deposit(int amount) { // 예금
		balance += amount;
	}
	
	// final 1) 변수 : 값 변경 불가, 2) 메소드 : 오버라이딩 불가, 3) 클래스 : 상속 불가
	// final은 경계값을 설정하는 용도로 많이 쓰기 때문에 거의 static이랑 붙어다님 (ex. final 에어컨 아무리 내려도 18도 밑으로 안내려감 - static 에어컨 켜자마자 적용돼야하니까)
//	public final int withdraw(int amount) { // 출금
//	public int withdraw(int amount) { // 출금
//		if(balance<amount)
//			return 0; // 잔액이 부족하면 0을 리턴
//		balance -= amount;
//		return amount;
//	}
	
	public int withdraw(int amount) throws Exception { // 출금
		if(balance<amount)
			throw new Exception("잔액이 부족합니다."); // 예외 발생 시키기 "잔액이 부족합니다." 
			// 한번 쓰고 버리는 건 익명으로 (obj = new Exception 안함) - 메소드 withdraw에 throws Exception 발생 시킴
		balance -= amount;
		return amount;
	}
	
	// 추상 클래스화 : 설계 단계에서 내부에 제대로 구현하지 못한 추상 메소드가 있을 때 or 더이상 새로운 클래스를 생성하고 싶지 않을 때
//	abstract void test(int n); // 추상 메소드 만들면 클래스 자체를 추상 클래스로 바꿔야됨 - {}없이 세미콜론으로 끝낼수 있음 - 선언은 되는데 생성(new)가 안 됨
	
	// 상속 받을 때마다 메소드 고쳐써야 합니다. (오버라이딩 강제성 부여)
	public void view() {
		
	}
	
	// Account 클래스의 view() 메소드가 추상이어서 반드시 메소드가 있어야 한다.
//	@Override
//	public void view() {
//		System.out.println("한도액만큼 확인됩니다.");
//	}

}
