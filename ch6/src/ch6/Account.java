package ch6;

public class Account {
	
	//속성
	//계좌번호
	//계좌주
	//잔액
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
		if(balance>amount) {
			balance -= amount; 			
		} 
		return balance;
	}
	

}
