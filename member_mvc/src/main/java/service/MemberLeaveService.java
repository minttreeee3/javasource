package service;

import persistence.MemberDAO;

public class MemberLeaveService {
	
	public boolean leave(String userid, String password) {
		MemberDAO dao = new MemberDAO();
		return dao.delete(userid, password);
	}

}
