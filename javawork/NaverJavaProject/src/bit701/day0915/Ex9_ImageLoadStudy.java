package bit701.day0915;

import java.awt.Canvas;
//아래로 복사
//클래스명, 생성자명, 메인메서드의 호출 변경
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bit701.day0915.Ex5_ArrayButton.MyButton;
import bit701.day0915.Ex8_FileImageLoad.MyCanvas;


public class Ex9_ImageLoadStudy extends JFrame {
	
	JButton btn1,btn2,btn3,btnRnd;
	String initImage="D:\\image\\이쁜동물이미지\\C1.png";
	Image image;
	MyCanvas myCanvas=new MyCanvas();
	
	
	public Ex9_ImageLoadStudy(String title) {
		super(title); // JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100); //프레임의 시작위치
		this.setSize(600, 600);//프레임의 너비, 높이
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
	
	class MyCanvas extends Canvas {
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if(image.getWidth(this)>=300) {
				g.drawImage(image, 60, 10, 370, 450, this);
			} else {
				g.drawImage(image, 60, 10, this);
			}
		}
	}
	
	
	
	private void setDesign() {
		btn1=new JButton("동물1");
		btn2=new JButton("동물2");
		btn3=new JButton("연예인");
		btnRnd=new JButton("랜덤음식");
		
		JPanel p=new JPanel();
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btnRnd);
		
		this.add(p,"North");
		image=new ImageIcon(initImage).getImage();
		this.add("Center",myCanvas);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				initImage = "D:\\image\\이쁜동물이미지\\C2.png";
				image=new ImageIcon(initImage).getImage();
				
				myCanvas.repaint();
				
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				initImage = "D:\\image\\이쁜동물이미지\\C3.png";
				image=new ImageIcon(initImage).getImage();
				
				myCanvas.repaint();
				
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				initImage = "D:\\image\\연예인사진 (2)\\7.jpg";
				image=new ImageIcon(initImage).getImage();
				
				myCanvas.repaint();
				
			}
		});
		
		btnRnd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rnd=(int)(Math.random()*11)+1;
				initImage = "D:\\image\\음식사진\\"+rnd+".jpg";
				image=new ImageIcon(initImage).getImage();
				
				myCanvas.repaint();
				
			}
		});
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_ImageLoadStudy s=new Ex9_ImageLoadStudy("이미지로딩");
	}

}
