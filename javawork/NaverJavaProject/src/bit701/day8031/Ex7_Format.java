package bit701.day8031;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ㅠㅐ턴을 이용해서 다양하게 날짜 시간을 출력해보자
		Date date = new Date();
		
		//패턴 1
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		//MM:월 mm:분 EEE:요일짧게 HH:24시간기준 hh:12시간기준
		System.out.println(dateFormat1.format(date));
		
		//숫자를 포멧 양식에 맞게 출력하기
		int money=4567890;
		
		NumberFormat numberformat1=NumberFormat.getInstance(); // 단순 컴마만 추가
		System.out.println(numberformat1.format(money)); //4,567,890
		
		NumberFormat numberformat2=NumberFormat.getCurrencyInstance(); // 지역설정된 화폐 단위 붙여서
		System.out.println(numberformat2.format(money));		
		
		
	}

}
