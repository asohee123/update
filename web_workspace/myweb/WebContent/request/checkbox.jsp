<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>체크박스 체크된 값 서버로 전달하기</h1>
	
	<form method="post" action="checkboxview.jsp">
		<div>
			<label>이름</label>
			<div><input type="text" name="name"></div>
		</div>
		<div>
			<label>지원분야</label>
			<div>
				<label><input type="radio" name="job" value="정규">경력직</label>
				<label><input type="radio" name="job" value="신입" checked>신입</label>
			</div>
		</div>
		<div>
			<label>보유기술</label>
			<div>
				<label><input type="checkbox" name="skill" value="java">자바</label>
				<label><input type="checkbox" name="skill" value="DB">데이터베이스</label>
				<label><input type="checkbox" name="skill" value="web">웹개발</label>
				<label><input type="checkbox" name="skill" value="data">데이터 분석</label>
				<label><input type="checkbox" name="skill" value="ML">머신러닝</label>
			</div>
		</div>
		<div>
			<button type="submit">제출</button>
		</div>
	</form>
</body>
</html>