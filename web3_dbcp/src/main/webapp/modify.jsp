<%@page import="user.domain.UserDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    
<%
	// 수정할 회원 정보 보여준 후 새로운 값을 입력한 후 수정 버튼 누르면 새로운 값으로 업데이트
	
	// UserDTO dto = (UserDTO)request.getAttribute("dto");
	
	
%>
    

    
    <h1>회원 수정</h1>
	
<form action="updatePro.jsp" method="post">

<%-- <input type="hidden" name="no" value="<%=dto.getNo()%>" /> --%>
<input type="hidden" name="no" value="${dto.no}" />

  <div class="mb-3">
    <label for="addr" class="form-label">기존 주소</label>
    <%-- <input type="text" class="form-control" id="addr" name="addr" value="<%=dto.getAddr()%>" readonly> --%>
    <input type="text" class="form-control" id="addr" name="addr" value="${dto.addr}" readonly>
  </div>
  <div class="mb-3">
    <label for="newaddr" class="form-label">변경할 주소</label>
    <input type="text" class="form-control" id="newaddr" name="newaddr" >
  </div>
  <div class="mb-3">
    <label for="mobile" class="form-label">mobile</label>
    <%-- <input type="text" class="form-control" id="mobile" name="mobile" value="<%=dto.getMobile()%>" readonly> --%>
    <input type="text" class="form-control" id="mobile" name="mobile" value="${dto.mobile}" readonly>
  </div>
  <div class="mb-3">
    <label for="newmobile" class="form-label">변경할 mobile</label>
    <input type="text" class="form-control" id="newmobile" name="newmobile" >
  </div>
	
  <button type="button" class="btn btn-primary">목록으로</button>
  <button type="submit" class="btn btn-success">수정</button>
</form>

<%

%>
<script src="/js/modify.js"></script>
<%@ include file="/include/footer.jsp" %>