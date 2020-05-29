<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1><small style="font-weight: normal;">홍길동</small>님의 게시글</h1>
	</div>
	<div class="body">
		<p>게시글 목록을 확인하세요</p>
		
		<div>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">조회수</th>
						<th class="text-center">댓글수</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="text-center">1</td>
						<td><a href="hit.jsp?no=1">연습입니다.</a></td>
						<td class="text-center"><a href="writers.jsp?userid=hong">홍길동</a></td>
						<td class="text-center">10</td>
						<td class="text-center">3</td>
						<td class="text-center">2020-05-21</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td><a href="hit.jsp?no=1">연습입니다.</a></td>
						<td class="text-center"><a href="writers.jsp?userid=hong">홍길동</a></td>
						<td class="text-center">10</td>
						<td class="text-center">3</td>
						<td class="text-center">2020-05-21</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>