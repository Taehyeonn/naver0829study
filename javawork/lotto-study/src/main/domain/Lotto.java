package main.domain;

import java.util.ArrayList;
import java.util.List;

//무작위 로또숫자, 중복처리(?), 로또숫자정렬(?)

//배열저장 : 2차원배열 ?
//로직 : 무작위 숫자 생성 -> 중복검사 -> 저장 6회반복?


public class Lotto {
	
	List<Integer> lotto1 = new ArrayList<Integer>();
	private int temp;
	
	private int createRandomNumber() {
		return (int)(Math.random() * 45)+1;
	}

	
	private int lottoNumberDuplicate() {
			temp = createRandomNumber();
			if(lotto1.contains(temp)) {
				return lottoNumberDuplicate();
			}
		return temp;
	}

	public void addListNumber() {
		lotto1.add(lottoNumberDuplicate());
	System.out.println(lotto1.toString());
	}
	
	
	
	
}
