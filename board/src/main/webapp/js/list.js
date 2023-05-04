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
	 
	 form.submit();
	 
 });