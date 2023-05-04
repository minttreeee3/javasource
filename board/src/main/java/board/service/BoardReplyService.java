package board.service;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardReplyService {
	public boolean replyInsert(BoardDTO updateDto) {
		return new BoardDAO().reply(updateDto);
	}

}
