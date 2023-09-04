package bit701.day0904;

import java.util.Scanner;

public class Ex8_Book133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메세지입력");
		System.out.println("종료(q)");
	
		Scanner sc =new Scanner(System.in);
		String inputString;
		do {
			System.out.println(">");
			inputString=sc.nextLine();
			System.out.println(inputString);
		}while(!inputString.equalsIgnoreCase("q"));
		
		System.out.println();
		System.out.println("종료");
	}

}
