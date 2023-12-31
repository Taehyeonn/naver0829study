package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public DbConnect() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 드라이버 오류");
		}
	}
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL,"root","1234");
		} catch (SQLException e) {
			System.out.println("mysql Local 연결 실패"+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(Statement stmt, Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
