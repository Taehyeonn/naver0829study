package bit701.day0830;

import java.util.*;

public class ExEx0 {

	public static void main(String[] args) {
		/*
		 * 조건식 ？ 식1(true) ： 식2(false)
		 * 
		 * -if
			(sum>100) sum=200;
			-else
			sum = 0;
		 * 
		 */
	

//		int sum = (sum>100 ? 200 : 0);
//
//		Scanner sc = new Scanner(System.in);
//		System.out.println("2자리 정수를 입력해주세요.");
//		int su = sc.nextInt();
//		System.out.printf("입력 : %d\n", su);
//		System.out.println(su/10 == su%10);
//		
////		System.out.println(su/10);
////		System.out.println(su%10);
//		
//		
////		int inttt = sc.nextInt();
		
		Scanner sc = new Scanner(System.in);


		while(true) {
		System.out.println("1~99 정수를 입력해주세요, 0입력시 종료");
		int su = sc.nextInt();
		System.out.printf("입력 : %d\n", su);
		
		int a=su/10;
		int b=su%10;
		
		if((a==3||a==6||a==9)&&(b==3||b==6||b==9)) {
			System.out.println("짝짝");
			} else if((a==3||a==6||a==9)||(b==3||b==6||b==9)) {
				System.out.println("짝");
			} else {
				System.out.println("...");
			}
		
		
			if(su==0) {
				break;
			}
		}
		System.out.printf("종료");
		
	}

		
// 3, 6, 9
		
	}


