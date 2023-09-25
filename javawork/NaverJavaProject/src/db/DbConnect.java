package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public DbConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류"+e.getMessage());
		}
	
	
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("oracle 드라이버 오류"+e.getMessage());
		}
	
	}

	public Connection getOraConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL,"angel","a1234");
		} catch (SQLException e) {
			System.out.println("oracle 연결 실패"+e.getMessage());
		}
		return conn;
	}
	
	public Connection getMysqlConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(MYSQL_URL,"root","1234");
		} catch (SQLException e) {
			System.out.println("mysql 연결 실패"+e.getMessage());
		}
		return conn;
	}

	//close #1
	public void DbClose(Statement stmt,Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close error"+e.getMessage());
		}
	}

	//close #2
	public void DbClose(ResultSet rs, Statement stmt,Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("close error"+e.getMessage());
		}
	}
	
	//close #3
		public void DbClose(PreparedStatement ptmt,Connection conn) {
			try {
				ptmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("close error"+e.getMessage());
			}
		}

		//close #4
		public void DbClose(ResultSet rs, PreparedStatement ptmt,Connection conn) {
			try {
				rs.close();
				ptmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("close error"+e.getMessage());
			}
		}	
	
	
}

