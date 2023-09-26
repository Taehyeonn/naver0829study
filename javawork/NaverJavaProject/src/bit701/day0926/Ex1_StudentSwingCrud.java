package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DbConnect;

public class Ex1_StudentSwingCrud extends JFrame {
	JTextField tfName,tfPhone;
	JComboBox<String> cbBlood;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;
	
	DbConnect db=new DbConnect();
	
	public Ex1_StudentSwingCrud() {
		super("학생관리");
		this.setBounds(1000, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		
		tfName = new JTextField(4);
		tfPhone = new JTextField(10);
		String[] cbTitle= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(cbTitle);
		
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("전화"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);
		
		this.add("North",pTop);
		
		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("검색");
		btnAll=new JButton("전체조회");
		
		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		this.add("South",pBottom);
		
		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//데이터를 가져온다
				String name=tfName.getText();
				String phone=tfPhone.getText();
				String blood=(String)cbBlood.getSelectedItem();
				
				//이름이나 전화번호 입력 안했을 경우 종료
				if(name.length()==0||phone.length()==0) {
					return;
				}
				
				//db에 insert하는 메서드 호출
				insertStudent(name, phone, blood);
				
				//삽입후 데이터 재출력
				studentSelectAll();
				
				//입력값 초기화
				tfName.setText("");
				tfPhone.setText("");
			}
		});
		btnDel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//선택한 행번호를 얻는다
						
						int row=table.getSelectedRow();
						System.out.println(row);
						
						if(row==-1) {
							JOptionPane.showMessageDialog(Ex1_StudentSwingCrud.this, "삭제할 행을 선택해주세요");
						} else {
							//row행의 0번열이 num값
							String num=table.getValueAt(row, 0).toString();
							deleteStudent(num);
							//삭제후 데이ㅓ 다시 불러온다
							studentSelectAll();
						}
					}
				});
				
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchName=JOptionPane.showInputDialog("검색할 이름 입력");
				if(searchName==null) {
					return; //취소누를시 종료
				} else {
					searchStudent(searchName); //이름이 포함된 모든 데이터 테이블에 출력
				}
			}
		});
		
		btnAll.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						studentSelectAll();
					}
				});

		
		//Center Table
		String[] title = {"번호","이름","혈액형","전화","작성일"};
		tableModel = new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center", new JScrollPane(table));

//		tableModel.get
		
		//초기 db 데이터 가져오기
		studentSelectAll();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_StudentSwingCrud ex = new Ex1_StudentSwingCrud();
				
	}
	
	//db method
	//db에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void studentSelectAll() {
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);
		
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from student order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				
				Timestamp ts=rs.getTimestamp("writeday");
				String writeday= sdf.format(ts);
				
				//vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(writeday);
				
				//테이블에 추가
				tableModel.addRow(data);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(rs, pstmt, conn);
		}
		
	}

	//db에 추가
	public void insertStudent(String name, String phone, String blood) {
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql="insert into student values (null, ?, ?, ?, now())";
	
		try {
			pstmt=conn.prepareStatement(sql);
			
			// ? 3개 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
		
	}
	
	//db삭제하는 메서드
	
	public void deleteStudent(String num) {
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql="delete from student where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
		
	}
	
	public void searchStudent(String name1) {
		
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from student where name like ?";
		
		tableModel.setRowCount(0);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name1+"%");
			
			
			rs = pstmt.executeQuery();
			
			System.out.println(name1+"검색결과");
			
			int cnt = 0;
			while(rs.next()) {
				Vector<String> data1=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				
				//vector에 순서대로 추가한다
				data1.add(num);
				data1.add(name);
				data1.add(blood);
				data1.add(phone);
			
				//테이블에 추가
				
				tableModel.addRow(data1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(rs, pstmt, conn);
		}
		
	}
	
	
}
