package shop2;

import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		MyShop2 shop = new MyShop2();  
		
		//shop 이름지정
		shop.setTitle("MyShop");
		
		
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			System.out.println("-----------------------");
			System.out.println("1. user 생성");
			System.out.println("2. product 생성");
			System.out.println("3. 상점 open");
			System.out.println("4. 전체 조회");
			System.out.println("5. 종료");
			System.out.println("-----------------------");
			
			System.out.print("선택 >> ");
			
			int no = sc.nextInt();
			
			switch (no) {
			case 1: // user 생성
				shop.genUser();
				break;
				
			case 2: // product생성
				shop.genProduct();				
				break;
				
			case 3: // shop 시작
				shop.start();
				break;
				
			case 4: // 전체 조회
				shop.userList();
				break;
				
			case 5: // 종료
				flag = false;			
				break;

			default:
				System.out.println("메뉴를 다시 확인해 주세요");
				break;
			} //switch닫기
		} //while닫기
	
		
		
		
		

	}

}
