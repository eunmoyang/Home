/*
 * 생물이 가져야 하는 기본 기능을 작성한 인터페이스
 * 숨쉰다(), 잔다()
 */
package kr.co.job.chap6;

public interface Flow {
	// 고정 필드와 추상 메소드
	public void breath(); // (원래 인터페이스에는 추상 메소드만 쓸 수 있기 때문에 abstract 생략 가능)
	public void sleep();

}
