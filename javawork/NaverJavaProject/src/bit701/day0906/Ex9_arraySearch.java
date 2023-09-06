package bit701.day0906;

import java.util.Scanner;

public class Ex9_arraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String[] names= {"강호동", "유재석", "한채영", "이효리"};
		//이름을 검색하여 몇번째에 있는지 출력
		// 없을경우 "xxx님은 명단에 없습니다"
		
		Scanner sc= new Scanner(System.in);
		String SearchName="";
		int find=-1;//찾을 경우 배열 인덱스값 저장
		
		
		//검색할 이름 입력
		System.out.println("검색할 이름을 입력하세요");
		SearchName = sc.nextLine();
		
		//for문: 같은 이름이 있을 경우 출력,find에 배열인덱스 저장-break;
		for(int i=0; i<names.length; i++) {
			if(SearchName.equals(names[i])) {
				
				find=i;
				break;
			}
		}
		
		
		//find 값에 따라 메세지 출력
		if(find==-1) {
			System.out.println(SearchName+"님은 "+find+"번 배열에 있습니다.");
		}else {
			System.out.println(SearchName+"님은 명단에 없습니다.");
		}
		
		
		//bfind 값에 따라 못찾은 경우 메세지 출력
//		
//		if(!bFind)//if(bFind==false)
			
		
		
		

	}

}
