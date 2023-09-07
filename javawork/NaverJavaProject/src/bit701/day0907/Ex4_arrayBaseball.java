package bit701.day0907;

import java.util.Scanner;

public class Ex4_arrayBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] com=new int[3];
		int[] user=new int[3];
		String strNum;
		Scanner sc= new Scanner(System.in);
		int ball, strike;
		
		//1~9사이의 중복되지 않은 숫자를 배열에 담는다
		for(int i=0; i<com.length; i++) { 
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0; j<i; j++) { //중복처리
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
//		System.out.printf("정답: %d%d%d",com[0],com[1],com[2]);
//		System.out.println();
		
		while(true) {
			System.out.println(">>");
			strNum=sc.nextLine();
			//strNum의 각 숫자를 USER배열에 정수형태로 넣기
			
			user[0]=strNum.charAt(0)-'0'; //ASKII값 48에 해당하는 문자0빼서 구하려는값
			user[1]=strNum.charAt(1)-'0';
			user[2]=strNum.charAt(2)-'0';
			//user와 com을 비교하여 숫자가 있지만 자리수가 안맞을 경우 ball증가
			//자리수까지 맞을 경우 strike증가
			//strike가 3이면 정답입니다 출력후종료
			
			ball=0;
			strike=0;
			for(int i=0;i<com.length;i++) {
				for(int j=0; j<user.length; j++) {
					if(com[i]==user[j]) {
						if(i==j) {
							strike+=1;
							
						}else {
							ball+=1;
						}
					}
					
				}
			}
			
			
			System.out.printf("%d,%d,%d\n",user[0],user[1],user[2]);
			
			//결과
			if(strike==3) {
				System.out.println("정답입니다");
				System.out.println("게임을 종료합니다");
				break;
			}else {
				System.out.printf("결과 : %dS %dB\n",strike,ball);
			}
			
			//종료
			if(strNum.equalsIgnoreCase("q")) {
				System.out.println("게임을 종료합니다");
				break;
			}
		}

	}

}
