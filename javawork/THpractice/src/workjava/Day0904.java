package workjava;

import java.util.Arrays;

public class Day0904 {

	public static void quiz1() {
	
//	*배열과 for문을 이용하여 중복값 제거하기
//	1 ~ 5 사이의 랜덤한 난수를 10개 발생 시켜 배열에 저장하고 그 배열 속에서 중복 된 값을 제거해라.
//	ex) [1,1,1,3,3,3,5,5,5,2] 와 같은 배열을 [1,3,5,2]로 만들어 보아라 + 0 제외시키기
//  랜덤난수는 Math.random() 을 사용할 것
	
		int[] arr = new int[10];
		int[] temp = new int[arr.length];
		int count=0; // temp에 들어있는 수
		//난수 생성
		for(int i=0; i<10; i++) {
		arr[i] = (int)(Math.random()*5)+1;
		}
		System.out.println("난수 확인용 : "+Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			boolean eq = false;
			for(int j=0; j<temp.length; j++) {
				if(temp[j]==arr[i]) {
					eq = true;
					}
			}
			if(eq==false) {
			temp[count++] = arr[i];
			}
		}
		System.out.println("출력결과 확인"+Arrays.toString(temp));
		System.out.println(count);
		
		
		int[] arr2 = new int[count];
		for(int i=0; i<count; i++) {
			arr2[i] = temp[i];
		}
		System.out.println("최종결과확인"+Arrays.toString(arr2));
		
		
		
	}
	
	public static void main(String[] args) {
		quiz1();
	}
}
