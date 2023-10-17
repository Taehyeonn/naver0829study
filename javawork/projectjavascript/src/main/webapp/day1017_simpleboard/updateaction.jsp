<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

		//insert와 달라진점 : update는 num값을 읽어야 한다.
		//그러므로 num을 읽고 dto에 추가하는거까지
		
	MultipartRequest multipartRequest = null;
	
	String realPath = getServletContext().getRealPath("/save");
	int uploadSize=1024*1024*5; //5mb
	
	try{
	multipartRequest=new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
	
	//dao dto 선언
	SimpleBoardDao dao = new SimpleBoardDao();
	SimpleBoardDto dto = new SimpleBoardDto();
	
	//데이터 읽기(파일 포함)
	String num=multipartRequest.getParameter("num");
	String writer = multipartRequest.getParameter("writer");
	String subject = multipartRequest.getParameter("subject");
	String content = multipartRequest.getParameter("content");
	
	// 사진은 DefaultFileRenamePolicy()로 인해 변경될 수 있으므로
	// 원본값인 getParamete가 아니라 실제값 getFilesystemName로 받기
	String photo = multipartRequest.getFilesystemName("upload"); 
	
		
	//dto에 넣기
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPhoto(photo);
	
	
	//update 메서드 호출
	dao.updateBoard(dto);
	
	//content.jsp로 이동 (content는 num를 필요로 한다)
	response.sendRedirect("content.jsp?num="+num);
	
	} catch(Exception e){
		out.print("<h3>파일 업로드 오류 발생 : "+e.getMessage()+"</h3>");
	}

%>
