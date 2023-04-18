package inheritance;

public class ComputerEx {

	public static void main(String[] args) {
		
		Computer computer = new Computer();
		
		System.out.println(computer.areaCircle(10));
		
		
		Calculator calculator = new Calculator();
		System.out.println(calculator.areaCircle(10));
		
		

	}

}
