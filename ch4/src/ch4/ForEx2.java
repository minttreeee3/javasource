package ch4;

import java.util.Scanner;

public class ForEx2 {

	public static void main(String[] args) {
		
		//주사위 5번 던지기
		
		//int dice1=(int)(Math.random()*6)+1; =>5번반복
		
//		for (int i = 0; i < 5; i++) {
//			int dice1=(int)(Math.random()*6)+1;
//			System.out.println(dice1);
//		}
//		
//		//구구단 출력
//		
//		for (int i=1; i<=9; i++) {
//			System.out.printf("5 * %d = %d\n",i,(5*i));		
//		}
//		
//		System.out.println();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("출력을 원하는 단을 입력하세요");
//		int num1 = Integer.parseInt(sc.nextLine());
//		
//		for (int i=1; i<=9; i++) {
//			System.out.printf("%d * %d = %d\n",num1,i,(num1*i));
//		}
//		
		
		//1~100중에서 3의배수와 5의배수 합 구하기
		
		int sum=0;
		for (int i=1; i<=100; i++) {
			//i가 3의 배수인지 or 5의 배수인지 확인
			if(i%3==0 || i%5==0) {
				sum+=i; 
			}				
		}
		System.out.println("3과 5의 배수의 합 =" +sum);
		
		
		
		//3의 배수 합 (단, 9의 배수는 빼기)
		//sum변수 그대로 사용
		
		sum=0;
		for (int i=1; i<=100; i++) {
			if(i%3==0 && i%9!=0) {
				sum+=i;
			}
		}
		System.out.println("3의 배수 합(단 9의배수는 아님)=" +sum);
		
		
		
		
		
	}

}
