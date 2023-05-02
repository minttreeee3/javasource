package board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.domain.BoardDTO;

public class BoardDAO {
	
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
	
	
	
	// 게시글 등록
	// insertArticle(BoardDTO boardDTO)
	// re_ref : bno와 동일한 값, re_lev랑 re_seq: 일단 0으로 
	public boolean insertArticle(BoardDTO boardDTO) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) ";
			sql += "values(board_seq.nextval, ?, ?, ?, ?, ?, board_seq.currval, ?, ?)";
			// re_ref : bno와 같은값넣으려고 => seq의 현재값 => seq.currval 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getName());
			pstmt.setString(2, boardDTO.getPassword());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setString(5, boardDTO.getAttach());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
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
	} //insert끝
	
	
	
	// board전체 가져오기
	// bno, title, name, regdate, cnt 추출 
	public List<BoardDTO> getRows() {
		List<BoardDTO> list = new ArrayList<>();
		
		try {
			con = getConnection();
			
			String sql = "select bno, title, name, regdate, cnt from board order by bno desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegDate(rs.getDate("regdate"));
				dto.setCnt(rs.getInt("cnt"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	} //getRows끝 
	

}
