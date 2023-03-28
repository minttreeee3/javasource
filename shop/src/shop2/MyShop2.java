package shop2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyShop2 implements IShop {
	
	
	//쇼핑몰 이름
	private String title;
	
	//user 정보 저장 배열
	UserDTO[] users = new UserDTO[2];
	
	//product 정보 저장 배열
	Product[] products = new Product[4];
	
	//구매한 제품을 저장 배열(cart)
	Product carts[] = new Product[10];
	
	//선택된 user 저장하는 변수
	private int selUser; 
	
	// UserDAO 객체 생성
	UserDAO userDAO = new UserDAO();
	ProductDAO productDAO = new ProductDAO();
	
	
	
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
		System.out.println(title + " : 메인화면 - 계정 선택");
		System.out.println("=================================");
		for (int i = 0; i < users.length; i++) {
			// System.out.println("["+i+"]" + users[i].getName() + "("+users[i].getPayType()+")");
//			System.out.printf("[%d] %s(%s)\n",i,users[i].getName(),users[i].getPayType() );
		}
		System.out.println("[X] 종 료");
		System.out.print("선택 : ");
		String sel = sc.nextLine();
		System.out.println("## "+sel+" 선택 ##");
		System.out.println();
		
		//0,1 누르면 => productList()호출
		//다른 걸 입력시 => 메뉴를 확인해 주세요
		switch (sel) {
		case "x": case "X":
			System.exit(0);  //프로그램 종료			
			break;
		case "0": case "1":
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
		for (int i = 0; i < products.length; i++) {
			System.out.printf("[%d]",i);
			products[i].printDetail();
			products[i].printExtra();			
		}
		System.out.println("[h] 메인 화면");
		System.out.println("[c] 체크 아웃");
		System.out.println("선택 : ");
		String sel = sc.nextLine();
		// 상품선택시 0~3 => cart에 제품 추가, productList() 다시 호출 
		// 메뉴선택 h => 다시 start(); 메뉴호출 , c => checkOut() 호출
		
		switch (sel) {
		case "0": case "1": case "2": case "3":
			
			for (int i = 0; i < carts.length; i++) {        //빈 배열에 담기... BankApp 다시 보기 
				if(carts[i]==null) {
					carts[i] = products[Integer.parseInt(sel)];  //sel을 정수형으로 바꿔주면됨
					break; //한번 담고 나와야되니까
				}
			}						
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
		}
		
		
		
		}
	
	int sum;
	
	public void checkOut() {
		System.out.println("MyShop : 체크아웃");
		System.out.println("======================================");
		
		for (int i = 0; i < carts.length; i++) {
			if(carts[i]!=null) {
				System.out.printf("[%d] %s(%s)\n",i,carts[i].getName(),carts[i].getPrice() );
				sum += carts[i].getPrice();									
			}						
		}
//		System.out.println("결제방법 : "+users[selUser].getPayType());
		System.out.println("합계 : "+sum);
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
	


