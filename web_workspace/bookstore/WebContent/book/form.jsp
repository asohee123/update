<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
	
	<%
		String position = "book";
	%>
	<%@ include file="../common/navibar.jsp" %>
	
	</div>
	<div class="header">
		<h1>책 등록</h1>
	</div>
	<div class="body">
		<p>책 정보를 입력하세요.</p>
		<div class="well">
			<form method="post" action="register.jsp">
				<div class="form-group">
					<label>제목</label>
					<div><input type="text" name="title" /></div>
				</div>
				
				<div class="form-group">
					<label>저자</label>
					<div><input type="text" name="writer" /></div>
				</div>
				
				<div class="form-group">
					<label>장르</label>
					<div>
						<select name="genre">
							<option disabled selected>-- 선택하세요 --</option>
							<option value="소설"> 소설</option>
							<option value="인문서적"> 인문서적</option>
							<option value="경제서적"> 경제서적</option>
							<option value="자연과학"> 자연과학 서적</option>
							<option value="IT"> IT</option>
							<option value="외국어"> 외국어</option>
							<option value="교재"> 교재/수험서</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label>출판사</label>
					<div><input type="text" name="publisher" /></div>
				</div>
				
				<div class="form-group">
					<label>가격</label>
					<div><input type="number" name="price" /></div>
				</div>
				
				<div class="form-group">
					<label>할인가격</label>
					<div><input type="number" name="discountPrice" /></div>
				</div>
				
				<div class="form-group">
					<label>입고량</label>
					<div>
						<select name="stock">
							<option disabled selected> -- 선택하세요 -- </option>
							<option value="10"> 10개</option>
							<option value="30"> 30개</option>
							<option value="50"> 50개</option>
							<option value="100"> 100개</option>
							<option value="200"> 200개</option>
						</select>
					</div>
				</div>
				
				<div class="text-right">
					<button type="submit">등록</button>
				</div>
				
			</form>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>

</body>
</html>