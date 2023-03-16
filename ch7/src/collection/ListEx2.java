package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx2 {

	public static void main(String[] args) {
		
		
		
		//배열에선 이렇게 했던것처럼
//		Member1[] members = new Member1[10];
//		members[0] = new Member1(" ");
		
		// ArrayList에 Member객체를 추가
		ArrayList<Member1> list = new ArrayList<>();
		list.add(new Member1("홍길동"));
		list.add(new Member1("성춘향"));
		list.add(new Member1("고길동"));
		list.add(new Member1("강감찬"));
		list.add(new Member1("송혜교"));
		
		
		System.out.println(list);
		
		
		ArrayList<Member2> list2 = new ArrayList<>();
		list2.add(new Member2("홍길동","hong123","hong123"));
		list2.add(new Member2("성춘향","sung123","sung123"));
		list2.add(new Member2("고길동","kong123","kong123"));
		list2.add(new Member2("강감찬","kang123","kang123"));
		list2.add(new Member2("송혜교","song123","song123"));
		
		System.out.println(list2); //오버라이딩된 toString() 으로 출력됨 =>확인용 / 원하는 작업 하려면 for문 써야함
		
		System.out.println("size() : "+list2.size());
		
		
		for (int i = 0; i <list2.size(); i++) {
			Member2 member = list2.get(i);  //특정위치의 요소를 갖고오는 get으로
			System.out.println("id: "+member.getId()+", password: "+member.getPassword()+", name: "+member.getName());
		}
		
		
		// Iterator 인터페이스 : List,Set,Map 구조에서 요소를 꺼내 쓰는(접근하는) 방법에 대한 통일성 제공
		// hasNext() : 다음 요소가 존재한다면 true 
		// next() : 요소 가져오기 
		System.out.println();
		System.out.println("id    password  name");
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			Member2 member2 = (Member2) iterator.next();
			System.out.println(member2.getId()+"\t"+member2.getPassword()+"\t"+member2.getName());
		}
		
		
		System.out.println();
		for (Member2 member2 : list2) {
			System.out.println(member2.getId()+"\t"+member2.getPassword()+"\t"+member2.getName());
		}
		
		
		
		
		

	}

}
