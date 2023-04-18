package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionex2 {

	public static void main(String[] args) {
		
		BufferedReader input = null;
		String line = "";


		try {
			URL url = new URL("https://www.naver.com");
			
			// url.openStream() : 연결된 url에서 데이터를 읽어 InputStream 형태로 리턴
			// InputStreamReader() : InputStream ==> Reader 변환하는 보조스트림 
			
			//url.openStream() 대신에 URLConnection 사용하기
			//URLConnection con = url.openConnection();
			//con.getInputStream();
			
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine())!=null) {
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
