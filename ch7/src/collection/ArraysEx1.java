package collection;

import java.util.Arrays;

public class ArraysEx1 {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		
		// toString : 배열의 요소를 문자열로 출력 
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		
		// deepToString() : 2차원 배열의 요소를 문자열로 출력 
		int arr2[][] = {{11,22}, {21,22}};		
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));	//2차원배열에선 주소나옴
		System.out.println(Arrays.deepToString(arr2));	//이걸로해야 문자열 나옴 
		
		
		// equals() : 값비교 (두 배열에 저장된 모든 요소를 비교) 
		String[] str1 = {"aaa","bbb"};
		String[] str2 = {"aaa","bbb"};
		System.out.println(Arrays.equals(str1, str2));
		
		// deepEquals() : 2차원배열 값비교
		String[][] str2D = {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = {{"aaa","bbb"},{"AAA","BBB"}};
		System.out.println(Arrays.equals(str2D, str2D2));
		System.out.println(Arrays.deepEquals(str2D, str2D2));
		
		
		int arr3[] = new int[5];
		// arr 배열을 arr3로 복사
		
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr[i];
		}
		System.out.println(Arrays.toString(arr3));
		
		
		// copyOf(원본배열, 복사할 요소 개수), copyOfRange()
		int arr5[] = Arrays.copyOf(arr, 3);
		System.out.println(Arrays.toString(arr5));
		
		// copyOfRange(원본배열, 시작, 끝+1) 
		int arr6[] = Arrays.copyOfRange(arr,2,4);
		System.out.println(Arrays.toString(arr6));
		
		

	}

}
