package kr.co.job.array;

import java.util.HashMap;

public class HashMapTest01 {

	public static void main(String[] args) {
		// Map 클래스 : map, hashmap, hashtable
		// hashmap : [K, V] key, value로 구성된 타입 (데이터 처리의 가장 기본적인 타입)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("한국", "서울"); // key(나라), value(수도), put으로 key와 value를 넣어줌
		map.put("한국2", "서울2");
		map.put("한국3", "서울3");
		map.put("한국4", "서울4");
		map.put("한국5", "서울5");
		
		String tmp = map.get("한국3"); // get으로 key를 통해 value를 구함 (key가 기준!)
		System.out.println(tmp);

	}

}
