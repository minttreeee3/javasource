package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardReadService;

public class BoardReplyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// get 
		int bno = Integer.parseInt(request.getParameter("bno"));
		// service
		BoardReadService service = new BoardReadService();
		BoardDTO dto = service.read(bno);
		
		request.setAttribute("dto", dto);
		
		// 원글을 읽어오는거라서 위에는 read서비스고 페이지만 replyForm으로 
		return new ActionForward(false, "replyForm.jsp");
	}
}







