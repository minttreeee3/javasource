package ch2;

import java.util.TooManyListenersException;

public class OperatorEx2 {

	public static void main(String[] args) {
		
		/*연산자
		 * 1.단항연산자
		 * 	+(양수),-(음수),++,--,~,!
		 * 2.이항연산자
		 * 	산술 : +,-,*,/,%,<<,>>,>>>
//		 * 	비교 : >,<,>=,<=,==(값이 같니?),!=(값이 같지 않니?)
		 * 	논리 : &&(and), ||(or),^(xor),&(and),|(or)
		 * 3.삼항연산자 : ? :
		 * 4.대입연산자 : =
		 */
		
		int num1=10;
		int num2=10;
		
		System.out.println(num1==num2);
		System.out.println(num1!=num2);
		System.out.println(num1>=num2);
		System.out.println(num1<=num2);
		
		boolean result = num1==num2;
		System.out.println(result);
		
		
		char ch1='A';
		char ch2='B';
		System.out.println("ch1==ch2="+(ch1==ch2));
		System.out.println("ch1>=ch2="+(ch1>=ch2));
		System.out.println("ch1<=ch2="+(ch1<=ch2));
		System.out.println("ch1!=ch2="+(ch1!=ch2));

		
		double d1=0.4;
		float f1=0.4f;
		System.out.println("d1==f1="+(d1==f1));
		System.out.println("d1!=f1="+(d1!=f1));
		System.out.println("d1<=f1="+(d1<=f1));
		System.out.println("d1>=f1="+(d1>=f1));
		//정밀도의 차이가 있음 ( double가 더 정밀도가 높아서 사실 0.4124124124와 같이 사실 뒤에 더 많이 붙어있음 )
		
	

		
		
		
		
		
	
	
	}
}
