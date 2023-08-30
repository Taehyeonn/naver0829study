package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
	
	// char, int는 같은 타입이라 봐도 된다(아스키값으로 판단하기 때문)
	char a1=65;
	int a2='B';
	System.out.println(a1); //A
	System.out.println(a2);	//66
	System.out.println((int)a1);//65
	System.out.println((char)a2);//B
	
	System.out.printf("%d의 아스키문자는 %c이다\n",(int)a1,a1);
	
	//A65 B66 C67
	
	char b1='C';
	int b2=67;
	System.out.println(b1);
	System.out.println(b2);	
	System.out.println(b1+1);//68(묵시적 형변환에 의해서 char+int=int) 
	
	/*
	 * 묵시적 형변환
	 *		char + int = int
	 *		long + int = long
	 *		double + int = double
	 *		String + int = String
	 * 	(큰쪽따라감)
	 */
	
	//print나 println은 모든 타입 출력가능
	//이유는 타입별로 여러개를 같은 이름으로 만들어놨기 때문
	//이런 메서드를 중복함수(overloading method)라고 한다
	
	System.out.println((char)(b1+2)); //E b1+2=69로 int타입이나 char로 강제 형변환
	System.out.println(5/2); //2
	System.out.println(5.0/2); //2.5
	System.out.println((double)5/2); //2.5
	System.out.println((double)(5/2)); //2.0
	
	
	
	
	}
}
