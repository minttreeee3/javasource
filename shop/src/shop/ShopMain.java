package shop;

public class ShopMain {

	public static void main(String[] args) {
		IShop shop = new MyShop();  //왼쪽이 부모(인터페이스), 오른쪽이 자식 
		
		//shop 이름지정
		shop.setTitle("MyShop");
		//user생성
		shop.genUser();
		//product생성
		shop.genProduct();
		//shop시작
		shop.start();
		

	}

}
