package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_OracleJdbc {
	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public Ex1_OracleJdbc(){
		try {
			Class.forName(ORACLE_DRIVER);
//			System.out.println("오라클 드라이버 성공");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류"+e.getMessage());
		}
	}
	
	public void shopAllDatas() {
		Connection conn=null;
		
		Statement stmt=null;
		ResultSet rs=null; //select일 경우에만 필요
		String sql="select * from shop order by sang_no";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
//			System.out.println("성공");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//select일 경우 무조건 executeQuery(반환타입이 resultSet이라)
			
			//rs.next() : 다음 데이터로 이동하고 true/false 반환
			
			System.out.println("상품번호\t상품명\t가격\t색상");
			System.out.println("=".repeat(40));
			
			int total=0;
			
			while(rs.next()) {
				//데이터를 가져올때 인덱스로 가져오거나 컬럼명으로 가져온다
				//인덱스로 가져와보자
//				String no=rs.getString(1);
//				String name=rs.getString(2);
//				int price=rs.getInt(3);
//				String color=rs.getString(4);
				
				//컬럼명으로 가져와보자
				String no=rs.getString("sang_no");
				String name=rs.getString("sang_name");
				int price=rs.getInt("sang_price");
				String color=rs.getString("sang_color");
				
				total+=price;
				
				System.out.println(no+"\t"+name+"\t"+price+"\t"+color);
				
			}
			System.out.println("\n총 금액은 "+total);
		} catch (SQLException e) {
			System.out.println("실패");
		}finally {
			try {
				rs.close();
				stmt.close(); //열린 역순으로 닫기
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracleJdbc ex=new Ex1_OracleJdbc();
		ex.shopAllDatas();
	}

}
