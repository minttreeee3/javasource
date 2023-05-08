package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.service.BoardReadService;

public class BoardReplyViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// get 
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 페이지 나누기 정보
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		PageDTO pageDTO = new PageDTO(criteria, keyword, page, amount);		
		
		// service
		BoardReadService service = new BoardReadService();
		BoardDTO dto = service.read(bno);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageDTO", pageDTO);
		
		
		// 원글을 읽어오는거라서 위에는 read서비스고 페이지만 replyForm으로 
		return new ActionForward(false, "replyForm.jsp");
	}
}







