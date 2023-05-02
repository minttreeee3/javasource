package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.BoardDTO;
import board.service.BoardWriteService;
import board.util.BoardUploadUtils;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// multipart/form-data 형태라서 ==> request.getParameter() 로 가져올수가 없음
		// request ==> BoardUploadUtils로 넘겨야함
		BoardUploadUtils utils = new BoardUploadUtils();
		Map<String, String> formData = utils.uploadFile(request);
		
		// formData 값들을 BoardDTO 객체 생성 후 담기
		BoardDTO dto = new BoardDTO();
		dto.setName(formData.get("name"));  //name이라는 키값에 담긴 데이터를 가져와서 세팅 
		dto.setTitle(formData.get("title"));
		dto.setContent(formData.get("content"));
		dto.setPassword(formData.get("password"));
		if(formData.containsKey("attach")) { // 파일첨부 했을때만 데이터 담기도록 if문으로 
			dto.setAttach(formData.get("attach"));
		}
		
		// 서비스작업
		BoardWriteService service = new BoardWriteService();
		Boolean writeFlag = service.insert(dto);
		
		// ActionForward : 성공하면 목록보여주기, 실패하면 writeForm.jsp
		String path = "";
		if(writeFlag) {
			path = "list.do"; 
		} else {
			path = "writeForm.jsp";  
		}
		
		return new ActionForward(true, path);
	}

}
