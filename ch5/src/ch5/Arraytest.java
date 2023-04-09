package ch5;

import java.util.Arrays;

public class Arraytest {

	public static void main(String[] args) {
		// 배열이. 어렵다.
		
		int array[] = new int[6];
		
		for (int i = 0; i < array.length; i++) {			
			array[i] = (int)(Math.random()*45)+1; 
		}
		System.out.println(Arrays.toString(array));
		

	}

}
