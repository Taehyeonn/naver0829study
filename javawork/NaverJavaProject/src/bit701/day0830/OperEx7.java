package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// 비교연산자와 논리연산자 결과값은 참, 거짓
		int kor=100, eng=90, mat=100;
		
		System.out.println(kor>=80);
		System.out.println(kor>=80 || kor!=mat);//앞이 참이므로 뒤를 비교하지 않는다
		System.out.println(kor<80 || kor!=mat);//
		System.out.println(kor>=80 && kor!=mat);
		System.out.println(kor<80 && kor!=mat);
		System.out.println(!(kor==mat));
		System.out.println(kor>=95 && eng>=95 && mat>=95);
		System.out.println(kor>=95 && eng>=95 || mat>=95);
		System.out.println(kor>=95 || eng>=95 && mat>=95);
		
		
		int year=2023;
		//year 윤년여부 확인
		System.out.println(year%4==0 && year%100!=0 || year%400==0);

	}

}
