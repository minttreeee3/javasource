package service;

import domain.ChangeDTO;
import persistence.MemberDAO;

public class MemberChangeService {
	
	public boolean changePwd(ChangeDTO dto) {
		MemberDAO dao = new MemberDAO();
		return dao.update(dto);
	}

}
