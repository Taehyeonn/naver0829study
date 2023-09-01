package bit701.day0831;

import java.util.Scanner;

public class Ex1_KeyInput {

	public static void main(String[] args) {
		// 키보드 입력받기
		
		//System.in은 1바이트밖에 입력못받음 그래서 Scanner 클래스 사용
		
		//static 변수나 메소드는 new로 객체 생성하지 않고 호출한다.
		//대표적으로 Math클래스의 모든 메서드는 static
		System.out.println("3의 5승 :"+Math.pow(3, 5));
		
		//new로 객체를 생성 해야 하는 변수를 인스턴스라고 함
		Scanner sc = new Scanner(System.in);
		
		
		//숫자 입력후 문자열 입력받는 경우 입력 안되는 현상 발생
		//숫자 입력 후 발생하는 엔터값이 버퍼에 저장되는데 
		//문자열 입력시 버퍼를 먼저 읽고 없는 경우에 키보드로 읽는다 
		

		System.out.println("당신의 이름을 입력하세요.");
		String name = sc.nextLine();
		
		System.out.println("당신의 나이를 입력하세요.");
		int age = sc.nextInt();

		System.out.printf("이름 : %s, 나이 : %d",name,age);
		
		//해결방안1 버퍼의 엔터문자를 먼저 읽어서 없애기
		sc.nextLine();
		
		//해결방안2 문자열을 입력 받고 숫자로 변환
		
	
		
	}

}
