package shop2;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class OrderDTO {
	
	private int orderId;
	private int userId;
	private int productId;
	private Date orderDate;
	
	// 포함관계  	(클래스 관계엔 상속(isa)과 포함(hasa)이 있음)
	private UserDTO userDTO;
	private ProductDTO productDTO;
	private PayType payType;

}
