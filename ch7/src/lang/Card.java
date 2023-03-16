package lang;

public class Card {
	
	String kind;
	int number;
	
	public Card() {		//기본생성자 - new Card();를 생성하면 무조건 스페이드1이 됨 
		this("SPADE",1);
	}
	
	public Card(String kind, int number) {		//매개인수를 받는 생성자 - new Card("HEART",7) 식으로 생성 가능 
		super();
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}
	
//	@Override
//	public String toString() {
//		return "kind : "+kind+", number : "+number; 
//	}
	
	

}
