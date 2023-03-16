package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GenericsEx3 {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("강백호", 1, 1));
		list.add(new Student("서태웅", 1, 2));
		list.add(new Student("정대만", 1, 3));
		list.add(new Student("채치수", 1, 4));
		
		//List, Set, Map 구조에서 요소에 접근하는 통일된 방법
		Iterator<Student> it = list.iterator();
		
		while (it.hasNext()) {
			// Student student = (// Student) it.next(); //이런 형변환 필요없음 위에서 지네릭스 써서
			Student student = it.next(); 
			System.out.println(student.getName());
		}
		
		
		HashMap<String, Student> map = new HashMap<>();
		map.put("stu1",new Student("강백호", 1, 1));
		map.put("stu2",new Student("서태웅", 1, 2));
		map.put("stu3",new Student("정대만", 1, 3));
		

	}

}
