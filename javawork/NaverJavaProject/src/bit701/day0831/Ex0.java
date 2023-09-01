package bit701.day0831;

public class Ex0 {

	public static void main(String[] args) {

		int[] arr1;
		int[] arr2;
		int[] arr3;
		
		arr1 = new int[] {1,2,3};
		arr2 = new int[] {1,2,3};
		arr3 = null;
		
		System.out.println(arr1 == arr2);
		System.out.println(arr3 == arr2);
		System.out.println(arr3 == null);
		
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3);
		System.out.println(charValue);

//		boolean result = str1.equals.(str2);
		
		String board = "1,가나다라,aaa,dasasa";
		String[] tokens = board.split(",");
		for(int i=0; i<tokens.length; i++) {
		System.out.println(tokens[i]);
		}
	}

}
