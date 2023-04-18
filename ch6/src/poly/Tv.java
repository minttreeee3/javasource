package poly;

/* 다형성(polymorphism) : 여러가지 형태를 가질 수 있는 능력. 상속일때만 가능
 * 
 * 
*/
public class Tv {
	
	//속성(property) ==> 멤버변수
	//크기, 길이, 높이, 색상, 볼륨, 채널... 
	String color; //색상
	int channel; //채널
	boolean power; //전원상태 
	
	//기능(function) ==> 메서드
	//켜기, 끄기, 볼륨 높이기, 볼륨 낮추기, 채널 변경...
	// void : 메소드 실행이 끝난 후 리턴값 없음 
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

}
