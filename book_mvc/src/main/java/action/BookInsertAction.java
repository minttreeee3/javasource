package action;

import javax.servlet.http.HttpServletRequest;

import domain.BookDTO;
import service.BookInsertService;

public class BookInsertAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		// get or post 넘어오는 내용 가져오기
		int code = Integer.parseInt(request.getParameter("code"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		
				
		// service를 통해 DB작업
		BookDTO insertDto = new BookDTO(code, title, writer, price, description);
		BookInsertService service = new BookInsertService();
		boolean insertFlag = service.insertBook(insertDto);
		
		String path = "";
		if(insertFlag) {
			path = "list.do"; //insert성공시 list.do => 서블릿 ListAction, ListService => list.jsp로 돌아가게됨  
		} else {
			path = "insert.jsp"; // 실패시 insert.jsp => 다시입력하고 저장버튼누르면 form action에 걸린 insert.do 요청 
		}
		
		// ActionForward 만들기 
		return new BookActionForward(true, path);
	}

}
