package main.view;
//구입금액, 당첨번호, 보너스번호

import java.util.Scanner;

public class InputView {
	Scanner sc= new Scanner(System.in);
	
	final String EEROR_MESSAGE_INPUT = "입력오류 : ";
	
	public String inputMessageLottoBuy() {
		System.out.println("구매할 금액을 입력하세요");
		return sc.nextLine();
	}

	public String inputMessageWinNumber() {
		System.out.println("당첨번호를 입력하세요");
		return sc.nextLine();
	}

	public String inputMessageBonusNumer() {
		System.out.println("보너스 번호를 입력하세요");
		return sc.nextLine();
	}
}
