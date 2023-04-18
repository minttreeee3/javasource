package ch6;


// private : 외부 접근 불가

// final : 상수 (대문자로 표현함)
// 선언하면서 초기화한다 


public class Tv4 {
	
	private String color; //색상
	private int channel; //채널
	private boolean power; //전원상태 
	

	final int VOLUME = 10;  //상수라서 처음부터 지정해야됨 
	
	
	
	
	public Tv4() {
		super();
	}

	public Tv4(String color, int channel, boolean power) {
		super();
		this.color = color;
		this.channel = channel;
		this.power = power;
	}

	void power() {
		power = !power;
	}
	
	//채널을 증가하고 현재 채널을 리턴
	// int : 메소드가 실행이 끝난 후 int 값을 가지고 돌아감
	int channelUp() {
		channel++;
		return channel;
	}
	
	void channelDown() {
		channel--;
	}

	
	
	
	// getter/setter 메소드 - 마우스오른쪽 - source 
	
	// getter : 변수의 값을 리턴하는 형태
	
	public String getColor() {
		return color; 
	}
	
	// setter : 변수의 값을 변경하는 형태

	public void setColor(String color) {
		this.color = color;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}
	
	
	
	
	
	
	
	
	
	
	

}
