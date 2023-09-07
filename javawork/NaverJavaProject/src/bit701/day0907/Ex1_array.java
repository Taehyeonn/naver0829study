package bit701.day0907;

import java.util.Scanner;

public class Ex1_array {

	public static void main(String[] args) {
		System.out.println("배열 복습");
		/*
		 * 처음에 인원수(count)를 입력후 그 인원수만큼
		 * names, kor, eng를 배열 할당한 후 
		 * 인원수만큼 이름, 국어, 영어점수를 입력하면 
		 * 
		 * 아래와 같이 출려고디도록 프로그램을 작성하세요
		 * 
		 * 번호 이름 국어 영어 총점 평균
		 * --------
		 * 1	김	90	90	90	270 90
		 * 2	이
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		String[] names;
		int[] kor, eng, sum;
		double[] avg;
		
		
		System.out.println("인원수를 입력하세요");
		int count = Integer.parseInt(sc.nextLine());
		
		names=new String[count];
		kor=new int[count];
		eng=new int[count];
		sum=new int[count];
		avg=new double[count];
		
		for(int i=0; i<count; i++) {
	
		System.out.println(i+") 이름을 입력하세요");
		names[i] = sc.nextLine();
		System.out.println(i+") 국어점수를 입력하세요");
		kor[i] = Integer.parseInt(sc.nextLine());
		System.out.println(i+") 영어점수를 입력하세요");
		eng[i] = Integer.parseInt(sc.nextLine());
		
		sum[i]=kor[i]+eng[i];
		avg[i]=sum[i]/2.0;
		System.out.println();
		
		}
		
		System.out.println("번호 이름 국어 영어 총점 평균");
		System.out.println("=".repeat(40));
		
		for(int i=0; i<count; i++) {
		System.out.printf("%d %s %d %d %d %f",i,names[i],kor[i],eng[i],sum[i],avg[i]);
		System.out.println();
		}
		
		
		
		
		
		
	}
		
		

}
