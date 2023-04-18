<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP : Java Server Page
			html 작성하기 편하게 되어있음
			자바코드를 사용할 수 있음 
			
			http://localhost:8080/web1/basic/hello.html
			
			http://localhost:8080 : 도메인명
			localhost == 127.0.0.1 == 내컴퓨터
			8080 포트번호 ==> 변경가능
			
			/web1 : 프로젝트명
			/basic : webapp폴더아래에 생성한 폴더
			
			프로젝트 명 제거후
			http://localhost:8080/basic/hello.html
			-->
<%
	// 자바 코드 작성하기
	// HttpServletRequest request: 사용자의 요청 가져오기
	
	// post방식은 데이터를 가져올때 한글은 깨짐
	// form에서 method="get"으로하면 한글 안깨짐 
	// post로 하면서도 한글 안깨지게 하려면 데이터 가져오기 전에 제일먼저 코딩 
	request.setCharacterEncoding("utf-8"); 
	
%>
<h3>이름</h3>
<%=request.getParameter("name") %>  <!-- html에서 작성한 input의 name이랑 맞추는것 -->
<%=request.getParameter("age") %>
</body>
</html>
