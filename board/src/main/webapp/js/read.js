/**
 * 
 */
document.querySelector(".btn-success").addEventListener("click",()=>{
	location.href = "list.do";
})




// form에다가 submit걸거나
document.querySelector(".btn-primary").addEventListener("click", (e) => {
	// 수정 클릭시 submit 기능 중지
	e.preventDefault();
	
	
	// readForm을 가져온 후 readForm 전송 - modify.do로 
	const reaForm = document.querySelector("#readForm");
	readForm.action = "modify.do";
	readForm.submit();
	
});

