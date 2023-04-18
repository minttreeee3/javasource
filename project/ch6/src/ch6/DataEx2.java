package ch6;

public class DataEx2 {

	public static void main(String[] args) {

		// 인스턴스 생성
		// 참조형타입  변수명 = new  참조형타입();
		Data d = new Data();
		d.x = 10;
		
		
		
		//메소드의 리턴타입이 void가 아닌 경우 리턴 타입에 대한 준비를 해야 함
				// 1) 출력문안에 넣고 출력하기
				//System.out.println("5+3= " +calc.add(5,3));
				
				// 2) 변수에 받기
				//int result=calc.add(15,3);
		Data d2 = copy(d); //주소가 넘어감 /  d.x 를 쓰면 값이 넘어감
				// 변수에 받은 후 출력 / 변수에 받은 후 다른 연산이나 작업들을 추가로 함
		
		System.out.println("d.x = "+d.x);
		System.out.println("d2.x = "+d2.x);
		
		
	}
	
	// int a = 4;
	
	static Data copy(Data d) {  //temp가 Data타입이라서... static Data
		Data temp = new Data();
		//
		temp.x = d.x;
		return temp;
		
	}
	
	

}
