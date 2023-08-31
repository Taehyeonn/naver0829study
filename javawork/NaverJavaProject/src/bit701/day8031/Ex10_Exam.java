package bit701.day8031;

import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총 금액 출력
		 * 그리고 수량이 5개 이상일 경우 10%할인된 최종 금액 출력
		 * 
		 * (예)
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가 : 1000
		 * 
		 * 총 금액 : 6000원
		 * 5개 이상 10%할인된 금액 : 5400원
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명 입력");
		String name = sc.nextLine();
		System.out.println("수량 입력");
		int i = sc.nextInt();
		System.out.println("단가 입력");
		int won = sc.nextInt();
		
		
		int sum = i*won;
		System.out.println("총 금액 : "+sum);
		if(i>=5) {
			int dc = sum/10;
			System.out.println("5개 이상 10% 할인된 금액"+(sum-dc));
		}
		
		
		
	}

}
