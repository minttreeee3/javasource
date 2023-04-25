package book.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.domain.BookDTO;

public class BookDAO {
	
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
	
	
	// 도서목록 전체 조회
	public List<BookDTO> getList() {
		List<BookDTO> list = new ArrayList<>();
		
		try {
			
			con = getConnection();
			String sql = "select code,title,writer,price from booktbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				/* int code = rs.getInt("code");
				 * String title = rs.getString("title"); 
				 * String writer = rs.getString("writer");
				 * int price = rs.getInt("price");
				 * 
				 * list.add(new BookDTO(code, title, writer, price));
				 */ //4개짜리 생성자를 DTO에 만들거나 
				
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	} // getList 끝
	

	
	// 도서 상세 조회
	// select * from booktbl where code=?
	public BookDTO getRow(int code) {
		BookDTO dto = null; 
		
		try {					
			con = getConnection();
				
			String sql = "select * from booktbl where code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
				
			rs = pstmt.executeQuery(); 
				
			if(rs.next()) {
				
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				
				dto = new BookDTO(code, title, writer, price, description);										
			}
							
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
				close(con, pstmt, rs);
		}
		return dto;
		
	} //getRow끝
	

	
	// 도서 정보 입력
	public boolean insert(BookDTO insertDto) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "insert into booktbl(code, title, writer, price, description) ";
				   sql += "values(?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setInt(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			pstmt.setString(5, insertDto.getDescription());
			
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
	}//insert끝
	
	
	// 도서정보수정(가격)
	public boolean update(int code, int price) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "update booktbl set price =? where code=?";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);

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
	
	
	
	// 도서정보 삭제
	public boolean delete(int code) {
		boolean flag = false;
		
		try {
			con = getConnection();
			
			String sql = "delete from booktbl where code=?";
			
			pstmt = con.prepareStatement(sql);
			// ?해결
			pstmt.setInt(1, code);

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
	}//delete끝	
	
	
	

}
