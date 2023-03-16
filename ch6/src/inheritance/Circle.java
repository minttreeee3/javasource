package inheritance;	//패키지명은 소문자. 클래스명 첫글자는 대문자 

// 클래스 관계
// 상속관계(is-a) : Circle is a Point 원은 점이다 (x)
// 포함관계(has-a) : Circle has a Point 원은 점을 가지고 있다 (o) 
// 그래서 여기는 포함관계로 만드는것

// 포함관계 : 한 클래스의 멤버 변수로 다른 클래스 타입의 참조변수를 선언


// Car 라는 클래스를 정의한다면
// 엔진 클래스, 도어 클래스 등을 포함관계로 만드는게 맞음 



public class Circle {
	
//	int x;	//x좌표
//	int y;	//y좌표
	Point p = new Point();  //포함관계
	
	int r;	//반지름

}
