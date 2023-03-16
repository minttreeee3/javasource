package ch6;

/* 변수와 메서드에 static이 붙으면 
 * 같은 static끼리는 문제가 없음
 * static이 붙지 않은 변수나 메서드를 호출하려면 인스턴스 생성 후 가능
*/


public class MemberCall {
	
	//인스턴스 변수
	int iv=10;
	//static(클래스) 변수
	static int cv=20;
	
	
	//인스턴스 변수 = 클래스변수
	int iv2 = cv;	
	
	//클래스변수 = 인스턴스 변수 =>오류남
	//인스턴스 변수의 값을 클래스 변수에 대입하는 건 불가 - 생성시기가 다르기때문
//	static int cv2 = iv;   => new 이후에만 가능
	
	
	static void staticMethod1() {
		System.out.println(cv); 
		// System.out.println(iv); 		=> new 이후에만 가능 
		// instanceMethod1();  => new 이후에만 가능 (static은 이미 생성되어있는데 iv, instance는 아직임
	}
	
	
	void instanceMethod1() {
		System.out.println(cv);
		//iv와 instanceMethod1은 생성되는 시기가 같음 =>문제없이 실행됨
		System.out.println(iv);
	}

}
