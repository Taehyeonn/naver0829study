package bit701.day0919;

@FunctionalInterface
interface Calculable2 {
	double calculator2(double x, double y);
}

class Person{
	public void action(Calculable2 cal) {
		double result = cal.calculator2(10, 4);
		System.out.println("결과 ="+result);
	}
}

public class Ex2_Book704 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.action((x,y)->{
			double result=x+y;
			return result;
		});
		
		//위 호출문과 같은 로직처리
		//리턴 코드 한줄인 경우 return 생략 가능
		person.action((x,y)->(x+y));
	}

}
