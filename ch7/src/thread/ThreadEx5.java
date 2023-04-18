package thread;

public class ThreadEx5 {

	public static void main(String[] args) {
		
		
		CalcThread t1 = new CalcThread();
		CalcThread2 t2 = new CalcThread2();
		
		// 우선순위 : 숫자가 높을수록 우선순위가 높음, 최대 우선순위는 10, main에서 생성한 쓰레드는 자동적으로 5		
		t2.setPriority(7);
		
		System.out.println("t1 우선순위 "+t1.getPriority());
		System.out.println("t2 우선순위 "+t2.getPriority());
		
		t1.start();
		t2.start();



	}

}
