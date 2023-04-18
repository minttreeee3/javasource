package ch6;

public class TvEx1 {

	public static void main(String[] args) {
		//클래스로부터 객체를 만드는 과정 : 인스턴스화
		//Tv 객체 생성
		
		
		// Tv tv = new Tv();  //클래스이름 변수명 = new 클래스이름(); 
		//나눠써보면
		//객체 선언
		Tv tv;
		//객체 생성
		tv = new Tv();
		
		//객체가 가지고 있는 속성, 메서드를 사용하기 위해서는 .(dot)으로 접근
		print(tv); //주소를 넘김
		
		//멤버변수 초기화
		tv.color = "black";
		tv.channel = 6;
		tv.power = true;
		
		
		//초기화 후 확인
		print(tv); 

		
		//메서드 호출 ==> 메서드 실행됨     void 메서드() {이안의일이 실행됨} 
		tv.channelUp();
		System.out.println("채널 "+tv.channel);
		
		tv.power();
		System.out.println("전원여부 "+tv.power);
		
		
		
		Tv tv2 = new Tv();
		tv2.color="white";
		tv2.channel=11;
		
		//tv켜기, tv끄기
		
		 tv2.power(); 
		 /* System.out.println("색상 "+tv2.color);
		 * System.out.println("채널 "+tv2.channel); 
		 * System.out.println("전원여부 "+tv2.power);
		 */
		print(tv2);  //주소를 넘김
		
		
										

		
		
		
	}
	
	//이걸 쓴다음에 위에 print(tv); 로 주소넘기는...
	
	static void print(Tv tv) {
		System.out.println("색상 "+tv.color);
		System.out.println("채널 "+tv.channel);
		System.out.println("전원여부 "+tv.power);
	}
	
	
	

}
