package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// run - runConfigurations - Arguments에서 직접 입력(구분은 공백으로) 
		System.out.println("내이름은 "+args[0]+" 입니다");
		System.out.println("내지역은 "+args[1]+" 입니다");
		System.out.println("내혈액형은 "+args[2]+"형 입니다");
		System.out.println();
		System.out.println("실수형 데이터 타입");
		float f1=1234.567891234f; // 온점이 들어가면 값과 무관하게 Double로 인식 
							 // 4byte Float으로 값을 변환하려면 끝에 f추가
		double f2=1234.567891234;		
	
		System.out.println(f1); //8자리까지만 정확하게 출력
		System.out.println(f2); //15자리까지 정확하게 출력
	
		char ch1='A';
		char ch2='가';
		System.out.println(ch1);
		System.out.println(ch2);
		
		
		
	}
}
