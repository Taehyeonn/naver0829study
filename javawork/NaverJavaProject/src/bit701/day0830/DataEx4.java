package bit701.day0830;

public class DataEx4 {

	public static void main(String[] args) {
		
		int a1=0xa3; // a3 16진수->10진수 10*16+3=163
		System.out.println(a1);
		int a2=0xf4; // f4 15*16+4
		System.out.println(a2);
		int a3=0xa56; //10*16^2+5*16+6
		System.out.println(a3);
		
		//8진수
		int a4=045; //앞에 0을 붙이면 8진수로 인식한다 : 4*8+5
		System.out.println(a4); //37
	}

}
