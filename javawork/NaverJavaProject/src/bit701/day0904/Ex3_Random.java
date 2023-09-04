package bit701.day0904;

public class Ex3_Random {

	public static void main(String[] args) {
		// 
		
	for(int i=0; i<5; i++) {
		double r=Math.random(); //0.0<=1.0
		System.out.println(r);
	}
	System.out.println("=".repeat(30));
	for(int i=0; i<5; i++) {
		int n=(int)(Math.random()*10); //0.0<=1.0
		System.out.println(n);
	}
	System.out.println("=".repeat(30));
	for(int i=0; i<5; i++) {
		int m=(int)((Math.random()*26)+97); //65~90 사이의 난수 발생(대문자)
		System.out.println(m);
	}

	}

}
