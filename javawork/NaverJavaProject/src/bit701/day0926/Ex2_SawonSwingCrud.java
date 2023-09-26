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

public class Ex2_SawonSwingCrud extends JFrame {
	JTextField tfName,tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;
	
	DbConnect db=new DbConnect();
	
	public Ex2_SawonSwingCrud() {
		super("사원관리");
		this.setBounds(1000, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		
		tfName = new JTextField(4);
		tfScore = new JTextField(5);
		String[] cbGenderTitle= {"남자","여자"};
		cbGender=new JComboBox<String>(cbGenderTitle);
		String[] cbBuseoTitle= {"홍보부", "인사부", "교육부","총무부","개발부"};
		cbBuseo=new JComboBox<String>(cbBuseoTitle);
		
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);
		
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
				String score=tfScore.getText();
				String gender=(String)cbGender.getSelectedItem();
				String buseo=(String)cbBuseo.getSelectedItem();
				
				
				//이름이나 점수 입력 안했을 경우 종료
				if(name.length()==0||score.length()==0) {
					return;
				}
				
				//db에 insert하는 메서드 호출
				insertSawon(name, score, gender, buseo);
				
				//삽입후 데이터 재출력
				sawonSelectAll();
				
				//입력값 초기화
				tfName.setText("");
				tfScore.setText("");
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
							JOptionPane.showMessageDialog(Ex2_SawonSwingCrud.this, "삭제할 행을 선택해주세요");
						} else {
							//row행의 0번열이 num값
							String num=table.getValueAt(row, 0).toString();
							deleteSawon(num);
							//삭제후 데이ㅓ 다시 불러온다
							sawonSelectAll();
						}
					}
				});
				
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchBuseo=JOptionPane.showInputDialog("부서명 입력");
				if(searchBuseo==null) {
					return; //취소누를시 종료
				} else {
					searchSawon(searchBuseo); //이름이 포함된 모든 데이터 테이블에 출력
				}
			}
		});
		
		btnAll.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						sawonSelectAll();
					}
				});

		
		//Center Table
		String[] title = {"번호","이름","점수","성별","부서"};
		tableModel = new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center", new JScrollPane(table));

//		tableModel.get
		
		//초기 db 데이터 가져오기
		sawonSelectAll();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_SawonSwingCrud ex = new Ex2_SawonSwingCrud();
				
	}
	
	//db method
	//db에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void sawonSelectAll() {
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);
		
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="select * from sawon order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");

				//vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
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
	public void insertSawon(String name, String score, String gender, String buseo) {
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql="insert into sawon values (null, ?, ?, ?, ?)";
	
		try {
			pstmt=conn.prepareStatement(sql);
			
			// ? 3개 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
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
	
	public void deleteSawon(String num) {
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql="delete from sawon where num=?";
		
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
	
	public void searchSawon(String searchBuseo) {
		
		Connection conn =db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from sawon where buseo like ?";
		
		tableModel.setRowCount(0);
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchBuseo+"%");
			
			
			rs = pstmt.executeQuery();
			
//			System.out.println(searchBuseo+" 검색결과");
			
			int cnt = 0;
			while(rs.next()) {
				Vector<String> data1=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");

				//vector에 순서대로 추가한다
				data1.add(num);
				data1.add(name);
				data1.add(score);
				data1.add(gender);
				data1.add(buseo);
			
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
