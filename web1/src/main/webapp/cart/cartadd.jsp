<%@page import="java.util.ArrayList"%>
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
	// cart.html 에서 사용자가 선택한 자동차 가져오기
	String product = request.getParameter("product");


	// 여러번 선택했을때 이전선택 안날아가고 장바구니처럼 계속 담길수있게하려면
	// 배열 - ArrayList 사용 / 순서가있는건 전부 index로 접근 
	
	// session에 ArrayList 사용
	// 자동차를 추가하기 전에 이미 생성된 List session이 존재하는지 확인해야함
		ArrayList<String> products = (ArrayList<String>)session.getAttribute("products");
	// 존재하지 않는다면 - 새로운 List를 만들어서 session 추가 
		if(products == null) {
			products = new ArrayList<>();
			products.add(product);
			session.setAttribute("products", products);
		} else {
	// 이미 존재한다면 - 해당 session에 선택된 자동차를 추가만 하면 됨
			products.add(product);			
		}
	
	

	// 가져온 자동차 정보를 session에 저장 => 장바구니 
	// 하나만 담는다면
	// session.setAttribute("product", product);

%>
	<h3>장바구니 저장</h3>	
	 <!-- 이동할 수 있는 페이지 제공 -->
	<h4><a href="cartlist.jsp">장바구니 보기</a></h4>
</body>
</html>