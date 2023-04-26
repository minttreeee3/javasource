package action;

import javax.servlet.http.HttpServletRequest;

public class DeleteAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		System.out.println("code "+request.getParameter("code"));
		
		return new ActionForward(true, "list.jsp");
	}
}
