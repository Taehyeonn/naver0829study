package bit701.day0908;

//sa.setSawonNo("bit1234");
//sa.setName("홍길동");
//sa.setAge(23);


public class Sawon { 
	private String sawonNo; //클래스의 변수는 무조건 private
	private String name;
	private int age;
	
	//setter method
	public void setSawonNo(String sawonNo) {
		this.sawonNo=sawonNo;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	
	//getter method
	public String getSawonNo() {
		return sawonNo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	

}
