package io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class FileOutputEx1 {


	public static void main(String[] args) {
		// 키보드에서 입력을 받아들여 파일에 쓰기
		// 조건 : 키보드에서 q가 입력되기 전까지 계속 받아들이도록 한다
		// Scanner, FileWriter/BufferWriter 사용
		
		
		String content = null; //사용자 입력 내용을 저장하는 변수	
				
		try(Scanner sc = new Scanner(System.in);
			FileWriter fw = new FileWriter("c:\\temp\\output3.txt");
			BufferedWriter bw = new BufferedWriter(fw)) 	{	 
				
			System.out.println("파일에 저장할 데이터를 입력해 주세요");
			System.out.println("입력을 중단하려면 q를 입력해 주세요");
			
			
			do {
				
				System.out.print(" >> ");
				content = sc.nextLine(); 	// 사용자 입력을 저장
				
				if(!content.equals("q")) {		//종료문자 q는 저장 안되도록
					bw.write(content); 		// 파일에 쓰기
					bw.newLine(); 			// 엔터쳐주기 					
				}
				
			} while(!content.equals("q"));
			
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		

	}

}
