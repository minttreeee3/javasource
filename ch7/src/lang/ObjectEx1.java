package lang;

/* java.lang 패키지 안의 유용한 클래스 알아보기

java.lang 패키지 : import 구문 없이 사용 가능
Object : 모든 패키지의 부모

*/

public class ObjectEx1 {

	public static void main(String[] args) {
		
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		// equals() : obj1과 obj2가 같은 객체냐? 
		if(obj1.equals(obj2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		System.out.println(obj1 == obj2 ? "같음":"다름"); 
		// Object의 toString() 메소드
		System.out.println("obj1 toString "+obj1.toString());
		System.out.println("obj2 toString "+obj2.toString());
		
		
		// Value 부모 : Object 
		// 부모 메소드 + Value 객체의 메소드 모두 사용 가능 
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		System.out.println(v1.equals(v2) ? "v1==v2 같음":"v1!=v2 다름"); 
		//equals는 부모의 메소드라서 v1,v2값이 아닌 주소를 비교하게됨 =>그래서 다르다는 결과가 나옴 => 값을 비교하고싶으면 value클래스에서 오버라이딩 필요(equals를 재정의) 
		//boolean equals(Object obj) 메소드 호출
		// Object obj = v2 
		//하고나면 같다는 결과가 나옴
		System.out.println("v1 toString "+v1.toString()); 
		
		
		
		Person p1 = new Person(80281193933247L);
		Person p2 = new Person(80281193933247L);
		System.out.println(p1.equals(p2) ? "p1과 p2는 같은 사람":"p1과 p2는 다른 사람");
		System.out.println(p1);
		System.out.println(p1.toString()); //toString이 오버라이딩이 되어있다면 변수명(p1)만 써도 결과가 똑같이 나옴 
		
		
		
		Card card1 = new Card();
		Card card2 = new Card("HEART",8);
		System.out.println(card1);
		System.out.println(card2);

	}

}
