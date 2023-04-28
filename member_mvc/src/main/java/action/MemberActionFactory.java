package action;

public class MemberActionFactory {
	private static MemberActionFactory maf;
	// 싱글톤 패턴 - 디폴트생성자를 private로 - 외부에서 객체생성을 못하게
	private MemberActionFactory() {}
	// 단, 하나의 객체는 생성할 수 있어야함 
	public static MemberActionFactory getInstance() {
		if(maf == null) {
			maf = new MemberActionFactory();
		}
		return maf;
	}
	
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/login.do")) {
			action = new MemberLoginAction();
		} else if(cmd.equals("/logout.do")) {
			action = new MemberLogoutAction();
		} else if(cmd.equals("/register.do")) {
			action = new MemberRegisterAction();
		} else if(cmd.equals("/change.do")) {
			action = new MemberChangeAction();
		} else if(cmd.equals("/leave.do")) {
			action = new MemberLeaveAction();
		} else if(cmd.equals("/dupId.do")) {
			action = new MemberDupAction();
		}

		
		return action;
	}

}
