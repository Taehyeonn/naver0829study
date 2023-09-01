package bit701.day0901;

public class Ex4_For {

	public static void main(String[] args) {

		System.out.println("=".repeat(20));// "=" 20번 반복

		for (int i = 0; i < 10; i++) {
			System.out.printf("%2d", i); // 2칸단위로 출력
		}
		System.out.println();
		System.out.println("=".repeat(20));

		// 다중 for문
		for (int i = 0; i < 3; i++) {
			System.out.println("i=" + i);
			for (int j = 0; j < 5; j++) {
				System.out.printf("%2d", j);
			}
			System.out.println();
		}
		System.out.println("=".repeat(20));
		


	}
}
