<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 모든 요청을 서블릿으로 보내기 -->

<ul>
<!-- /list.do 이렇게쓰면 http://localhost:8080/ 다음에 바로 붙게됨, list.do로 쓰면 프로젝트명다음에 가서 붙게됨 
	그런데 c:url 쓰면 / 써도 프로젝트명 알아서 붙여주고 그 다음에 주소가 붙음 
	-->
	<li><a href='<c:url value="/list.do"/>'>리스트</a></li>
	<li><a href='<c:url value="/insert.jsp"/>'>삽입</a></li>
	<li><a href='<c:url value="/delete.do?code=1001"/>'>삭제</a></li>
	<li><a href='<c:url value="/update.do"/>'>수정</a></li>

</ul>
</body>
</html>