package bit701.day0911;

public class Ex5_Constructor {

class Car2{
	
	String carName;
	String carColor;
	
	private Car2() {
		carName="아우디";
		carColor="검정";
	}
	
	//생성자가 private 이므로 생성해서 반환해줄 static 메서드가 반드시 필요
//	public static Car2 getInstance() {
//		return new Car2();
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "자동차명:"+carName+", 색상:"+carColor;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Car2 car2 = new Car2(); //오류발생, private라서 같은 멤버만 호출 가능하다
//		Car2 car1=Car2.getInstance();
//		System.out.println(car1);

	}

}
