/** 세션 값 저장 버튼 클릭시 sessionSet.jsp로 이동
/** 세션 값 삭제 버튼 클릭시 sessionDel.jsp로 이동
/** 세션 값 초기화 버튼 클릭시 sessionInv.jsp로 이동
 * 
 */
document.querySelector(".btn-primary").addEventListener("click", () => {
	location.href = "sessionSet.jsp";
})
document.querySelector(".btn-success").addEventListener("click", () => {
	location.href = "sessionDel.jsp";
})
document.querySelector(".btn-danger").addEventListener("click", () => {
	location.href = "sessionInv.jsp";
})