package thread;


// Thread 작성 
public class Smallletters extends Thread {
	
	@Override
	public void run() {
		// 같이 수행할 코드 작성 
		// a~z 출력				
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
		}
		
		
	}

}
