package shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//배열로 선언된 부분 => ArrayList로 변경(프로그램 수정) 

public class MyShop implements IShop {
	
	
	//쇼핑몰 이름
	private String title;
	
	//user 정보 저장 배열
	//User[] users = new User[2];
	ArrayList<User> users = new ArrayList<>();
	
	//product 정보 저장 배열
	//Product[] products = new Product[4];
	ArrayList<Product> products = new ArrayList<>();
	
	//구매한 제품을 저장 배열(cart)
	//Product carts[] = new Product[10];
	ArrayList<Product> carts = new ArrayList<>();
	
	//선택된 user 저장하는 변수
	private int selUser; 
	
	
	
	Scanner sc = new Scanner(System.in);
	
	

	@Override
	public void setTitle(String title) {
		this.title=title;		
	}

	@Override
	public void genUser() {
		//user 2명 생성

		users.add(new User("홍길동", PayType.CARD));
		users.add(new User("성춘향", PayType.CASH));
				
	}

	@Override
	public void genProduct() {
		//product 4개 생성 후 배열에 저장 

		products.add(new CellPhone("플립", 700000, "SKT"));
		products.add(new CellPhone("노트", 800000, "KT"));
		products.add(new SmartTv("삼성tv", 1000000, "1k"));
		products.add(new SmartTv("LGtv", 2000000, "4k"));
		
	}

	@Override
	public void start() {
		System.out.println(title + " : 메인화면 - 계정 선택");
		System.out.println("=================================");
//		for (int i = 0; i < users.size(); i++) {
//			User us = users.get(i);
//			System.out.printf("[%d] %s(%s)\n", i, us.getName(), us.getPayType());
//		}
		
		int i=0;	//이 형태의 for문은 안에 i가 없어서 따로 쓰고 증가시켜줘야됨 
		for (User user : users) {
			System.out.printf("[%d] %s(%s)\n", i++, user.getName(), user.getPayType());
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
		int i =0;
		for (Product product : products) {
			System.out.printf("[%d]",i++);
			product.printDetail();
			product.printExtra();
		}
		
		System.out.println("[h] 메인 화면");
		System.out.println("[c] 체크 아웃");
		System.out.println("선택 : ");
		String sel = sc.nextLine();
		// 상품선택시 0~3 => cart에 제품 추가, productList() 다시 호출 
		// 메뉴선택 h => 다시 start(); 메뉴호출 , c => checkOut() 호출
		
		switch (sel) {
		case "0": case "1": case "2": case "3":
			
			for (Product cart : carts) {        //빈 배열에 담기... BankApp 다시 보기 
				if(cart==null) {
					carts.add(products.get(Integer.parseInt(sel)));  //sel을 정수형으로 바꿔주면됨
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
		
		int i=0;
		for (Product cart : carts) {
			if(cart!=null) {
				System.out.printf("[%d] %s(%s)\n",i++,cart.getName(),cart.getPrice() );
				sum += cart.getPrice();									
			}						
		}
		System.out.println("결제방법 : "+users.get(selUser).getPayType());
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
	


