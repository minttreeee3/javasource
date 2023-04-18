package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsp == Servlet : 할 수 있는 일이 같음 
 * 					사용자 요청 처리  
 * 화면에 보여주는 작업은 jsp, 클래스 작업은 servlet이 더 편함 
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//form을 get으로 줄때 작동하는 메소드 (파라미터가 정해져있음) 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		//get방식일땐 한글 원래 안깨짐, 근데 post에서 넘어오게 될때 깨질수도있으니까 
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		//화면에 보여주기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3> 이름 : "+name+"</h3>");
		out.print("<h3> 나이 : "+age+"</h3>");
	}

	//post로 줄때 작동하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		// doGet메소드 실행하게 => 반복코드 안써도됨
		doGet(request, response);
				
	}

}
