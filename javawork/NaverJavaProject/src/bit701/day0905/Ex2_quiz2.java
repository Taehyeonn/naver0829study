package bit701.day0905;

import java.util.Scanner;

public class Ex2_quiz2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민등록번호를 입력해주세요 ex)970303-2222123");
		String ssn = sc.nextLine();
	
		if(ssn.substring(0,1).equals("0")) {
			System.out.printf("%d년 %s월 %s일년생\n",Integer.parseInt(ssn.substring(0,2))+2000,ssn.substring(2,4),ssn.substring(4,6));
		} else {
			System.out.printf("%d년 %s월 %s일년생\n",Integer.parseInt(ssn.substring(0,2))+1900,ssn.substring(2,4),ssn.substring(4,6));		}
		char sex = ssn.charAt(7);
	
		
		switch(sex) {
			case '1':
			case '3':
			case '5':
				System.out.println("남성");
				if(sex == 5) {
					System.out.println("외국인입니다");
				} else {
					System.out.println("내국인입니다");
				}
				break;
				
			case '2':
			case '4':
			case '6':
				System.out.println("여성");
				if(sex == 6) {
					System.out.println("외국인입니다");
				} else {
					System.out.println("내국인입니다");
				}
				break;
		
		}

	}

}
