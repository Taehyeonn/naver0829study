package bit701.day0911;

/*
 * 자바 생성자의 규칙
 * 1. 반드시 클래스명과 같은 메서드명
 * 2. 리턴 타입 자체가 없다
 * 3. 오버로딩 가능
 * 4. 주로 멤버변수의 초기화를 담당
 * */

class Car{
	private String carName;
	private int carPrice;
	
	//디폴트 생성자 -> 초기값을 주기 위함
	Car(){
		carName="그랜저";
		carPrice=3500;
	}
	
	//생성자를 통해서 외부에서 값을 받아 초기화
	Car(String carName, int carPrice){
		this.carName = carName;
		this.carPrice = carPrice;
	}
	
	public void carShow() {
		System.out.println("자동차명:"+carName+"단가:"+carPrice);
	}
}
public class Ex4_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		car1.carShow();
		
		Car car2=new Car("아반떼",2700);
		car2.carShow();
	}

}
