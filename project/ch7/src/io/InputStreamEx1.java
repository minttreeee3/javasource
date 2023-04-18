package io;

import java.io.IOException;
import java.io.InputStream;

/* I/O(Input/Output) 
Input : 키보드
Output : 화면 

스트림(Stream) : 한쪽에서 다른 쪽으로 데이터를 전달하기 위해, 
                     두 대상을 연결하고 데이터를 전송할 수 있는 것
1) 바이트 기반 스트림 : 바이트 단위로 데이터 전송 - FileInputStream, FileOutputStream...

2) 문자 기반 스트림 : 문자 단위로 데이터 전송 - FileReader, FileWriter... 



*/
public class InputStreamEx1 {

	public static void main(String[] args) {
		
		//Input : 키보드 
		//InputStream은 추상클래스 
//		InputStream in = System.in;
		
		//키보드에서 입력이 들어오면 읽어오기
//		try {
//			//read()는 한 바이트만 읽어옴 ex) abc입력해도 a만 읽음, 한글(3byte)입력하면 깨짐 
//			//int input = in.read();
//			
//			//여러글자 다 읽어오려면 =>반복문 사용
//			int input = 0;
//			while((input = in.read())!=-1) {		// read가 더이상 읽어올게 없으면 -1을 리턴 
//				
//				System.out.println((char)input);
//			}						
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	
//	}

		
	//try-whit-resource : Closable을 구현한 클래스여야 함
	// () 안에 생성한 건 알아서 닫아줌
		try(InputStream in = System.in) {
				int input = 0;		
			while((input = in.read())!=-1) {		
				System.out.println((char)input);
			}			
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
}



