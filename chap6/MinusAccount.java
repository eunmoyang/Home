/*
 * 마이너스 계좌 클래스
 * 속성 => 마이너스 한도 추가
 * 메소드 => 인출한다를 수정해야함
 */
package kr.co.job.chap6;

public class MinusAccount extends Account{
	// (Account 클래스의 필드) + 필드 추가 : 마이너스 한도
	int creditLine;
	
	public MinusAccount() {
		
	}

	public MinusAccount(String name, String accNo, int balance, String cardNo, int creditLine) {
		super(name, accNo, balance); // 상속 받은 클래스(Account)에 있던 생성자
		this.creditLine = creditLine;
	}
	
	// (Account 클래스의 메소드) + 인출한다를 수정함 => 메소드 오버라이딩
	@Override
	public int withdraw(int amount) {
		if((balance+creditLine)<amount) // 우리가 알고 있는 단순한 오류(예외)들을 모아놓음 => exception 클래스
			return 0;
		
		balance -= amount;
		return amount;
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		System.out.println("한도액만큼 확인됩니다.");
		
	}
	
}
