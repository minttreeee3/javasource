package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// 텍스트 읽어올때 이게 제일 좋은 방법 

public class FileInputEx5 {
	public static void main(String[] args) {
		
		// 파일에서 문자단위로 읽어오기 (버퍼를 사용해서) 
		// 읽어온 내용을 문자단위로 파일에 쓰기 (버퍼를 사용)
		try(FileReader fr = new FileReader("c:\\temp\\file1.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("c:\\temp\\output3.txt");
			BufferedWriter bw = new BufferedWriter(fw)) {
			
			String str = null;
			// readLine() : 줄단위로 읽기
			while((str = br.readLine()) !=null) {
				bw.write(str);
				//엔터한번넣어주기
				bw.newLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
