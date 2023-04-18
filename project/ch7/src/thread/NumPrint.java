package thread;

public class NumPrint implements Runnable { // Runnable은 인터페이스 - 상속은 한개밖에못하니까 이미 상속을 사용한 경우엔 Runnable 사용 
	
	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.print(i);
		}
		
	}

}
