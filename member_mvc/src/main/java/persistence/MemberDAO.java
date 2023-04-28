package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.ChangeDTO;
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
	
	
	public boolean register(MemberDTO registerDto) {
		boolean flag = false;
		try {
			con = getConnection();
			
			String sql = "insert into membertbl(userid, password, name, gender, email) ";
				   sql += "values(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setString(1, registerDto.getUserid());
			pstmt.setString(2, registerDto.getPassword());
			pstmt.setString(3, registerDto.getName());
			pstmt.setString(4, registerDto.getGender());
			pstmt.setString(5, registerDto.getEmail());

			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				flag=true;
				commit(con);
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return flag;		
		
	} //register끝
	
	
	// 비밀번호 변경
	public boolean update(ChangeDTO dto) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "update membertbl set password=? where userid=?";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setString(1, dto.getConfirmPassword());
			pstmt.setString(2, dto.getUserid());

			int result = pstmt.executeUpdate();
			
			if(result>0) {
				flag=true;
				commit(con);
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return flag;		
		
	}//update끝
	
	
	//회원탈퇴 - 아이디와 비밀번호 일치시
	public boolean delete(String userid, String password) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "delete from membertbl where userid=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setString(1, userid);
			pstmt.setString(2, password);

			int result = pstmt.executeUpdate();
			
			if(result>0) {
				flag=true;
				commit(con);
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return flag;		
	} //delete끝
	
	
	
	// 중복아이디 검사
	// 이미 존재하는 아이디가 없다면(=사용가능하면) true 리턴
	public boolean duplicateId(String userid) {
		boolean flag = true;
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from membertbl where userid=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cnt = rs.getInt(1);  //1번칼럼에 있는 숫자 => 아이디가 하나 있으면 1 나옴 
				if(cnt>0) flag = false;
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}		
		return flag; 
	}
	

}
