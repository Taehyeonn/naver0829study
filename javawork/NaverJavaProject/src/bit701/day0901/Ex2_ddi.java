package bit701.day0901;

import java.util.Scanner;

public class Ex2_ddi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 년도는?");
		int year=sc.nextInt();
		
		//12 로 나눈 나머지를 구한다
		int m=year%12;
		
		//
		String ddi=m==0?"원숭이":m==1?"닭":m==2?"개":m==3?"돼지":m==4?"쥐":m==5?"소"
				:m==6?"호랑이":m==7?"토끼":m==8?"용":m==9?"뱀":m==10?"말":"양";
		System.out.println(year+"년생은 "+ddi+"띠 입니다.");
	}

}
