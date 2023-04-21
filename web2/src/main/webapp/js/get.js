/**
 * 목록으로 클릭 시 : list.jsp
 * 수정 클릭 시 : form 안의 no값 가져오기, modify.jsp로 이동 
 * 				==> 주소를 (modify.jsp?no=가져온값)으로 
 * 삭제 클릭 시 : form안의 no값 가져오기
 * 				==> 주소를 remove.jsp?no=가져온값
 * 
 */

// form안의 히든태그로 담아둔 no를 갖고오는 방식
// const no = document.querySelector("#no").value;


 document.querySelector(".btn-primary").addEventListener("click", () => {	 
	 location.href = "list.jsp";
 });
 document.querySelector(".btn-success").addEventListener("click", () => {	 
	 location.href = "modify.jsp?no="+no;
 });
 document.querySelector(".btn-danger").addEventListener("click", () => {	 
	 location.href = "remove.jsp?no="+no;
 });