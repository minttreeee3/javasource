package action;

import javax.servlet.http.HttpServletRequest;

// execute로 통일하기 위해서 인터페이스
public interface Action {
	public void execute(HttpServletRequest request) throws Exception;
}
