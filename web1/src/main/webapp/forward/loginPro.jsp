<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h4>아이디 : <%=request.getParameter("userid") %></h4>
<h4>비밀번호 : <%=request.getParameter("password") %></h4> --%>


<!-- forward 하면 request가 같아짐 
		=> login에서 한 setAttribute를 loginPro에서 getAttribute로 불러올수있음 
			(session을 사용하지 않고) -->
<h4>아이디 : <%=request.getAttribute("userid") %></h4>
<h4>비밀번호 : <%=request.getAttribute("password") %></h4>
</body>
</html>