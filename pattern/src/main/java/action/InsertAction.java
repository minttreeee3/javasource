package action;

import javax.servlet.http.HttpServletRequest;

import service.InsertService;

public class InsertAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// get or post 넘어오는 내용 가져오기
		System.out.println("이름 "+request.getParameter("name"));
		
		// 서비스 호출
		InsertService service = new InsertService();
		// ﻿서비스 요청 결과를 받음
		boolean result = service.insertArticle();
		
		
		ActionForward af = null;
		if(result) {
			af = new ActionForward(true, "list.jsp");
		} else {
			af = new ActionForward(true, "insert.jsp");
		}
		
		// return 페이지이동방식(true,false), 페이지(String) ==>두개이상을 return하기위해선 객체로 만들어야함 
		// sendRedirect 방식일 때는 true, forward방식일 때는 false로 세팅 
		return af;
	}

}
