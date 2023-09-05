package workjava;

import java.util.Arrays;

public class Day0905 {

	public static void quiz1() {
		//hello를 입력했을때 ㅏㄱ각으 ㅣ알파벳 당 갯수를 반환하는 함수
		//h는 1개 
		//e는 1개...
		//
		// 배열에 하나씩 쪼개ㅓ 넣고 
		// 중복값을 제거한 다음 
		
		
		String text = "hlllo";
		char[] arr1 = new char[text.length()];
		int[] arr2 = new int[text.length()];
		int count = 0;
		int eqCount = 0;
		
		
		for(int i=0; i<text.length(); i++) { //i=01234
			boolean eq = false;
			
			for(int j=0; j<arr1.length; j++) { //01234
				if(text.charAt(i)==arr1[j]) { 
				eq = true;								
				}
			}
			
//			if(eqCount==1) {
//				System.out.println(arr1[count]+"는 "+eqCount+"개 입니다");
//			}else {
//			System.out.println(arr1[count]+"는 "+eqCount+"개 입니다");
//			}
			
			if(eq==false) {
			arr1[count] = text.charAt(i);
			count+=1;
			} 
		}
		
		for(int i=0; i<count; i++) {
			for(int j=0; j<text.length(); j++) {
			if(arr1[i]==text.charAt(j)) {
				eqCount += 1;
				System.out.println(eqCount);
			}
			}
		}
		
		
//		
//		for(int i=0; i<count; i++) {
//		
//		System.out.println(arr1[count]+"는 "+eqCount+"개 입니다");
//		}
		
		System.out.println("arr1 배열 확인용"+Arrays.toString(arr1));
		System.out.println("arr2 배열 확인용"+Arrays.toString(arr2));
		
		
		
		
		
	}

	public static void quiz2() {
		String text = "hello";
		char[] arr1 = new char[text.length()];
		int[] arr2 = new int[text.length()];
		int count = 0; //arr1의 갯수
		 //중복횟수
		for(int i=0; i<text.length(); i++) {
			int eqC=0;
			for(int j=0; j<text.length(); j++) {
				if(text.charAt(i)==arr1[j]) {
					eqC+=1;	
				}
			}
			if(eqC==1) {
				arr1[count]=text.charAt(i);
			}
		}
		
		
		
		System.out.println("arr1 배열 확인용"+Arrays.toString(arr1));
		System.out.println("arr2 배열 확인용"+Arrays.toString(arr2));
		
	}
	
	
	
	public static void main(String[] args) {
		quiz1();
	}
}
