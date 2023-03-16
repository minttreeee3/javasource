package lang;

public class StringEx4 {

	public static void main(String[] args) {
		
		
		String names[] = {"Queen","Tod","Park","Kim","Hong"};
		System.out.println(findKim(names));
		// 출력결과
		//김씨 성은 4번째에 있다


	}
	
	public static String findKim(String[] seoul) {
		int index = 0; //Kim이 있는 위치를 저장할 변수
		
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				index = i+1;
				break; 
			}
		}
		return "김씨 성은 "+ index +"번째에 있다";
		
	}



}
