package bit701.day0913;

abstract class AbstEx1{
	int a=100;
	final String str="abstract test"; //상수
	public String getStr() {
		return str;
	}
	abstract public int getA();
}

abstract class AbstEx2 extends AbstEx1 {
	@Override
	public int getA() {
		// TODO Auto-generated method stub
		return a;
	}
	abstract public void show();
}

class AbstEx3 extends AbstEx2 {
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("마지막기능구현한클래스");
	}	
}

public class Ex4_InheriAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AbstEx1 ex1=new AbstEx1();//abstract 클래스는 객체생성할수없다

//		AbstEx1 ex1=new AbstEx2();//show메서드 추가 후 오류발생
//		System.out.println("a="+ex1.getA());
//		System.out.println("str="+ex1.getStr());
		
		AbstEx3 ex3=new AbstEx3();
		System.out.println("a="+ex3.getA());
		System.out.println("str="+ex3.getStr());
		ex3.show();
		
		AbstEx1 ex4=new AbstEx3();
		ex4.getA();
		ex4.getStr();
//		ex4.show(); //오류발생. show()는 AbstEx2에서 선언이 됨.
	}

}
