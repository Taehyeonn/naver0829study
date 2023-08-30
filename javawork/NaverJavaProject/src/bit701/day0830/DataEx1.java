package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("1");
		System.out.println("2");
		System.out.println("3");
		
		// printf 변환기호에 의한 출력 
		// 정수:%d, 실수:%f, 문자 : %c, 문자열 : %s
		// \n : 줄넘김, \t : 탭넘김
		
		int age = 23;
		double weight = 56.7;
		char blood = 'A';
		String name = "캐서린";
		System.out.printf("\n이름:%s\n",name);
		System.out.printf("나이:%d세\n",age);
		//%5.1f : 전체 자리수-5 소숫점자리수-1
		System.out.printf("몸무게:%4.2fkg\n",weight);
		System.out.printf("혈액형:%c형\n",blood);
		System.out.println("====================");
		//한줄로
		System.out.printf("이름:%s\n혈액형:%c\n나이:%d\n몸무게:%4.1f\n",name,blood,age,weight);
	}

}
