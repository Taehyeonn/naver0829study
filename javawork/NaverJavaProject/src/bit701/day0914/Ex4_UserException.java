package bit701.day0914;

import java.util.Scanner;

class NicknameException extends Exception { // 사용자 설정 예외 추가하기
	public NicknameException (String msg) {
		super(msg);
	}
}
public class Ex4_UserException {
	
	public static void dataInput() throws NicknameException{
		Scanner sc = new Scanner(System.in);
		String nickName;
		System.out.println("닉네임은?");
		nickName =sc.nextLine();
			if(nickName.equals("바보")||nickName.equals("ㅋㅋ")) {
				throw new NicknameException("고운말을 씁시다");
			}
		System.out.println("당신의 닉네임은 "+nickName);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dataInput();
		} catch (NicknameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
