package ch5;

import java.util.Arrays;

/* 기본타입 - byte,char,short,int,long,float,double,boolean
 * 참조타입 - String(클래스),배열

*/

public class ArrayEx2 {

	public static void main(String[] args) {

		int score[]=new int[5];
		
		for (int i = 0; i < score.length; i++) {
			score[i] = i*10;
		}
		
		
		System.out.println(score); //배열은 참조타입이라서 heap에 저장된 주소가 출력됨
		System.out.println(Arrays.toString(score)); //배열값 가장 빠르게 확인(근데 형식은 못바꿈)
		
		
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
		
		System.out.println();
		//향상된 for문
		for(int i:score ) {
			System.out.println(i);
		}
		
		
		
		
		
		int iArr2[] = new int[10];
		//1~10사이 임의의 숫자를 10개 생성해서 배열에 저장
		
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int)(Math.random()*10)+1;
		}
		System.out.println(Arrays.toString(iArr2));
		
		
		
		
		char chArr[]= {'a','b','c','d','e'};
		System.out.println(chArr);

		String strArr[]= {"abc","efg"};
		System.out.println(strArr);

		
		
		
		
	}

}
