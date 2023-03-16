package ch6;

public class PersonEx {

	public static void main(String[] args) {
		
		Person p = new Person();  //pearson 인스턴스 생성 => pearson이 가지고 있는 인스턴스
		p.setName("");
		p.print();
		
		Person.print2(); //다른곳에있는 static 을 부를때는 클래스.변수명 으로 불러냄 

	}

}
