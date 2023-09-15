package bit701.day0915;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ex7_Canvas extends JFrame {
	//캔버스 멤버변수로 선언
	MyCanvas myCanvas=new MyCanvas();
	
	public Ex7_Canvas(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); //프레임의 시작위치
		this.setSize(500, 500);//프레임의 너비, 높이
//		this.getContentPane().setBackground(Color.cyan); // color 상수를 이용해서 변경
//		this.getContentPane().setBackground(new Color(210,255,190)); //color생성자를 통해변경
		
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
	
	//캔바스 내부 클래스
	class MyCanvas extends Canvas {
		
		String imageIcon1="D:\\image\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//원그리기
			g.setColor(new Color(255, 100, 255)); //선색
			g.drawOval(50, 50, 100, 100);//테두리선만있는 원
			
			//채워진 원
			g.setColor(Color.orange);
			g.fillOval(200, 50, 100, 100);
					
			//테두리만 있는 사각형
			g.setColor(Color.gray);
			g.drawRect(50, 200, 100, 100);
			
			//채워진 사각형
			g.setColor(Color.pink);
			g.fillRect(200, 200, 100, 100);
			
			Image image1=new ImageIcon(imageIcon1).getImage();
			//이미지 그리기
			g.drawImage(image1, 350, 100, this);
			
			//크기변경해서출력
			g.drawImage(image1, 350, 250, 100, 100, this);
		
		}
	}
	
	
	private void setDesign() {
		this.add(myCanvas,"Center");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_Canvas s=new Ex7_Canvas("캔바스");
	}

}
