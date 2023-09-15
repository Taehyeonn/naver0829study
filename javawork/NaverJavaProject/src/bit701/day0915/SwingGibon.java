package bit701.day0915;


//아래로 복사
//클래스명, 생성자명, 메인메서드의 호출 변경
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SwingGibon extends JFrame {
	
	
	public SwingGibon(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); //프레임의 시작위치
		this.setSize(300, 300);//프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.cyan); // color 상수를 이용해서 변경
		this.getContentPane().setBackground(new Color(210,255,190)); //color생성자를 통해변경
		
		this.setDesign();
		this.setVisible(true); //true:프레임을 보이게 false:프레임숨기기
	
		//디자인이나 이벤트를 구현할 메서드 호출
		
		
		//윈도우 이벤트 발생 
		//windowlisten인터페이스를 구현하면 강제로 7개 이상의 메소드를 
		//오버라이딩 해야 하기에 어뎁터를 익명내부 클래스로 생성
		this.addWindowListener(new WindowAdapter() {  				
			@Override
			public void windowClosing(WindowEvent e) { //x버튼 클릭시 호출되는 메서드
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				System.exit(0); //정상종료
				super.windowClosing(e);
			}
		});
	
	}
	
	private void setDesign() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon s=new SwingGibon("안녕");
	}

}
