package main.domain;

import java.util.ArrayList;
import java.util.List;

//무작위 로또숫자, 중복처리(?), 로또숫자정렬(?)

//배열저장 : 2차원배열 ?
//로직 : 무작위 숫자 생성 -> 중복검사 -> 저장 6회반복?


public class Lotto {
	int[] lottoTemp = new int[6];
	List<String> lotto1 = new ArrayList<String>();
	private int temp;
	
	private int createRandomNumber() {
//		int randomNumber = (int)(Math.random() * 45)+1;
//		return lottoNumberDuplicate(randomNumber);
		return (int)(Math.random() * 45)+1;
	}

	
	private int lottoNumberDuplicate() {
			temp = createRandomNumber();
			if(lotto1.contains(temp) {
				return createRandomNumber();
			}
		return temp;
//		int temp = createRandomNumber();
//		if(lotto1.contains(temp));
	}
	
	public void addListNumber() {
		lotto1.add(lottoNumberDuplicate());
	}
	
	
	
}
