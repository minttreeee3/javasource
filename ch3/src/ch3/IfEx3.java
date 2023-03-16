package ch3;

import java.util.Scanner;

public class IfEx3 {
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("숫자를 입력하시오 ");
		
		int num1 = Integer.parseInt(sc.nextLine());
		
		String result1 = num1%2==0?"짝수":"홀수";
		System.out.println(result1);
		String result = " ";
		
		if (num1%2==0) {
			result="짝수";
		}else {
			result="홀수";
		}System.out.println(result);
		
		
		
		sc.close();
		
		
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

