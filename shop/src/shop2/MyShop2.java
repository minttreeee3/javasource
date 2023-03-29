package shop2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyShop2 implements IShop {
	
	
	//쇼핑몰 이름
	private String title;
	
	
	//선택된 user 저장하는 변수
	private int selUser; 
	
	// UserDAO 객체 생성
	UserDAO userDAO = new UserDAO();
	ProductDAO productDAO = new ProductDAO();
	OrderDAO orderDAO = new OrderDAO();
	
	
	Scanner sc = new Scanner(System.in);
	
	

	@Override
	public void setTitle(String title) {
		this.title=title;		
	}

	
	
	
	@Override
	public void genUser() { //user생성 메소드
		
		// user 정보를 입력받아서 suser 테이블에 저장
		
		System.out.println("***** User 입력 *****");
		// userID, name, payNo를 입력받기
		System.out.print("userID >> ");
		int userID = Integer.parseInt(sc.nextLine());
		System.out.print("name >> ");
		String name = sc.nextLine();
		System.out.print("payNo >> ");
		int payNo = Integer.parseInt(sc.nextLine());
		
		System.out.println(userDAO.insert(userID, name, payNo) ? "user 추가 성공" : "user 추가 실패");
		
	}
	
	
	
	
	
	public void userList() { //전체조회 메소드
		System.out.println("***** User 목록 *****");
		System.out.println("userID\t name\t payNo");
		System.out.println("-----------------------------");
		
		List<UserDTO> list = userDAO.getList();
		
		for (UserDTO userDTO : list) {
			System.out.print(userDTO.getUserId()+"\t");
			System.out.print(userDTO.getName()+"\t");
			System.out.println(userDTO.getPayNo()+"\n");
		}
		
	}

	
	
	@Override
	public void genProduct() {
		// 상품 정보 입력받아서 product 테이블에 저장 
		System.out.println("***** 상품 입력 *****");
		
		ProductDTO dto = new ProductDTO();
		//상품정보 product_id, pname, price, content 입력받기 => ProductDTO에 담기
		System.out.print("productId >> ");
		dto.setProductId(Integer.parseInt(sc.nextLine()));
		System.out.print("pname >> ");
		dto.setPname(sc.nextLine());
		System.out.print("price >> ");
		dto.setPrice(Integer.parseInt(sc.nextLine()));
		System.out.print("content >> ");
		dto.setContent(sc.nextLine());
		
		// 상품정보 입력받기 => ProductDTO에 담기 
		System.out.println(productDAO.insert(dto) ? "상품 입력 성공" : "상품 입력 실패");
		
	}
	
	
	
	

	@Override
	public void start() {
		System.out.println(title + " : 메인 화면 - 계정 선택");
		System.out.println("=================================");
		
		// 전체 user 정보 출력
		List<UserDTO> list = userDAO.getList();
		
		for (UserDTO userDTO : list) {
			System.out.print(userDTO.getUserId()+"\t");
			System.out.print(userDTO.getName()+"\t");
		//  System.out.println(userDTO.getPayNo()+"\t");
			System.out.println(userDTO.getType()+"\n");
		}
		

		System.out.println("[X] 종 료");
		System.out.print("선택 : ");
		String sel = sc.nextLine();  // 숫자("100"형태), X 다 받아들이기위해 nextLine으로 
		System.out.println("## "+sel+" 선택 ##");
		System.out.println();
		
		//상품 번호 누르면 => productList()호출
		//다른 걸 입력시 => 메뉴를 확인해 주세요
		switch (sel) {
		case "x": case "X":
			System.exit(0);  //프로그램 종료			
			break;
		case "1000": case "1001":
			selUser = Integer.parseInt(sel);   //유저가 선택될때 그 번호를 selUser라는 변수에 담아둠 
			productList();
			break;
		default:
			System.out.println("메뉴를 확인해 주세요\n");
			start();  //메뉴를 갖고있는 메서드 다시 호출
			break;
		}
	
	
		
		
	}
	
	
	public void productList() {
		System.out.println();
		System.out.println(title + " : 상품 목록 - 상품 선택");
		System.out.println("=================================");
		
		// product 데이터베이스 상품 출력		
		List<ProductDTO> list = productDAO.getList();
		for (ProductDTO productDTO : list) {
			System.out.print(productDTO.getProductId()+"\t");
			System.out.print(productDTO.getPname()+"\t");
			System.out.print(productDTO.getPrice()+"\t");
			System.out.println(productDTO.getContent()+"\n");
		}
		
		
		
		System.out.println("[h] 메인 화면");
		System.out.println("[c] 체크 아웃");
		System.out.print("선택 : ");
		
		String sel = sc.nextLine();
		// 상품선택시 => sorder에 저장, productList() 다시 호출 
		// 메뉴선택 h => 다시 start(); 메뉴호출 , c => checkOut() 호출
		
		switch (sel) {
		case "1111": case "2222": case "3333": case "4444":
			
			orderDAO.insert(selUser, Integer.parseInt(sel));
			
			productList();			
			break;
		case "h": case "H":
			start();
			break;
		case "c": case "C":
			checkOut();
			break;
		default:
			System.out.println("입력값을 확인해 주세요");
			productList();
			break;
		} //switch끝
		
				
		} //productlist끝
	

	
	public void checkOut() {
		System.out.println(title+" : 체크아웃");
		System.out.println("==================================================================");
		
		//carts출력
		int total = 0; //제품가격 합계
		
		List<OrderDTO> list = orderDAO.carts(selUser);
		
		System.out.println("아이디    이름    결제방법    제품번호       제품명       가격      상세내용      주문일자");
		for (OrderDTO orderDTO : list) {
			// OrderDTO 안의 UserDTO  (OrderDAO에서 carts메소드 만들때 담았던곳으로 찍어야함) 
			System.out.print(orderDTO.getUserDTO().getUserId()+"\t");
			System.out.print(orderDTO.getUserDTO().getName()+"\t");
			System.out.print(orderDTO.getUserDTO().getType()+"\t");
			// OrderDTO 안의 ProductDTO
			System.out.print(orderDTO.getProductDTO().getProductId()+"\t");
			System.out.print(orderDTO.getProductDTO().getPname()+"\t");
			System.out.print(orderDTO.getProductDTO().getPrice()+"\t");
			System.out.print(orderDTO.getProductDTO().getContent()+"\t");
			System.out.println(orderDTO.getOrderDate()+"\n");
			
			//가격합산
			total += orderDTO.getProductDTO().getPrice();
			
		}
		
		System.out.println("===================================================================");
		System.out.println("결제 금액 : "+total);
		System.out.println("[p] 이전, [q] 결제완료");
		System.out.println("선택 : ");
		String sel = sc.nextLine();
		
		// p일때 productList() 호출
		// q일때 결제가 완료되었습니다. 프로그램 종료
		// 잘못입력 시 checkOut() 호출		
		switch (sel) {
		case "p": case "P":
			productList();			
			break;
		case "q": case "Q":
			System.out.println("결제가 완료되었습니다.");
			System.exit(0);  //프로그램 종료			
			break;
		default:
			checkOut();
			break;
		}
		
	}


		
}
	


