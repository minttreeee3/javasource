package service;

import domain.BookDTO;
import persistence.BookDAO;

public class BookInsertService {
	
	public boolean insertBook(BookDTO insertDto) {
		
		BookDAO dao = new BookDAO();
		return dao.insert(insertDto);  //boolean타입 메소드임 
				
	}

}
