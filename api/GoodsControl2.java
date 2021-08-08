/*
 * 상품 추가, 수정, 삭제, 조회
 * public void goodsJoin(obj);
 * public void goodsUpdate(obj);
 * public void goodsDelete(obj);
 */
package kr.co.job.api;

import java.util.Scanner;

public class GoodsControl2 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Goods p1 = null;
		GoodsMessageImpl gc = new GoodsMessageImpl();
		boolean system = true;
		
		while(system) {
			int num = 0;
			num = gc.menuSelect();
			
			switch(num) {
			case 1 : // 등록 
				gc.goodsJoin(p1);
				break;
			case 2 : // 수정
				gc.goodsUpdate(p1);
				break;
			case 3 : // 삭제
				gc.goodsDelete(p1);
				break;
			case 4 : // 조회
				gc.goodsShow(p1);
				break;
			case 99 :
				System.out.println("상품 관리를 종료합니다.");
				system = false;
				break;
			default :
				System.out.println("다시 입력하세요.");
			
			} // switch
		} // while
	} // main



}
