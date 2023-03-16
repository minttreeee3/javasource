package ch6;

public class StudentEx2 {

	public static void main(String[] args) {
		
		//student2 객체 배열
		Student2 stuArr[] = new Student2[5];
		
		//기본값 확인 =>null나옴 
		System.out.println(stuArr[0]);
		
		//초기화
		stuArr[0]=new Student2("홍길동", 1, 1, 45, 55, 65);
		stuArr[1]=new Student2("성춘향", 1, 2, 55, 65, 98);
		stuArr[2]=new Student2("서유기", 1, 3, 35, 85, 67);
		stuArr[3]=new Student2("김미남", 1, 4, 56, 25, 49);
		stuArr[4]=new Student2("이서진", 1, 5, 63, 75, 65);
		
		
		//홍길동의 정보를 출력하려면
		System.out.println("이름 : "+stuArr[0].name);
		System.out.println("반 : "+stuArr[0].ban);
		System.out.println("번호 : "+stuArr[0].no);
		System.out.println("국어 : "+stuArr[0].kor);
		System.out.println("영어 : "+stuArr[0].eng);
		System.out.println("수학 : "+stuArr[0].math);
		
		
		//전체학생의 정보를 출력하려면
		for (int i = 0; i < stuArr.length; i++) {
			System.out.println("이름 : "+stuArr[i].name);
			System.out.println("반 : "+stuArr[i].ban);
			System.out.println("번호 : "+stuArr[i].no);
			System.out.println("국어 : "+stuArr[i].kor);
			System.out.println("영어 : "+stuArr[i].eng);
			System.out.println("수학 : "+stuArr[i].math);
			System.out.println("총점 : "+stuArr[i].getTotal());
			System.out.println("평균 : "+stuArr[i].getAverage());
		}
		

	}

}
