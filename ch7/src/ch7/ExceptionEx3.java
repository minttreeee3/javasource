package ch7;

public class ExceptionEx3 {

	public static void main(String[] args) {
		
		// System.out.println(args[0]); => java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds 배열인덱스오류
		
//		if(args.length==1) {
//			System.out.println(args[0]);
//		} else {
//			System.out.println("실행방법 확인");
//		}
//		
		
		try {
			//java.lang.ArrayIndexOutOfBoundsException
			System.out.println(args[0]);
			
			//java.lang.ArithmeticException		//예외마다 다르게 출력하려면
			System.out.println(3/0);
			
		} catch (ArrayIndexOutOfBoundsException e) {	//부모부터 점점 아래로 
			System.out.println("실행방법 확인");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
		} catch (Exception e) {
			System.out.println("실행방법 확인");
		}

	}

}
