package ch6;

public class DataEx {

	public static void main(String[] args) {
		
		Data data = new Data();
		
		//초기화
		data.x = 10;
		System.out.println("main() : x = "+data.x);
		
		System.out.println();
		
		//값만 넘어감
		change(data.x);
		System.out.println("After change(data.x)");
		System.out.println("main() : x = "+data.x); 
		
		System.out.println();
		
		//주소가 넘어감
		change2(data);
		System.out.println("After change2(data.x)");
		System.out.println("main() : x = "+data.x); 
		
	}
	
	//int x : x가 가지고있는 값만 받게 됨 - 기본형 매개변수(int 등)일땐 항상 값만 받게 됨
	static void change(int x) {         //위에가 static메소드라서 여기도 static이어야 오류가 안남
		x = 1000;
		System.out.println("change() : x = "+x);
	}
	
	//참조형 매개변수 : 값을 읽고 수정 가능
	static void change2(Data d) {
		d.x = 1000;
		System.out.println("change() : x = "+d.x);
	}
	
	

}
