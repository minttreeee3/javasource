package ch3;

import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {
		// +,-,*,/,%
		
		// 사용자로부터 두개의 피연산자와 연산자를 입력받기
		// 연산을 수행한 후 출력
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자1 입력: ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("연산자를 입력: ");
		String op = sc.nextLine();
		
		System.out.println("숫자2 입력: ");
		int num2 = Integer.parseInt(sc.nextLine());
		

		int result=0;
		switch (op) {
		case "+":
			result=num1+num2;
			break;
		case "-":
			result=num1-num2;
			break;
		case "*":
			result=num1*num2;
			break;
		case "/":
			result=num1/num2;
			break;
		default:
			result=num1%num2;
			break;

		}
		System.out.printf("%d %s %d = %d",num1,op,num2,result);

	}

}
