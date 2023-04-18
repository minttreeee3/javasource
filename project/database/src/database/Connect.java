package database;

import java.sql.Connection;
import java.sql.DriverManager;


/* JDBC (Java Database Connectivity)
 * 자바에서 데이터베이스에 접속할 수 있도록 제공해주는 자바 api
 * 
 * 프로젝트에 ojdbc8.jar 포함되어야함 (필수)
 * [build path] - [configure build path] - class path에 ojdbc8.jar 포함
 * 
 * 1) connection 가져오기
 * - 드라이버 로드
 * - 연결문자열 연결 시도

*/



public class Connect {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			// jdbc:oracle:thin:@  =>고정(정해져있음) / 이 뒤는 변경가능한 값 
			// localhost == 127.0.0.1 (내컴퓨터) 
			// 1521 => 기본 포트번호 
			// xe   => 기본 sid이름  
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("연결되었습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
