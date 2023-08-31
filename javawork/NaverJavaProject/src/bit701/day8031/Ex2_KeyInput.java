package bit701.day8031;

import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		Scanner sc = new Scanner(System.in);
		System.out.println("당신이 태어난 년도는?");
		int birthYear=Integer.parseInt(sc.nextLine());

		System.out.println("지금 사는 곳은?");
		String address=sc.nextLine();

		System.out.println("저는 "+address+"에 사는 "+birthYear+"년생 학생입니다.");
		//	

		//Date클래스를 이용해서 현재 년도를 구해보자(jdk1.1에 deprecate 되었지만 여전히 많이 사용
		// 권장 : Calendar
		Date date = new Date();
		//getYear 는 1900을 뺀 값이 반환
		int curYear = date.getYear()+1900;
		System.out.println("현재 년도"+curYear);


		//나이구하기
		int age = curYear-birthYear;

		System.out.println("저는 "+address+"에 사는 "+birthYear+"년생 "+age+"살 입니다.");
		System.out.printf("저는 %s에 사는 %d년생 %d살 입니다.\n",address,birthYear,age);


		//20세 이상이면 성인 , 미만이면 미성년자라는 글자 출력
		//if문 or 조건(삼항)연산자(조건식?참일때값:거짓일때값)
		//		String msg=age>=20?"성인":"미성년자";
		//		System.out.println("당신은"+msg);
		//		
		//if문
		String msg="";
		if(age>=20) {
			msg="성인";
		} else {
			msg="미성년자";			
		}
		System.out.println("당신은 "+msg);



	}

}
