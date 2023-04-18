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
			case 1: //사원추가
				EmpDTO empDTO = new EmpDTO();
				System.out.print("사원 번호 >> ");
				empDTO.setEmpno(sc.nextInt());
				System.out.print("사원 이름 >> ");
				empDTO.setEname(sc.next());
				System.out.print("직무 >> ");
				empDTO.setJob(sc.next());
				System.out.print("매니저 번호 >> ");
				empDTO.setMgr(sc.nextInt());
				System.out.print("급여 >> ");
				empDTO.setSal(sc.nextInt());
				System.out.print("추가 수당 >> ");
				empDTO.setComm(sc.nextInt());
				System.out.print("부서 번호 >> ");
				empDTO.setDeptno(sc.nextInt());
				System.out.println(empDAO.insert(empDTO) ? "추가 성공" : "추가 실패");
				
				break;
			
			case 2: //사원삭제
				System.out.print("삭제할 사번 입력 >> ");
				int empno = sc.nextInt();
				System.out.println(empDAO.remove(empno) ? "삭제 성공" : "삭제 실패");
				
				break;
			
			case 3: //급여수정
				//empno, sal 입력받기				
				System.out.print("사번 입력 >> ");
				empno = sc.nextInt();
				System.out.print("수정 급여 입력 >> ");
				int sal = sc.nextInt();
				
				// boolean으로 리턴돼서
				System.out.println(empDAO.update(sal, empno) ? "급여 변경 성공" : "급여 변경 실패");								
				
				break;
				
			case 4: //사원조회(사번) - 하나만 리턴 
				//empno 입력받기
				System.out.print("조회할 사원의 사번 입력 >> ");
				empno = sc.nextInt();
				
				//하나 조회
				// EmpDTO가 null상태일 수 있음 - getRow메소드만들때 초기화를 null로했기땜에 조건이false가 나오면 null이 나옴
				EmpDTO row = empDAO.getRow(empno);				
				//출력
//				System.out.println(row);  => toString 형식으로 출력됨
				
				if(row!=null) {
					System.out.println("\n*** 사원정보 조회 *** ");
					System.out.println("사원번호 : "+row.getEmpno());
					System.out.println("사원명 : "+row.getEname());
					System.out.println("직무 : "+row.getJob());
					System.out.println("급여 : "+row.getSal());
					System.out.println("추가수당 : "+row.getComm());
					System.out.println("부서번호 : "+row.getDeptno());
					System.out.println();
					
				} else {
					System.out.println("없는 사원 번호입니다");
				}
				
				break;
			
			case 5: //사원조회(이름) - 리턴 여러개일수도 있음 
				System.out.print("조회할 사원의 이름 입력 >> ");
				String ename = sc.next();
				
				ArrayList<EmpDTO> list = empDAO.getList(ename);
				// getList는 객체생성했기땜에 null은 안나옴 -> list가 비어있는 상태는 .isEmpty() 또는 size=0 로 표현 
				
				System.out.println();
				
				if(list.isEmpty()) {
					System.out.println("없는 사원명입니다");
				} else {
					
					System.out.println("사번\t 사원명\t 직무\t    입사일");
					for (EmpDTO empDTO1 : list) {
						System.out.print(empDTO1.getEmpno()+"\t");
						System.out.print(empDTO1.getEname()+"\t");
						System.out.print(empDTO1.getJob()+"\t");
						System.out.print(empDTO1.getHiredate()+"\n");
					}
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
