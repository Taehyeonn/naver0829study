package main;

import java.util.Arrays;
import java.util.Scanner;

// https://github.com/chosunghyun18/java-lotto-study


//- 로또 번호의 숫자 범위는 1~45까지이다.
//- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
//- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
//- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
//    - 1등: 6개 번호 일치 / 2,000,000,000원
//    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//    - 3등: 5개 번호 일치 / 1,500,000원
//    - 4등: 4개 번호 일치 / 50,000원
//    - 5등: 3개 번호 일치 / 5,000원
//로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
//로또 1장의 가격은 1,000원이다.
//당첨 번호와 보너스 번호를 입력받는다.
//사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
//사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.


public class Ex_Application {
	
	public static void main(String[] args) {

		//선언
		Scanner sc = new Scanner(System.in);
		
		
		//입력
		 //금액, 번호, 보너스번호
		int money = 0;
		System.out.println("구입 금액을 입력하세요");
		money = Integer.parseInt(sc.nextLine());
		
		//당첨번호 입력
	//	int[] lottoWinNumber = new int[6];
		System.out.println("당첨번호를 입력하세요.");
		String[] lottoWinNumber = sc.nextLine().split(",");
				
		
		//보너스번호 입력
		int lottoWinBonusNumber = 0;
		System.out.println("보너스 번호를 입력하세요");
		lottoWinBonusNumber = Integer.parseInt(sc.nextLine());
		
		
		//계산
		
		
		 //구매 수량 구하기
				int lottoBuyQuantity = money/1000;
				System.out.println(lottoBuyQuantity+"개를 구매했습니다.");
				
				
		 //무작위 로또 숫자 발급
		int[] lottoTemp = new int[6];
		
		for(int i=0; i<lottoTemp.length; i++) {
			lottoTemp[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++) {
				if(lottoTemp[i]==lottoTemp[j]) {
					i--;
					break;
				}
			}
		}
		
		 //정렬
		for(int i=0; i<lottoTemp.length-1; i++) { 
			for(int j=i+1; j<lottoTemp.length; j++) {	
				if(lottoTemp[i]>lottoTemp[j]) {
					int temp = lottoTemp[i];
					lottoTemp[i] = lottoTemp[j];
					lottoTemp[j] = temp;
				}
			}
		}
		
		
		System.out.println("로또번호 확인"+Arrays.toString(lottoTemp));
		
		
		
		
		//출력
		

	}

}
