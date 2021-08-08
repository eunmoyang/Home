/* 
 * 직불 카드 계좌 클래스
 * [속성]
 * 계좌번호, 예금주명, 잔액, 카드번호
 * [생성자]
 * [메소드]
 * 예금한다, 인출한다, 지불한다
 */
package kr.co.job.chap6;

public class CheckingAccount extends Account {
	// (Account 클래스의 필드) + 필드 추가 : 카드번호
	String cardNo;
	
	// 생성자
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String name, String accNo, int balance, String cardNo) {
//		this.name = name;
//		this.accNo = accNo;
//		this.balance = balance;
		super(name, accNo, balance); // 상속 받은 클래스(Account)에 있던 생성자
		this.cardNo = cardNo;
	}
	
	// (Account 클래스의 메소드) + 메소드 추가 : 지불한다
	int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo) || (balance<amount))
			return 0;
		
		return withdraw(amount); // 어카운트 클래스의 withdraw 메소드에 예외 발생 시켰기 때문에 add throws declaration 해줌
	}
}
