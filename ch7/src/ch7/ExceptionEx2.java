package ch7;

/*




*/
public class ExceptionEx2 {

	public static void main(String[] args) {
		
		//  java.lang.ArithmeticException: / by zero
		
		
		try {
			System.out.println(3/0);
		} catch (Exception e) {
			// e.printStackTrace(); //개발시 자주쓰는코드 - 예외가 발생하는 구문을 추적해서 출력함 
			//System.out.println("0으로 나눌 수 없습니다");
			System.out.println(e.getMessage()); //예외발생시 자바가 제공하는 기본메세지 출력 
		}

	}

}
