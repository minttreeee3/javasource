package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.MemberDTO;
import service.MemberLoginService;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// post 가져오기
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// service
		MemberLoginService service = new MemberLoginService();
		MemberDTO loginDto = service.login(userid, password);
		
		String path = "";
		if(loginDto != null) { // login정보가 틀리면 null이 담김 (isLogin메소드만들때 null로 초기화하고 시작함,로그인실패하면 rs에 값이 안담기니까) 
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			path = "index.jsp";
		} else {
			path = "login.jsp";
		}
		
		// ActionForward
		return new ActionForward(true, path);
	}

}
