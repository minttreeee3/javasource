<%@page import="user.domain.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userId = request.getParameter("userid");
	String password = request.getParameter("password");
	
	
	// 다른곳으로 이동해서도 꺼내쓸수있게 session에 담아두기
	/* session.setAttribute("id", userId);
	session.setAttribute("pwd", password); */
	
	// 한번에 하려면 DTO 객체를 사용 => DTO객체를 생성한 뒤에 session에 담음	
	LoginDTO loginDTO = new LoginDTO(userId, password);
	session.setAttribute("loginDTO", loginDTO);
	
	/* 한줄로 정리 ==> session.setAttribute("loginDTO", new LoginDTO(userId, password)); */
	
%>

<h4>아이디 : <%=userId %></h4>
<h4>비밀번호 : <%=password %></h4>
<h4><a href="request2.jsp">이동</a></h4>

</body>
</html>