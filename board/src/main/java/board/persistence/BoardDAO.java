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
import board.domain.PageDTO;

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
	public List<BoardDTO> getRows(PageDTO pageDTO) {
		List<BoardDTO> list = new ArrayList<>();
		
		try {
			con = getConnection();
			
			String sql = null;
			
			// rownum값 : 페이지번호 * 한 페이지에 보여줄 글 개수
			// rnum값 : (페이지번호-1) * 한 페이지에 보여줄 글 개수
			int start = pageDTO.getPage() * pageDTO.getAmount();
			int end = (pageDTO.getPage()-1) * pageDTO.getAmount();	
			
			if(pageDTO.getKeyword().isEmpty() && pageDTO.getCriteria().isEmpty()) {
				//전체리스트
//				sql = "select bno, title, name, regdate, cnt, re_lev from board order by re_ref desc, re_seq asc";			

				//페이지 나눠서 가져오기
				sql = "select * ";
				sql += "from (select rownum rnum, bno, title, name, regdate, cnt, re_lev ";
				sql += "from(select bno, title, name, regdate, cnt, re_lev ";
				sql += "from board order by re_ref desc, re_seq asc) ";
				sql += "where rownum <= ?) ";
				sql += "where rnum > ?";
								
				pstmt = con.prepareStatement(sql);
																	
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				
				
			} else {
				//검색리스트
//				sql = "select bno,title,name,regdate,cnt,re_lev from board where " + pageDTO.getCriteria() + " like ? order by re_ref desc, re_seq asc";			
				
				// 검색도 페이지 나눠서 
				sql = "select * ";
				sql += "from (select rownum rnum, bno, title, name, regdate, cnt, re_lev ";
				sql += "from(select bno, title, name, regdate, cnt, re_lev ";
				sql += "from board where "+ pageDTO.getCriteria() + " like ? ";
				sql += "order by re_ref desc, re_seq asc) ";
				sql += "where rownum <= ?) ";
				sql += "where rnum > ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+pageDTO.getKeyword()+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
												
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegDate(rs.getDate("regdate"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setReLev(rs.getInt("re_lev"));
				
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
				
				String sql = "select bno,name,title,content,attach,re_ref,re_lev,re_seq from board where bno=?";
				
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
					// 댓글 작성 위해서 갖고옴 
					dto.setReRef(rs.getInt("re_ref"));
					dto.setReLev(rs.getInt("re_lev"));
					dto.setReSeq(rs.getInt("re_seq"));
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
		
		
		
		// 답변달기
		public boolean reply(BoardDTO updateDto) {
			boolean flag=false;
			try {
				con = getConnection();
				
				// update먼저
				String sql = "update board set re_seq = re_seq + 1 where re_ref = ? and re_seq > ?";
				// 부모값 가져오기
				int reRef = updateDto.getReRef();
				int reLev = updateDto.getReLev();
				int reSeq = updateDto.getReSeq();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, reRef);
				pstmt.setInt(2, reSeq);
				
				pstmt.executeUpdate(); 
				
				// 그리고나서 insert
				sql = "insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) ";
				sql +="values(board_seq.nextval,?,?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, updateDto.getName());
				pstmt.setString(2, updateDto.getPassword());
				pstmt.setString(3, updateDto.getTitle());
				pstmt.setString(4, updateDto.getContent());
				pstmt.setString(5, updateDto.getAttach());
				pstmt.setInt(6, reRef);
				pstmt.setInt(7, reLev + 1);
				pstmt.setInt(8, reSeq + 1);  //부모꺼보다 1씩 증가해서 넣어야함 
				
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
		}//reply끝
		
		
		//검색 - 위에 getRows랑 합침 - 지금은 작동 안함
		public List<BoardDTO> searchList(String criteria, String keyword) {
			List<BoardDTO> list = new ArrayList<>();
			
			try {
				con = getConnection();
				
				String sql = "select bno,title,name,regdate,cnt,re_lev from board where " + criteria + " like ? order by re_ref desc, re_seq asc";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setTitle(rs.getString("title"));
					dto.setName(rs.getString("name"));
					dto.setRegDate(rs.getDate("regdate"));
					dto.setCnt(rs.getInt("cnt"));
					dto.setReLev(rs.getInt("re_lev"));
					
					list.add(dto);
				}
								
			} catch (Exception e) {
				rollback(con);
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			return list;
		} //검색 끝
		
		
		//전체 게시물 개수 
		public int totalRows(PageDTO pageDTO) {
			int total = 0;
			try {				
				con = getConnection();
				
				String sql = "";
				
				if(pageDTO.getKeyword().isEmpty() && pageDTO.getCriteria().isEmpty()) {
					// 전체 게시글 개수
					sql = "select count(*) from board";
					pstmt = con.prepareStatement(sql);
					
				} else {
					// 검색시의 게시글 개수
					sql = "select count(*) from board where " + pageDTO.getCriteria() + " like ? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+pageDTO.getKeyword()+"%");
					
				}
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					total = rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			return total;
		}
		
		
		
		
		
	}
	


