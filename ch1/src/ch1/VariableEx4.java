package ch1;

public class VariableEx4 {

	public static void main(String[] args) {
		
		
		/*리터럴 = 대입되는 값(상수)
		 * 
		 * 정수형 : long
		 */
		
		
		long big =9219920000000000000L;
		float f = 0.14159f;
		double d = 0.151516d;
		//접미사 : L,F,D
		//접두사 : 0(8진수),0x(16진수),0b(2진수)
		int octNum = 010;//8진수 10
		int hexNum = 0x10;//16진수 10
		int binNum = 0b10;//2진수 10
		System.out.println(big);
		System.out.println(octNum);
		System.out.println(hexNum);
		System.out.println(binNum);
	
		int i = 'A';
		System.out.println(i);
        //타입이 달라도 저장범위가 넒은 타입에 좁은 타입의 값을 저장하는 것은 허용됨
		//'A' : 2byte
		//int : 4byte
		
		
		//"":문자열
		//String : 참조타입
		
	String name = "hong";
	name = name+" 77";
	//1.name값 가져오기
	//2.문자77연결하기
	//3.연결한 값을 name에 담기
	
	System.out.println(name);
	
	String num = 7+7+"7";
		System.out.println(num);
		
		
		
		
		//	 printf() : 형식화된 출력
		//	 %d : 10진 정수의 형식 출력
		//	 %c : 문자
		//	 %s : 문자열
		//	 %f : 부동소수점
		//	 엔터가 안돼서 \n으로 줄바꿈
		int age = 25;
		System.out.println("age="+age);
		System.out.printf("age=%100d\n",age);
		
		char ch1='a';
		String str1 = "abcd";
		double d1 = 3.141592;
		System.out.printf("ch1=%c\n",ch1);
		System.out.printf("str1=%-10s\n",str1);
		System.out.printf("d1=%10.3f\n",d1);
		
		
		
		
		
		
	}

}
