package collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx2 {

	public static void main(String[] args) {


		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("김자바", 90);
		map.put("홍자바", 100);
		map.put("박자바", 95);
		map.put("이자바", 98);
		map.put("최자바", 88);
		map.put("표자바", 89);
		
		
		// entrySet() : map => set 구조로 변환  
		// Entry : 키와 값의 결합
		Set<Entry<String, Integer>> set = map.entrySet();
		//Iterator : 통일성 제공
		// hasNext() : 다음 요소가 존재한다면 true 
		// next() : 요소 가져오기 
		Iterator<Entry<String, Integer>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();  //괄호는 캐스팅(강제형변환)
			System.out.println("이름 : "+entry.getKey()+", 점수 : "+entry.getValue());			
		}
				
		
		// keySet() : map에서 키 값만 가져오기		
		Set<String> keys = map.keySet();
		System.out.println("참가자 명단 : "+keys);
		
		// values() : map에서 value 값만 가져오기 
		Collection<Integer> values = map.values();
		System.out.println("점수 : "+values);
		//Collection은 List와 Set의 부모 인터페이스
		//Collections는 클래스 - Collection에 유용한 메소드들을 갖고있음 

		
		//총점, 평균, 최고점, 최저점
		int total = 0;
		Iterator<Integer> it2 = values.iterator();
		while (it2.hasNext()) {			
			total += it2.next();
		}
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+ (float)total/set.size());
		System.out.println("최고 점수 : "+Collections.max(values));
		System.out.println("최저 점수 : "+Collections.min(values));
		
		
		
		

	}

}
