package bit701.day0912;

class SuperA{
	public void processA() {
		System.out.println("부모가 가진 메서드 A");
	}
	
	protected void processB() {
		System.out.println("부모가 가진 메서드 B");
	}
	
	private void processC() { //private는상속이 안됨
		System.out.println("부모가 가진 메서드 C");
	}
}

class SubA extends SuperA{
	
	public void show() {
		
		//this는 자ㅣ 자ㅣㄴ의 주소를 ㅏ진 인스턴스 변수
		//this로 processA호출시 현재 클래스에 없으면 부모클래스로부터 
		//찾아서 가져온다
		this.processA();
		this.processB();
//		this.processC(); //
		
		//부모의 주소값을 가진 인스턴스 변수 super
		//반드시 super로만 부모 메서드를 가져와야 하는 경우는
		//부모의 메서드를 자식이 오버라이드한 경우에만
		super.processA();
		super.processB();
	}
}


public class Ex6_Inheri {

	public static void main(String[] args) {
		SubA sub1=new SubA();
		sub1.processA();
		sub1.processB();
//		sub1.processC(); //private는 상속이 안됨
	}

}
