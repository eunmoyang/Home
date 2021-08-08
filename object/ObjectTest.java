/*
 * Object 클래스 : 클래스의 조상 (p.450) (p.466 String이랑 같이 보기)
 */
package kr.co.job.object;

public class ObjectTest {

	public static void main(String[] args) {
		// 들어있는 값이 같더라고 주소가 다름!!!!!!!!!!!!!!!!!
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		// equals 메소드의 매개변수는 obj만 될 수 있기 때문에 기본형(int, char 등)은 들어갈 수 없음
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}
		
		// v1 인스턴스의 주소값을 v2에 대입(저장)!!!!!!!!!!!! = 주소가 같아짐
		v2 = v1;
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같습니다.");
		} else {
			System.out.println("v1과 v2는 다릅니다.");
		}

		
	}
	
}
// 기본형을 참조형으로 바꿔주는 메소드 (wrapper 클래스 p.490)
class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}
}

