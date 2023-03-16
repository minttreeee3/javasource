package exam;

import java.util.Scanner;

public class CalcEx {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input Num1 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("Input Num2 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("Input operator : ");
		String op = sc.nextLine();
		
		
		Calc calc = null;
		
		switch (op) {
		
		case "+":
			calc = new Add();  //왼쪽은 부모, 오른쪽은 자식의 형태가 올수있어서 (feat.다형성) 코드가 간단해짐 
			break;		
		case "-":
			calc = new Sub();
			break;
		case "*":
			calc = new Mul();
			break;
		case "/":
			calc = new Div();
			break;
		}
		calc.setValue(num1, num2);  //setValues는 부모가 갖고있음
		System.out.println("결과 "+calc.calculate());  //calculate는 오버라이딩돼서 각자 다들 갖고있음
		
		

	}

}
