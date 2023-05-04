/**
 *  전체리스트
 * 	http://localhost:8080/board/list.do?criteria=&keyword=
 * 뭔가 따라붙으면 검색리스트
 * 	http://localhost:8080/board/list.do?criteria=title&keyword=게시글 
 * 로 바꿔서
 * 둘다 list.do를 쓰도록 합치기 
 */

 document.querySelector(".btn-primary").addEventListener("click", () => {
	 location.href = "list.do?criteria=&keyword=&page=1&amount=30";
 });
 
 