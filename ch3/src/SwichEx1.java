package ch3;

public class SwichEx1 {
	public static void main(String[] args) {
		//switch : if~else if~else 대신 사용
		//break : 빠져 나가기

		int month =6;
		switch (month) {
		case 3:  				
		case 4: 
		case 5:
			System.out.println("현재 계절은 봄");	
		case 6: case 7: case 8:
			System.out.println("현재 계절은 여름");	
		case 9: case 10: case 11: 
			System.out.println("현재 계절은 가을");	
		case 12: case 1: case 2: 
			System.out.println("현재 계절은 겨울");	
		}
		
		
	
//		int month =9;
//		
//		if (month<=5&&month>=3) {
//			System.out.println("현재 계절은 봄");
//		}else if (month<=8&&month>=6) {
//			System.out.println("현재 계절은 여름");
//		}else if (month<=11&&month>=9) {
//			System.out.println("현재 계절은 가을");
//		}else if (month==12||month==1||month==2) {
//			System.out.println("현재 계절은 겨울");
//		}
//		
//		
		
		}
}
