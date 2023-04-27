package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.BookDTO;
import domain.SearchDTO;
import service.BookSearchService;

public class BookSearchAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// get
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		// DAO
		BookSearchService service = new BookSearchService();
		List<BookDTO> list = service.list(criteria, keyword);
		
		//request.setAttribute("criteria", criteria); //검색후에 뭘검색했는지 알수있게하려고 => list.jsp에서 달러{}로 꺼내씀 
		//request.setAttribute("keyword", keyword);
		//한번에 담으려고 DTO생성
		SearchDTO searchDTO = new SearchDTO(criteria, keyword);
		
		request.setAttribute("searchDTO", searchDTO);
		request.setAttribute("list", list);
		
		return new BookActionForward(false, "list.jsp");
	}

}
