package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db=new DbConnect();
	
	public void sawonDelete() {
		//사원명 입력후 해당 사원삭제
		//결과값이 0 이면 xxx사원은 없습니다
		//			n이면 총 nn명의 xxx사원정보를 삭제했습니다.
		
		System.out.println("삭제할 사원명을 입력하세요");
		Scanner sc=new Scanner(System.in);
		String name = sc.nextLine();
		
		//delete from stu where idx=100;
		String sql = "delete from sawon where name='"+name+"'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn=db.getMysqlConnection();
		
		try {
			stmt=conn.createStatement();
			
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println(name+" 사원은 없습니다");
			} else {
				System.out.println("총 "+n+"명의 "+name+" 사원 정보를 삭제했습니다.");
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
		Ex4_MysqlSawonDelete ex=new Ex4_MysqlSawonDelete();
		ex.sawonDelete();

	}

}
