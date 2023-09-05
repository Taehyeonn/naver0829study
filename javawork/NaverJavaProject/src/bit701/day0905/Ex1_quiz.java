package bit701.day0905;

import java.util.Scanner;

public class Ex1_quiz {

	public static void main(String[] args) {
		
		for(int i=1; i<5; i++) {
			for (int j=i; j<5; j++) {
			System.out.print("*");
			}
			System.out.println();
		}

		
		for(int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if(i==j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}
					
			}
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		Exit:
		while(true) {
			System.out.println("-".repeat(35));
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-".repeat(35));
			
			int num = Integer.parseInt(sc.nextLine());
			

			switch(num) {
				case 1:
					System.out.println("선택> 1");
					System.out.println("예금액> ");
					temp += Integer.parseInt(sc.nextLine());
					break;
				case 2:
					System.out.println("선택> 2");
					System.out.println("출금액> ");
					temp -= Integer.parseInt(sc.nextLine());
					break;
				case 3:
					System.out.println("선택> 3");
					System.out.println("잔고> "+temp);
					break;
				case 4:
					System.out.println("선택> 4");
					break Exit;
				default :
					System.out.println("잘못입력");
					break;
			
		
			}
			
			
			
			
		}
		System.out.println("종료");
		
	}

}
