package action;

import javax.servlet.http.HttpServletRequest;

import service.MemberDupService;

public class MemberDupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// 
		String userid = request.getParameter("userid");
		
		MemberDupService service = new MemberDupService();
		boolean dupFlag = service.dupId(userid);
		
		// true면 아이디 사용가능(중복없음) 
		if(dupFlag) {
			request.setAttribute("dupId", "true");
		} else {
			request.setAttribute("dupId", "flase");
		}
		
		
		return new ActionForward(false, "checkId.jsp");
	}

}
