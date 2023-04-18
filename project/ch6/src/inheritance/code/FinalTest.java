package inheritance.code;

//상속금지
public final class FinalTest {
	
	final int MAX_SIZE=10;	//멤버변수에 final 붙이면 상수
	
	final static int MIN_SIZE=0; //공용 상수 
	
	//오버라이딩 금지
	final void getMaxSize() {
		final int LV = MAX_SIZE;	//이 지역 안에서 쓰이는 상수 
	}

}
