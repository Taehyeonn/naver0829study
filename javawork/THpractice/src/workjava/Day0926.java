package workjava;

import java.util.Arrays;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

public class Day0926 {
	boolean[] arr = { false, false, false, false, false, false, false };
	int count = 0;
	
	public int getNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 1~7");
		int num = Integer.parseInt(sc.nextLine());
		return num-1;
	}
	
	public void calcul(int num) {
		
		if(num==0) {
			arr[6] = !arr[6];
		}else {
			arr[num-1] = !arr[num-1];
		}
		
		arr[num] = !arr[num];
		
		if(num==6) {
			arr[0] = !arr[0];
		}else {
			arr[num+1] = !arr[num+1];
		}
		
	}
	
	public void result() {
		System.out.println("1\t2\t3\t4\t5\t6\t7");
		for(int i=0; i<7; i++) {
			
			System.out.print(arr[i]+"\t");
				if(arr[i]==true) {
					count++;
				}
			}
		System.out.println("\n"+count+"개 on");
		
	}
	
	public void win() {
		if(count==7) {
			System.out.println("종료");
			System.exit(0);
		} 
		count=0;
	}
	
	public static void main(String[] args) {

		Day0926 day = new Day0926();
		
		while(true) {
		day.calcul(day.getNumber());
		day.result();
		day.win();
		}
//				
//		
//		boolean g = false;
//		while(true) {
//				
//			if(cnt==7) {
//				break;
//			}
//			
//			if(num==0) {
//				s[0] = !s[0];
//				s[1] = !s[1];
//				s[6] = !s[6];
//				
//			} else {
//			for(int i=0; i<3; i++) {
//				s[num-2+i] = !s[num-2+i];
//			}
//			}
//			
//			
//			cnt = 0;
//			
//			
//			for(int i=0; i<7; i++) {
//			System.out.print(s[i]+" ");
//				if(s[i]==true) {
//					cnt++;
//					
//				}
//			}
//
//			
//			
//			
//			System.out.println(cnt);
//		}
		
		
	}

}
