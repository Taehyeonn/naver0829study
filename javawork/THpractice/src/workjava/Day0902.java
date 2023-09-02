package workjava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.net.ssl.SSLEngine;

public class Day0902 {
	
	
	public static void quiz1() {
//	*배열과 for문을 이용하여 중복값 제거하기
//	1 ~ 5 사이의 랜덤한 난수를 10개 발생 시켜 배열에 저장하고 그 배열 속에서 중복 된 값을 제거해라.
//	ex) [1,1,1,3,3,3,5,5,5,2] 와 같은 배열을 [1,3,5,2]로 만들어 보아라 + 0 제외시키기
//  랜덤난수는 Math.random() 을 사용할 것
//  
	
		
		int[] arr= new int[10]; //난수 배열
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*5)+1;
		}
		
		System.out.println(Arrays.toString(arr)); // 난수 확인용
		
		
		int[] temp = new int[5]; // 
		int tempCount = 0; // 중복 횟수
		
		
		//중복제거 이중for문
		for(int i=0; i<arr.length; i++) {
			boolean eq = false;
			for(int j=0; j<temp.length; j++) {
				if(arr[i]==temp[j]) {
					eq = true;
				}
			}//for j end
			
			if(eq == false) {
				temp[tempCount++] = arr[i];
			}
			
		}// for i end
		
		
		// 0을 배제 해주기 위한 부분
				int[] result = new int[tempCount];
				for(int i = 0; i < result.length; i++){
					result[i] = temp[i];
				}
		System.out.println(Arrays.toString(result));
		
		
		
		
//		int temp=0, count=0, total=0;
//		
//		for(int i=0; i<arr.length; i++) {
//			for(int k=0; k<arr.length; k++) {
//				if(tempArr[k]==arr[i]) {
//					break;
//				}else {
//					temp=arr[i];
//					tempArr= temp;
//				}
//			}
//			
//			for(int j=0; j<arr.length; j++) {
//				if(temp==arr[j]) {
//					count +=1;
//				}	
//				
//				
//			}
//			System.out.println(temp+" : "+count);
//			total+=count;
//			count=0;
//			if(total>=arr.length) {
//				System.out.println("total"+total);
//				break;
//			}
//		}
		
		
	}
	
	
	
	
	
	//hello를 입력했을때 ㅏㄱ각으 ㅣ알파벳 당 갯수를 반환하는 함수
	//h는 1개 
	//e는 1개...
	//
	// 배열에 하나씩 쪼개ㅓ 넣고 
	// 중복값을 제거한 다음 
	public static char[] getChar(String str) {
		char[] arr=str.toCharArray();
		return arr;
	}
	
	public static int countChar(String str, char ch) {
		

//		System.out.println(str);
		
		int count=0;
		
		for(int i=0; i<str.length(); i++) {
			if(ch==str.charAt(i)) {
				count +=1;
				System.out.println(str.charAt(i)+" : "+count);
			}
		}
		
		return count;
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);	
//		System.out.println("문자열을 입력하세요");
//		String str="hello";
//		System.out.println("문자열 : "+str);
//		
//		System.out.println(Arrays.toString(getChar(str)));

		quiz1();
		

	}

}
