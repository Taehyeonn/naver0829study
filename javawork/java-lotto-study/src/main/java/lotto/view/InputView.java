package main.java.lotto.view;

import java.util.Scanner;

public class InputView {
	Scanner sc = new Scanner(System.in);
	
	public String showInputMoneyMessage() {
		System.out.println("구입 금액을 입력해주세요.");
		return sc.nextLine();
	}
	public String showInputLottoNumberMessage() {
		System.out.println("당첨번호를 입력해주세요.");
		return sc.nextLine();
	}
	public String showInputBounsNumberMessage() {
		System.out.println("보너스 번호를 입력해해주세요");
		return sc.nextLine();
	}
	
	
}
