package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex1_OracleShopInsert {
	DbConnect db = new DbConnect();
	public void shopInsert() {
		Scanner sc=new Scanner(System.in);
		System.out.println("상품명 입력");
		String sang=sc.nextLine();
		
		System.out.println("가격 입력");
		int price=Integer.parseInt(sc.nextLine());
		
		System.out.println("색상 입력");
		String color=sc.nextLine();
		
		String sql="insert into shop values(seq_shop,'"+sang+"',"+price+",'"+color+"')";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		//db연결
		conn=db.getOraConnection();
		//statement
		try {
			stmt=conn.createStatement();
			
			//실행
//			boolean b=stmt.execute(sql);//반환타입boolean
//			int n=stmt.executeUpdate(sql);//반환타입 int
//			System.out.println(b+","+n);
			stmt.execute(sql);
			System.out.println("데이터 두번 insert 됨");
		} catch (SQLException e) {
			System.out.println("insert sql문 오류"+e.getMessage());
		} finally {
			db.DbClose(stmt, conn);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Ex1_OracleShopInsert ex=new Ex1_OracleShopInsert();
	ex.shopInsert();
		
	}

}
