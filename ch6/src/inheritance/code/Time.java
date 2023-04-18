package inheritance.code;

//접근제어자를 사용하는 이유 =>캡슐화
//외부로부터 데이터를 보호하기 위해서
//외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서


public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	
	// set 메서드: 매개변수에 지정된 값을 검사하여 조건에 맞을때만 멤버변수의 값을 변경함 
	// get 메서드: 멤버변수의 값을 읽는 메서드 
	
	public void setHour(int hour) {
		if(hour<0 || hour>24) return;
		//0~23일때만 실행
		this.hour = hour;
	}
	
	public int getHour() {
		return hour;
	}
	
	
	public void setMinute(int minute) {
		if(minute<0 || minute>60) return;
		//0~59일때만 실행
		this.minute = minute;
	}
	
	public int getMinute() {
		return minute;
	}
	
	
	public void setSecond(int second) {
		if(second<0 || second>60) return;
		//0~59일때만 실행
		this.second = second;
	}
	
	public int getSecond() {
		return second;
	}
	
	
	
	

}
