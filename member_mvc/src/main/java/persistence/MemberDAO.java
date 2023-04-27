package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.MemberDTO;

public class MemberDAO {
	
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
		
	
	// DB서버 연결
	public Connection getConnection() {
		
		
		try {
			// dbcp로 바꾸면서 
			Context ctx = new InitialContext();
			
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle");
			
			Connection con = ds.getConnection();
			//DML 실행 시 트랜잭션 관리를 직접 하겠다는 구문 - 원래 안쓰면 true(자동커밋)인데, false로 써서 직접관리하겠다고 
			con.setAutoCommit(false);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	// close(자원해제) 
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
	
	// 커밋 메소드 
	public void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 롤백 메소드 
	public void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 로그인 메소드
	// 아이디와 비밀번호가 일치하면 아이디와 이름만 추출 
	// select userid, name from membertbl where userid=? and password=? 
	
	public MemberDTO isLogin(String userid, String password) {
		MemberDTO dto = null;
		
		try {
			con = getConnection();
			
			String sql = "select userid, name from membertbl where userid=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			// ?처리
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
		
	} //login끝
	
	
	
	
	

}
