package bit701.day0911;

import java.util.Scanner;




//교재 클래스부분 20번문제
public class Book_BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] account = new Account[10];
		Scanner sc=new Scanner(System.in);
		int count = 0;
		
		//배열 10개가 꽉차면 "더이상 계좌 생성이 안됩니다." 출력
		while(true) {
			System.out.println("-".repeat(50));
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-".repeat(50));
			System.out.println("선택>");
			int s =Integer.parseInt(sc.nextLine());
			if(s==5) {
				System.out.println("프로그램 종료");
				break;
			}
			
			switch(s) {
			case 1:
			{	if(count>=10) {
					System.out.println("더이상 계좌 생성이 안됩니다.");
					break;
				}
				System.out.println("-------계좌생성-------");
				System.out.println("계좌번호>");
				String accountNo = sc.nextLine();
				System.out.println("계좌주>");
				String accountName = sc.nextLine();
				System.out.println("초기입금액>");
				int money=Integer.parseInt(sc.nextLine());
				
				account[count] = new Account(accountNo,accountName,money);
				count += 1;
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
			case 2:
			{
				System.out.println("-------계좌목록-------");
				for(int i = 0; i<count; i++) {
					account[i].accountWrite();
				}
				break;
			}
			case 3:
			{
				System.out.println("-------예금-------");
				System.out.println("계좌번호:");
				String accountNo=sc.nextLine();
				System.out.println("예금액:");
				int money=Integer.parseInt(sc.nextLine());
				//계좌번호를 찾은 후 그 배열버닞의 MONEY에 추가
				for(int i=0; i<count; i++) {
					if(account[i].isAccount(accountNo)) {
						account[i].addMoney(money);
						break;
					}
				}
				System.out.println("결과:예금되었습니다");
				break;
			}
			case 4:
			{
				System.out.println("-------출금-------");
				System.out.println("계좌번호:");
				String accountNo=sc.nextLine();
				System.out.println("출금액:");
				int money=Integer.parseInt(sc.nextLine());
				//계좌번호를 찾은 후 그 배열버닞의 MONEY에서 빼기
				for(int i=0; i<count; i++) {
					if(account[i].isAccount(accountNo)) {
						account[i].subMoney(money);
						break;
					}
				}
				System.out.println("결과:출금되었습니다");
				break;
			}
				
			}
		}

	}

}
