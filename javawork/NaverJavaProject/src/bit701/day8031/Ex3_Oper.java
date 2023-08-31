package bit701.day8031;

import java.util.Scanner;

public class Ex3_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		Scanner sc = new Scanner(System.in);
		//점수를 입력받아 1~100점이 아닐 경우 종료
		//90 이상은 합격, 80이상은 재시험, 그 나머지는 불합격이라고 출력
		//if, 삼항연산자 각각
		
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		String msg;
		if(score<1 || score>100) {
			System.out.println("잘못된 값 입력으로 종료");
			return; // return은 해당 메서드만 종료하는 명령어지만 main 메서드 종료는 곧 프로그램 종료
		} else if(score>=90) {
			msg="합격";
		} else if(score>=80) {
			msg="재시험";
		} else {
			msg="불합격";
		}
		
		System.out.println("입력된 점수는 "+score+"점 입니다");
		System.out.println("결과는 "+msg+"입니다");
		
		//조건연산자 
		msg=score>=90?"합격":score>=80?"재시험":"불합격";

	}

}
