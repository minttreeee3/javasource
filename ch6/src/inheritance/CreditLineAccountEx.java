package inheritance;

public class CreditLineAccountEx {

	public static void main(String[] args) {
		CreditLineAccount creditLineAccount = new CreditLineAccount("110-11", "홍길동", 100000, 500000);
		
		//금액이 큰 경우
		System.out.println("사용액 : "+creditLineAccount.withdraw(6000000));
		System.out.println("잔액 : "+creditLineAccount.getBalance());
		
		
		System.out.println();
		
		//금액이 적은 경우
		System.out.println("사용액 : "+creditLineAccount.withdraw(400000));
		System.out.println("잔액 : "+creditLineAccount.getBalance());

	}

}
