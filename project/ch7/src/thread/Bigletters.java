package thread;


// Thread 작성 
public class Bigletters extends Thread {
	
	@Override
	public void run() {
		// 같이 수행할 코드 작성 
		// a~z 출력				
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		
		
	}

}
