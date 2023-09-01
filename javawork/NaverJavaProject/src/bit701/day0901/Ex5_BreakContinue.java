package bit701.day0901;

public class Ex5_BreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for(int a=0; a<10; a++) {
			System.out.printf("%3d", a);
			if(a==4)
				break;
		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		
		for(int a=0; a<10; a++) {
			if(a%2==0)
				continue;
			System.out.printf("%3d",a);
		}
		System.out.println();
		System.out.println("-".repeat(30));

	//다중 for문을 한번에 빠져나가고 싶은 경우
	Exit:
		for(int i=0; i<3; i++) {
			System.out.println("i="+i);
			for(int j=0; j<5; j++) {
				System.out.printf("%3d",j);
				if(j==3)
					break Exit;// j=3일때 탈출
			}
			System.out.println();
		}
	System.out.println("-".repeat(30));
		
	
	}

}
