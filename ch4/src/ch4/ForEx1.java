package ch4;
/*반복문
 * 어떤 작업이 반복적으로 수행되도록 할 때 사용
 * 종류: for(주로사용됨), while, do-while
 */

public class ForEx1 {

	public static void main(String[] args) {

		// int i = 0; 초기화
		// i < 10; 조건식(false일때 반복문 종료)
		// 조건식이 true일때 블럭안으로 진입: 출력문 실행
		// i++ 증감식 i=1로 바뀜
		// i <10;
		// 조건식이 true일때 블럭안으로 진입: 출력문 실행
		// 이런식으로 조건식이 거짓이 될때까지 반복
		
		System.out.println();
		for (int i=0; i<10; i++) {
			System.out.print(i+"  ");
			
		}	
		
		// i+=2  는  i=i+2  의 의미
		//1 3 5 7 9 나오게하려면
		System.out.println();
		for (int i=1; i<=10; i+=2) {
			System.out.print(i+"  ");
		}
			
		//3번반복하려면
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.println("Hello");
		}
		
		//1~100 출력
		System.out.println();
		for (int i = 1; i <=100; i++) {
			System.out.print(i+"  ");
		}
		
		//1~100중에 홀수만 출력
		System.out.println();
		for (int i = 1; i <=100; i+=2) {
			System.out.print(i+"  ");
		}
		
		//1~10까지 덧셈결과 출력
		System.out.println();
		int sum=0;
		for (int i = 1; i <=10; i++) {
			sum = sum+i; 
		}
		System.out.println("1~10의 합 = " +sum);
		
		
		
		


	}

}
