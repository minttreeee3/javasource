package shop2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 생성자, getter/setter, toString =>lombok으로

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class UserDTO {
	
	private int userId;
	private String name;
	private int payNo;
	
	//card, cash 정보를 담을 변수
	private String type;
	
	
}	
	