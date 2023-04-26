package service;

import persistence.BookDAO;

public class BookUpdateService {
	
	public boolean updateBook(int code, int price) {
		
	/*	BookDAO dao = new BookDAO();
		return dao.update(code, price);
		
		한줄로 줄이면 	*/		
		return new BookDAO().update(code, price);
		
	}
}
