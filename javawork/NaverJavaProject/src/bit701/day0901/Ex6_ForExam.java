package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 숫자 n을 입력 받은 후 1부터 n까지의 총 합계 출력
		 * 
		 * 2. 구구단 숫자 2~9 사이의 숫자를 입력받은 후 
		 * 범위 벗어날경우 종료시키기
		 * 제대로 입력시 해당 구구단 출력
		 * 
		 * ** 5단 **
		 * 5 x 1 =  5
		 * 5 x 2 = 10
		 */
				
		
//		Scanner sc = new Scanner(System.in);
//		int su, sum=0;
//		
//		System.out.println("숫자을 입력하세요");
//		su = sc.nextInt();
//		
//		for(int i=1; i<=su; i++) {
//			sum+=i;
//		}
//		System.out.printf("1부터 %d까지의 합계는 %d\n",su,sum);
//		
		
		
		
		Scanner sc = new Scanner(System.in);
		int su=0;
		
		System.out.println("숫자을 입력하세요");
		su = sc.nextInt();
		
		if(su<2||su>9) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		System.out.printf("** %d단 **\n",su);
		for(int i=1; i<=9; i++) {
		System.out.printf("%d x %d = %d\n",su,i,su*i);
		}
		
		
		
		
	}

}
