<%@page import="java.net.URLEncoder"%>
<%@page import="board.domain.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<main>
	<h2>Board Update</h2>
	<form action='<c:url value="/update.do" />' method="post" enctype="multipart/form-data">
		<div class="row mb-3">
			<label for="inputName" class="col-sm-2 col-form-label">작성자</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputName" name="name" readonly value="${dto.name}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputTitle" class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputTitle" name="title" value="${dto.title}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputContent" class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<textarea rows="10" class="form-control" id="inputContent" name="content" >${dto.content}</textarea>
			</div>
		</div>
		<div class="row mb-3">
			<label for="inputAttach" class="col-sm-2 col-form-label">파일첨부</label>
			
			
			
			
		<%-- <div class="col-sm-10">
				<a href="download.jsp?fileName=${dto.attach}">${dto.attach}</a>
			</div> --%>
			
			<!-- 
				파일명에 ++와 같은 특수문자가 들어있거나 하는경우에는 다운로드 요청시 문제가 생김
			 -->
			 <div class="col-sm-10">
			 <%
			 	// 다운로드 받을 파일명 가져오기 ==> EL과 java코드가 호환이 안됨
			 	BoardDTO dto = (BoardDTO)request.getAttribute("dto");
			 	
			 	String attachFullName = dto.getAttach();		
			 	
			 	// 첨부파일 없으면 널포인트 뜨기때문에 널이아닐때에만 
			 	if(attachFullName!=null) {
			 		// 작성자가 올린 파일명 분리
			 		String attachName = attachFullName.substring(attachFullName.indexOf("_")+1);
			 		// 특수문자 해결
			 		String encodeAttach = URLEncoder.encode(attachFullName, "utf-8");
			 		out.print("<a href='download.jsp?fileName="+encodeAttach+"'>");
			 		out.print(attachName);
			 		out.print("</a>");
			 	} else { // 파일없을때 - 새로 올릴 수 있게 
			 		out.print("<input type='file' class='form-control' id='inputAttach' name='attach'>");
			 	}
			 %>							
			</div>
			

			
		<div class="row mb-3">
    		<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
    		<div class="col-sm-10">
      			<input type="password" class="form-control" id="inputPassword" name="password" required>
    		</div>
  		</div>	
						
		</div>		 
	<!-- bno를 하나 숨겨서 가져감 => update,deleteAction에서 getParameter로 가져가기위해- 나머지는 다 있는데 bno는 위에 없기땜에 -->
		<input type="hidden" name="bno" value="${dto.bno}" />
		<button type="submit" class="btn btn-primary">수정</button>		
		<button type="button" class="btn btn-danger">삭제</button>		
		<button type="button" class="btn btn-success">목록보기</button>
	</form>
</main>
<form action="" id="modifyForm">
	<input type="hidden" name="bno" value="${dto.bno}" />
	<input type="hidden" name="password" value="" id="password" />
</form>

<script src='<c:url value="/js/modify.js"/>'></script>
<%@ include file="include/footer.jsp"%>












