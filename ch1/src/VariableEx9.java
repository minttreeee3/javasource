package ch1;

public class VariableEx9 {

	public static void main(String[] args) {
		

		//변수의 범위
		//변수 : 지역변수, 인스턴스 변수, 클래스 변수
		//	  : 모든 변수는 유효범위 존재
		
		int i=4;
		//i의 유효범위? {}안에서만 유효 (main 메소드 안에서만 가능) - 지역변수
		
		
		
		{
			int j=5;
			//j의 유효범위?
			System.out.println(j);
			System.out.println(i);
			
			
		}
		
		
		//j cannot be resolved to a variable - 변수j가 유효범위 안에 없음
		System.out.println(i);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
