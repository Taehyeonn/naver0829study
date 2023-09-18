package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame{
	
	JPanel p = new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow, rbMagenta, rbGray, rbBlue;
	
	public Ex1_ComboBox(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 종료시켜주는 메서드
		this.setDesign();
		this.setVisible(true); //모든컴포넌트는 visible 되기 전에 넣어야 함
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub	
		Vector<String> list = new Vector<String>();
		list.add("빨강");
		list.add("파랑");
		list.add("핑크");
		list.add("회색");
		
		//콤보박스 생성
		combo=new JComboBox<String>(list);
		
		//상단에 추가
//		this.add("North",combo); //상단영역 전체에 추가된다
		
		// 크기 지정해서 넣고 싶은경우(패널에 넣어서 추가)
		JPanel pTop = new JPanel();
		pTop.add(combo);
		this.add("North",pTop);
		JLabel lblMessage;//출력만 가능(입력불가)
		
		//p패널에 라벨 추가
		lblMessage = new JLabel("hava a nice day");
		lblMessage.setFont(new Font("Comic Sans Ms",Font.BOLD,30));
		p.add(lblMessage);
		
		
		//center에는 jpanel p를 추가
		p.setBackground(Color.red);
		this.add("Center",p);
		
		//콤보박스 이벤트
		combo.addItemListener(new ItemListener() { //익명내부클래스
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				// 선택한 문자열을 얻어보자
//				JComboBox<String> eCombo = e.getSource()
				String selectColor=(String)combo.getSelectedItem();
//				System.out.println(selectColor);
				
				//jdk8부터 swtich문에서 String 사용 가능
				switch(selectColor) {
				case "빨강":
					p.setBackground(Color.red);
					break;
				case "파랑":
					p.setBackground(Color.blue);
					break;	
				case "핑크":
					p.setBackground(Color.pink);
					break;
				case "회색":
					p.setBackground(Color.gray);
					break;	
				}
				
				
			}
		});
		
		//하단에 4개의 라디오 버튼 추가하기
		ButtonGroup bg = new ButtonGroup();
		rbYellow = new JRadioButton("노랑");
		rbBlue = new JRadioButton("파랑");
		rbMagenta = new JRadioButton("핫핑크");
		rbGray = new JRadioButton("회색");
		
		//라디오 버튼들을 같은 그룹으로 묶기
		bg.add(rbYellow);
		bg.add(rbBlue);
		bg.add(rbMagenta);
		bg.add(rbGray);
		
		//4개의 라디오 버튼을 패널에 묶어서 넣은 후 프레임에 추가하기
		JPanel pBottom = new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbBlue);
		pBottom.add(rbGray);
		pBottom.add(rbMagenta);
		
		this.add("South",pBottom);
		
		
		//글자색 변ㄴ경 이벤트(배여링 아니므로 각각 이벤트 추가)
		rbYellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.yellow);
				
			}
		});
		
		rbBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.blue);
				
			}
		});
		
		rbGray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.gray);
				
			}
		});
		
		rbMagenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.magenta);
				
			}
		});
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_ComboBox ex = new Ex1_ComboBox("ComboBox");
		
		
	}
}
