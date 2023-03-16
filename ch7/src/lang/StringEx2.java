package lang;

import java.util.Arrays;

public class StringEx2 {

	public static void main(String[] args) {
		// String 생성자
		
		// new String(char value[])
		char c[] = {'H', 'e', 'l', 'l', 'o'};
		String str1 = new String(c);
		System.out.println();
		
		String str2 = "Hello";
				
		//length() :
		System.out.println("length() : 문자열 길이 "+str1.length());
		
		// charAt()
		// str1.chartAt(0) : char 호출 시 int 매개변수를 넣어서 호출하고 결과값은 char을 받는다.
		System.out.println(str2.charAt(0));
		System.out.println(str1.charAt(str1.length()-1));
		
		
		String str3 = "자바 프로그래밍";
		//str3 문자열에 '프' 문자가 들어있는지 확인 : length(), charAt()으로
		
		
		for (int i = 0; i < str3.length(); i++) {
			if(str3.charAt(i)=='프') {
				System.out.println("프가 들어있음");
				break;
			} 
		}
		
		
		int cnt=0; //프 문자 갯수를 세는 변수
		for (int i = 0; i < str3.length(); i++) {
			if(str3.charAt(i)=='프') {
				cnt++;
			} 
		}		
		System.out.println(cnt>0 ? "프가 들어있음" : "");
		
		
		
		
		// indexOf(int ch) : 주어진 문자 ch가 문자열에 들어있는지 확인하고 위치를 리턴(0부터 시작, 못찾으면 -1리턴) 
		// String str2="Hello";
		System.out.println("indexOf(int ch) : " +str2.indexOf('o'));  // =>4
		System.out.println("indexOf(String str) : " +str2.indexOf("llo"));  // =>2 (시작위치가 나옴) 
		System.out.println("indexOf(int ch, int fromIndex) : " +str2.indexOf('e',0));  // =>0번위치에서 시작해서 e를찾음 1   
		System.out.println("indexOf(int ch, int fromIndex) : " +str2.indexOf('e',2));  // 못찾아서 -1 
		
		//lastIndexOf() : 위치를 찾을 때 오른쪽 끝부터 찾음
		System.out.println("lastIndexOf(int ch) : "+str2.lastIndexOf('l'));
		
		
		
		//str3문자열에 '프' 문자가 들어있는지 확인 : indexOf() 사용해서		
		System.out.println(str3.indexOf('프')!=-1 ? "프가 들어있음" : "");
		
		
		// subString() : 범위에 해당하는 문자열 얻기 
		String ssn = "880515-1553448";
		// subString(int beginIndex)
		String result = ssn.substring(3); 
		System.out.println(result);
		// subString(int beginIndex, int endIndex) :endIndex 미포함
		System.out.println("subString(int beginIndex, int endIndex) "+ssn.substring(3, 8)); //3까지자르고 4부터8까지 나옴 
		
		// concat() : String을 더하기 할때 
		String result2 = str2.concat(" 안녕하세요");
		System.out.println(result2);
		
		
		// startsWith(String prefix) : prefix로 시작하냐 true/false
		String str4 = "java.lang.Object";
		System.out.println("startsWith(Stirng prefix) : "+ str4.startsWith("java"));
		System.out.println("startsWith(Stirng prefix) : "+ str4.startsWith("lang"));
		System.out.println("startsWith(Stirng prefix,int toOffset) : "+ str4.startsWith("lang",5));
		
		// endsWith(String suffix) : suffix로 끝나냐
		
		// contains(CharSequence s) : s문자열이 포함되어 있느냐 
		System.out.println("contains(CharSequence s) "+str2.contains("Hello"));
		
		// replace(원본문자열, 변경문자열) 
		String str5 = "자바는 객체지향 언어입니다. 자바는 풍부한 API를 제공합니다.";
		System.out.println(str5.replace("자바", "java")); 
		System.out.println(str5); // String은 변경이 불가능해서 replace 썼어도 원본은 안바뀜
		
		str5 = str5.replace("자바", "java"); //이렇게 새로운 문자열로 리턴되는값을 다시 담아줘야 원본문자열이 바뀜
		System.out.println(str5);
		
		System.out.println(str2.replace('H', 'h'));
		
		//replaceFirst(String regex, String replacement) : 첫번째것만 변경
		System.out.println(str5.replaceFirst("java", "자바"));
		
		
		
		// trim() : 양쪽 공백 제거 (중간공백은 제거못함)  - 공백도 문자다
		String str6 = "   	Hello World     ";
		System.out.println(str6.length());
		System.out.println(str6.equals("Hello World"));
		System.out.println("trim() : " +str6.trim());
		
		
		// static 메서드 => 클래스이름.메소드명 으로 부름
		// static String valueOf() : 지정된 값을 문자열로 변환하여 반환시켜줌. 대부분의 형태로 넣어도되는데 반환값은 전부 String 
		System.out.println(String.valueOf(true));  // "true" 를 돌려줌 
		
		
		// 100을 문자열로 변경
		int a =100;
		String str7 = a + "";
		System.out.println(str7);
		//혹은
		System.out.println(String.valueOf(100));
		// "100"을 다시 숫자 100으로 변경 => Integer.parseInt("100")
		
		
		// toLowerCase() / toUpperCase() : 모든 문자열을 소문자로 / 대문자로 변경 
		System.out.println("toLowerCase() : " +str2.toLowerCase());
		System.out.println("toUpperCase() : " +str2.toUpperCase());
		
		
		
		// split(String regex) : 특정 기호 가지고 분리하는거, 배열로 리턴됨 
		// regex : Regular expression(정규 표현식) : 특정한 규칙을 가진 문자열의 집합 
		String animals = "dog,cat,bear,tiger";
		String[] arr = animals.split(",");
		System.out.println(arr); //주소만 나옴
		
		//배열이 제대로 안찍히면 for문 쓰면됨 - 원하는형태로 출력가능 
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//아니면
		System.out.println(Arrays.toString(arr));  //[dog, cat, bear] =>확인용 
		
		
		// split(String regex, int limit) : regex로 나누되 limit의 갯수로 나눔 
		arr = animals.split(",", 2);  
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		// compareTo(String anotherString) : 문자열 비교 (사전순서) : 같으면0, 사전순으로 이전이면 음수, 이후면 양수, 첫번째문자 비교후 같으면 두번째문자 비교 
		System.out.println("aaa".compareTo("aaa")); //0
		System.out.println("aaa".compareTo("bbb")); //-1
		System.out.println("ccc".compareTo("aaa")); //2
		
		
		// split(0 <-> join() 
		// join() : 특정 문자열(구분자)로 결합 / static메소드 
		arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		String str8 = String.join("-", arr);
		System.out.println("join() : "+str8);

	}

}
