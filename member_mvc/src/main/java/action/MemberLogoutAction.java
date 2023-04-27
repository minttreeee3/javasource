package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// get/post 넘어오는게 없음
		// service도 필요없음 (로그아웃은 DB작업이 필요없음)
		
		// session 해제해야함
		HttpSession session = request.getSession();
		session.removeAttribute("loginDto"); // or session.invalidate(); 이건 전체를 날리는거
		
		// ActionForward : index.jsp로 이동		
		return new ActionForward(true, "index.jsp");
	}

}
