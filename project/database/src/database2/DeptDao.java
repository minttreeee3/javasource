package database2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// ~~~Dao : DataBase 작업을 담당하는 클래스라는 뜻

// syso 빼야됨
// rs는 닫아야돼서 다른곳에서 rs로 받으면 안됨


public class DeptDao {
	
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	// 커넥션을 위한 드라이버 로드
	// static => 시작하면 알아서 로드됨 (공용 메서드)	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}			
	
	
	
		//커넥션을 위한 리턴메소드		
		public Connection getConnection() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			try {
				con = DriverManager.getConnection(url, user, password);		
			}
			catch (SQLException e) {
				e.printStackTrace();
			}			
			return con;			
		}
	
			
		//close() :자원닫기
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
		

		
		//select-하나 (Main의 case1)
		public DeptDTO getRow(int deptno) {
		
			//커넥션 가져오기
			con = getConnection();
			
			//sql 구문 작성하기
			String sql = "select * from dept_temp where deptno=?";
			
			// return을 dto로 하기위해 여기에다가 선언
			DeptDTO dto = null;	
			
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, deptno);
								
				rs = pstmt.executeQuery();
			
				if(rs.next()) {		
					//System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					
					// rs => DeptDTO에 담기 (따로만들어준 DeptDTO클래스에 생성자 있음)
					deptno = rs.getInt(1);
					String dname = rs.getString(2);
					String loc = rs.getString(3);
					// 담은걸 이용해서 dto객체 생성 ( return을 dto로 해야하기땜에 위에다가 선언하고/ 타입을 DeptDTO로 맞추고/ 아래에 return쓰고)
					dto = new DeptDTO(deptno, dname, loc);
	
					
					// 줄이면 이렇게 쓸수도 있음
//					return new DeptDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
					
					// 이렇게도 가능
//					dto = new DeptDTO();
//					dto.setDeptno(rs.getInt(1));
//					dto.setDname(rs.getString(2));
//					dto.setLoc(rs.getString(3));
					
										
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			
			return dto;
		}  // getRow 메소드 끝
		
	
	
		//select-all (Main의 case2)
		public ArrayList<DeptDTO> getRows() {
			
			// 여러줄이라서 list를 만듦
			ArrayList<DeptDTO> list = new ArrayList<>();
			
			
			try {
				con = getConnection();
				
				String sql = "select * from dept_temp";
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				while(rs.next()) {		
//					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					
					// 방법1.
					int deptno = rs.getInt(1);
					String dname = rs.getString(2);
					String loc = rs.getString(3);
					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					
					list.add(dto);
					
					// 방법2. 
//					list.add(new DeptDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
					
					
//					DeptDTO dto = new DeptDTO();
//					dto.setDeptno(rs.getInt(1));
//					dto.setDname(rs.getString(2));
//					dto.setLoc(rs.getString(3));
//					list.add(dto);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt, rs);
			}
			
			return list;
						
		} // getRows 메소드 끝


		
		
		// 새 부서 추가 메소드 - 사용자 입력 결과를 DAO클래스로 넘기는 방법(Main의 case3의 방법2)
		public boolean insert(DeptDTO dto) { 
					
					boolean status = false;
									
					try {
						
						con = getConnection();
						
						String sql = "insert into dept_temp(deptno, dname, loc) values(?,?,?)";
						
						pstmt = con.prepareStatement(sql);
						
						// ?처리 -dto만들었으니까 불러올수있음
						pstmt.setInt(1, dto.getDeptno());
						pstmt.setString(2, dto.getDname());
						pstmt.setString(3, dto.getLoc());
						
						
						int result = pstmt.executeUpdate();  //DML에선 executeUpdate() 사용 
						
						if(result>0) status=true;
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						close(con, pstmt);
					}
					
					return status;
					
				} //insert() 끝
		
		
		
		
		
		// 새 부서 추가 메소드 (Main의 case3)  -방법1		
		public boolean insert(int deptno, String dname, String loc) { 
			// status를 리턴하니까 status의 타입인 boolean을 써줌, Main에서 입력받은 변수들 여기서 받아서 써야하니까 ()안에 넣어줌
			
			//DML작업은 성공한 행의 갯수만 전달받음 => ResultSet 사용x, int로 받음 
			
			// insert성공여부  => result>0이면 성공임 (행의 갯수가 넘어온단뜻이니까)
			boolean status = false;
			
			
			try {
				
				con = getConnection();
				
				String sql = "insert into dept_temp(deptno, dname, loc) values(?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				// ?처리
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				
				
				int result = pstmt.executeUpdate();  //DML에선 executeUpdate() 사용 
				
				if(result>0) status=true;
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt);
			}
			
			return status;
			
		} //insert() 끝


		
		
		// 부서 정보 수정 메소드 (Main의 case4)
		public boolean update(String value, int deptno, int updateNo) { //sql문에서 뭘 받아와야하는지 생각해서 ()안에 쓰기 
			
			boolean status = false;
			String sql = null;
			
			try {
				
				con = getConnection();
				
				if(updateNo==1) {
					// 부서 수정
					sql = "update dept_temp set dname=? where deptno=?";					
				} else if(updateNo==2) {
					// 위치 수정
					sql = "update dept_temp set loc=? where deptno=?";										
				}
				
				pstmt = con.prepareStatement(sql);
				
				// ?처리
				pstmt.setString(1, value);
				pstmt.setInt(2, deptno);
				
				int result = pstmt.executeUpdate();
				
				if(result>0) status = true;
				
								
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt);
			}
			return status;
		} // update메소드 끝


		
		
		// 부서 정보 삭제 메소드 (Main의 case5)
		public boolean remove(int deptno) {
			boolean status = false;
						
			
			try {
				
				con = getConnection();
				
				// deptno 일치한 부서 삭제
				String sql = "delete from dept_temp where deptno=?";
				
				pstmt = con.prepareStatement(sql);
				
				//?처리
				pstmt.setInt(1, deptno);
				
				int result = pstmt.executeUpdate();
				
				if(result>0) status = true;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, pstmt);
			}
			return status;			
		}  //remove메소드 끝
		
		
		
		
			
						
}
