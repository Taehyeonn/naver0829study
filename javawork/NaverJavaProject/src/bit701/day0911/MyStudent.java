package bit701.day0911;

public class MyStudent {
	private String name;
	private int kor, eng;
	
	public MyStudent(String name, int kor, int eng) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	}
	
	//두 과목의 합계를 구해서 리턴
	
	public int getTotal() {
		return kor+eng;
	}
	
	//두 과목의 평균
	public double getAvg() {
		return getTotal()/2.0;
	}
	
	//평균에 따른 등급 리턴(90이상 : "A그룹", 80이상은 "B그룹", 나머지는 "탈락"
	public String getGrade() {
		double avg = this.getAvg();
		if(avg>=90)
			return "A그룹";
		else if(avg>=80)
			return "B그룹";
		return "탈락";
		
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	
	
}
