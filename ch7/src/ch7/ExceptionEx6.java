package ch7;

public class ExceptionEx6 {

	public static void main(String[] args) {
		
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} finally {
			//예외와 상관없이 항상 수행되어야 하는 구문 작성
			System.out.println("반드시 실행");
		}
		
		try {
			
		} finally {
			//예외와 상관없이 항상 수행되어야 하는 구문. catch는 있어도 없어도 되지만 finally는 항상 마지막에
		}
	}

}
