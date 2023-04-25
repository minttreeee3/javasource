<%@page import="user.domain.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="user.persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	UserDAO dao = new UserDAO();
	List<UserDTO> list = dao.getList();
	
	//결과값 list를 list.jsp에서 보여주고싶음
	request.setAttribute("list", list);
	pageContext.forward("list.jsp");
	
%>