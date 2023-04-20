<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String userid = request.getParameter("userid");
	String password = request.getParameter("password");

	
	// loginPro에서 userid, password값을 공유하고 싶음
	// setAttribute(), getAttribute(), removeAttribute()
	
	request.setAttribute("userid", userid);
	request.setAttribute("password", password);
	
	
	// 화면에 보여주는 내용은 전부 loginPro에서 
	pageContext.forward("loginPro.jsp");

%>