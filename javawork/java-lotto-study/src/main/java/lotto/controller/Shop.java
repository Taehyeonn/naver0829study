package main.java.lotto.controller;

import main.java.lotto.domain.Money;
import main.java.lotto.view.InputView;

public class Shop {

	private InputView inputView;
	private Money money;

	private Shop(){
		this.money = new Money();
		this.inputView = new InputView();
	}
	
	public static Shop visitShop(){
		return new Shop();
	}
	
	public void buyLottos() {
		String input = inputView.showInputMoneyMessage();
		money.inputMoney(input);
	}
	
	
	
}
