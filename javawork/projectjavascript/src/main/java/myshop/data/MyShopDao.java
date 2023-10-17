package myshop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;



import mysql.db.DbConnect;

public class MyShopDao {
	DbConnect db=new DbConnect();

	//전체 출력
	public List<MyShopDto> getAllSangpums(){
		List<MyShopDto> list = new Vector<MyShopDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop order by num";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				MyShopDto dto=new MyShopDto();//반드시 while문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setPhoto(rs.getString("photo"));
				dto.setColor(rs.getString("color"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				//list에 추가
				list.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}


	//insert
	public void insertShop(MyShopDto dto) {


		String sql="insert into myshop (sangpum, color, price, photo, writeday) values (?, ?, ?, ?, now())";



		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;


		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getColor());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getPhoto());

			pstmt.execute();
			System.out.println("사원추가완료");
		} catch (SQLException e) { 
			System.out.println("insert sql문 오류"+e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void deleteShop(String num) { //계산할필요없으면 굳이 int로 안받아도 됨

		String sql = "delete from myshop where num=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	//num에 해당하는 dto 반환
	public MyShopDto getSangpum(String num){

		MyShopDto dto=new MyShopDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop where num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();

			if(rs.next()) {

				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setPhoto(rs.getString("photo"));
				dto.setColor(rs.getString("color"));
				dto.setWriteday(rs.getTimestamp("writeday"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	
	//update
		public void updateShop(MyShopDto dto) {

			String sql="update myshop set sangpum=?, color=?, price=?, photo=?, where num=?";
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;

			try {
				pstmt = conn.prepareStatement(sql);

				//바인딩
				pstmt.setString(1, dto.getSangpum());
				pstmt.setString(2, dto.getColor());
				pstmt.setInt(3, dto.getPrice());
				pstmt.setString(4, dto.getPhoto());
				pstmt.setInt(5, dto.getNum());
				
				//실행
				pstmt.execute();
			} catch (SQLException e) { 
				System.out.println("insert sql문 오류"+e.getMessage());
			} finally {
				db.dbClose(pstmt, conn);
			}
		}



}
