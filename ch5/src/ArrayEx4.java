package ch5;

public class ArrayEx4 {

	public static void main(String[] args) {

		int score[]= {79,88,91,33,100,55,95};
		
		//최대값과 최소값
		
		int max = score[0];   //첫번째값으로
		int min = score[0];
		
		for (int i = 1; i < score.length; i++) {
			
			if (max<score[i]) {
				max=score[i];
			}
			if (min>score[i]) {
				min=score[i];
			}
						
		}
		System.out.println("최대값은 "+max);
		System.out.println("최소값은 "+min);
		
		
		
	}

}
