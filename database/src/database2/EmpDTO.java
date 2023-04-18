package database2;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//table 컬럼과 동일하게 작성
//생성자, getter/setter 메소드, toString() 만들기 -lombok사용해서 

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString

public class EmpDTO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	

}
