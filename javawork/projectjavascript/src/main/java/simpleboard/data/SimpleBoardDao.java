package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import mysql.db.DbConnect;

public class SimpleBoardDao {
	DbConnect db=new DbConnect();
	
	//목록 
	public List<SimpleBoardDto> getAllList(){
		List<SimpleBoardDto> list = new Vector<SimpleBoardDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from simpleboard order by num desc";
//		String sql = """
//				select * 
//				from simpleboard 
//				order by num desc
//				""";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SimpleBoardDto dto=new SimpleBoardDto();//반드시 while문 안에 선언
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setPhoto(rs.getString("photo"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("목록 dao 오류"+e.getMessage());
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	//insert
	public void insertBoard(SimpleBoardDto dto) {
		//String sql = "insert into simpleboard (writer, subject, content, photo, writeday) value (?, ?, ?, ?, now())"; 
		String sql = """
						insert into simpleboard 
							(writer, subject, content, photo, writeday) 
						value (?, ?, ?, ?, now())
				""";
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;

		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPhoto());
			pstmt.execute();

		} catch (SQLException e) { 
			System.out.println("insert dao 오류"+e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//내용보기
	public SimpleBoardDto getData(String num) {
		SimpleBoardDto dto = new SimpleBoardDto();
		//String sql="select * from simpleboard where num=?";
		String sql= """
					select * 
					from simpleboard 
					where num=?
					""";

		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();

			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setPhoto(rs.getString("photo"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));	
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			System.out.println("내용보기 dao 오류"+e.getMessage());
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	
	
	//조회수 증ㅇ가
	public void updateReadcount(String num) {
		SimpleBoardDto dto = new SimpleBoardDto();
		//String sql= "update simpleboard set readcount=readcount+1 where num=?";
		String sql= """
					update simpleboard 
					set readcount = readcount+1 
					where num=?
					""";
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("조회수 증가 dao 오류"+e.getMessage());
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//삭제
		public void deleteBoard(String num) {
						
			//String sql="delete from simpleboard where num=?";
			String sql = """ 
							delete 
							from simpleboard 
							where num=?
						""";
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				pstmt.execute();
			} catch (SQLException e) {
				System.out.println("조회수 증가 dao 오류"+e.getMessage());
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//수정
		public void updateBoard(SimpleBoardDto dto) {
				
			String sql="";
			//사진은 수정하지 않았을 경우 null
			//null이 아닐경우에만 photo를 수정한다
			
			if(dto.getPhoto()==null) { //바인딩 갯수 맞추기 위해 포토는 직접 넣음
				//사진 수정안함
				//sql="update simpleboard set writer=?, subject=?, content=? where num=?";
				sql= """
						update simpleboard 
						set writer=?
						,	subject=? 
						,	content=? 
						where num=?
				""";
			}else {
				//사진 수정
			//	sql="update simpleborad set writer=?, subject=?, content=?, photo='"+dto.getPhoto()+"' where num=?";
			//	sql="update simpleboard set writer=?,subject=?,content=?,photo='"
			//			+dto.getPhoto()+"' "
			//			+ "where num=?";	
				sql = """
						update simpleboard 
						set writer = ?
						,	subject = ?
						,	content = ?
						,	photo = '#1'
						where num = ?
						""".replace("#1", dto.getPhoto());

			}
						
			Connection conn = db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getNum());
				
				pstmt.execute();
			} catch (SQLException e) {
				System.out.println("수정 dao 오류"+e.getMessage());
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
	
}
