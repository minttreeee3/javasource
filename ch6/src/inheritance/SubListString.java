package inheritance;

/* 오버로딩 : 하나의 클래스에 동일한 이름의 메소드(생성자)를 작성
 *  -메소드 오버로딩, 생성자 오버로딩 
 *  
 * 오버라이딩 : 상속에서만 나옴. 
 *  -부모의 메소드와 동일한 시그니처(리턴타입, 메소드명, 매개변수 등)을 가짐
 *  -부모가 제공해주는 기능 + 확장/새로운 기능 정의



*/

public class SubListString extends ListString {
	String name = "성춘향";
	
	
	@Override
	public void list() {
		super.list();  //부모의 리스트도 호출할수 있게됨
		System.out.println(name + " 하위 클래스 이름");
	}  //부모꺼+자식꺼 두줄다 출력됨
	
	
	
	public void writer() {
		System.out.println("하위 클래스 name 값 "+name);  //내꺼니까 그냥쓰거나 this.붙이거나
		System.out.println("상위 클래스 name 값 "+super.name);  //부모꺼니까 super.붙이면됨 
		
		//list() 호출 - SubListString, ListString 
		list();
		super.list();
	}
	
	

}
