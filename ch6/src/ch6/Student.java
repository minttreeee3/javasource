package ch6;

public class Student {
	
	String name;	//학생이름 name ew)홍길동
	int ban;	//반 ban ex)1
	int no;		//번호 no ex)1
	int kor;	//국어점수 kor ex)78
	int eng;	//영어점수 eng ex)68
	int math; 	//수학점수 math ex)65
	
	
	
	
	


	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	



	String info() {  //출력시랑 타입 맞춰야함, return필요하므로 void로는안됨 
		
		//국어+영어+수학
		int sum = this.kor+this.eng+this.math;  //this안써도됨
		double avg = (double)sum / 3;
		
		return this.name+","+this.ban+","+this.no+","+this.kor+","+this.eng+","+this.math+","+sum+","+avg;

	}




	//마우스오른쪽 source - generate to string 

	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}


	
	
	
	
}
