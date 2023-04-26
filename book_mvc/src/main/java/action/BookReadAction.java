package action;

import javax.servlet.http.HttpServletRequest;

import domain.BookDTO;
import service.BookReadService;

public class BookReadAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// get or post 넘어오는 내용 가져오기
		int code = Integer.parseInt(request.getParameter("code"));
		
		// service를 통해 데이터베이스 작업
		BookReadService service = new BookReadService();
		BookDTO dto = service.read(code);
		
		//boolean값 아니면 다 이렇게 담음 
		request.setAttribute("dto", dto);
		
		// setAttribute 나오면 forward로 이동함 
		return new BookActionForward(false, "read.jsp");
	}

}
