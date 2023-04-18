package ch6;

import java.util.Scanner;

public class StudentEx3 {

	public static void main(String[] args) {
		
		//Student2 인스턴스 생성
		//사용자로부터 입력을 받은 정보를 가지고 생성
		
		Scanner sc = new Scanner(System.in);
		
		//이름,반,번호,국어,영어,수학 점수 입력받기
//		System.out.print("이름 >> ");
//		String name = sc.nextLine();
//		
//		System.out.print("반 >> ");
//		int ban = Integer.parseInt(sc.nextLine());
//		
//		System.out.print("번호 >> ");
//		int no = Integer.parseInt(sc.nextLine());
//		
//		System.out.print("국어 >> ");
//		int kor = Integer.parseInt(sc.nextLine());
//		
//		System.out.print("영어 >> ");
//		int eng = Integer.parseInt(sc.nextLine());
//		
//		System.out.print("수학 >> ");
//		int math = Integer.parseInt(sc.nextLine());
//		
//		
//		Student2 student = new Student2(name, ban, no, kor, eng, math);
//		// source-toString눌러놔서 주소가 아닌 인스턴스변수가 가지고 있는 값이 출력됨
//		System.out.println(student);
		
		
		
		//입력값으로 Student2 인스턴스를 3개 생성  =>배열!
		Student2 students[] = new Student2[3];
		
		for (int i = 0; i < students.length; i++) {
	
			System.out.print("이름 >> ");
			String name = sc.nextLine();
			
			System.out.print("반 >> ");
			int ban = Integer.parseInt(sc.nextLine());
			
			System.out.print("번호 >> ");
			int no = Integer.parseInt(sc.nextLine());
			
			System.out.print("국어 >> ");
			int kor = Integer.parseInt(sc.nextLine());
			
			System.out.print("영어 >> ");
			int eng = Integer.parseInt(sc.nextLine());
			
			System.out.print("수학 >> ");
			int math = Integer.parseInt(sc.nextLine());
			
			
			students[i] = new Student2(name, ban, no, kor, eng, math);

		}
		
		//확인용
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
		
		//향상된for로 쓴다면
		
		for(Student2 stu:students) {
			System.out.println(stu);
		}
		
		
		
		
		//향상된 for
		//기본배열
		int arr[] = new int[3];
		for(int num:arr) {
			System.out.println(num);
		}
		
		
		
		

	}

}
