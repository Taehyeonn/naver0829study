package bit701.day0901;

import java.util.Scanner;

public class Ex3_Score {

	public static void main(String[] args) {
		/*
		 * 이름, 3과목의 점수(kor, eng, mat)를 입력받은후 총점과 평균(소수1자리출력-NumberFormat)
		 * 그리고 등급을 출력(grade : 평균이 90 이상이면 Excellent 80이상good 나머지try
		 * if~else 사용
		 */
		//선언
		String name, grade, jumsu;
		String[] arr1 = {};
		int sum=0;
		double avg;
		Scanner sc = new Scanner(System.in);		
		
		//입력
		
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		
		System.out.println("국, 영, 수 점수를 입력하세요.");
		jumsu = sc.nextLine();		
		
		//계산
		arr1 = jumsu.split(","); 
		
		for(int i=0; i<3; i++) {
		sum+=Integer.parseInt(arr1[i]);
		}
		
		avg = sum/arr1.length;
		
		if(avg>=90) {
			grade = "Excellent";
		} else if(avg>=80){
			grade = "Good";
		} else {
			grade = "Try";
		}
		
		
		//출력
		System.out.println("이름 "+name);
		System.out.println("총점 "+sum);
		System.out.println("평균 "+avg);
		System.out.println("등급 "+grade);
		
	}

}
