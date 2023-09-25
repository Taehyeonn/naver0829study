package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex6_MysqlSawonUpdate {
	DbConnect db= new DbConnect();
	
	public void sawonUpdate() {
	//num을 입력받아 이름 점수 부서 수정
		Scanner sc= new Scanner(System.in);
		
		System.out.println("수정할 사원번호를 입력해주세요");
		String num = sc.nextLine();
		System.out.println("이름을 입력해주세요");
		String name = sc.nextLine();
		System.out.println("점수를 입력해주세요");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("부서를 입력해주세요");
		String buseo = sc.nextLine();
		
		// update person set age=33,sal=310 where name='박길동';
		String sql = "update sawon set name='"+name+"', score="+score+", buseo='"+buseo
				+"' where num="+num;
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		try {
			stmt=conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println("해당 데이터가 없습니다");
			} else {
				System.out.println("변경완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(stmt, conn);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_MysqlSawonUpdate ex = new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

}
