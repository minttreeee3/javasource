package ch7;

public class Account {
	
	
		//속성
		String accountNo;
		String owner;
		int balance;
		
		
		
		
			
		public Account(String accountNo, String owner, int balance) {
			super();
			this.accountNo = accountNo;
			this.owner = owner;
			this.balance = balance;
		}


		//기능
		//예금하다(deposit): 현재 잔액 = 잔액 +예금액, 현재 잔액 리턴
		//인출하다(withdraw): 잔액>출금액, 현재 잔액=잔액-출금액, 현재 잔액 리턴
		
		int deposit(int amount) {
			balance += amount;  // balance=balance+amount; 
			return balance;
		}
		
		
		int withdraw(int amount) {
			if(balance < amount) {
				//throw new RuntimeException("잔액부족");
				throw new BalanceInsufficientExcetion("잔액부족");
			} 
			balance -= amount; 			
			return balance;
		}

}
