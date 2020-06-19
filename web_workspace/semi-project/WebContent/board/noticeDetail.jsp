<%@page import="semi.dao.NoticeDao"%>
<%@page import="semi.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/navibar.jsp" %>
<div class="container">  
	<div class="row justify-content-center">
		<h4>notice</h4>
	</div>
	<div class="row">
		<div class="col-4">
		<%
			int noticeNo = Integer.parseInt(request.getParameter("noticeno"));
			NoticeDao noDao = new NoticeDao();
			Notice notice = noDao.getNoticeByNo(noticeNo);
		%>
			<table class="table mt-5 table-borderless">
				<tr>
					<th>subject</th>
					<td><%=notice.getTitle() %></td>
				</tr>				
				<tr>
					<th>작성자</th>
					<td>관리자</td>
				</tr>				
			</table>		
		</div>
	</div>
	<div class="container border" style="margin-bottom: 20px; padding-top: 10px;">
		<p><%=notice.getContent() %></p>
	</div>
	<div class="text-right">
	<%
		if("admin".equals(userName)) {
	%>
				<a class="btn btn-primary " href="noticeModify.jsp?noticeno=<%=noticeNo%>" role="button">글 수정</a>			
				<a class="btn btn-primary " href="noticeDelete.jsp?noticeno=<%=noticeNo%>" role="button">글 삭제</a>			
	<%
		}
	%>
				<a class="btn btn-primary " href="notice.jsp" role="button">글 목록</a>			
	</div>	
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>