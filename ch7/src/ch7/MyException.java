package ch7;

// 사용자 정의 예외 작성 



public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}
	
	

}
