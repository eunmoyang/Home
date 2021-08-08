/*
 * 상품 추가, 수정, 삭제, 조회
 * public void goodsJoin(obj);
 * public void goodsUpdate(obj);
 * public void goodsDelete(obj);
 */
package kr.co.job.api;

//import java.util.ArrayList;
import java.util.Scanner;

public class GoodsControl {
	static Scanner scan = new Scanner(System.in);
//	static ArrayList<Goods> list = new ArrayList<Goods>();
	
	public static void main(String[] args) {
		Goods p1 = new Goods();
		boolean system = true;
		while(system) {
			int num = menuSelect();
			
			switch(num) {
			case 1 : 
				goodsJoin(p1);
				break;
			case 2 : 
				goodsUpdate(p1);
				break;
			case 3 :
//				p1 = goodsDelete(p1);
				goodsDelete(p1);
				break;
			case 4 :
				System.out.println("▼ 상품조회");
				System.out.println(p1);
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

	private static int menuSelect() {
		System.out.println("===============상품관리===============");
		System.out.println("1. 등록 2. 수정 3. 삭제 4. 조회 99. 종료");
		System.out.print("select number : ");
		return Integer.parseInt(scan.next());
	}

//	private static Goods goodsDelete(Goods p1) {
	private static void goodsDelete(Goods p1) {
//		p1 = null;
		p1.setgNo(0);
		p1.setgName(null);
		p1.setgPrice(null);
		p1.setgMade(null);
		System.out.println("상품이 삭제되었습니다.");
//		return p1;
	}

	private static void goodsUpdate(Goods p1) {
		boolean admin = true;
		while(admin) {
			System.out.println("====================상품수정====================");
			System.out.println("1. 상품번호 2. 상품명 3. 상품가격 4. 제조국가 99. 종료");
			System.out.println("select number : ");
			int num2 = Integer.parseInt(scan.next());
			
			switch(num2) {
			case 1 :
				System.out.println("수정할 상품 번호를 입력하세요 : ");
				p1.setgNo(Integer.parseInt(scan.next()));
				System.out.println("상품 번호가 " + p1.getgNo() + "으로 변경되었습니다.");
				break;
			case 2 : 
				System.out.println("수정할 상품명을 입력하세요 : ");
				p1.setgName(scan.next());
				System.out.println("상품명이 " + p1.getgName() + "으로 변경되었습니다.");
				break;
			case 3 :
				System.out.println("수정할 상품 가격을 입력하세요 : ");
				p1.setgPrice(scan.next());
				System.out.println("상품 가격이 " + p1.getgPrice() + "으로 변경되었습니다.");
				break;
			case 4 :
				System.out.println("수정할 제조 국가를 입력하세요 : ");
				p1.setgMade(scan.next());
				System.out.println("제조 국가가 " + p1.getgMade() + "으로 변경되었습니다.");
				break;
			case 99 :
				System.out.println("상품 관리를 종료합니다.");
				admin = false;
				break;
			default :
				System.out.println("다시 입력하세요.");
			} // switch
		} // while
	}

	private static void goodsJoin(Goods p1) {
		System.out.println("▼ 상품 등록을 시작합니다.");
		System.out.print("상품 번호 : ");
		p1.setgNo(Integer.parseInt(scan.next()));
		System.out.print("상품명 : ");
		p1.setgName(scan.next());
		System.out.print("상품 가격 : ");
		p1.setgPrice(scan.next());
		System.out.print("제조 국가 : ");
		p1.setgMade(scan.next());
		System.out.println("▼ 상품 등록이 완료되었습니다.\n" + p1);
		
//		list.add(p1);
	}

}
