package bit701.day0913;
//interface 는 기능구현을 할 메서드들의 목록을 나열해놓는 일을 한다.
//상수와 추상메서드로만 구현이 가능하다.
//그래서 구분을 할 필요가 없기에 final, abstact 선언은 생략된다
//interface도 new로 생성할 수 없다

interface InterA {
	int SCORE=100; //final상수임( 선언생략)
	public void play(); //abstract메서드임
	public void study();
}	

//일반클래스가 인터페이스를 구현할 경우 implements로 구현
//인터페이스를 구현한 경우 반드시 모든 메서드를 오버라이드 해야 한다
class My implements InterA {

	int myscore=SCORE;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("SCORE="+SCORE); //상수출력
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		//SCORE=90; //오류발생, final상수는 변경할 수 없음
		myscore=80; //그래서 myscore라는 변수를 생성 후 출력
		System.out.println("점수 변경함:"+myscore);	
	}
	
	//My클래스만이 갖고 있는 메서드
	public void processMY() {
		System.out.println("My클래스가 단독으로 처리하는 작업");
	}
	
}
public class Ex5_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterA a=new My();
		a.play();
		a.study();
//		a.processMy();//오류발생-오버라이드 메서드가 아니므로 My로 선언해야 함
		
		System.out.println("====");
		My b=new My();
		b.play();
		b.study();
		b.processMY();

	}

}
