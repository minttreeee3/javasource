package ch6;

public class Student2 {
	
	String name;	//학생이름 name ew)홍길동
	int ban;	//반 ban ex)1
	int no;		//번호 no ex)1
	int kor;	//국어점수 kor ex)78
	int eng;	//영어점수 eng ex)68
	int math; 	//수학점수 math ex)65
	
	
	
	
	


	public Student2(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	
	int getTotal() {
		//점수 총계
		int sum=this.kor+this.eng+this.math;
				return sum;
	}
	
	double getAverage() {
		//평균
		return (double)getTotal()/3;		
	}



	//마우스오른쪽 source-투스트링 => 하고나면 System.out.println(student);찍었을때 주소가 아닌 정보값이 나오게됨 
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}





	
}
