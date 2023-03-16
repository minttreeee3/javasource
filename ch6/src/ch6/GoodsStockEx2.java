package ch6;

import java.util.Scanner;

public class GoodsStockEx2 {

	public static void main(String[] args) {
		
		//입력값으로 GoodsStock 인스턴스 생성
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("상품코드 >> ");
//		String code = sc.nextLine();
//		
//		System.out.print("재고수량 >> ");
//		int stockNum = Integer.parseInt(sc.nextLine());
//		
//		
//		GoodsStock Stock = new GoodsStock(code, stockNum);
//		System.out.println(Stock);
//		
		
		
		//3개의 상품에 대해서 인스턴스를 생성해야 한다면? =>배열이용
		
		//배열선언부터
		GoodsStock[] goods = new GoodsStock[3];
		//초기화
//		goods[0] = new GoodsStock("p1001",200);
//		goods[1] = new GoodsStock("p1002",100);
//		goods[2] = new GoodsStock("p1003",300);
		//위 세줄의 코드를 입력값으로 변경
		
		
		for (int i = 0; i < goods.length; i++) {
			
			System.out.print("상품코드 >> ");
			String code = sc.nextLine();
			
			System.out.print("재고수량 >> ");
			int stockNum = Integer.parseInt(sc.nextLine());
			
			goods[i] = new GoodsStock(code, stockNum);
			System.out.println("-----------------------------");
			
		}
		
		
		//확인용
		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i]);
		}
		
		//향상된for문
		//for (타입  아무거나변수명:배열명) 
		for (GoodsStock stock:goods) {
			System.out.println(stock);
		}
		
		
		

	}

}
