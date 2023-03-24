package database2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	
	// ~DAO : 드라이버로드, 커넥션, select + DML 정의 등의 작업
	
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	
	//드라이버로드
	static {		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	//커넥션
	public Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "TIGER";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	
	//자원닫기
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// select - many : 무조건 ArrayList로 리턴 
	
	public ArrayList<EmpDTO> getList(String ename) { // 받아야하는 ? 에 맞춰서 String ename
		
		ArrayList<EmpDTO> list = new ArrayList<>();		
		
		try {
			
			con = getConnection();
			
			// ename을 입력받은 사람 조회(empno, ename, job, hiredate) 
			String sql = "select empno, ename, job, hiredate from emp_temp where ename=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setHiredate(rs.getDate(4));
				//갖고나온 데이터를 empDTO에 담아서 list에 추가 
				list.add(empDTO);
			}
			
						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		} 
		return list;						
	}
	
	
	
	
	// select - one : DTO 리턴
	
	public EmpDTO getRow(int empno) {
		EmpDTO empDTO = null;
		
		try {
			
			con = getConnection();
			
			// where절에 pk(primary key=기본키 -> 중복불가, null불가)가 조건으로 들어오는경우 무조건 하나의 행이 나옴
			// empno, deptno 등이 pk임
			String sql = "select empno, ename, job, sal, comm, deptno from emp_temp where empno=?"; 
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt(1));
				empDTO.setEname(rs.getString(2));
				empDTO.setJob(rs.getString(3));
				empDTO.setSal(rs.getInt(4));
				empDTO.setComm(rs.getInt(5));
				empDTO.setDeptno(rs.getInt(6));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}		
		return empDTO;		
	}
	
	
	
	
	

}
