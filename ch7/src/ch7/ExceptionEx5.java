package ch7;

public class ExceptionEx5 {

	public static void main(String[] args) {
		int arr[] = new int[0];
		try {
			getAverage(arr);
		} catch (Exception e) {
			// e.printStackTrace();
			// 예외 메세지만 출력
			System.out.println(e.getMessage());
		}
		

	}
	// getAverage메서드에 예외 선언 
	// getAverage를 호출하면 예외가 발생할 수 있다는 뜻 
	static double getAverage(int arr[]) throws Exception {
		if(arr.length==0) {
			//강제로 예외 발생
			//Exception 클래스 사용 시 컴파일시 예외
			throw new Exception("비어있는 배열입니다.");
			//RuntimeException사용시 실행시 예외
			//throw new RuntimeException("비어있는 배열입니다.");
			
		}
		
		return getTotal(arr)/arr.length;
	}
	static int getTotal(int arr[]) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}

}
