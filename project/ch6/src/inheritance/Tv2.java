package inheritance;


//this : 자기자신
//this() : 생성자에서 내가 가지고있는 다른 생성자를 호출할때 사용, this.변수명 : 매개변수와 이름이 같을때 구별하기위해

//super : 부모
//super() : 생성자에서 부모 생성자를 호출할때 사용, super.변수명 : 부모가 가지고 있는 인스턴스 변수명을 사용할때


//클래스 작성시 부모를 지정하지 않으면 최상위 부모는 Object 클래스가 존재함 


public class Tv2 {
	
	boolean power;
	int channel;
	
	
	//디폴트생성자 (source- generate constructors from superclass
	public Tv2() {
		super();  //부모의 기본생성자를 호출
	}
	
	
	
	
	
	
	
	public Tv2(boolean power, int channel) {
		super();
		this.power = power;
		this.channel = channel;
	}







	void power() {
		power =!power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}

}
