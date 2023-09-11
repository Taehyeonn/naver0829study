package bit701.day0911;

import java.util.Scanner;

public class Ex10_SawonInput {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Sawon[] sa=new Sawon[3];
		
		//3명의 사원에 대한 정보 입력후 배열 생성하기
		for(int i=0; i<sa.length; i++) {
			System.out.println(i+"번의 이름은?");
			String name=sc.nextLine();
			System.out.println(i+"번의 기본급은?");
			int gibon=Integer.parseInt(sc.nextLine());
			System.out.println(i+"번의 수당은?");
			int sudang=Integer.parseInt(sc.nextLine());
			System.out.println(i+"번의 가족수는?");
			int fmailySu=Integer.parseInt(sc.nextLine());
			
			//MyStudent 해당 배열 번지를 생성
			sa[i]=new Sawon(name, gibon, sudang, fmailySu);
		}
		
		
		
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
		for(Sawon s:sa)
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"
					+s.getFamilySu()+"\t"+s.getFamilySudang()+"\t"+s.getTax()+"\t"+s.getNetPay());
		
			
		
	
	
	}

}
