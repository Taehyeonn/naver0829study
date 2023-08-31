package bit701.day8031;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바에서 시간이나 날짜 출력ㅎㅏ는 방법
		
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDay();
		System.out.printf("현재 년도 : %d-%2d-%2d\n",year,month,day);
		System.out.printf("현재 년도 : %d-%02d-%02d\n",year,month,day);
		
		int hour=date.getHours();
		int min=date.getMinutes();
		int sec=date.getSeconds();
		
		System.out.printf("현재시각 : %d:%d:%d", hour, min, sec);
		
		System.out.printf("calender에서");
		
		
		
	}

}
