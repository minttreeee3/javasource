package lang;


/* String 클래스
-변경이 불가능한(immutable) 클래스
 => str2 = str2+str; 한다고 덧붙이기 되는거 아님 

문자열 만들기
1) 문자열 리터럴 지정 String str2 = "Hello";
2) new 사용하는 방식 String str = new String("안녕하세요");


*/

public class StringEx1 {

	public static void main(String[] args) {
		
		//String 클래스의 동작 구현
		String str = new String("안녕하세요"); //원래는 이렇게 쓰는건데
		String str2 = "Hello"; //워낙 많이쓰는거라 new를 사용하지않고도 인스턴스를 생성할 수 있도록 되어있음 
		String str3 = new String("안녕하세요");
		String str4 = "Hello";
		
		//문자열 비교
		//String 클래스에 equals는 이미 오버라이딩 되어있음
		System.out.println(str.equals(str3));
		System.out.println(str.equalsIgnoreCase(str3)); //대소문자 구별없이 값비교
		System.out.println(str == str3); //문자열은 ==로 비교못함
		System.out.println(str2 == str4); //근데 이건 true나옴... 주소가 같아서
		

	}

}
