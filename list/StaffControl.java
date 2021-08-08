/* 스탭 관리 클래스
 * 1. 초기값
 * 2. 화면메뉴
 * 3. 스탭추가
 * 4. 스탭수정
 * 5. 사번검색(찾으면 index, 못찾으면 index=-1 return)
 * 6. 스탭삭제
 *    => 삭제된 스탭을 StaffExpel클래스에서 저장
 * 7. 스탭조회(출력)
 *        1. 전체보기 2. 사번검색 3. 삭제정보    
 */
package kr.co.job.list;

import java.util.ArrayList;

public class StaffControl {
	ArrayList<Staff> members = new ArrayList<Staff>();
	Staff s = new Staff();
	
	public void init() {
		members.add(new Staff("eunmo", 31, "barista", "202104"));
		members.add(new Staff("jiyeon", 28, "manager", "201607"));
		members.add(new Staff("mihee", 26, "supervisor", "201911"));
		members.add(new Staff("seungyeon", 24, "barista", "201701"));
		
	}

}
