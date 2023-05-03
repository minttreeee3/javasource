package board.service;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardUpdateService {
	public boolean update(BoardDTO updateDto) {
		BoardDAO dao = new BoardDAO();
		return dao.updateArticle(updateDto);
	}

}
