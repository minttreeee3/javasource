package action;

import javax.servlet.http.HttpServletRequest;

import domain.MemberDTO;
import service.MemberRegisterService;


public class MemberRegisterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// post가져오기
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		//DTO만들고 service가져오기
		MemberDTO registerDto = new MemberDTO(userid, password, name, gender, email); 
		MemberRegisterService service = new MemberRegisterService();
		boolean registerFlag = service.memberInsert(registerDto);
		
		//회원가입 성공시 로그인페이지
		String path = "";
		if(registerFlag) {
			path = "login.jsp"; 
		} else {
			path = "register.jsp";  
		}
		
		// ActionForward 만들기 
		return new ActionForward(true, path);

	}

}
