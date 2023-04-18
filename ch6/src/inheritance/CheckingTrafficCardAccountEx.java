package inheritance;

public class CheckingTrafficCardAccountEx {

	public static void main(String[] args) {
				
		
		CheckingTrafficCardAccount checkingTrafficCardAccount = new CheckingTrafficCardAccount("110-22", "성춘향", 100000, "2222-3333", false);
		CheckingTrafficCardAccount checkingTrafficCardAccount2 = new CheckingTrafficCardAccount("110-33", "홍길동", 100000, "2222-4444", true);
		
		
		
		//교통카드 기능이 없을 때
		checkingTrafficCardAccount.payTrafficCard("2222-3333", 2500);
				
		//교통카드 기능이 있을 때, 카드번호 일치x
		System.out.println(checkingTrafficCardAccount2.payTrafficCard("6666-5555", 1000));
		
		//교통카드 기능이 있을 때, 카드번호 일치
		System.out.println(checkingTrafficCardAccount2.payTrafficCard("2222-4444", 1000));
		
		//교통카드 기능이 있을 때, 잔액 부족
		System.out.println(checkingTrafficCardAccount2.payTrafficCard("2222-4444", 200000));
				
				
				
		
				

	}

}
