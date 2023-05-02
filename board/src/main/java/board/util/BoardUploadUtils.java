package board.util;


import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

// upload.jsp에서 했던 작업
public class BoardUploadUtils {
	
	public Map<String, String> uploadFile(HttpServletRequest request) {
		
		Map<String, String> formData = new HashMap<>();
		
		
		// 현재 request에 file upload요청이 들어있는지 확인 
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if(isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			
			try {
				
				// Parse the request
				List<FileItem> items = upload.parseRequest(request);
				
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				
				String name=null, value=null;
				
				while (iter.hasNext()) {
				    FileItem item = iter.next();
				    
				    // 필드명 가져오기
				    name = item.getFieldName();
				    
				    //일반요소 - writerForm에서 name,password,content,title
				    if (item.isFormField()) {
				    	//인코딩 여기서 하는거
				        value = item.getString("utf-8");
				        
				        formData.put(name, value);
				        
				    } else { //파일요소
				        value = item.getName();
				        
				        //파일저장
				        if(!name.isEmpty() && item.getSize()>0) {
				        	// 만들어둔 파일 경로
				        	String path = "D:\\eclipse\\upload"; 	      
				        	
				        	// 그냥저장하면 중복된 파일은 처음올린것만 저장됨 ->중복되지 않게하기위해 파일명앞에 고유값을 넣어줌
				        	// 고유값 생성 (자바 유틸)
				        	UUID uuid = UUID.randomUUID();
				        					        					        		        	
				        	// 파일 객체 생성 
				        	File f = new File(path+"\\"+uuid.toString()+"_"+value);
				        	
				        	formData.put(name, f.getName());
				        	
				        	//파일저장
				        	item.write(f);  
				        }
				    }			    		
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
		return formData;
		}
}




