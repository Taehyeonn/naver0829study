package main.java.lotto.domain;

import main.java.lotto.validate.InputValidate;
import main.java.lotto.validate.MoneyValidate;

public class Money {
	
	private static final int UNIT = 1_000;
	private int givenMoney;
	private MoneyValidate moneyValidate;
	private InputValidate inputValidate;
	
	public Money() {
		this.moneyValidate = new MoneyValidate();
		this.inputValidate = new InputValidate();
	}
	
	public void inputMoney(String input) {
		Integer inputNumber = inputValidate.inputSingleNumberValidate(input);
		this.givenMoney = moneyValidate.checkMoneyValidate(inputNumber, UNIT);
	}
	
	

}
