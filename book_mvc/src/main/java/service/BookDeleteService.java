package service;

import persistence.BookDAO;

public class BookDeleteService {
	
	public boolean remove(int code) {
		
		BookDAO dao = new BookDAO();
		return dao.delete(code);
		
	}

}
