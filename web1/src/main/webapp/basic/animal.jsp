<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp 주석 --%>
<!-- html주석 -->
<%
	request.setCharacterEncoding("utf-8");

	// getParameter => 여러개 선택해도 값을 하나만 가져옴 
	//String animals = request.getParameter("animal"); 
	
	String animals[] = request.getParameterValues("animal"); //배열로 리턴됨
	
	
	
	// 화면에 출력 (아래랑 똑같은 결과 - 태그 쓸 때 편한 쪽으로)
	out.print("<h3>"+Arrays.toString(animals)+"<h3>"); 
	
%>
<h3><%=Arrays.toString(animals)%></h3>
</body>
</html>