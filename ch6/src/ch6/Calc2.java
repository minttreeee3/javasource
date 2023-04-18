package ch6;

/* 메서드 오버로딩
 * 메서드 이름이 같아야 함
 * 매개변수의 개수 또는 타입이 달라야 함
 * 반환타입은 관계없음

*/
public class Calc2 {
	
	int add(int a, int b) {
		return a+b;
	}
	
//	int add(int num1, int num2) {   위랑 완전히 겹쳐서 안됨 (변수명바꾸는거랑은 상관없음) 
//		return num1+num2;
//	}
	
	long add(long num1, int num2) {
		return num1+num2;
	}
	
	
	float add(int a, float b) {
		return a+b;
	}
	
	
	int add(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	
	

}
