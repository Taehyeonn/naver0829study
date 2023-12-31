package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex5_OracleShopUpdate {
	DbConnect db=new DbConnect();
	
	public void shopUpdate() {
		Scanner sc = new Scanner(System.in);
		
		//sang_no 값으로 수정(가격, 색상)
		System.out.println("수정할 상품 번호는?");
		String no = sc.nextLine();
		System.out.println("수정할 가격은?");
		int price=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 색상은?");
		String color=sc.nextLine();
		
		//--수정, 강호동의 혈액형을 ab형으로 수정
//		update test set blood='AB' where name='ㄱㄱ';
		String sql="update shop set sang_price="+price+", sang_color='"+color+"' where sang_no="+no;
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOraConnection();
		
		try {
			stmt = conn.createStatement();
			int n=stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println("해당 상품이 없습니다");
			} else {
				System.out.println("수정완료");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.DbClose(stmt, conn);
		}
		
		
	}
	
	public static void main(String[] args) {
		Ex5_OracleShopUpdate ex=new Ex5_OracleShopUpdate();
		ex.shopUpdate();

	}

}
