package ch3;

import java.util.Scanner;

public class IfEx1 {

	/*조건문
	 * 조건식과 실행될 하나의 문장 또는 불럭으로 구성됨
	 * 종류 : if(주로 사용), switch
	 * 
	 * 
	 * 1.	if
	 * 2.	if
	 * 3.	if~else
	 * 4.	if~else if
	 */
	
	public static void main(String[] args) {
		
		//조건 : true/false 판별되어야 함
//		
//		if (조건) {
//			//블럭 실행 여부는 조건이 true 일때만
//		} 
		
//		if (조건) {
//			//true일때
//		}else {
//			//false일때
//		}
//		
//		//성적이 90이상A, 80이상B, 70이상C...
//		if (조건1) {
//			//조건true일때
//		}else if(조건2) {
//			//조건2true일때
//		else if(조건3)
//			//조건3 true일때
//		}
//
//	}
		
		//score가 60이상이면 합격 출력
//		int score=88;
//		
//				if (score>=60) {
//					System.out.println("합격");
//				}
//		
//			
//		
//		
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("'안상민 키'입력 ");
		
		int score = Integer.parseInt(sc.nextLine());
		
		
		if (score>=190) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		System.out.print("몸무게는? ");
		
		int jum =Integer.parseInt(sc.nextLine());
		String grade=" ";
		
		if (jum>=90) { 
			grade="Great";
		}else if (jum>=80) {
			grade="Good";
		} else if (jum>=70) {
			grade="Soso";
		}else if (jum>=60) {
			grade="Bad";
		}else if (jum>=50) {
			grade="So bad";
		}
		System.out.printf("몸무게 : %d, 등급 :%S\n",jum,grade);
		
		
		
		sc.close();
		
		
		
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

