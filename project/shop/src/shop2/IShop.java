package shop2;

// 인터페이스 - 상수만 가질 수 있음, 모든 메서드는 추상

public interface IShop {
	//모든 메서드 앞에 자동으로 public static abstract 붙어있음 
	
	void setTitle(String title);
	void genUser();
	void genProduct();
	void start();

}
