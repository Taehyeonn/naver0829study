package workjava;

import java.util.Scanner;

public class Day0926 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		
		boolean[] s = new boolean[7];
		
		for(int i=0; i<7; i++) {
			s[i]=false;
		}

		
		boolean g = false;
		while(true) {
		System.out.println("숫자를 입력하세요 1~7");
		int num = Integer.parseInt(sc.nextLine());
			
			
		
			if(cnt==7) {
				break;
			}
			
			if(num==0) {
				s[0] = !s[0];
				s[1] = !s[1];
				s[6] = !s[6];
				
			} else {
			for(int i=0; i<3; i++) {
				s[num-2+i] = !s[num-2+i];
			}
			}
			
			
			cnt = 0;
			
//			if(num==0) {
//				System.out.print(s[0]+" ");
//				if(s[0]==true) {
//					cnt++;
//					
//				}
//				System.out.print(s[1]+" ");
//				if(s[1]==true) {
//					cnt++;
//					
//				}
//				System.out.print(s[6]+" ");
//				if(s[6]==true) {
//					cnt++;
//					
//				}
//				
//				
//			} else {
			
			for(int i=0; i<7; i++) {
			System.out.print(s[i]+" ");
				if(s[i]==true) {
					cnt++;
					
				}
			}
//			}
			
			
			
			System.out.println(cnt);
		}
		
		
	}

}
