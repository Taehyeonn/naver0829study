package workjava;

import java.util.Random;
import java.util.Scanner;

public class Day0831_1 {

	
	
		
	public static void main(String[] args) {
//		 Q : 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
//		
//		 1. 사용자 / 컴퓨터가 임의의 가위, 바위, 보를 입력
//		     - 사용자는 Scanner 를 사용하여 입력 (직접 가위, 바위, 보 중 하나 입력)
//		     - 컴퓨터는 Random 를 사용하여 입력 (0, 1, 2 중 하나를 임의로 생성)
//		     - Random 을 통해 생성된 0, 1, 2 의 값은 각각 가위, 바위, 보로 치환하여 동작하게 한다.
//		
//		 2. 승부 비교를 위한 조건문 작성
//		     - 가위 : 바위 -> 바위 승, 가위 : 보 -> 가위 승, 가위 : 가위 -> 무승부
//		     - 바위 : 바위 -> 무승부,  바위 : 보 -> 보 승,  바위 : 가위 -> 바위 승
//		     - 보 : 바위 -> 보 승,    보 : 보 -> 무승부,   보 : 가위 -> 가위 승
//		
//		 3. 2번 비교 결과에 따른 승, 패, 무 저장해두어 승률을 출력

		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		String result = "";
		int count = 0;

		for (int i = 0; i < 10; i++) {

			System.out.println((i + 1) + "Round) 입력하세요(가위, 바위, 보)");
			String myRSP = sc.nextLine();
			System.out.println("나 : " + myRSP);

			int comcom = rnd.nextInt(3);

			switch (comcom) {
			case 0: // 가위
				System.out.println("컴퓨터 : 가위");
				if (myRSP.equals("가위")) {
					result = "무승부";
				} else if (myRSP.equals("바위")) {
					result = "승";
					count = count + 1;
				} else {
					result = "패";
				}
				break;
			case 1: // 바위
				System.out.println("컴퓨터 : 바위");
				if (myRSP.equals("바위")) {
					result = "무승부";
				} else if (myRSP.equals("보")) {
					result = "승";
					count = count + 1;
				} else {
					result = "패";
				}
				break;
			case 2: // 보
				System.out.println("컴퓨터 : 보");
				if (myRSP.equals("보")) {
					result = "무승부";
				} else if (myRSP.equals("가위")) {
					result = "승";
					count = count + 1;
				} else {
					result = "패";
				}
				break;
			}

			System.out.println(result);
			System.out.println("////////////////////");

			String[] arr = new String[10];
			arr[i] = result;

			double per = ((double) count / (i + 1)) * 100;// (승리한 경기 수) ÷ {(승수)+(패수)}
			System.out.println("승률 :" + per + "% (" + (i + 1) + "전 " + count + "승)");
			System.out.println("///////////////////");

		}
		System.out.println("게임이 종료되었습니다.");
	}

}
