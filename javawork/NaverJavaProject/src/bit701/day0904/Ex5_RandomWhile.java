package bit701.day0904;

import java.util.Scanner;

public class Ex5_RandomWhile {

	public static void main(String[] args) {
		// 
		// 1~100사이의 난수를 발생시킨 후 맞추는 게임
		//
		
		Scanner sc=new Scanner(System.in);
		
		int rnd=(int)(Math.random()*100)+1;
		
		int count = 0;
		
		int num;

		while (true) {

			System.out.print(++count + " :");
			num = sc.nextInt();
			if (num > rnd) {
				System.out.println("\t" + num + "보다 작습니다");

			} else if (num < rnd) {
				System.out.println("\t" + num + "보다 큽니다");
			} else {
				System.out.println("\t정답입니다("+rnd+")");
				break;
			}

		}
		System.out.println("**프로그램 종료**");

	}

}
