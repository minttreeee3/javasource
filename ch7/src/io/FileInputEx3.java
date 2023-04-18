package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileInputEx3 {

	public static void main(String[] args) {
		// FileInputEx1.java 를 읽어서 화면 출력 
		// 행 번호와 같이 출력 (FileReader, Writer) 
		
		

		
//		try {FileInputStream fis = new FileInputStream(".\\src\\io\\FileInputEx1.java");
//				OutputStream out = System.out;
//				
//			byte[] b = new byte[1000];
//				
//			while(fis.read(b)!=-1) {
//				out.write(b);
//			}		
//			
//		} catch (Exception e) {		
//
//			e.printStackTrace();
//		}
//		
		
//		
//		try {FileReader fis = new FileReader(".\\src\\io\\FileInputEx1.java");
//				OutputStream out = System.out;
//		
//				int data = 0;
//				int row =1; //행번호
//				
//				System.out.print(row+"  ");
//		
//				while((data=fis.read())!=-1) {
//					System.out.print((char)data);
//					
//					if(data == '\n') {	//엔터를 만나면
//						row++;			//행번호 증가
//						System.out.print(row+"  ");
//					}
//					
//					
//				}		
//	
//			} catch (Exception e) {		
//				e.printStackTrace();
//			}	
		
		
		
		
		// FileReader / BufferedReader로 변경 
		
		try (FileReader fr = new FileReader(".\\src\\io\\FileInputEx1.java");
			 BufferedReader br = new BufferedReader(fr)) {
		
		
			String str = null;
			
			int i =1;
			while((str=br.readLine())!=null) {
				System.out.println(i+"  "+str);
				i++;						
			}		

		} catch (Exception e) {		
				e.printStackTrace();
		}	
		
		
		
		
		
		
		

	}

}
