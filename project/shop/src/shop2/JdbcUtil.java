package shop2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
	// 드라이버로드, 커넥션얻기, 자원해제 => 중복이니까 모아둔 클래스 따로 만들기 => 전부 static으로
	// rollback, commit 메소드
	
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	} //드라이버로드 끝
	
	
	// 연결문자열을 이용해서 커넥션 얻어오기
	public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "javadb";
		String password = "12345";
		
		try {
			return DriverManager.getConnection(url, user, password);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
	} //getConnection 끝
	
	
	public static void close (Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close (Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //close 끝
	

}
