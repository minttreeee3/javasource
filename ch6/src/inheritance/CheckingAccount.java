package inheritance;

public class CheckingAccount extends Account {
	
	
	private String cardNo; //체크카드 번호
	
	
	
	
	//은행계좌 + 체크카드 기능 추가

	public CheckingAccount(String ano, String owner, int balance, String cardNo) {
		super(ano, owner, balance); //부모 인자
		this.cardNo = cardNo; 
	}
	
	
	
	//체크카드 사용액을 지불한다
	//카드번호, 사용액을 매개변수로 받아서 은행잔고보다 작은 경우 사용액을 지불 
	//카드번호 일치하는지 확인
	//은행잔고보다 사용액이 크거나, 카드번호가 일치하지 않으면 지불불가 메세지 출력 
	
	//pay(cardNo, amount...), 잔액을 리턴
	
		int pay(String cardNo, int amount) {
		//카드번호가 일치하지않거나 잔액이 사용액보다작을경우 지불불가메세지 출력 ->하면 여기서 끝내야하기땜에 return (int로받아야해서도 return 0; 필요함)
		if(!this.cardNo.equals(cardNo) || getBalance()<amount) {   //balance바로못씀 private라서,내꺼아니라서... 
			System.out.println("카드번호나 잔액을 확인해 주세요");
			return 0;
		}
		//잔액 = 잔액-사용액
//		setBalance(getBalance()-amount);
//		System.out.println("사용액 지불 후 잔액 "+getBalance());
//		return getBalance();
		
		//부모의 메소드를 호출할수도있음
		return withdraw(amount);
				
		
	}
	
	
	
	
	

}
