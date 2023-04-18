package lang;

public class Value {
	
	int value;

	public Value(int value) {
		super();
		this.value = value;
	}
	
	
	//Object가 equals를 주소 비교로 사용하고 있는데 
	//값 비교로 바꾸려고 오버라이딩 
	@Override
	public boolean equals(Object obj) {
		// instanceof : 특정 객체의 인스턴스인지 확인 
		if(obj instanceof Value) {	// obj가 Value 객체의 인스턴스냐?
			Value v = (Value) obj;
			
			if(this.value == v.value) {
				return true;
			}
		}
		
		return false;
	}


	// toString() : Object는 패키지명.클래스명@hashCode값 
	// 자손 toString() : 인스턴스에 대한 정보(멤버변수에 할당된 값)를 문자열로 제공하는 목적으로 사용 
	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}
	
	
	
	
	
	
	

}
