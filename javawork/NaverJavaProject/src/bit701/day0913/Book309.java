package bit701.day0913;

class Parent {
	public void method1() {
		System.out.println("parent method1");
	}
	public void method2() {
		System.out.println("parent method2");
	}
}

//상속받는 클래스 구현
class Child extends Parent {
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Child method2");
	}
	
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("Child method3");
	}
}


public class Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child c = new Child();
		c.method1();
		c.method2();
		c.method3();
		System.out.println("------");
		Parent p = new Parent();
		p.method1();
		p.method2();
//		p.method3(); //오류발생, 호출해야 한다면
		((Child)p).method3(); // 부모메서드를 형변환해서 호출하는 방법 
		

	}

}
