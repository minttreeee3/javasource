package database2;

import java.util.ArrayList;
import java.util.Scanner;

// DeptDao 를 실행할 메인

public class DeptMain {

	public static void main(String[] args) {
		
		DeptDao dao = new DeptDao();
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("====================");
			System.out.println("1. 특정부서 조회");
			System.out.println("2. 전체부서 조회");
			System.out.println("3. 새 부서 추가");
			System.out.println("4. 부서 정보 수정");
			System.out.println("5. 부서 정보 삭제");
			System.out.println("6. 종료");
			System.out.println("====================");
			
			System.out.print("메뉴입력 >> ");
			int no = sc.nextInt();
			
			switch (no) {
			case 1:	
				// 사용자로부터 조회를 원하는 부서코드 입력받기
				System.out.print("부서 코드 입력 >> ");
				int deptno = sc.nextInt();
				
				//하나 조회
				DeptDTO row = dao.getRow(deptno);	
				//DeptDTO 출력
				System.out.println(row);
				break;
			
			case 2:					
				//전체 조회
				ArrayList<DeptDTO> list = dao.getRows();
				for (DeptDTO deptDTO : list) {
					System.out.print(deptDTO.getDeptno()+"\t");
					System.out.print(deptDTO.getDname()+"\t");
					System.out.print(deptDTO.getLoc()+"\n");
				}
			
				break;
			
			case 3: //새 부서 추가
//				System.out.print("부서번호 >> ");
//				deptno = sc.nextInt();
//				System.out.print("부서명 >> ");
//				String dname = sc.next();  // 띄어쓰기입력하면 그전까지만 인식됨.. 포함하려면 nextLine으로 쓰고 윗줄을 다 Integer.parseInt로 바꿔야함 
//				System.out.print("지역 >> ");
//				String loc = sc.next();
//				
//				//결과가 boolean으로 넘어옴
//				System.out.println(dao.insert(deptno, dname, loc)? "삽입성공" : "삽입실패");
				
				
				// 방법2. 사용자 입력 결과를 DAO클래스로 넘김  -먼저 dto객체를 만들고 거기에 담은다음에 
				DeptDTO dto = new DeptDTO();
				System.out.print("부서번호 >> ");
				dto.setDeptno(sc.nextInt());
				System.out.print("부서명 >> ");
				dto.setDname(sc.next());  
				System.out.print("지역 >> ");
				dto.setLoc(sc.next()); 
				System.out.println(dao.insert(dto)? "삽입성공" : "삽입실패" );
				
				
				break;
			
			case 4: //부서 정보 수정
				
				System.out.print("부서번호 >> ");
				deptno = sc.nextInt();
				
				System.out.print("1) 부서명 수정 2) 위치 수정  원하는 번호 입력 >> ");
				int updateNo = sc.nextInt();
				
				String input = null;
				
				if(updateNo==1) {
					// 1 선택시
					System.out.print("새 부서명 입력 >> ");
					input = sc.next();
					
				} else if(updateNo==2) {
					// 2 선택시
					System.out.print("새 위치 입력 >> ");
					input = sc.next();
				}
				
				System.out.println(dao.update(input, deptno, updateNo) ? "수정성공" : "수정실패");
								
				break;
				
			case 5: //삭제
				System.out.print("삭제할 부서 코드 입력 >> ");
				deptno = sc.nextInt();
				
				System.out.println(dao.remove(deptno) ? "삭제성공" : "삭제실패" );
				
				break;
			
			case 6:
				flag = false;
				break;

			default:
				System.out.println("번호를 다시 입력해 주세요");
				break;
			}
		}
				
	}
}
