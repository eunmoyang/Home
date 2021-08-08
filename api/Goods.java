package kr.co.job.api;

import java.util.Scanner;

public class Goods {
	Scanner scan = new Scanner(System.in);
	private int gNo; // 상품번호
	private String gName; // 상품이름
	private String gPrice; // 상품가격
	private String gMade; // 제조국가
	
	public Goods() {}

	public Goods(int gNo, String gName, String gPrice, String gMade) {
		super();
		this.gNo = gNo;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gMade = gMade;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgPrice() {
		return gPrice;
	}

	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}

	public String getgMade() {
		return gMade;
	}

	public void setgMade(String gMade) {
		this.gMade = gMade;
	}

	@Override
	public String toString() {
		return "상품번호 : " + gNo + "\n상품명 : " + gName + "\n상품가격 : " + gPrice + "\n제조국가 : " + gMade;
	}


}
