package ch6;

public class Member {
	
	String userid;		//아이디 userid ex)hong123
	String password;		//비밀번호 password ex)hong123!@
	String confirmPassword;		//비밀번호확인 confirmPassword ex)hong123!@
	String hp;				//전화번호 hp ex)01012341234
	String address;		//주소 address ex)서울 
	
	
		
	
	public Member(String userid, String password, String confirmPassword, String hp) {
		super();
		this.userid = userid;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.hp = hp;
	}



	public Member(String userid, String password, String confirmPassword, String hp, String address) {
		super();
		this.userid = userid;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.hp = hp;
		this.address = address;
	}
	
	
//	void passwordAndConfirmPasswordEquals() {
//		//문자열 비교는 equals()
//		if(password.equals(confirmPassword)) {
//			System.out.println("비밀번호가 일치합니다");
//		} else {
//			System.out.println("비밀번호를 확인해 주세요");
//		}		
//	}

	boolean  passwordAndConfirmPasswordEquals() {
		//문자열 비교는 equals로
		return password.equals(confirmPassword);	
		}
	
	
}
