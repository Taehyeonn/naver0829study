package bit701.day8031;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("년도 4자리 숫자 입력");
		int year=sc.nextInt();
		System.out.println("월(1-12) 입력");
		int month=sc.nextInt();		
		
		//월을 잘못 입력한 경우 종료
		if(month<1 || month>12) {
			System.out.println("월을 잘못 입력 했");
			return;
		}
		
		System.out.printf("입력한 년도와 월 : %d년 %d월 \n\n", year, month);
		int days=0;
		boolean b=year%4==0 && year%100!=0 || year%400==0;
		//if(b==true) System.out.println("윤년");
		if(b) System.out.println("윤년"); //조건에서 ture는 생략가능
										//(b==false 이 경우는 !b 이렇게 많이 씀)
		else System.out.println("평년");
		System.out.println("");
		
		
		switch(month) {
		case 2:
			days=b?29:28; // b가 ture면 윤년으로 29일, 아닐경우 평년으로 28을 저장
			break;
		case 4:	
		case 6:
		case 9:
		case 11:
			days=30;
			break;
		default:
			days=31;
		}
		System.out.printf("%d년 %월은 %d일까지 있어요",year,month,days);
		
	}

}
