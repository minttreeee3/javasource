package ch6;

public class StudentEx {

	public static void main(String[] args) {
		
		Student stu = new Student("홍길동", 1, 2, 100, 60, 76);
		
		String msg = stu.info();
		System.out.println(msg);
		//msg출력 시
		//홍길동,1,2,100,60,76,점수합계,평균
		System.out.println(stu);  //그냥하면 주소 나옴 - student클래스에서 source에서 generate to string 눌러두면 세팅된값 나옴 
		
		//student2 객체 생성
		Student2 stu2 = new Student2("성춘향", 1, 3, 90, 80, 95);
		System.out.println("이름: "+stu2.name);
		System.out.println("총점: "+stu2.getTotal());
		System.out.println("평균: "+stu2.getAverage());
		//이름: 성춘향
		//총점: 236
		//평균:
		
		System.out.println(stu2);
		

	}

}
