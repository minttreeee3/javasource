<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//적용이 안됨 - 받아온 파일은 request로 바로 처리 못함 
request.setCharacterEncoding("utf-8");

// 현재 request에 file upload요청이 들어있는지 확인 
boolean isMultipart = ServletFileUpload.isMultipartContent(request);

if(isMultipart) {
	// Create a factory for disk-based file items
	DiskFileItemFactory factory = new DiskFileItemFactory();

	// Create a new file upload handler
	ServletFileUpload upload = new ServletFileUpload(factory);

	// Parse the request
	List<FileItem> items = upload.parseRequest(request);
	
	// Process the uploaded items
	Iterator<FileItem> iter = items.iterator();
	
	String name=null, value=null;
	
	while (iter.hasNext()) {
	    FileItem item = iter.next();

	    //일반요소
	    if (item.isFormField()) {
	    	name = item.getFieldName();
	    	//인코딩 여기서 하는거
	        value = item.getString("utf-8");
	        out.print("<h3>일반 데이터</h3>");
	        out.print(name+" : "+value+"<br>");
	    } else { //파일요소
	    	name = item.getFieldName();
	        value = item.getName();
	        long size = item.getSize();
	        out.print("<h3>파일 데이터</h3>");
	        out.print(name+" : "+value+" - "+size+"<br>");
	        
	        //파일저장
	        if(!name.isEmpty()) {
	        	// 만들어둔 파일 경로
	        	String path = "D:\\eclipse\\upload"; 	      
	        	
	        	// 그냥저장하면 중복된 파일은 처음올린것만 저장됨 ->중복되지 않게하기위해 파일명앞에 고유값을 넣어줌
	        	// 고유값 생성 (자바 유틸)
	        	UUID uuid = UUID.randomUUID();
	        		        	
	        	// 파일 객체 생성 
	        	File f = new File(path+"\\"+uuid.toString()+"_"+value);
	        	//파일저장
	        	item.write(f);  
	        	
	        	
	        	
	        	// 다운로드를 위한 링크 생성
	        	String encodeName = URLEncoder.encode(f.getName(), "utf-8"); // 인코딩(특수문자도 됨)
	        	
	        	out.print("<p>");
	        	out.print("<a href='download.jsp?fileName="+encodeName+"'>"+value+"</a>");
	        	out.print("</p>");
	        }
	        	        
	    }
	}
	
}

%>