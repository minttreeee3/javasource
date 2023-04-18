package lang;

/* 자바에서 문자열 다루기
1) String
2) StringBuffer : 원본 문자열 변경 가능 / 멀티쓰레드 안전
3) StringBuilder : 원본 문자열 변경 가능 / StringBuffer랑 똑같은데 멀티쓰레드 부분만 제거된 클래스


*/
public class StringBufferEx1 {

	

	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer(); // initial capacity of 16 characters : 버퍼의 크기가 16
		StringBuffer sb2= new StringBuffer(100); // 버퍼의크기가 100
		StringBuffer sb3= new StringBuffer("Hello"); // 버퍼의 크기는 문자열 길이만큼
		
		// StringBuffer sb4 = "Hello"; //이건안됨
		System.out.println(sb2); //버퍼안의 내용이 없음
		System.out.println(sb3);
		
		
		
		//append() : 원본 문자열 뒤에 계속 추가 
		sb2.append(false).append("abc").append('d');
		System.out.println(sb2);
		
		//equals는 오버라이딩 안되어있음 - 주소비교로 사용됨 
		StringBuffer sb4 = new StringBuffer("Hello");
		System.out.println("equals() : "+ sb3.equals(sb4));
		
		//값비교를 해야 한다면 => String으로 변경 
		String str1 = sb3.toString(); 
		
		
		// delete(int start, int end) : 시작위치에서 끝위치-1 사이의 문자를 제거
		StringBuffer sb5 = new StringBuffer("0123456");
		StringBuffer sb6 = sb5.delete(3, 6);
		System.out.println(sb6); //0126
		System.out.println(sb5); //0126 =>원본이 바뀜(스트링버퍼라서) 
		
		// deleteCharAt(int index) : index(위치)의 문자 제거 -순서는 항상 0부터시작 
		sb5 = new StringBuffer("123456");
		sb6 = sb5.deleteCharAt(4);
		System.out.println(sb6);
		
		
		// insert(int offset, String str) : offset 위치에 str삽입 
		sb5.insert(4, "-");
		System.out.println(sb5);
		
		
		// replace(int start, int end, String str)
		sb5 = new StringBuffer("0123456");
		sb5.replace(3, 6, "ABC");
		System.out.println(sb5);
		
		
		
		String str2 = "0123456789";
		//출력을 거꾸로 		
		for (int i = str2.length()-1; i >=0 ; i--) {
			System.out.print(str2.charAt(i));
		}
		
		sb5 = new StringBuffer(str2);
		System.out.println(sb5.reverse());  //reverse메소드는 버퍼에만있음 
		
		
		
		//setCharAt(int index, char ch) : index 자리에 ch하나 넣음 
		sb5 = new StringBuffer("0123456");
		sb5.setCharAt(4, 'A');
		System.out.println(sb5);
		
		
		
	}

}
