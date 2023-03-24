package ch5;

public class ArrayEx3 {

	public static void main(String[] args) {

		// [] : 1차원 배열
		// [][] : 2차원 배열(행,열)
		
		// int[] score; 이렇게해도됨
		int score[]= {100,88,100,100,90};
		
		//배열 총합과 평균
		int sum=0;
		float average=0f;
		
		for (int i = 0; i < score.length; i++) {
			sum+=score[i];
			
		}
		average = sum / (float)score.length;  //float로 변환시켜야. 478/5.0이 돼서 소수점까지 결과가 출력됨
		
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+average);
		
		
		
		
		
		
	}

}
