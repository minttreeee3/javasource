/**
 * 
 */
document.querySelector(".btn-success").addEventListener("click",()=>{
	location.href = "list.do";
})



// 삭제버튼 클릭 시 modifyForm 전송
// action -> delete.do 

document.querySelector(".btn-danger").addEventListener("click", () => {
	//password입력여부 확인
	const password = document.querySelector("#inputPassword");
	
	if(password.value == "") {
		alert("비밀번호를 확인해 주세요");
		password.focus();
		return;
	}
	
	// 사용자가 입력한 비밀번호를 가져와서 
	// #password 요소의 value값으로 세팅
	document.querySelector("#password").value = password.value;
	
	
	const modifyForm = document.querySelector("#modifyForm");
	
	modifyForm.action = "delete.do";
	modifyForm.method = "post";
	console.log(modifyForm);
	modifyForm.submit();
});
