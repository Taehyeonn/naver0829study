package bit701.day0906;

public class Ex1_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 : 연속된 형태로 데이터가 저장되는 형태
	    //        	배열은 하나의 객체로 인식
		
		
		//배열 선언방법 1
		
		int[] arr1 = new int[5]; // 5개의 정수타입을 저장할 공간이 확보, 0으로 자동 초기화
		System.out.println("arr1의 할당 갯수"+arr1.length);
		
		//배열의 특정 번지에 값을 넣는 방법
		arr1[1]=10;
		arr1[5]=20; // {0 10 0 0 20}
		
		//출력1
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println();
		//출력2
		for(int n:arr1) { //arr1의 갯수만큼 자동으로 반복이되면서 하나하나의 값을n으로 보냄
			System.out.println(n); //출력1과 같은 출력값
		}
	}

}
