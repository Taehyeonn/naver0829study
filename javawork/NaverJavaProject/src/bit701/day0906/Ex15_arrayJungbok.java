package bit701.day0906;

import java.util.Random;

public class Ex15_arrayJungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//10개의 배열 안에 1~20 사이의 난수를 ㅜㄱ해서 저장후 출력
		
		Random rnd = new Random();
		int[] data=new int[20];
		
		Loop:
		for(int i=0; i<data.length; i++) {
			data[i]=rnd.nextInt(20)+1;
			
			//중복처리
			for(int j=0; j<i; j++) {
				if(data[i]==data[j]) {
					i--;
					continue Loop; //i++로 이동
				}
			
			}
			
		}
		
		
		//출력(한줄에 5개씩 출력)
		
		for(int i=0; i<data.length; i++) {
			if(i%5==0 && i!=0) {
				System.out.println();
			}
			System.out.printf("\t"+data[i]);
		}
		
		

	}

}
