package bit701.day0907;

import java.util.Scanner;

public class Ex3_arrayBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 3행3열의 배열 선언후 1~3사이의 난수를 넣고 가로, 세로, 대각선으로
		 * 비교하여 같은 숫자가 나온 갯수를 구한다
		 * 
		 * */
		
		Scanner sc=new Scanner(System.in);
		int[][]data=new int[3][3];
		int bingo;
		
		while(true) {
			bingo=0;
			
			//3행3열에 1~3의 숫자 임의로 넣기
			for(int i=0; i<data.length;i++) {
				for(int j=0; j<data[i].length; j++) {
					data[i][j]=(int)(Math.random()*3)+1;
				}
			}
			
			//출력
			for(int i=0; i<data.length;i++) {
				for(int j=0; j<data[i].length; j++) {
					System.out.printf("%3d",data[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			//빙고 계산(0이면 꽝, 아닐경우 빙고:2개)
			
			
			//
			for(int i=0;i<3;i++) {
				//가로
				if(data[i][0]==data[i][1]&&data[i][1]==data[i][2])
					bingo+=1;
				//세로
				if(data[0][i]==data[1][i]&&data[1][i]==data[2][i])
					bingo+=1;
			}
			
			// /대각
			if(data[0][0]==data[1][1]&&data[1][1]==data[2][2])
				bingo+=1;
			// \대각
			if(data[0][2]==data[1][1]&&data[1][1]==data[2][0])
				bingo+=1;
			
			if(bingo==0)
				System.out.println("꽝");
			else
				System.out.println("빙고 : "+bingo);
			
			
			
			
			System.out.println("종료:q");
			String ans=sc.nextLine();
			if(ans.equalsIgnoreCase("q"))
				break;
			System.out.println("-".repeat(10));
		}		System.out.println("게임 종료");

		System.out.println("게임 종료");
		
		

	}

}
