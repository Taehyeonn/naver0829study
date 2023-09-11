package bit701.day0911;

//Overloading method: 메서드명은 반드시 같아야 하고 인자는 반드시 달라야 한다
class Apple{
	public static int sum(int a, int b) {
		return a+b;
	}
	public static int sum(int s1, int s2, int s3) {
		return s1+s2+s3;
	}
	public static double sum(double a, double b) {
		return a+b;
	}
	public static String sum(String a, String b) {
		return a+b;
	}
	public static String sum(String a, int b) {
		return a+b;
	}
	
	//... Variable Argument
	public static int sum(int...n) { // n은 배열타입
		System.out.println("총 "+n.length);
		return 0;	
	}
}


public class Ex2_Overloading {

	public static void main(String[] args) {
		System.out.println(Apple.sum(5, 7));
		System.out.println(Apple.sum("APPLE","ORANGE"));
		System.out.println((Apple.sum(1, 2,3)));
//		System.out.println(Apple.sum(100, "ORANGE"));//오류

	}

}
