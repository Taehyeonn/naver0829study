package bit701.day0904;

public class Ex1_while {

	public static void main(String[] args) {
		// 반복문
		/*
		 * while과 do-while 차이점은 조건을 먼저주느냐, 나중에주느냐(선조건, 후조건)의 차이 
		 * 
		 * 
		 * 
		 * */
		
		int a=65; // 대문자A의 아스키코드 값
		while(a<=90) // 조건이 참인동안 실행, 91이 되면 빠져나간다		
		{
			System.out.println((char)a++);
		}
		System.out.println();
		System.out.println("빠져나온후 a값"+a);
		
		a=65;
		
		// do_while은 조건과 관계없이 무조건 한번은 실행
		int n=10;
		do {
			System.out.println(n--);
		}while(n<10);
			
		
	
		
	}

}
