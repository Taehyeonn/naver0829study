<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
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
	img.photo{
		position: absolute;
		left:430px;
		top:100px;
		width: 200px;
		border: 5px groove orange;
	}
</style>
</head>
<%
	String num = request.getParameter("num");

	//dao 선언
	MyShopDao dao = new MyShopDao();
	//dto 얻기
	MyShopDto dto = dao.getSangpum(num);
	
	
%>
<body>
<form action="./myshopupdatejsp" method="post">
	<table class="table table-bordered" style="width:300px; margin:30px 100px;">
		<caption align="top"><b>상품 수정</b></caption>	
		<tr>
			<td align="center" width="100">상품명</td>
			<td>
				<input type="text" name="sangpum" class="form-control"
				required="required" autofocus="autofocus" value="<%=dto.getSangpum() %>">
			</td>
		</tr>
		<tr>
			<td align="center" width="100">사진선택</td>
			<td>
				<select class="form-select" name="photo" id="photo">
				<%
				int n = Integer.parseInt(dto.getPhoto().split("[.]")[0]);
				System.out.println(n);
				for(int i=1; i<=34; i++){%>
					<option value="<%=i%>.<%=(i==24?"gif":"jpg")%>" <%=n==i?"selected":""%>>상품<%=i %></option>
				<%}
				%>
				</select>
				<script>
					//select로 사진 선택시 .photo의 사진 변경
					$("#photo").change(function(){
						let imgval=$(this).val();
						
						//.photo의 src에 적용
						$(".photo").attr("src", "../shop/"+imgval);
					});
				</script>
			</td>
		</tr>
		
		<tr>
			<td align="center" width="100">색상</td>
			<td>
				<input type="color" name="color" class="form-control"
				value="<%=dto.getColor()%>">
			</td>
		</tr>
		<tr>
			<td align="center" width="100">가격</td>
			<td>
				<input type="number" name="price" class="form-control"
				required="required" step=500 min=1000 max=100000 value="<%=dto.getPrice() %>" >
			</td>
		</tr>

		<tr>
			<td align="center" colspan="2">
				<button type="submit">DB수정</button>
				<button type="button" onclick="location.href='myshop.jsp'">목록보기</button>
			</td>
		</tr>
		
	</table>
</form>
<img src="../shop/<%=dto.getPhoto() %>" class="photo">
</body>
</html>