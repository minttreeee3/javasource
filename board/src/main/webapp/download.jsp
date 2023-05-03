<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 다운로드 받기를 원하는 파일명
	String fileName = request.getParameter("fileName");

	// 서버 폴더에 가서 사용자가 요청한 해당 파일 가져오기
	// 자바 File 처리 ( ch7 > io 폴더 복습 )
	FileInputStream fis = new FileInputStream("d:\\eclipse\\upload\\"+fileName);
	BufferedInputStream bis = new BufferedInputStream(fis);
	
	// 새로 세팅을 하겠다는 의미 
	out.clear();
	out = pageContext.popBody();
	
	// 브라우저에 파일 붙여서 보내기
	// 다운받을땐 uuid값 제거되게 
	fileName = fileName.substring(fileName.indexOf("_")+1); // _를 찾은다음에 그 다음자리(+1)부터 잘라내서 fileName으로 저장 
	//인코딩 : te st.jpg ==> te\\+st.jpg 
	fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");  
	//MIME (파일 타입 설정) - application/octet-stream은 모든종류의 이진데이터
	response.setContentType("application/octet-stream");	 
	response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	
	BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());
	
	int numRead=0;
	byte[] b = new byte[4896];
	while((numRead=bis.read(b))!=-1) {
		buf.write(b,0,numRead);
	}
	buf.flush();
	buf.close();
	bis.close();
	


%>