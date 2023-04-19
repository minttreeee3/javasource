<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	세션과 쿠키
	세션 : 서버쪽에 저장 (객체 상태로 저장 가능)
	쿠키 : 클라이언트 쪽에 저장 (객체로 저장 불가 = DTO사용못함 , 하나씩 따로 해야함), 
		  만료기간 지정, 저장할 수 있는 양이 정해져있음
	
	웹 스토리지 : 브라우저에 저장(스크립트에서 할 수 있음)
				영구저장 가능, 쿠키보다는 큰 데이터 저장 가능
	로컬 스토리지
	세션 스토리지
 -->
 <%
 
 	// 서버에서 클라이언트한테 응답시 특정 값을 붙여서 보냄
 	
 	response.addCookie(new Cookie("name", "John"));
 	response.addCookie(new Cookie("gender", "Male"));
 	response.addCookie(new Cookie("age", "30"));
 	response.addCookie(new Cookie("addr", "Seoul"));
 %>
 <h3>쿠키 데이터가 저장되었습니다</h3>
 <a href="getCookie1.jsp">쿠키 확인하러 가기</a>
 
 
 <!-- 
 	http://localhost:8080/cookie/cookie1.jsp 요청하면
 	cookie1.jsp 응답 = 브라우저 헤더 정보에 쿠키 정보를 같이 보냄
	 클라이언트 컴퓨터에 쿠키정보가 저장됨
 
	 http://localhost:8080/cookie/cookie1.jsp 요청
 	쿠키 저장소에 있는 http://localhost:8080/이 저장해놓은 값들이 따라가게 됨 
 	서버는 담아놓은 쿠키정보를 확인할 수 있게 됨
 
 -->
</body>
</html>

