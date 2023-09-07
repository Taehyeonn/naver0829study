package bit701.day0907;

public class Ex2_array2 {

	public static void main(String[] args) {
		// 2차원 배열선언 방법
		int[][]arr=new int[2][3];
		System.out.println("행 갯수:"+arr.length);
		System.out.println("0번행의 열갯수:"+arr[0].length);
		System.out.println("1번행의 열갯수:"+arr[1].length);
		
		arr[0][1]=3;
		arr[1][1]=5;
		System.out.println("첫번째 배열 출력");
		arrayWrite(arr);
		
		
		//두번째방법
		int[][] arr2= {
				{1,2},{3,4,5},{10,20,30,40}
		};//0번행 열갯수:2., 1번행 열갯수:3 ...
		System.out.println("두번째 배열 출력");
		arrayWrite(arr2);
		
		//세번째방법
		int[][] arr3;
		arr3=new int[][] {{1,2},{3,4,5},{10,20,30,40}};
		System.out.println("세번째 배열 출력");
		arrayWrite(arr3);
		
	}
		
		public static void arrayWrite(int[][]arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("[%2d][%2d]=%2d ",i,j,arr[i][j]);
			}
			System.out.println();
		}
		
		
		

	}

}
