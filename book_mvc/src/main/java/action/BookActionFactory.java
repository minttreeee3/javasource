package action;

public class BookActionFactory {

	private static BookActionFactory baf;
	
	// 밖에서 직접 객체생성 못하게 private로 생성자 만들기
	private BookActionFactory() {}
	// 밖에서 이 메소드를 써서 객체 갖다 쓰는거니까 public static
	public static BookActionFactory getInstance() {
		if(baf == null) {
			baf = new BookActionFactory();
		}
		return baf;
	}
	
	
	public BookAction action(String cmd) {
		BookAction action = null;
		
		if(cmd.equals("/list.do")) { 
			action = new BookListAction();
		} else if(cmd.equals("/insert.do")) {
			action = new BookInsertAction();
		} else if(cmd.equals("/read.do")) {			
			action = new BookReadAction();
		} else if(cmd.equals("/modify.do")) {
			action = new BookModifyAction();
		} else if(cmd.equals("/update.do")) {
			action = new BookUpdateAction();
		}
		
				
		return action;
	}
	
	
}
