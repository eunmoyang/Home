/*
 * 더하기, 곱하기, 빼기, 나누기 등의 메소드를 모아놓은 클래스
 */
package kr.co.job.object;

public class Cal {
	public int sum(int n1, int n2) {
		int result = n1+n2;
		
		return result;
	}
	
	public int div(int n1, int n2) throws Exception {
		// if문의 간소화 (옛날식 예외처리 방식)
//		if(n2==0) {
//			return -1;
//		}
		
		// 고의로 예외 발생 시킴 (공이 그냥 날아오는게 아니라 익셉션을 가지고 날아옴)
		if(n2==0) {
			throw new Exception("0으로 나누면 안돼요!"); // 단발성으로 한번 쓰고 버리도록 만들기 때문에 변수명도 안씀
		}
		
		int result = n1/n2;
		
		return result;
	}

}
