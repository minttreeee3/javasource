package inheritance;

public class BonusPointAccount extends Account {	//extends 다음에 하나밖에 못옴 (단일상속) 
	//은행 + 보너스포인트 기능
	//보너스포인트 = 예금액 * 1%
	private int bonusPoint;

	public BonusPointAccount(String ano, String owner, int balance, int bonusPoint) {
		super(ano, owner, balance);
		this.bonusPoint = bonusPoint;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//예금기능 오버라이딩에 기능추가
	//보너스포인트 += 예금액*1%
	@Override
	public void deposit(int amount) {
		//예금하다
		super.deposit(amount);
		
		//보너스포인트 += 예금액 *1%
		this.bonusPoint += amount * 0.01;
		
		
	}
	
	
	
	
	//마우스오른쪽 - source - getters setters 
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	
	
	

}
