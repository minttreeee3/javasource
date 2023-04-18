package inheritance.code;

import java.util.Date;

//import문
//다른 패키지에 있는 클래스를 사용할때 필요

import java.util.Scanner; //java.util이라고 하는 패키지에 있는 스캐너를 사용 

import exam.Account;


//java.lang 패키지에 있는 클래스를 사용할때는 import구문이 필요없음
//자주사용하는 패키지이기땜에 기본적으로 사용할수있도록 되어있음 ex)String


// 접근 제어자(modifier) : 멤버 또는 클래스에 사용되어 해당하는 멤버 또는 클래스를 외부에서 접근하지 못하도록 제한
// 접근 제어자가 사용되는 곳 : 클래스, 멤버변수, 메서드, 생성자 
// 메소드는 대부분 public, 인스턴스변수(멤버변수)는 대부분 private로 

// 접근범위 : public > protected > 생략(default) > private
// 1) public, protected, default, private

// private : 같은 클래스 내에서만 접근 가능
// 생략 : 같은 패키지 내에서만 접근 가능 
// protected : 같은 패키지 내에서, 다른 패키지의 자손 클래스에서 접근 가능
// public : 접근 제한이 전혀 없음 



// 제어자
// static(공통적인것에 사용) - 멤버변수, 메소드, 초기화블럭
// final - 클래스, 메소드, 멤버변수, 지역변수에 붙일수있음
// abstract... 



public class Test {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
				
		
		Account account = new Account(null, null, 0);
		
		Date date = new Date();
		
		String str = "Hello";
		
	}

}
