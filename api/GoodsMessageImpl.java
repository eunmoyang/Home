package kr.co.job.api;

import java.util.Scanner;

public class GoodsMessageImpl implements GoodsMessage{
	Scanner scan = new Scanner(System.in);

	@Override
	public int menuSelect() {
		System.out.println("===============상품관리===============");
		System.out.println("1. 등록 2. 수정 3. 삭제 4. 조회 99. 종료");
		System.out.print("select number : ");
		return Integer.parseInt(scan.next());
	}

	@Override
	public void goodsJoin(Goods p1) {
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
		
	}

	@Override
	public void goodsUpdate(Goods p1) {
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

	@Override
	public void goodsDelete(Goods p1) {
		p1.setgNo(0);
		p1.setgName(null);
		p1.setgPrice(null);
		p1.setgMade(null);
		System.out.println("상품이 삭제되었습니다.");
		
	}

	@Override
	public void goodsShow(Goods p1) {
		System.out.println("▼ 상품조회");
		System.out.println(p1);
	}

}
