package bit701.day0904;

import java.util.Random;

public class Ex4_Random {

	public static void main(String[] args) {
		// 
		
		Random rnd = new Random();
		for(int i=0;i<5;i++) {
			int a = rnd.nextInt(10); //0~9 사이의 난수 발생
			System.out.print(a);
		}
		System.out.println();
		System.out.println("=".repeat(30));
		for(int i=0;i<5;i++) {
			int a = rnd.nextInt(26)+65; //임의의 대문자가 나오도록(65~90)
			System.out.print((char)a);
		}
	}

}
