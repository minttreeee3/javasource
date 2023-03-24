package ch3;

import java.util.Scanner;

public class IfEx4 {
	public static void main(String[] args) {
		//근무시간 입력받기
		//8시간 근무시 시급9800
		//초과근무수당 1.5배
//		Scanner sc=new Scanner(System.in);
//		
//		
		
		//키,몸무게 입력받기
		//저체중,표준,과체중 출력하는 프로그램 작성
		
		//(키-100)*0.9 <몸무게 :과체중
		//(키-100)*0.9 =몸무게 :표준
		//(키-100)*0.9 >몸무게 :저체중
		//if~else if, if~else if~else
		
//		System.out.print("키를 입력하시오 : ");
//		int hight=Integer.parseInt(sc.nextLine());
//				System.out.print("몸무게를 입력하시오 : ");
//		int weight=Integer.parseInt(sc.nextLine());
//		
//		String rate= " ";
//		if ((int)(hight-100)*0.9<weight) {
//			rate="과체중";
//		}else if ((int)(hight-100)*0.9==weight) {
//			rate="표준";
//		}else {
//			rate="저체중";
//		}
//		
//		double result = Double.parseDouble(sc.nextLine());
//		
//		System.out.println("당신은 : "+rate);
//		
//		
		
//		//윤년,평년 구하기
//		System.out.println("연도를 입력 : ");
//		int year=Integer.parseInt(sc.nextLine());
//		//윤년 : 연도를 4로 나눈 나머지가 0 이고 연도를 100으로 나눈 나머지가 0이 아니거나 연도를 400으로 나눈 나머지가 0이면 윤년
//		String 올해는=" ";
//		if ((year%4==0)&&(year%100!=0)||(year%400==0)) {
//			System.out.println("올해는=윤년")	;
//		}else {
//			System.out.println("올해는=평년");
//		}
//		
//		
		
//		임의의 숫자3개 입력받기
		
		Scanner sc=new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하시오 ");
		int num1=Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력하시오 ");
		int num2=Integer.parseInt(sc.nextLine());
		System.out.print("세번째 숫자를 입력하시오 ");
		int num3=Integer.parseInt(sc.nextLine());
		
		
////		입력받은 3개의 숫자 중 가장 작은 수 출력하기
//		if (num1<num2&&num1<num3) {
//			System.out.println("첫번째 수");
//		}else if (num2<num1&&num2<num3) {
//			System.out.println("두번째 수");
//		}else {
//			System.out.println("세번째 수");
//		}
//		//num1<num2&&num1<num3
//		//num2<num1&&num2<num3
//		//num3<num1&&num3<num2
//		
//		
		
//		가장 큰 수
		int max=num1;
		if (max<num2) {
			max=num2;	
		} if (max<num3) {
			max=num3;
		}
		System.out.println("가장 큰 수는 "+max);
		
//		int min=num1;
//		if (min>num2) {
//			min=num2;
//		}else if (min>num3) {
//			min=num3;
//		}
//		System.out.println("가장작은 수"+min);
//		
//		
		sc.close();
		
		
		
		
		
		
		
		
		
		
		
			
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

