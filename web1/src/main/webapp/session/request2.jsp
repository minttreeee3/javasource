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
	<h2>request2</h2>
	<%=session.getAttribute("name") %>
	<!-- request1에서 받은 name 사용하려면... 
		getParameter~ 하는건 html에서 action에 직접 연결된 폼에서만 가능함(request1에서만 쓸수있음)
		
		==> request2에서 쓰려면 
			HttpSession 객체 사용해야함 
			1) 사용할 값을 담아둔다 : setAttribute("키", 담아놓을 값)
			2) 필요한 페이지에서 꺼내쓴다 : getAttribute("키")
			
			로그인 유지시키는 개념임 
			
	-->
	
	<% //DTO로 담은거 불러오기
	
		// LoginDTO loginDTO = (LoginDTO)session.getAttribute("loginDTO");  //타입이 안맞아서 형변환 한거임 
		
		// EL(Expression Language) : jsp에서 데이터를 추출하는 표현식 
		//							setAttribute()로 담아놓은 값을 쉽게 찾아다 쓰기
		//							${이름.변수명} 으로 간단하게 (setAttribute을 담은 이름, 사용했던 변수명)
	
	%>
	
	<h3>로그인 정보</h3>
	<ul>
		<%-- <li>아이디 : <%=session.getAttribute("id") %></li>
		<li>비밀번호 : <%=session.getAttribute("pwd") %></li> --%>
		
		<%-- <li>아이디 : <%=loginDTO.getUserId() %></li>
		<li>비밀번호 : <%=loginDTO.getPassword() %></li> --%>
		<li>아이디 : ${loginDTO.userId}</li>
		<li>비밀번호 : ${loginDTO.password}</li>
	</ul>
</body>
</html>