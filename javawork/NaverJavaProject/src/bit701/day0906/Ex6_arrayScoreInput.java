package bit701.day0906;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6_arrayScoreInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * score에 5개의 배열 할당 후 키보드로 직접 점수를 입력히여 배열에 저장후
		 * 총점과 평균을 구하세요
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		String in; 
		int[] score = new int[5];
		double avg;
		int sum=0;
		
		//입력
		for(int i=0; i<score.length; i++) {
			System.out.println(i+"번 점수 입력 : ");
			
			score[i]=sc.nextInt();
			if(score[i]<0||score[i]>100) {
				System.out.println("\t 0~100의 정수로 입력");
				i--;
				continue; //i++로 이동
			}
			
			sum+=score[i];
		}
		//연산
		avg=(double)sum/score.length;
		
		//출력
		System.out.println("입력한 점수들");
		for(int n:score)
			System.out.printf("%5d",n);
		System.out.println("\n총점:"+sum);
		System.out.println("평균:"+avg);
		
		
		
	
		
		
		

	}

}
