package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.domain.PageDTO;
import board.service.BoardReadService;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// 요소 가져오기 
		int bno = Integer.parseInt(request.getParameter("bno"));
				
		// 페이지 나누기 정보
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		PageDTO pageDTO = new PageDTO(criteria, keyword, page, amount);
		
		// 서비스 가져오기 (Read서비스랑 같음 - 수정하려면 일단 원래 내용을 읽어야 하니까)
		BoardReadService service = new BoardReadService();
		BoardDTO dto = service.read(bno);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageDTO", pageDTO);
		
		// modifyForm.jsp 보여주기
		return new ActionForward(false, "modifyForm.jsp");
	}

}
