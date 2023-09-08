package bit701.day0908;

class Bitcamp{
	//인스턴스 멤버 변수
	String name;
	String address;
	
	//클래스 멤버변수 (static이 붙은 거)
	static final String STUDYNAME="네이버클라우드 3기 자바 웹"; //final 상수는 변수명을 대문자로 한다
}

public class Ex2_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bitcamp stu1=new Bitcamp();
		stu1.name="이미자";
		stu1.address="여의도";
		
		Bitcamp stu2=new Bitcamp();
		stu2.name="이기자";
		stu2.address="제주도";
		
		System.out.println("학생정보1");
		System.out.println("이름:"+stu1.name);
		System.out.println("주소:"+stu1.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);//인스턴스는 클래스 이름으로 출력
		
		System.out.println("*".repeat(30));
		System.out.println("학생정보2");
		System.out.println("이름:"+stu2.name);
		System.out.println("주소:"+stu2.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);//인스턴스는 클래스 이름으로 출력
		
		
	}

}
