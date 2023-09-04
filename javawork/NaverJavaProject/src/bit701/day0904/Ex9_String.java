package bit701.day0904;

public class Ex9_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="apple";
		String str2="AppLe";
		String str3="Have a Good day";
		String str4="	Happy	";
		
		System.out.println(str3.length()); //str3의 총 길이
		System.out.println(str2.toLowerCase()); //str1 모두 소문자로 변환하여 출력
		System.out.println(str2.toUpperCase()); //str2 모두 소문자로 변환하여 출력
		System.out.println(str3.substring(5)); //5부터 끝까지 출력
		System.out.println(str3.substring(7, 11)); //7부터 11
		System.out.println(str3.charAt(0)); //0번 문자 출력
		System.out.println(str3.charAt(7)); //7번 문자 출력
		System.out.println(str1.indexOf('a')); // 첫번째 a의 인덱스 출력
		System.out.println(str3.lastIndexOf('a')); // 마지막 a의 인덱스 출력
		System.out.println(str4.length()); 
		System.out.println(str4.trim().length()); //공백을 제거한 str4의 길이출력
		System.out.println(str3.startsWith("Have")); // have로 시작하는지
		System.out.println(str3.endsWith("day")); // end로 끝나는지
		System.out.println(str1.equals(str2)); //문자열 비교
		System.out.println(str1.equalsIgnoreCase(str2)); //문자열 비교(대소문자구분x)
		System.out.println(str1.compareTo(str2)); //str1과 str2의 차이(양수값:str1>str2, 음수:str1<str2)
		System.out.println(str1.compareTo("apple")); //같을경우 0 (문자 하나씩 대소문자 비교)
				
	}

}
