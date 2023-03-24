package ch2;

import java.util.Scanner;
import java.util.TooManyListenersException;

public class OperatorEx5 {

	public static void main(String[] args) {
		
		/*연산자
		 * 1.단항연산자
		 * 	+(양수),-(음수),++,--,~,!
		 * 2.이항연산자
		 * 	산술 : +,-,*,/,%,<<,>>,>>>
	 * 	비교 : >,<,>=,<=,==(값이 같니?),!=(값이 같지 않니?)
		 * 	논리 : &&(and), ||(or),^(xor),&(and),|(or)
		 * 3.삼항연산자 : ? :
		 * 4.대입연산자 : =
		 */
		
		//534자루의 연필을 30명의 학생들에게 또같은 개수로 나눌 때 학생 한 명당 몇 개를 가질 수 있고, 연필의 나머지는 몇 개인가
		
		//출력) 학생 한명당 : 몇자루
		//	   남은 연필 수 : 몇자루
		
//		int pensil = 534, students = 30;
//		
//		System.out.println("학생 한명당 : "+(pensil/students));
//		System.out.println("남은 연필 수 : "+(pensil%students));
//		
//		//사다리꼴 너비 구하기
//		//윗변 : 5, 아랫변 : 10, 높이 : 7인 사다리꼴 너비 구하기
//		//변수 사용, 소수 자리수 까지 출력
//		
//		double 윗변 = 5, 아랫변 = 10, 높이 = 1;
//		
//		System.out.println("사다리꼴의 너비 : "+((double)11/(double)9*(9/10)));
//		
//		//한달월급을 10년동안 저축할때 최종 저축금액 구하기
		//		조건 : 사용자로부터 한달 월급 입력받기
		//		출력예시 : 10년 저축 금액 : 2000000
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("한달 월급을 입력하시오 ");
//		
//		int 월급 = Integer.parseInt(sc.nextLine());
//		System.out.println("10년 저축 금액은 "+ (월급*12*10)	);

		
				
		//화씨 온도를 섭씨 온도로 변경하기
		//화씨 온도가 100일때 섭씨 온도가 얼마인지 출력하기
		//섭씨온도 = 5/9*(화씨온도-32)
		
//		double 화씨온도 = 100, 섭씨온도 = (double)5/9*(화씨온도-32);
//		System.out.println("화씨 온도가 100일때 섭씨 온도는 : "+섭씨온도);
//		
//		
//		double a=100,b=5/9*(a-32);
//		
//		System.out.println(b);
//		
//		System.out.println(7.5*7);
		
		
		//삼항연산자 이용
		// int num=10 일때 num이 양수인지, 음수인지, 0인지 출력
		
		int num = 10;
				if (num<0) {System.out.println("음수");
				}
				if (num>0) {System.out.println("양수");
				}
				if (num==0) {System.out.println("0");
				}
				
		
		
		
		//숫자를 입력받아 짝수인지, 홀수인지 출력하기
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("숫자를 입력하시오 ");
		
		int num1 = Integer.parseInt(sc.nextLine());
		
		String result = num1%2==0?"짝수":"홀수";
		System.out.println(result);
		
		sc.close();
		
		
	
	
	}
}
