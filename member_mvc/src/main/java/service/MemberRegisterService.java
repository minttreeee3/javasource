package service;

import domain.MemberDTO;
import persistence.MemberDAO;

public class MemberRegisterService {
	
	public boolean memberInsert(MemberDTO registerDto) {
		MemberDAO dao = new MemberDAO();
		return dao.register(registerDto);
	}

}
