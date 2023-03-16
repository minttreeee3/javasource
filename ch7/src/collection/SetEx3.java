package collection;

import java.util.HashSet;
import java.util.Set;

public class SetEx3 {

	public static void main(String[] args) {
		
		// Person 객체를 Set 구조에 담기		
		Set<Person> set = new HashSet<Person>();  //뒷쪽 Person은 생략가능
		
		//사용자정의객체는 중복저장을 허용함  (Set이 중복저장 막아주는건 String, Integer같은 원래 자바에 있는 객체)
		//허용하지 않으려면 equals(), hashCode() 오버라이딩
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));	
		
		System.out.println(set);
		

	}

}
