package ch5;

/* 배열 (array)
 * 같은 타입의 여러 변수를 하나의 묶음으로 다루는 방법
 * int score1=98, score2=88,.....; 
 * 
 * ==> int score[]; //배열 선언
 * ==> score = new int[30]; //배열 생성



*/
public class ArrayEx1 {

	public static void main(String[] args) {

		//연속된 공간에 int값을 저장할 수 있는 30개의 공간을 생성
		//index를 이용해서 접근할 수 있음
		//int타입은 0으로 초기화됨 
		int score[]=new int[30];
		
		System.out.println(score[0]); //0~29 인덱스로 접근
		System.out.println(score[15]); //0~29 인덱스로 접근
		
		//새로운 값을 할당
		score[0]=98; 
		score[1]=88;
		
		//배열선언,생성,초기화 한번에 하기
		int score2[]= {98,88,78,65,86,79,89,66,77,87};
		System.out.println("5번째 학생 점수 "+score2[4]);  //순서가 0부터 시작함
		
		
		double score3[]= {98.3,88.1,78.2,65,86.88,79,89,66,77,87};
		for (int i=0; i<score3.length; i++) {
			System.out.println((i+1)+"번째 학생 점수: "+score3[i]);
		}
		
		//char 5개를 담는 배열
		char chArr[]= {'a','b','c','d','e'};
		
		//byte,char,short,int,long,float,double,boolean ==>배열 타입 가능
		String strArr[]= {"abc","efg"};
		
		//java.lang.ArrayIndexOutOfBoundsException
		// System.out.println(strArr[2]); => 0부터시작이라서 1번까지밖에없음 2입력하면오류남
		
		

		
		
	}

}
