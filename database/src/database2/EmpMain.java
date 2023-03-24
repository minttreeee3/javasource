package database2;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EmpDAO empDAO = new EmpDAO();
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 삭제");
			System.out.println("3. 사원 수정");
			System.out.println("4. 사원 조회(사번)");
			System.out.println("5. 사원 조회(이름)");
			System.out.println("6. 종료");
			System.out.println("--------------------------------");
			
			
			// 메뉴번호 입력받기
			System.out.print("메뉴 입력 >> ");
			int no = sc.nextInt();
			
			// switch 작성
			switch (no) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4: //사원조회(사번) - 하나만 리턴 
				//empno 입력받기
				System.out.print("조회할 사원의 사번 입력 >> ");
				int empno = sc.nextInt();
				
				//하나 조회
				EmpDTO row = empDAO.getRow(empno);				
				//출력
//				System.out.println(row);  => toString 형식으로 출력됨
				System.out.println("\n***사원정보 조회***");
				System.out.println("사원번호 : "+row.getEmpno());
				System.out.println("사원명 : "+row.getEname());
				System.out.println("직무 : "+row.getJob());
				System.out.println("급여 : "+row.getSal());
				System.out.println("추가수당 : "+row.getComm());
				System.out.println("부서번호 : "+row.getDeptno());
				System.out.println();
				
				break;
			case 5: //사원조회(이름) - 리턴 여러개일수도 있음 
				System.out.print("조회할 사원의 이름 입력 >> ");
				String ename = sc.next();
				
				ArrayList<EmpDTO> list = empDAO.getList(ename);
				for (EmpDTO empDTO : list) {
					System.out.print(empDTO.getEmpno()+"\t");
					System.out.print(empDTO.getEname()+"\t");
					System.out.print(empDTO.getJob()+"\t");
					System.out.print(empDTO.getHiredate()+"\n");
				}
				
				break;
			case 6: //종료
				flag = false;
				break;

			default: 
				System.out.println("메뉴번호를 확인하세요");
				break;
			} //스위치 끝
			
			
			
		} //while 끝



	}

}
