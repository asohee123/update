<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
	.bold-bordered {
		border-bottom: 1px double black;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 상세정보</h1>
	</div>
	<div class="body">
		<p>게시글의 내용을 확인하고, 댓글도 달아보세요.</p>
		<div>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">연습입니다.</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><a href="writers.jsp?userid=hong">홍길동</a></td>
						<th>등록일</th>
						<td>2020-04-31</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>100</td>
						<th>댓글갯수</th>
						<td>20</td>
					</tr>
					<tr>
						<th style="vertical-align: top;">내용</th>
						<td colspan="3" style="vertical-align:top; height:150px; min-height: 150px;">내용입니다. 내용입니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="text-right">
			[<a href="modifyform.jsp?no=1">수정하기</a>]
			[<a href="delete.jsp?no=1">삭제하기</a>]
			[<a href="list.jsp">목록가기</a>]
		</div>
		
		<div>
			<p>댓글을 확인하세요.</p>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>작성자</th>
						<td>김유신</td>
						<th>등록일</th>
						<td>2020-04-31</td>
					</tr>
					<tr class="bold-bordered">
						<th>내용</th>
						<td colspan="3">내용입니다. 내용입니다.</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>김유신</td>
						<th>등록일</th>
						<td>2020-04-31</td>
					</tr>
					<tr class="bold-bordered">
						<th>내용</th>
						<td colspan="3">내용입니다. 내용입니다.</td>
					</tr>
				</tbody>
			</table>
			<br/>
			<div class="well">
				<form method="post" action="../reply/register.jsp">
					<input type="hidden" name="boardno" value="1"/>
					<div class="form-group">
						<textarea rows="3" name="content"></textarea>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>