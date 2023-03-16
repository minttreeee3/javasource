package ch3;

import java.util.Scanner;

public class IfEx5 {
	public static void main(String[] args) {
		//중첩if


		//점수를 입력받아서 점수가 90이상이면 A 인데, 98이상이라면 A+, 94미만이라면 A-
		//점수를 입력받아서 점수가 80이상이면 B 인데, 98이상이라면 B+, 94미만이라면 B-
		//점수가 80미만이라면 C
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("점수를 입력하시오 ");
		int score = Integer.parseInt(sc.nextLine());
		char grade =' ', opt=' ';
		if (score>=90) {
			grade='A';if (score>=98) {
				opt='+';
			}
				else if (score<94) {
					opt='-';
				}
		}else if (score>=80){
			grade='B';if (score>=88) {
				opt='+';
			}
				else if (score<84) {
					opt='-';
				}else {
					grade='c';
				}
		System.out.println("학점은 "+grade+opt);
		}
	}
}
		
		
		
		
		
		
		
		
		
		


