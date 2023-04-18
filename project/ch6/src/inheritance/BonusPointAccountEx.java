package inheritance;

public class BonusPointAccountEx {

	public static void main(String[] args) {
		
		BonusPointAccount bonusPointAccount = new BonusPointAccount("110-11", "홍길동", 10000, 100);
		
		//예금액 : 100000
		//현재보너스포인트 : 10점
		
		
		//예금
		int amount = 100000; 
		bonusPointAccount.deposit(amount);
		
		System.out.println("예금액 : "+amount);
		System.out.println("현재 보너스 포인트 : "+bonusPointAccount.getBonusPoint());
		
		
		

	}

}
