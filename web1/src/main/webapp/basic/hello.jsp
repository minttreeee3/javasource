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
			html �ۼ��ϱ� ���ϰ� �Ǿ�����
			�ڹ��ڵ带 ����� �� ���� 
			
			http://localhost:8080/web1/basic/hello.html
			
			http://localhost:8080 : �����θ�
			localhost == 127.0.0.1 == ����ǻ��
			8080 ��Ʈ��ȣ ==> ���氡��
			
			/web1 : ������Ʈ��
			/basic : webapp�����Ʒ��� ������ ����
			
			������Ʈ �� ������
			http://localhost:8080/basic/hello.html
			-->
<%
	// �ڹ� �ڵ� �ۼ��ϱ�
	// HttpServletRequest request: ������� ��û ��������
	
	// post����� �����͸� �����ö� �ѱ��� ����
	// form���� method="get"�����ϸ� �ѱ� �ȱ��� 
	// post�� �ϸ鼭�� �ѱ� �ȱ����� �Ϸ��� ������ �������� ���� ���ϸ��� �ڵ� 
	request.setCharacterEncoding("utf-8"); 
	
%>
<h3>�̸�</h3>
<%=request.getParameter("name") %>  <!-- html���� �ۼ��� input�� name�̶� ���ߴ°� -->
<%=request.getParameter("age") %>
</body>
</html>
