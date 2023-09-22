package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGroupSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex3_MysqlGroupSawon() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패:"+e.getMessage());
		}
		
	}
	
	public void sawonBunSeok() {
		String sql="select buseo, count(*) count, max(score) maxscore, min(score) minscore, "
				+ "avg(score) avgscore from sawon group by buseo;";
		Connection conn=null;	
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("부서명\t인원수\t최고점\t최저점\t평균");
			System.out.println("=".repeat(40));
			int total=0;
			double su=0;
			while(rs.next()) {
				String buseo = rs.getString("buseo");
				int count = rs.getInt("count");
				int max = rs.getInt("maxscore");
				int min = rs.getInt("minscore");
				double avg = rs.getDouble("avgscore");
//				total+=score;
//				su++;
				System.out.println(buseo+"\t"+count+"\t"+max+"\t"+min+"\t"+avg);
			}
//			System.out.println("\n평균 점수는 "+(double)total/su);
			
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패:"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MysqlGroupSawon ex=new Ex3_MysqlGroupSawon();
		ex.sawonBunSeok();
	}

}

