package bit701.day0913;

abstract class Tire {
	abstract public void roll();
}

class HankookTire extends Tire {

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다");
	}
	
}

class KumhoTire extends Tire {

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다");
	}
	
}

class Car{
	public Tire tire; //초기값 null
	public void run() {
		tire.roll(); //tire에 new로 생성을 하지 않은 상태에서 호출시
					//null pointerException 발생
	}
}


public class Book314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.tire=new HankookTire(); //추상클래스는 생성이 안되기에 상속받은 클래스를 생성
		car.run();
		
		car.tire=new KumhoTire();
		car.run();

	}

}
