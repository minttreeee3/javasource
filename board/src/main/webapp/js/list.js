/**
 * 
 * 
 */

// 검색 클릭시 검색기준 value, keyword 입력여부 확인 - 있으면 submit, 없으면 막기

 const form = document.querySelector("form");
 const criteria = document.querySelector(".form-select");
 const keyword = document.querySelector(".form-control");
 
 form.addEventListener("submit", (e) => {
	 
	 e.preventDefault();
	 
	 if(criteria.value === "n") {
		 alert("검색 기준을 선택해 주세요");
		 criteria.focus();
		 return;
	 } else if(keyword.value === "") {
		 alert("검색어를 입력해 주세요");
		 keyword.select();
		 return;
	 }
	 
	 // page 태그의 value 값을 1로 변경 
	 // 게시판 5페이지보다가 검색하면 5페이지부터 나오게됨 => 검색했을때 1페이지로 가게하려고
	 document.querySelector("[name='page']").value = "1"; 
	 
	 form.submit();
	 
 });
 
 
 // 페이지 나누기 클릭
 // a태그 기능 중지
 // href값 가져오기
 // page 값을 href값 가져온 걸로 대체 (내가 클릭한 값으로 바꾼다고...)
 // actionForm 가져온 후 보내기
 
 // const pageLinks = document.querySelectorAll(".page-link");
 const actionForm = document.querySelector("#actionForm");
 
 /*pageLinks.forEach(pageLink => {	
	 pageLink.addEventListener("click", (e) => {
		e.preventDefault(); 
		
		console.log(e.target);
		console.log(e.target.href);
		console.log(e.target.getAttribute("href"));
		
		const href = e.target.getAttribute("href");
		
		const page = document.querySelector("#actionForm input:nth-child(3)");
		page.value = href;
		
		console.log(actionForm);
		actionForm.submit();
		 
	 }) 
	
 });
 
 */
 
 const bno = document.querySelector("#actionForm input:nth-child(1)");
 
 // 이벤트 버블링 개념을 이용한다면 
 // 자식의 이벤트가 부모로 전달 됨 
 const pagination = document.querySelector(".pagination");
 pagination.addEventListener("click", (e) => {
	 
	 e.preventDefault(); 
		
		console.log(e.target);
		console.log(e.target.href);
		console.log(e.target.getAttribute("href"));
		
		const href = e.target.getAttribute("href");
		
		const page = document.querySelector("#actionForm input:nth-child(4)");
		page.value = href;
		
		console.log(actionForm);
		actionForm.action = "list.do"; 
		actionForm.submit();
	 
 });
 
 
 // 게시물 개수 변경이 일어날 때 actionForm 전송하기
 // actionForm 안의 amount값은 사용자의 선택값으로 변경 후 전송 
 document.querySelector("select[name='amount']").addEventListener("change", (e) => {
	 
	 const amount = document.querySelector("#actionForm input:nth-child(5)");
	 amount.value = e.target.value;
	 
	 actionForm.action = "list.do"; 
	 actionForm.submit();
 });
 
 
 
 // 제목 클릭 시
 // a 태그 중지
 // href 값 가져오기 => bno
 // action에 bno태그 하나 추가한 후 actionForm 전송하기
 
 const moves = document.querySelectorAll(".move");
 
 moves.forEach(move => {
 	move.addEventListener("click", (e) => {
	 	e.preventDefault();
	 	
	 	const href = e.target.getAttribute("href");
	 	
	 	//const element = "<input type='hidden' name='bno' value='" +href + "'>";
	 	//actionForm.insertAdjacentHTML("afterbegin", element);
	 	
	 	// actionForm 안의 bno를 찾아온 후 value를 href값으로 지정
	 	bno.value = href;
	 	console.log(actionForm);
	 	actionForm.action = "cntUpdate.do";
	 	actionForm.submit();
	 
 	});
	 
 })
 
 
 
 
 
 