/* 인터페이스 : 설계 원형 작업
 * final 필드, 추상 메소드로 구성
 */
package kr.co.job.api;

public interface GoodsMessage {
	// 메뉴 선택
	public int menuSelect();
	// 상품 추가
	public void goodsJoin(Goods obj);
	// 상품 수정
	public void goodsUpdate(Goods obj);
	// 상품 삭제
	public void goodsDelete(Goods obj);
	// 상품 조회
	public void goodsShow(Goods obj);
}
