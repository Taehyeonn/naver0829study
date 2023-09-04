package bit701.day0904;

public class Ex7_Book51 {

	public static void main(String[] args) {
		// json 데이터변환
		// {"키":"값"}
		String jdata="{\"name\":\"이진\"}"; // 자바로 주려면 이렇게 \" 줘야 함
		System.out.println(jdata);
		
		//jdk13에서 추가된 텍스트 블록 문법 """
		String jdata2=
				"""
				{"name":"캔디","adress","역삼동"}
				""";
		System.out.println(jdata2);
		
		//jdk13이전 방식
		String name="마이클잭슨";
		int age=32;
		String jdata3= "{\"name\":\""+name+"\",\"age\":"+age+"}";
		System.out.println(jdata3);
		
		//텍스트 블록 문법에 변수값을 넣는 방법
		String jdata4="""
				{"name":"%s","age":%d}
				""".formatted(name, age);
		System.out.println(jdata4); //{"name":"마이클잭슨","age":32}
		
		
		
		
		String str1="red\nblue\ngreen";
		System.out.println(str1);
		
		String str2="""
				red
				blue
				green
				""";
		System.out.println(str2); //텍스트블록문법은 자동줄바꿈
		
		
		
		
	}

}
