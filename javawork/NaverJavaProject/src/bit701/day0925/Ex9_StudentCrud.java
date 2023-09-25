package bit701.day0925;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {
	DbConnect db=new DbConnect();
	Scanner sc=new Scanner(System.in);
	
	
	public int getMenu() {
		System.out.println("1.추가 2.삭제 3.수정 4.전체출력 5.검색 6.종료");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public void insertStudent() {
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("혈액형");
		String blood = sc.nextLine();
		System.out.println("핸드폰번호");
		String phone = sc.nextLine();
		
		//insert into student values(null, '이름', 'A', '01077067706',now());
		String sql= "insert into student values(null, ?, ?, ?, now())";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = db.getMysqlConnection();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			
			int n = pstmt.executeUpdate();
			if(n==1) {
				System.out.println("추가 완료");
			} else {
				System.out.println("추가 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.DbClose(pstmt, conn);
		}
		
		
	}
	
	public void deleteStudent() {
		
		System.out.println("삭제할 휴대폰 번호 뒷자리 입력");
		String phone = sc.nextLine();
		
		String sql = "delete from student where right(phone, 4)=?";
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = db.getMysqlConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			
			int n = pstmt.executeUpdate();
			if(n == 0) {
				System.out.println("해당 데이터를 찾지 못했습니다.");
			} else {
				System.out.println(n+"개 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
		
		
		}
	
	public void updateStudent() {
		
		System.out.println("수정할 사원번호를 입력해주세요");
		String num = sc.nextLine();
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("혈액형 입력해주세요");
		String blood = sc.nextLine();
		
		String sql = "update student set name=?, blood=? where num=?";
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = db.getMysqlConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, num);
			
			int n = pstmt.executeUpdate();
			if(n == 0) {
				System.out.println("해당 데이터를 찾지 못했습니다.");
			} else {
				System.out.println("수정 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
		
		
		
	}
	public void selectAllStudent() {
		System.out.println("번호\t이름\t혈액형\t번호\t날짜");
		System.out.println("=".repeat(50));
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from student order by num";
		conn=db.getMysqlConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String score=rs.getString("blood");
				String phone=rs.getString("phone");
				String writeday=rs.getString("writeday");
//				java.sql.Timestamp ts =rs.getTimestamp("writeday");
				System.out.println(num+"\t"+name+"\t"+score+"\t"+phone+"\t"+writeday);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(rs,pstmt,conn);
		}
		
		
	}
	public void searchStudent() {
		
		System.out.println("검색할 이름을 입력하세요");
		String name = sc.nextLine();
		
		String sql = "select * from student where name like ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, "%"+name+"%");
			
			//실행
			rs=pstmt.executeQuery();
			
			System.out.println(name+" 검색 결과");
			

			while(rs.next()) {
				int num=rs.getInt("num");
				name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				String writeday=rs.getString("writeday");
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+writeday);

				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(rs, pstmt, conn);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex9_StudentCrud ex=new Ex9_StudentCrud();
		
		while(true) {
			System.out.println("=".repeat(50));
			int menu=ex.getMenu();
			System.out.println("=".repeat(50));
			
			switch(menu) {
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;				
			case 5:
				ex.searchStudent();
				break;				
			default:
				System.out.println("프로그램종료");
				System.exit(0);
			}
		}

	}

}
