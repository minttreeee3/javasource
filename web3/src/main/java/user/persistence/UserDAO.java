package user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.UserDTO;

// ~~~DAO : 데이터베이스 작업
public class UserDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "javadb";
		String password = "12345";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean insert(String name, String birthYear, String addr, String mobile) {
		
		boolean flag = false;
		
		con = getConnection();
		
		String sql = "INSERT INTO userTBL(no, username, birthYear, addr, mobile) ";   
		sql +=	"VALUES(user_seq.NEXTVAL, ?, ?, ?, ?)";
				
		
		try {
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(birthYear));
			pstmt.setString(3, addr);
			pstmt.setString(4, mobile);
			
			int count = pstmt.executeUpdate();
			if(count>0) flag=true;			
			
		} catch  (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return flag;
				
	} // insert 메소드 끝
	

	
	public List<UserDTO> getList() {
		List<UserDTO> list = new ArrayList<>();
		
		try {
			
			con = getConnection();
			
			String sql = "select * from usertbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); //쿼리문 실행한 후 결과 전송 - 테이블모양으로 담김
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String username = rs.getString("username");
				int birthYear = rs.getInt("birthyear");
				String addr = rs.getString("addr");
				String mobile = rs.getString("mobile");
				
				//
				
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
		
	} //getList() 끝 
	
	

}






