package action;

/*
 * 디자인 패턴 : 개발 방식 정의
 * 
 * 싱글톤(Singleton) 패턴
 * 객체 생성하는 메소드가 여러번 호출돼도, 단 하나의 생성자가 생성하는 객체가 리턴 
 * 	==> 객체는 하나만 생성


*/

public class ActionFactory {
	
	private static ActionFactory actionFactory;
	
	// 생성자 (클래스이름과 동일) 
	private ActionFactory() {}

	public static ActionFactory getInstance() {
		// 널이면 객체생성해서 리턴, 널이 아니라면 그냥 리턴 
		// 생성자를 private로 만들어서 밖에서 객체생성못하지만 이 if문으로 인해서 객체생성이 됨 
		if(actionFactory == null) {
			actionFactory = new ActionFactory();
		}
		return actionFactory;
	}
	
	
	
	// Action 리턴 메소드(action)
	Action action;
	public Action action(String cmd) {
		
		// 어디서 요청이 왔는지 알아내서 그에 따라 액션 생성 
		if(cmd.equals("/insert.do")) {
			action = new InsertAction();						
		} else if(cmd.equals("/list.do")) {
			
		} else if(cmd.equals("/update.do")) {
			
		} else if(cmd.equals("/delete.do")) {
			action = new DeleteAction();
		}
		
		return action;
		
	}
	
	

}
