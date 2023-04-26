package action;

import javax.servlet.http.HttpServletRequest;

public interface BookAction {
	// 추상메소드 
	public BookActionForward execute(HttpServletRequest request) throws Exception;
}
