package ch6;

public class Person {
	
	String name;
	float height;
	float weight;
	
	void print() {
		System.out.println("이름 : " +name);
		System.out.println("키 : " +height);
		System.out.println("몸무게 : " +weight);
	}
	
	//name 매개변수에 값을 받아서
	//Person이 가지고 있는 name 인스턴스변수의 값을 변경
	public void setName(String name) {
		//name이 공백이 아니고 null이 아니면
		if(name.equals("") || name==null) {
			this.name = "홍길동";
		} else {
			this.name = name;
		}		
		//공백이거나 null이면 기본값을 홍길동
	}
	
	static void print2() {
		Person p = new Person();  //setName이 속한 클래스를 인스턴스화해줌 -그래야만 setName부를수있게됨 
		p.setName(""); 
	}
	
	
	
	

}
