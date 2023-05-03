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
	
	
	
	//게시글 하나 조회
		public BoardDTO getRow(int bno){
			BoardDTO dto = null;
			
			try {
				con = getConnection();
				
				String sql = "select bno,name,title,content,attach from board where bno=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto = new BoardDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setAttach(rs.getString("attach"));
				}			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			return dto;
		} //getRow끝
		
		
		
		//조회수 증가
		//update board set cnt=cnt+1 where bno=3
		public boolean readCnt(int bno){
			boolean flag=false;
			
			try {
				con = getConnection();
				String sql = "update board set cnt=cnt+1 where bno=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				
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
		} // readCnt끝
		
		
		
		//업데이트
		//title,content 수정 (bno, 비번일치시) + attach(옵션 -들어올수도 아닐수도) 
		public boolean updateArticle(BoardDTO updateDto) {
			boolean flag = false;
			
			try {
				
				con = getConnection();				
				
				String sql = "";
				if(updateDto.getAttach() == null) {					
					sql += "update board set title=?, content=? where bno=? and password=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, updateDto.getTitle());
					pstmt.setString(2, updateDto.getContent());
					pstmt.setInt(3, updateDto.getBno());
					pstmt.setString(4, updateDto.getPassword());					
					
				} else {
					
					sql += "update board set title=?, content=?, attach=? where bno=? and password=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, updateDto.getTitle());
					pstmt.setString(2, updateDto.getContent());
					pstmt.setString(3, updateDto.getAttach());
					pstmt.setInt(4, updateDto.getBno());
					pstmt.setString(5, updateDto.getPassword());
					
				}
								
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					flag = true;
					commit(con);
				}
				
			} catch (Exception e) {
				rollback(con);
				e.printStackTrace();				
			} finally {
				close(con, pstmt);
			}
			return flag;
		} //update끝
		
		
		//삭제 (bno,password일치시)
		public boolean deleteArticle(int bno, String password) {
			boolean flag = false;
			
			try {				
				con = getConnection();
				
				String sql = "delete from board where bno=? and password=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
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
		
		
		
		
	}
	


