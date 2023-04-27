/**
 * 폼의 모든 요소가 비어있는지 확인
 * 하나라도 비어있으면 못가게 막아야함 
 * 
 */

 const form = document.querySelector("form");
 
 const userid = document.querySelector("#userid");
 const password = document.querySelector("#password");
 const name = document.querySelector("#name");
 const gender = document.querySelector(".form-check-input");
 const email = document.querySelector("#email");
 
 form.addEventListener("submit", (e) => {
	 e.preventDefault();
	 
	 if(userid.value =="") {
		 alert("아이디를 확인해 주세요");
		 userid.select();
		 return;
	 } else if(password.value =="") {
		 alert("비밀번호를 확인해 주세요");
		 password.select();
		 return;
	 } else if(name.value =="") {
		 alert("이름을 확인해 주세요");
		 name.select();
		 return;
	 } else if(gender.value == null) {
		 alert("성별을 선택해 주세요");
		 return;
	 } else if(email.value =="") {
		 alert("이메일을 확인해 주세요");
		 email.select();
		 return;
	 }
	 
	 form.submit();
	 
 });