<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	// form 내용 가져오기
	String addr = request.getParameter("newaddr");
	String mobile = request.getParameter("newmobile");
	int no = Integer.parseInt(request.getParameter("no"));
	
	// DB insert작업
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javadb";
	String password = "12345";
	Connection con = DriverManager.getConnection(url, user, password);
	
	
	PreparedStatement pstmt = null;
	String sql = "";
	
	// update usertbl set addr=?, mobile=? where no=? 
	if(addr!="" && mobile!="") {
		sql = "update usertbl set addr=?, mobile=? where no=?";		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, addr);
		pstmt.setString(2, mobile);
		pstmt.setInt(3, no);
		
		} else {		
	// update usertbl set addr=? where no=? 
			if (addr!="") {
				sql = "update usertbl set addr=? where no=?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, addr);
				pstmt.setInt(2, no);
		
	// update usertbl set mobile=? where no=? 
			} else {
				sql = "update usertbl set mobile=? where no=?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mobile);
				pstmt.setInt(2, no);
			}
				
		}
	
		
	
	int count = pstmt.executeUpdate();
	
				
	// update 성공시 페이지이동 get.jsp?no= 로 
	if (count>0) {
		response.sendRedirect("get.jsp?no="+no);
	}


%>




