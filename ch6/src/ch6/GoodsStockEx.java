package ch6;

public class GoodsStockEx {

	public static void main(String[] args) {

		//티셔츠 상품관리
		//객체 생성 ==>생성자가 자동으로 호출됨
		
		
		//GoodsStock goods = new GoodsStock(); //기본 생성자 호출 오류남 - 기본생성자 없어서 
		GoodsStock goods = new GoodsStock("p123456",150); //매개변수를가진 생성자 호출
		
		System.out.println("현재 재고수량 "+goods.stockNum);
		
		//상품 판매 10
		goods.subtractStock();
		
		
		
		
	}

}
