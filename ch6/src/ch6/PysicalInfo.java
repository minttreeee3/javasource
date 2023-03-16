package ch6;

public class PysicalInfo {
	
	// 생성자 / 메소드 오버로딩
	// 오버로딩 : 한 클래스에 동일한 이름의 메소드 혹은 생성자가 존재하는 것
	
	String name;
	int age;
	float height;
	float weight;
	
	//생성자 오버로딩
	//생성자 이름은 같아야 함
	//매개변수의 개수 또는 타입(String, int..)이 달라야 함. 괄호 안이 아예 똑같지만 않으면 됨
	public PysicalInfo(String name, int age, float height, float weight) {
//		super();
//		this.name = name;
//		this.age = age;
		this(name,age); //생성자에서 다른 생성자 호출할때 이렇게 처리 가능
		this.height = height;
		this.weight = weight;
//		this(height,weight); 이건 첫줄에서만 가능
		
		
	}
	
	public PysicalInfo(int age, String name, float height, float weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}


	public PysicalInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public PysicalInfo(float height, float weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	
	
	
	

}
