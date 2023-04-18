package inheritance;


// Math.random() : static메소드 
// Math.PI : final static double PI 



public class Computer extends Calculator {
		
	
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle 실행");
		return Math.PI * r * r;
	}
	
	
	

}
