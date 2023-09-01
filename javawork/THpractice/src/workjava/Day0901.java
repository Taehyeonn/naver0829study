package workjava;

public class Day0901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int jul=9;
		
		for(int i=0; i<jul; i++) { // 1 3 5 7 9
			System.out.printf(" ".repeat(jul-i));
			System.out.printf("*".repeat(1+2*i));
			System.out.println();
		}
		
		for(int i=jul-1; i>0; i--) { // 4 3 2 1
			System.out.printf(" ".repeat(1+jul-i));
			System.out.printf("*".repeat(i*2-1));
			System.out.println();
		}
		
	}
}
