package bit701.day0901;

import java.util.Scanner;

public class Ex7_ForExam {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/*
		 * 구구단 시작단 ㅇ입력
		 * 4
		 * 출력할 끝단 입력
		 * 6
		 * 
		 *  4단   5단   6단 - 단일for 
		 * 4x1=4 5x1=5 6x1=6 - 다중for
		 * 
		 */

		int sta=2, end=4;
		
//		System.out.println("구구단 시작단 입력");
//		sta = sc.nextInt();
//		System.out.println("구구단 끝단 입력");
//		end = sc.nextInt();
		
		for(int i=sta; i<=end; i++) {
			System.out.printf("%7d단 ",i);
		}
		System.out.println();
		
		for(int j=1; j<=9; j++) { // j = 뒤
			for(int i=sta; i<=end; i++) {
				System.out.printf("%5dx%d=%2d",i,j,i*j);
			}
			System.out.println();
		}
		
		
		
		
	}

}
