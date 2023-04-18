package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* I/O(Input/Output) 
Input : 키보드
Output : 화면 

스트림(Stream) : 한쪽에서 다른 쪽으로 데이터를 전달하기 위해, 
                     두 대상을 연결하고 데이터를 전송할 수 있는 것
1) 바이트 기반 스트림 : 바이트 단위로 데이터 전송 - FileInputStream, FileOutputStream...

2) 문자 기반 스트림 : 문자 단위로 데이터 전송 - FileReader, FileWriter... 



*/
public class OutputStreamEx1 {

	public static void main(String[] args) {
		
		//Input : 키보드 
		//InputStream은 추상클래스 
		InputStream in = System.in;
		
		//output : 화면
		OutputStream out = System.out;
		
		
		//키보드에서 입력이 들어오면 읽어오기
		try {
			//여러글자 다 읽어오려면 =>반복문 사용
			int input = 0;
			while((input = in.read())!=-1) {		// read가 더이상 읽어올게 없으면 -1을 리턴 
				out.write(input);
			
			}						
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 	// try-catch에서 무조건 실행해야하는 작업엔 finally 
			//스트림 닫기
			try {
				in.close();
				out.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
		

	}

}
