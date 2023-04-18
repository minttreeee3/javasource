package ch6;

public class Numbers {
	
	int num[];
	
	public Numbers(int[] num) {
		super();
		this.num = num;
	}
	
	//배열 총합
	int getTotal() {
		int sum=0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;
	}
	
	//배열 평균
	int getAverage() {
		return getTotal()/num.length;   //다른메소드의 결과를 받아다가 쓸 수 있음, 같은 클래스 내라서 그냥 이름만 쓰면 됨 
	}

}
