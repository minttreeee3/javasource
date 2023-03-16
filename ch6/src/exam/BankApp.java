package exam;


import java.util.Scanner;
//private : 외부 클래스에서 호출 불가 ==>내부에서만 사용하겠음

public class BankApp {
	//인스턴스 변수(초기화 완료)
	private static Account[] accountArray = new Account[10];  //Account 객체배열 10개 선언,생성
	private static Scanner scanner = new Scanner(System.in);  //사용자 입력을 위한

	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택 >> ");
			
			// sc.nextLine(); String타입으로 입력값을 처리
			// scanner.nextInt(); int타입으로 입력값을 처리
			int selectNo = Integer.parseInt(scanner.nextLine()); //nextInt();는 딱 숫자만 갖고가기땜에 엔터를입력하면 남아있다가 밑에 nextLine에서 실행돼버림
			
			switch (selectNo) {
			case 1:		
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				//while문 종료하는 코드
				run = false;
				break;
								

			default:
				break;
			}
		} //while종료

	} //main종료
	
	
	
	private static void createAccount() {
		//계좌생성
		//Account 인스턴스를 생성하기 위한 값을 입력받기 - 배열에
		
		System.out.print("계좌번호 >> ");
		String ano = scanner.nextLine();		
		System.out.print("예금주 >> ");
		String owner = scanner.nextLine();			
		System.out.print("잔액 >> ");
		int balance = Integer.parseInt(scanner.nextLine());	
		
		//for문을 돌려서 i에 해당하는 배열 초기값이 null이면 수행(한번만 수행하고 break) 
		for (int i = 0; i < accountArray.length; i++) {									
			if(accountArray[i]==null) {											
				accountArray[i] = new Account(ano, owner, balance);
				System.out.println("계좌가 생성되었습니다.");
				break;			
			} 				
		}
	}
	
	
	
	private static void accountList() {
		//accountArray에 있는 내용 - 생성된 계좌 정보 출력 (null이 아닌 경우만)
		
		System.out.println();
		System.out.println("계좌목록");
		System.out.println("--------------------------");
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i]!=null) {
				//private으로 작성했기땜에 .ano로는 못하고 public으로받았던 .getAno사용
				System.out.printf("%s \t %s \t %d\n",accountArray[i].getAno(),accountArray[i].getOwner(),accountArray[i].getBalance());
			}
		}
		
	}
	
	
	
	
	private static void deposit() {
		//예금하다 - 계좌번호, 예금액 입력받기
	
		
		System.out.print("계좌번호 >> ");
		String ano = scanner.nextLine();				
		System.out.print("예금액 >> ");
		int amount = Integer.parseInt(scanner.nextLine());	
		
		//accountArray에서 일치하는 계좌를 찾아 (null이 아닌 계좌를 돌면서 일치하는지 확인) 잔액 = 잔액+예금액
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i]!=null) { 
				if(accountArray[i].getAno().equals(ano)) {
					//private가 아니었다면  accountArray[i].balance += amount; 					
					accountArray[i].setBalance(accountArray[i].getBalance() + amount);					
				}				
			} 
		}
		
	}

	
	
	private static void withdraw() {
		//출금
		
		System.out.print("계좌번호 >> ");
		String ano = scanner.nextLine();				
		System.out.print("출금액 >> ");
		int amount = Integer.parseInt(scanner.nextLine());	
		
		//accountArray에서 일치하는 계좌를 찾아 (null이 아닌 계좌를 돌면서 일치하는지 확인) 잔액 = 잔액-출금액
		for (int i = 0; i < accountArray.length; i++) {
			if(accountArray[i]!=null) { 
				if(accountArray[i].getAno().equals(ano)) {
					//private가 아니었다면  accountArray[i].balance -= amount; 
					accountArray[i].setBalance(accountArray[i].getBalance() - amount);
				} 				
			}		
		
		}

		
		
		
		
	}
	
}
	