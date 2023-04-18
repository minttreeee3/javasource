package ch6;

//상품관리




public class GoodsStock {

	//속성
	String code; //상품코드(p123456)
	//상품코드
	int stockNum; //재고수량
	
	//생성자를 하나도 명시하지 않으면 기본생성자를 알아서 생성해줌 !!!
	// 그런데 아래 생성자 만들어서 여기서는 기본생성자는 생성안됨
	//마우스오른쪽 - source - 
	public GoodsStock(String code, int stockNum) {
		super();
		this.code = code;
		this.stockNum = stockNum;
	}
	
	//기능
	//재고수량 증가
	void addStock() {
		System.out.println("재고수량 증가");
	}

	//재고수량 감소
	void subtractStock() {
		System.out.println("재고수량 감소");
	}

	@Override
	public String toString() {
		return "GoodsStock [code=" + code + ", stockNum=" + stockNum + "]";
	}
	
	
	
	
}
