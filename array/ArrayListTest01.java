/*
 * 컬렉션 프레임 워크
 * List : ArrayList, LinkedList
 */
package kr.co.job.array;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("==========추가1==========");
		list.add("딸기"); // index 0, add로 값 넣어줌
		list.add("포도"); // index 1
		list.add("수박"); // index 2
		list.add("복숭아"); // index 3
		
		int num = list.size(); // 길이값 4, ArrayList는 일반 배열과 달리 공간이 무제한이기 때문에 size로 길이값 구할 수 있음
		System.out.println(num);
		
		for(int i=0; i<num; i++) {
			System.out.println(i + "번째 데이터 : " + list.get(i)); // get을 통해 데이터 가져옴
		}
		
		System.out.println("==========추가2==========");
		list.add(2,"메론"); // index 2 위치에 "메론"을 추가(원래 index 2 자리에 있던 데이터 "수박"은 삭제되는게 아니라 다음 인덱스로 밀림), insert 삽입하는 메소드도 있음
		for(int i=0; i<list.size(); i++) { // 사이즈가 늘어남
			System.out.println(i + "번째 데이터 : " + list.get(i));
		}
		
		System.out.println("==========변경==========");
		// 첫 번째 요소(index)의 데이터를 오렌지로 변경
		list.set(0, "오렌지"); // set으로 값을 변경해줌
		System.out.println("0번째 데이터 변경 완료");
		for(int i=0; i<list.size(); i++) { // 사이즈가 늘어나지 않음 (원래 index 0 자리에 있던 데이터 "딸기"가 사라지고 "오렌지"로 변경됨)
			System.out.println(i + "번째 데이터 : " + list.get(i));
		}
		
		System.out.println("==========삭제==========");
		// 두 번째 요소(index)의 데이터를 삭제
		list.remove(1); // remove로 인덱스 또는 값(list.remove("포도"))을 삭제
		for(int i=0; i<list.size(); i++) { // 사이즈가 줄어듦 (원래 index 1 자리에 있던 데이터 "포도"가 삭제되고 뒤에 있는 index의 데이터들이 앞으로 당겨짐)
			System.out.println(i + "번째 데이터 : " + list.get(i));
		}
		
		System.out.println("==========검색==========");
		int index = list.indexOf("수박"); // indexOf로 필요한 데이터의 index 주소값을 검색
		System.out.println("찾은 위치 : " + index);
		index = list.lastIndexOf("수박"); // LastIndexOf로 필요한 데이터를 뒤에서부터 찾음
		System.out.println("찾은 위치 : " + index);
		
		System.out.println("==========iterator==========");
		Iterator<String> iter = list.iterator(); // list를 iterator 반복자로 변환 (요소가 없는데 출력되는 부분을 막을 때 사용)
		while(iter.hasNext()) { // 다음을 가지고 있다면
			System.out.println(iter.next()); // 다음을 출력
		}
		
		System.out.println("==========향상된 for문==========");
		for(String str:list) { // list에 값이 없을 때까지 str에 계속 값을 넣어줌 (인덱스가 아니라 데이터로 봤을 때 사용)
			System.out.println(str);
		}

	}

}
