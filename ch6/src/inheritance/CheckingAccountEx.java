package inheritance;

public class CheckingAccountEx {

	public static void main(String[] args) {
		
		CheckingAccount checkingAccount = new CheckingAccount("110-11", "홍길동", 100000, "3333-5555");
		
		//카드번호가 다를 때
		checkingAccount.pay("222-3333", 50000);
		
		//카드번호 동일
		checkingAccount.pay("3333-5555", 50000);
		

	}

}
