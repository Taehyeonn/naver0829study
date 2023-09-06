package bit701.day0906;

import java.util.Scanner;

public class Ex8_arraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names= {"강호동", "유재석", "한채영", "이효리"};
		//이름을 검색하여 몇번째에 있는지 출력
		// 없을경우 "xxx님은 명단에 없습니다"
		
		Scanner sc= new Scanner(System.in);
		String SearchName="";
		boolean bFind=false;
		
		//검색할 이름 입력
		System.out.println("검색할 이름을 입력하세요");
		SearchName = sc.nextLine();
		
		//for문: 같은 이름이 있을 경우 출력, bFind도 true변경-break;
		for(int i=0; i<names.length; i++) {
			if(SearchName.equals(names[i])) {
				System.out.println(SearchName+"님은 "+i+"번 배열에 있습니다.");
				bFind=true;
				break;
			}
		}
		
		//bfind 값에 따라 못찾은 경우 메세지 출력
		
		if(!bFind)//if(bFind==false)
			System.out.println(SearchName+"님은 명단에 없습니다.");
		
		
		

	}

}
