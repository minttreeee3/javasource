package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Map 
 키(key) : 유일값
 값(value) : 중복 가능


*/
public class MapEx1 {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		
		
		//put() : 요소추가
		// key값이 동일하다면 나중에 추가한 요소만 남게됨 (덮어쓰기됨 
		map.put("myId1", "1234");
		map.put("myId2", "1234");
		map.put("myId3", "3645");
		map.put("myId4", "8653");
		
		System.out.println(map); 
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// key에 해당하는 id 입력받기
			// value에 해당하는 password 입력받기
			System.out.print("아이디 : ");
			String id = sc.nextLine().trim(); //공백은 제거하고 입력받음 / sc.nextLine()이거자체가 String이라서 바로 .trim부를수있음
			System.out.print("비밀번호 : ");
			String password = sc.nextLine().trim();			
			
			// map에 입력받은 id가 존재하지 않는 경우 "입력하신 아이디는 존재하지 않습니다. 다시 입력해 주세요" 메세지출력후 다시 id입력받기
			// containsKey(Object key) : HashMap에 키를 포함하고 있느냐? true/false 
			if(!map.containsKey(id)) {
				System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력해 주세요");
				continue; //아래 코드 건너뛰고 맨위로 다시 올라감 				
			} 
						
			// 입력받은 비밀번호가 일치하는지 확인한 후 
			// 비밀번호가 일치하면 프로그램 종료, 일치하지 않는 경우 "다시 입력해 주세요" 
			// get(Object key) : key의 value를 반환, 못찾으면 null
			if(!map.get(id).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요");
			} else {
				System.out.println("아이디와 비밀번호가 일치합니다");
				break;
			}
			
			
		}
		
		
		
		
		
		
	}

}
