package bit701.day0908;
import bit701.day0908.hello.*;
public class Ex1_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHello my=new MyHello();
		my.hello();
		
		//같은 패키지에 있는 클래스 선언
		//다른클래스라도 같은 패키지일경우 private을 제외하고 모두 접근 가능
		//패키지가 다를 경우는 상속관계가 아닐경우 public만 유일하게 접근 가능
		Test t=new Test();
		System.out.println("public 멤버 변수 출력"+t.str1);
		System.out.println("protected 멤버 변수 출력"+t.str2);
		System.out.println("default 멤버 변수 출력"+t.str3);
//		System.out.println("private 멤버 변수 출력"+t.str4);//에러발생(접근안됨)
		
		
		
	}

}
