package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.DeleteAction;
import action.InsertAction;


@WebServlet("*.do") // Url mapping : 이름은 상관없으나, 끝날때는 .do로 끝나야한다고 설정함 
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String requestURI = request.getRequestURI(); 	//	/pattern/list.do
		// 프로젝트 == context 
		String contextPath = request.getContextPath();	//	/pattern
		String cmd = requestURI.substring(contextPath.length());	//	/list.do
		
		// 주소 이동할때 콘솔창에 찍힘 
		System.out.println("requestURI "+requestURI);
		System.out.println("contextPath "+contextPath);
		System.out.println("cmd "+cmd);
		

		// ActionFactory 인스턴스 호출 (private로 만들어서 직접생성은 못하고) 
		ActionFactory actionFactory = ActionFactory.getInstance();		
		// ActionFactory에 만든 action리턴메소드 호출
		Action action = actionFactory.action(cmd);
		
		
		// 생성된 액션에 일 시키기(=메소드 호출)
		ActionForward af = null;
		try {
			af = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//﻿받은 ActionForward에 맞춰 사용자에게 화면 보여주기
		if(af.isRedirect()) { //true라면
			response.sendRedirect(af.getPath());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
