<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	body * {
		font-family: 'Jua';
	}	

</style>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	String irum = request.getParameter("irum");
	
	int java = Integer.parseInt(request.getParameter("java"));
	int jsp = Integer.parseInt(request.getParameter("jsp"));
	int spring = Integer.parseInt(request.getParameter("spring"));
	
	String hp1 = request.getParameter("hp1");
	String hp2 = request.getParameter("hp2");
	
	String tcolor = request.getParameter("tcolor");
	String bcolor = request.getParameter("bcolor");
	
	int sum=0;
	double avg=0;
	try{
		sum=java+jsp+spring;
		avg=sum/3.0;
	} catch(NumberFormatException e){
		sum=0;
		avg=0;
	}

%>
<body>
<div style="background-color:<%=bcolor%>; color:<%=tcolor%>; font-size: 1.5em;">
	<pre> 
이름 : <%=irum %>
점수 : java<%=java %> jsp<%=jsp %> spring<%=spring%>
평균 : <%=avg %>
핸드폰 번호 : <%=hp1%>-<%=hp2.substring(0, 4)%>-<%=hp2.substring(4, 8) %>
	<button style="width:100px"></button>	
			
	</pre>
</div>

</body>
</html>