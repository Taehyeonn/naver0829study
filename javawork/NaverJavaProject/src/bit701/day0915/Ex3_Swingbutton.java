package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex3_Swingbutton extends JFrame implements ActionListener {
	
	JButton btn1,btn2;  
	
	public Ex3_Swingbutton(String title) {
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
		btn1=new JButton("버튼 #1"); //버튼 생성
		//프레임에 추가
		this.add(btn1,"South"); //borderlayout(기본)인 경우는 위치를 지정해야 함

		//버튼2는 north에 추가해보자
		btn2=new JButton("버튼 #2");
		this.add(btn2,"North");
		
		//버튼 1,2에 이벤트가 발생되도록 추가해보자
		btn1.addActionListener(this); //()의 this는 이벤트 메서드가 구현된 클래스의 인스턴스
		btn2.addActionListener(this); //둘다 같은 이벤트 메서드가 호출
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_Swingbutton s = new Ex3_Swingbutton("버튼");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			System.out.println("버튼1 클릭");
			this.getContentPane().setBackground(Color.red);
		}
		else{
			System.out.println("버튼2 클릭");
			this.getContentPane().setBackground(Color.green);
		}
	}

}