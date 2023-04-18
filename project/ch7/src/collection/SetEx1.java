package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			set.add(String.valueOf(i)); // String.valueOf(i): int를 String으로 바꿈 
		}
		
		
		set.add("9");	//중복을 허용하지 않음 =>이미 9가 있기때문에 중복으로 담기지 않음 
		
		
		System.out.println(set);
		
		
		// while사용하기
		//Iterator : 통일성 제공
		// hasNext() : 다음 요소가 존재한다면 true 
		// next() : 요소 가져오기 
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}

	}

}
