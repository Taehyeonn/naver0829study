package workjava;

public class Day0901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int jul=5;
		
		for(int i=0; i<jul; i++) { // 1 3 5 7 9
			
			System.out.printf(" ".repeat(jul-i));
			System.out.printf("*".repeat(1+2*i));
			System.out.println();
		}
		
		for(int i=jul; i>0; i--) {
			System.out.println(i);
//			System.out.println("*".repeat(5  1 )); // 9  7 5 3 1
		}
		
	}
}
