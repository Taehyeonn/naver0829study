package bit701.day0919;

@FunctionalInterface //인터페이스가 함수형으로 구현이 가능한지 검증(추상메소드가 하나인지)
interface Calculable {
	public void calculate(int x, int y); //추상메서드
}


public class Ex1_Book697 {
	
	public static void action(Calculable calculable) {
		int x=10;
		int y=4;
		
		//데이터 처리
		calculable.calculate(x, y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		action((x,y)->{
			int result=x+y;
			System.out.println("add result="+result);
		});

	}

}
