package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 컬렉션 프레임웍

컬렉션 : 여러 데이터들을 모아 놓은 것
framework : 표준화되고 정형화된 프로그래밍 방식 

라이브러리 : 공통으로 사용될만한 유용한 기능을 모듈화 
(컬렉션 프레임웍과 비슷하지만 약간다름)


컬렉션은 인터페이스 
Collection
  /   \
List  Set
Map

List 인터페이스 : 순서가 존재함, 데이터 중복 허용
(인터페이스라서 인스턴스를 못만듦 -> 자식 필요 -> 구현클래스 존재)
			구현클래스 : ArrayList, LinkedList, Stack, Queue, Vector...)

Set 인터페이스 : 순서를 유지하지 않음, 데이터 중복 허용하지 않음
			구현클래스 : HashSet, TreeSet...

Map 인터페이스 : key, value의 쌍으로 이루어진 데이터 집합,
			순서를 유지하지 않음, key는 중복안되고 value는 중복허용
			구현클래스 : HashMap, TreeMap, Hashtable, Properties...



* <E> or <T>, <K,V> : 지네릭스 개념 ==>타입 지정
E : element 타입 지정
타입 : 참조 타입만 지정가능 (int를 담고싶으면 Integer로 써야됨)

*/

public class ListEx1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		System.out.println("size() "+list.size());	//배열의 length와 같은 개념 
		System.out.println("isEmpty() "+list.isEmpty());	//boolean으로 리턴
		
		// add() : 요소 추가
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list2.add("자바");
		list2.add("html");
		list2.add("script");
		list2.add("서블릿");
		
		System.out.println(list);	//toString이 오버라이딩되어있어서 리스트 확인가능 
		System.out.println(list2);
		
		
		String fruits[] = {"사과","포도","메론","딸기","바나나"};
		//배열 =>리스트로 변환 (추가할 내용이 없다면)
		List<String> list3 = Arrays.asList(fruits);
		System.out.println(list3);
		
		//배열 =>리스트로 변환 (이렇게해야 .add 써서 내용 추가할수있음)
		List<String> list4 = new ArrayList<>(Arrays.asList(fruits));
		list4.add("참외");
		System.out.println(list4);
		
		
		// add(int index, 요소)
		list.add(3, 6); 
		System.out.println("특정 위치에 추가 후 "+list);
		
		// set(int index, 요소)
		list.set(2, 7);
		System.out.println("특정 위치에 요소 변경 "+list);
		
		// remove(int index)
		list.remove(1);
		System.out.println("특정 위치 요소 제거 "+list);
		// remove(Object o) 
		list4.remove("바나나");
		System.out.println("특정 요소 제거 "+list4);
		
		
		// get(int index)
		System.out.println("특정 위치 요소 가져오기 : "+list2.get(0));
		
		// indexOf(Object o)
		System.out.println("특정 요소의 위치 가져오기 : "+list2.indexOf("서블릿"));
		
		
		// Collections.sort() : 오름차순 정렬 기본, 내림차순으로 하려면 기준 제공 
		Collections.sort(list4); // void라서 리턴타입이없어서 syso에 이걸 바로는 못찍고 list4를 찍어서 확인해봐야됨 
		System.out.println("정렬 후 : "+list4);

		// Comparator.naturalOrder() : 오름차순,  Comparator.reverseOrder() : 내림차순
		list.sort(Comparator.reverseOrder());
		System.out.println("정렬 후 : "+list);
		
		
		

	}

}
