package ch7;

public class ExceptionEx4 {

	public static void main(String[] args) {
		//참조형 초기화
		//null : 아직 값이 할당되지 않았음
		
		String data = null;
		Account account = null;  //클래스 		
		int[] arr = null;  // int arr[] = new int[5] 까지는 했어야 할당이 됨 - NullPointerException안남 
		//NullPointerException 에러 나면 데이터 변수 = 다음에 뭘 안해서...
		
		System.out.println(data);
		System.out.println(account);
		System.out.println(arr);
		
		//java.lang.NullPointerException  -참조변수가 가리키고 있는 곳을 접근 시
		
		System.out.println(arr[0]);
		System.out.println(data.length());

	}

}
