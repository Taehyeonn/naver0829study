package bit701.day0913;
//다형성 처리시 부모의 역할이 없을 경우?
//오버라이딩을 위해서 일단 메서드는 만들어야 한다

//추상 클래스의 특징
//1.일반 메서드와 미완성의 abstract메서드 둘 다 구현 가능하다
//2.abstract(추상)클래스는 new로 객체 생성을 할 수 없다
//3.추상 클래스를 상속받는 클래스는 반드시 추상 메서드를 오버라이드해서 기능을 구현해야 한다
//4.만약 추상 메소드를 오버라이드 안할경우 서브클래스도 추상화 시켜야 한다
abstract class SuperColor{
//	public void draw() {
//		//부모클래스가 하는일이 없으므로 안의 내용을 비운다
//		
//	}

	//오버라이드를 위해서 {}부분을 없앤다
	//abstract : 추상화, 미완성적인 메서드라는 의미
	//class의 멤버 메서드중 한개의상의 추상메소드가 있을 경우
	//반드시 클래스로 추상화시켜야 한다. 즉 class에 abstract를 붙인다
	abstract public void draw();
	
	
	public void parentJob( ) {
		System.out.println("부모클래스만 할 수 있는 메서드");
	}
}


//3개의 서브클래스를 만들어
class SubRed extends SuperColor {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("SubRed");
	}
}

class SubGreen extends SuperColor {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("SubGreen");
	}
}

class SubBlue extends SuperColor {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("SubBlue");
	}
}


public class Ex3_Inheri {
	
	public static void draw(SuperColor s) {
		s.parentJob(); //부모만 갖고있는 메소드 호출(오버라이드 안함)
		s.draw();
	}

	public static void main(String[] args) {
		SuperColor ss=new SuperColor() {
			
			@Override
			public void draw() {
				// TODO Auto-generated method stub
				
			}
		};
		
		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());
		
		

	}

}
