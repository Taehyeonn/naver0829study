package workjava;

import java.util.Random;
import java.util.Scanner;

public class Day0901 {

	public static void ex1() {
		//마름모 별찍기
		
		int jul=9;
		
		for(int i=0; i<jul; i++) { // 1 3 5 7 9
			System.out.printf(" ".repeat(jul-i));
			System.out.printf("*".repeat(1+2*i));
			System.out.println();
		}
		
		for(int i=jul-1; i>0; i--) { // 4 3 2 1
			System.out.printf(" ".repeat(1+jul-i));
			System.out.printf("*".repeat(i*2-1));
			System.out.println();
		}
	}
	
	public static void ex2() {
// 		up & down 게임규칙
//		
//		프로그램이 실행되면 컴퓨터는 난수를 통해 1~100사이의 정수 하나를 생성한다. 
//		사용자가 숫자를 입력하면 높은지(Up) 낮은지(Down) 판단하여 출력한다. 
//		7번내에 맞추면 사용자 승리, 틀리면 컴퓨터가 승리한다.
//		한번의 게임이 끝나면 계속할지 여부를 물어본다.
		
		
		
		Random rnd = new Random();
		int round = 0;
		String re="";
		Scanner sc = new Scanner(System.in);
		String result=""; 
		
		int com = (rnd.nextInt(99))+1;
		int my = 0;
		int end = 0;
		
	while(end==0) {
		
		
		round+=1;
		if(round>=10) {  //round 1~7 player win 
			// 결과
			
			System.out.printf("*%s* 다시하시겠습니까? y,n\n",result); 
			re = sc.nextLine();
			
			
			if(re.equals("y")||re.equals("Y")) {
				//다시
				round = 1;
				com = (rnd.nextInt(99))+1;
				re = "";
				result = "";
			}else if(re.equals("n")||re.equals("N")) {
				//종료
				end = 1;
				System.out.printf("게임종료"); 
				
			}
		}
	
		if(round==8) {
			result="패배";
			round=10;
		}
		
		if(round<=7 && round>0) {
		System.out.printf("%dRound) 숫자를 입력해주세요\n",round);
		my = sc.nextInt();
		} 

		
		if(my==com) {
			//정답
			result="승리";
			round=10;
			
			
		} else if(my>com) {
			//up
			System.out.println("Down");
		} else if(my<com) {
			//down
			System.out.println("Up");
		} else {
			//연산error
			System.out.println("Error");
		}
	}

		
		
	
		
		
		
//		for(int i=0; i<1; i++) {
//			System.out.println(com);
//		}
		
	}
	
	public static void ex3() {
		
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		boolean win = false;
		int re;

		while(true) {
			
			int com=rnd.nextInt(99)+1;
//			System.out.println("난수확인용 "+com);
			
			for(int i=1; i<=7; i++) {
				
				System.out.println(i+"Round) 숫자를 입력하세요1~99");
				int my = sc.nextInt();
				
				if(my>com) {
					System.out.println("Down");
					} else if(my<com){
						System.out.println("Up");
					} else {
						System.out.println("정답");
						win = true;
						break;
					}
			}//for end
			
			if(win==false) {
				System.out.println("실패");
			}
			
			
			while(true) {
				System.out.println("-------------");
				System.out.println("숫자를 입력하세요. 재시작(1), 종료(2)");
				re = sc.nextInt();
				if(re==1) {
					System.out.println("게임 재시작!");
					win=false;
					break;
				}else if(re==2) {
					System.out.println("종료");
					return;
				}else {
					System.out.println("입력오류");
				}
			}
			
		} //while end
	} // ex3 end
	
	
	
	
	public static void main(String[] args) {
//		ex1();
//		ex2();
		ex3();
	}
}
