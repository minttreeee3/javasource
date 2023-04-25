<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

	<h1>도서 상세 조회</h1>
	
<form action="" method="post">
  <div class="mb-3">
    <label for="name" class="form-label">code</label>
    <input type="text" class="form-control" id="code" name="code" value="${dto.code}" readonly>
  </div>
  <div class="mb-3">
    <label for="birthYear" class="form-label">title</label>
    <input type="text" class="form-control" id="title" name="title" value="${dto.title}" readonly>
  </div>
  <div class="mb-3">
    <label for="addr" class="form-label">writer</label>
    <input type="text" class="form-control" id="writer" name="writer" value="${dto.writer}" readonly>
  </div>
  <div class="mb-3">
    <label for="mobile" class="form-label">price</label>
    <input type="text" class="form-control" id="price" name="price" value="${dto.price}" readonly>
  </div>
  <div class="mb-3">
    <label for="mobile" class="form-label">description</label>
    <textarea class="form-control" id="description" name="description" readonly>${dto.description}</textarea>
  </div>

  <button type="button" class="btn btn-primary">목록으로</button>
  <button type="button" class="btn btn-success">수정</button>
</form>
<script>
	// read.js에서 불러다 쓰기 위해서 만들어두는 변수
	const code = ${dto.code}; 
</script>
<script src="/js/read.js"></script>
<%@ include file="/include/footer.jsp" %>
