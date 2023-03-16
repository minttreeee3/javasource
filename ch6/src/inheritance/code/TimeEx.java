package inheritance.code;

public class TimeEx {

	public static void main(String[] args) {
		
		Time time = new Time();
		
		//time.hour = 30;  public이면 이렇게쓰지만 값을 제어할수없음
		time.setHour(20);  //private로 바꾸고 setter메소드를 만들면 24까지만 쓰도록 제한할수있음
		time.setMinute(55);
		time.setSecond(58);
		
		System.out.println("현재시각 "+time.getHour()+":"+time.getMinute()+":"+time.getSecond());

	}

}
