package ch4;

import java.util.Scanner;

public class WhileEx5 {

	public static void main(String[] args) {
		
		boolean run=true;
		
		int balance=0; //잔액 변수
		int amount=0; //금액 변수
		
		Scanner sc = new Scanner(System.in);
						
		
		while (run) {
			
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔액 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("메뉴 선택 >> ");
			
			int menu = Integer.parseInt(sc.nextLine());
						
			
			switch (menu) {
			
			case 1:
				//예금액 입력받기
				//잔액 = 잔액+예금액
				//현재 잔액 출력
				System.out.print("예금액 입력 >> ");
				amount = Integer.parseInt(sc.nextLine());
				balance=balance+amount;
				
				// balance += Integer.parseInt(sc.nextLine()); 이렇게 줄여서 쓸 수 있음
				
				System.out.println("현재 잔액 : "+balance);
				break;
				
			case 2:
				//출금액 입력받기
				//잔액 = 잔액-출금액
				System.out.print("출금액 입력 >> ");
				amount  = Integer.parseInt(sc.nextLine());
				balance=balance-amount;
				System.out.println("현재 잔액 : "+balance);				
				break;
				
			case 3:
				System.out.println("현재 잔액 : "+balance);
				break;
				
			case 4:
				run=false;
				break;

			default:
				break;
			}
			
		}
		
	}

}
