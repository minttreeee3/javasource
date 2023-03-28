package shop2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static shop2.JdbcUtil.*;

// JdbcUtil 메소드 호출하는 방법
// 1) static 메소드이므로 객체생성없이도 JdbcUtil.메소드명() 으로 쓸수있음
// 2) JdbcUtil 클래스 안 메소드가 모두 static이라면 import static 패키지명.클래스명.*; ==> 그냥 메소드명()으로 호출이 가능해짐  

public class UserDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	
	
	
	// 회원가입
	public boolean insert(int userId, String name, int payNo) {
		boolean status = false;
		
		try {
			
			con = getConnection();  
			
			// suser 테이블에 insert
			String sql = "insert into suser(user_id, name, pay_no) values(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, userId);
			pstmt.setString(2, name);
			pstmt.setInt(3, payNo);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) status=true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return status;
	} //insert끝

	
	
	// 전체조회 - select
	public List<UserDTO> getList() {
		List<UserDTO> list = new ArrayList<>();
		
		try {
			con = getConnection();
			
			//suser 전체조회
			String sql = "select * from suser";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserDTO dto = new UserDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	} //getList끝
	
	
	

}
