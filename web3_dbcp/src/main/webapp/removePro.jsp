
<%@page import="user.persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 보는 페이지 아님
	// no값 가져오기
	int no = Integer.parseInt(request.getParameter("no"));
	//out.print("no"+no);
	
	UserDAO dao = new UserDAO();
	 
	
	// 삭제 결과에 따라 페이지 이동
	String path = "";
	if (dao.remove(no)) {
		path = "listPro.jsp";	//성공
	} else {
		path = "get.jsp?no="+no; //remove실패
	}
	response.sendRedirect(path);
	
%>