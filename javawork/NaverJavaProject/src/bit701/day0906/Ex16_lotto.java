package bit701.day0906;

import java.util.Arrays;

public class Ex16_lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 		6개 할당된 lotto 변수에 1~45 난수 발생
		 * 		중복된 경우 다시 발생후 오름차순 정렬로 출력
		 * 
		 * 		1등 6개일치
		 * 		2등 5개+보너스
		 * 		3등 5개
		 * 		4등 4개 50000
		 * 		5등 3개 5000
		 * 
		 * */
		
		int[] lotto = new int[6];
		int bo = 0;
		
		Loop:
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
				i--;
				continue Loop;
				}
			}
		}
		
		//보너스 숫자

		for(int i=0; i<lotto.length; i++) {
			bo = (int)(Math.random()*45)+1;
			if(bo==lotto[i]) {
				i=0;
			}
		}
		
		
	//	System.out.println("배열확인 : "+Arrays.toString(lotto));
		
		//selection sort
		for(int i=0; i<lotto.length-1; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
				
			}
		}
		System.out.println("추첨번호 : "+Arrays.toString(lotto)+" + "+bo);
		
		
		
		//추첨
		int count = 0;
		int[] arr = {1,2,3,4,5,6};
	
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(lotto[i]==arr[j]) {
					count++;
					
				}
			}
			
		}
		boolean boCount = false;
		for(int i=0; i<arr.length; i++) {
		if(bo==arr[i])
			boCount = true;
		}
		
		//결과
		
		String result="";
		switch(count) {
		case 6:
			result = "1등";
			break;
		case 5:
			if(boCount==true) {
			result = "2등";	
			}else {
				result = "3등";	
			}
			break;
		case 4:
			result = "4등";	
			break;
		case 3:
			result = "5등";	
			break;
		case 2:
		case 1:
		case 0:
			result = "꽝";	
			break;
		}
		
		System.out.println("내 번호 : "+Arrays.toString(arr));
		System.out.println(count+"개 일치 + 보너스번호 "+boCount);
		System.out.println("결과 : "+result);
		
		
		
		
		
		

	}

}
