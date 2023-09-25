package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex7_sawonCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public void selectAll() {
		System.out.println("번호\t사원명\t점수\t성별\t부서");
		System.out.println("=".repeat(50));
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from sawon order by num";
		conn=db.getMysqlConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				int score=rs.getInt("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				System.out.println(num+"\t"+name+"\t"+score+"\t"+gender+"\t"+buseo);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(rs,pstmt,conn);
		}
		
		
	}
	
	public void insertSawon() {
		System.out.println("이름");
		String name=sc.nextLine();
		System.out.println("1-100 사이 점수");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별");
		String gender = sc.nextLine();
		System.out.println("부서");
		String buseo = sc.nextLine();
		
		String sql="insert into sawon (name, score, gender, buseo) values (?,?,?,?)";
		// ? 에 값을 넣는 것: 바인딩, ?는 차례대로 1,2,3,4 .... 
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);//pstmt는 만들때 검사
			
			//?갯수만큼 값을 넣어준다
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
			//실행
			pstmt.execute(); //주의: sql문 안넣음
			System.out.println("사원정보를 추가하였습니다. ");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
	}
	
	public void deleteSawon() {
		System.out.println("삭제할 사원의 이름을 입력하세요");
		String name=sc.nextLine();
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from sawon where name=?";

		
		try {
			pstmt=conn.prepareStatement(sql);
			
			// ?갯수만큼 바인딩
			pstmt.setString(1, name);
			
			//삭제된 인원의 수 구할때 executeUpdate			
			int n=pstmt.executeUpdate();
			if(n==0) {
				System.out.println("삭제할 사원이 존재하지 않습니다");
			} else {
				System.out.println(n+"명 사원 정보 삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
		
	}
	
	public void updateSawon() {
		
		System.out.println("수정할 사원번호를 입력해주세요");
		String num = sc.nextLine();
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("점수를 입력해주세요");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("부서를 입력해주세요");
		String buseo = sc.nextLine();
		
		
		
		String sql = "update sawon "
				+ "set name=?,score=?, buseo=? "
				+ "where num=?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, buseo);
			pstmt.setString(4, num);
			
			int n = pstmt.executeUpdate();
			if(n==0) {
				System.out.println("데이터가 없음");
			} else {
				System.out.println("수정 완료");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(pstmt, conn);
		}
	}
	
	public int getMenu() {
		int menu=0;
		System.out.println("1.추가 2.삭제 3.수정 4.전체조회 5.종료");
		menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public static void main(String[] args) {
		Ex7_sawonCrud ex = new Ex7_sawonCrud();
		
		while(true) {
			int menu=ex.getMenu();
			switch(menu) {
			case 1:
				ex.insertSawon();
				break;
			case 2:
				ex.deleteSawon();
				break;
			case 3:
				ex.updateSawon();
				break;
			case 4:
				ex.selectAll();
				break;
			default:
				System.out.println("시스템을 종료합니다");
				System.exit(0); //시스템 종료
				
			}
			System.out.println("-".repeat(30));
		}

	}

}
