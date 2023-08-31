package bit701.day8031;

import java.util.Scanner;

public class Ex4_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 점수를 입력받아 90이상 A, 80이상 B, 70 C, 60 D, 나머지는 F
		 * 
		 * 출력값 : 99점은 A학점입니다.
		 * 
		 * if문과 조건연산자 두가지 방법으로
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		String msg;
		if(score<1 || score>100) {
			System.out.println("잘못된 값 입력으로 종료");
			return; // return은 해당 메서드만 종료하는 명령어지만 main 메서드 종료는 곧 프로그램 종료
		} else if(score>=90) {
			msg="A";
		} else if(score>=80) {
			msg="B";
		} else if(score>=70) {
			msg="C";	
		} else if(score>=60) {
			msg="D";	
		} else {
			msg="F";
		}
		System.out.println(score+"점은 "+msg+"학점입니다 -if문");
		
		//조건연산자
		msg=score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F";
		System.out.println(score+"점은 "+msg+"학점입니다 -조건연산자");
		
		
	}

}
