package bit701.day0906;

import java.util.Scanner;

public class Ex12_arraySerachName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names= {"강호동", "유재석", "한채영", "이효리","이승기","김남길","이민정","손미나"};
		
		/*
		 * 	검색할 성은? 이
		 * 		4:이효리
		 * 		5:이승기
		 * 		7:이민정
		 * 		 총 4명
		 * 	검색할 성은? 박
		 * 	'박' 씨 성을 가진 멤버는 없습니다.
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String firstName;
		
		
		while(true) {
		
		System.out.println("검색할 성은? ");
		firstName = sc.nextLine();
		
		if(firstName.equals("끝")) {
			break;
		}
		
		int count=0;
		boolean bFind=false;
		
		for(int i=0; i<names.length; i++) {
			
			if(names[i].startsWith(firstName)==true) {
				System.out.println(i+1+":"+names[i]);
				count++;
				bFind=true;
			}

		}
		
		
		System.out.println("총 "+count+"명");
		if(bFind==false) {
			System.out.println("'"+firstName+"'씨 성을 가진 멤버는 없습니다");
		}
		
		}
		
	}

}
