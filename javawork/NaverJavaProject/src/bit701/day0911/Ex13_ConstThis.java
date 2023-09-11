package bit701.day0911;
/*
 * this : 자기 자신을 의미하는 인스턴스 변수
 * this() : 생성자에서 다른 생성자 호출시 사용하는 이름 
 * 
 * */
class Kiwi{
	String name;
	int age;
	
	Kiwi(){
		this("홍길동",20);//3번째 생성자가 호출
	}
	
	Kiwi(String name){
		this(name,30); //3번째 생성자가 호출
	}
	Kiwi(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public void writeData() {
		System.out.println("name:"+name+"\tage:"+age);
	}
}


public class Ex13_ConstThis {

	public static void main(String[] args) {
		Kiwi[] karr= {
				new Kiwi(),
				new Kiwi("kim"),
				new Kiwi("Lee",35)
		};
		for(Kiwi k:karr)
			k.writeData();
		
		
	}

}
