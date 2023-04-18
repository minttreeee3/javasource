package shop2;

public class OrderMain {

	public static void main(String[] args) {
		
		// OrderDTO 사용하기
		OrderDTO dto = new OrderDTO();
		
		// 프로퍼티에 값 세팅 => 1)생성자 2)setter메소드 사용
		dto.setOrderId(1000);
		
		// 포함관계인 다른클래스를 불러올때는 setter메소드 안에다가 new객체생성으로 불러와야함
		dto.setUserDTO(new UserDTO(100, "hong", 1, "card"));
		//혹은 하나씩 불러서 담을수도 있음
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(100);
		userDTO.setName("hong");
		userDTO.setPayNo(1);
		userDTO.setType("card");
		dto.setUserDTO(userDTO);
		
		// 프로퍼티 값 조회
		System.out.println(dto.getOrderId());
		
		//UserDTO안의값을 한번더불러옴
		System.out.println(dto.getUserDTO().getName());   
		
		//나눠서 찍으려면
		UserDTO getUser = dto.getUserDTO();
		System.out.println(getUser.getName());
		System.out.println(getUser.getType());

	}

}
