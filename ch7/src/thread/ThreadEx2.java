package thread;

public class ThreadEx2 {

	public static void main(String[] args) {


		Thread t1 = new Bigletters();
		Smallletters t2 = new Smallletters();
		
		Runnable r = new NumPrint();
		Thread t3 = new Thread(r); 	//Runnable은 .start가 없어서 바로 못함 
//		Thread t3 = new Thread(new NumPrint());  합치면
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
