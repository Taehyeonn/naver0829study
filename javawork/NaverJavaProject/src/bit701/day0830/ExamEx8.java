package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// money 변수에 args[0] 값을 대입 후 급여를 백만단위로 변환
		/*
		 * 출력
		 * money : 5674321원
		 * 만원짜리 567장 
		 * 천원짜리 4장
		 * 백원짜리 3개
		 * 십원 2개
		 * 일원 1개
		 * 
		 * 산술연산자를 사용해서 출력
		 * 
		 */
		
		int money = Integer.parseInt(args[0]);

		System.out.println("money : "+money+"원");
		System.out.println("만원짜리"+money/10000+"장");
		System.out.println("천원짜리"+money%10000/1000+"장");
		System.out.println("백원짜리"+money%10000%1000/100+"장");
		System.out.println("십원짜리"+money%10000%1000%100/10+"장");
		System.out.println("일원짜리"+money%10000%1000%100%10+"장");

		
		
	}

}
