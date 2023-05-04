/**
 * 
 */
document.querySelector(".btn-success").addEventListener("click",()=>{
	location.href = "list.do";
})





// readForm을 가져온 후 readForm 전송 - modify.do로 
	const reaForm = document.querySelector("#readForm");


// 답변 클릭시 
document.querySelector(".btn-secondary").addEventListener("click",()=>{
	readForm.action = "replyView.do";
	readForm.submit();
})


 // form에다가 submit걸어도 됨
document.querySelector(".btn-primary").addEventListener("click", (e) => {
	// 수정 클릭시 submit 기능 중지
	e.preventDefault();
		
	readForm.action = "modify.do";
	readForm.submit();
	
});

