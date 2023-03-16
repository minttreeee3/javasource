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
public class InputStreamEx3 {

	public static void main(String[] args) {
		
		//Input : 키보드 
		//InputStream은 추상클래스 
		InputStream in = System.in;

		
		//키보드에서 입력이 들어오면 읽어오기
		try {
			//read(byte[] b) : byte배열만큼 읽어옴 ,  read가 더이상 읽어올게 없으면 -1을 리턴 		
			//write(byte[] b) : byte 배열만큼 쓰기
			//여러글자 다 읽어오려면 =>반복문 사용
			byte[] b = new byte[100];

			
			System.out.print("이름 : ");
			int nameByte = in.read(b);
			// String 생성자를 이용해서 nameByte를 String으로 변경 
			// enter : carriage return + line feed => 입력데이터에서 엔터를 빼주기 위해 2byte 차감 
			String name = new String(b,0,nameByte-2);
			
					
			System.out.print("하고 싶은 말 : ");
			int commentByte = in.read(b);
			// String 생성자를 이용해서 commentByte를 String으로 변경 			
			String comment = new String(b,0,commentByte-2);
			
			// 생성한 String 출력
			System.out.println("입력한 이름 : "+name);
			System.out.println("입력한 하고 싶은 말 : "+comment);
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 	// try-catch에서 무조건 실행해야하는 작업엔 finally 
			//스트림 닫기
			try {
				in.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
		
		
		// try-with-resource
		
		
		
		
		
		
		

	}

}
