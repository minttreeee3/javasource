package inheritance.code;

import modifier.Account;






public class Modifier1 {
	
	// Account acc;   //참조타입 - 기본값이 null로 세팅됨 -> 오류남 / 
	Account acc=new Account(); // ㄴ객체만들어주면됨 account를 포함관계로 끌고들어옴
	//String str="hello"; //초기값넣거나...
	//int age;  //기본타입은 - 정수형:0, 실수형:0.0, boolean:false로 세팅됨
	
	private void print() {
		
		//System.out.println(acc);
		//System.out.println(str.length());
		//System.out.println(age);
		
		//Account가 가지고 있는 ano에 접근하고싶다면?
		String ano=acc.getAno();
		System.out.println("ano : "+ano);
		
		acc.setAno("111-22");
		System.out.println("ano : "+acc.getAno());
	}
	
	
	public static void main(String[] args) {
		// static 메소드에서 non-static 메소드 호출하기
		// 1. 같은 static메소드로 만들기
		// 2. 객체 생성 후 호출하기 (지금은 이걸로했음) 
		Modifier1 modifier1 = new Modifier1();
		modifier1.print();
	}
	

}
