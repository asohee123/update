<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1>forEach 태그</h1>
		</div>
	</div>
	<%
		int pagePerBlock = 5; // 한 블록에 5개씩 페이지번호 표시
		int pageNo = Integer.parseInt(request.getParameter("pageno"));
		
		int currentBlock = (int)(Math.ceil((double)pageNo/pagePerBlock));
		int beginPage = (currentBlock-1)*pagePerBlock + 1;
		int endPage = currentBlock*pagePerBlock;
		
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		
		/*
			<c:forEach var="변수명" begin="시작값" end="종료값">
				<html 컨텐츠>가 시작값~종료값 범위만큼 반복해서 표시된다.
				지정된 변수명으로 현재 반복진행중인 값을 사용할 수 있다.
				${변수명}
			<c:forEach>
		
		*/
	%>
	<div class="row">
		<div class="col-12 text-center">
			<ul class="pagination">
			
				<c:choose>
				
					<c:when test="${param.pageno > 1 }">
						<li class="page-item"><a class="page-link" href="foreach.jsp?pageno=${param.pageno-1 }">이전</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled"><a class="page-link" href="">이전</a></li>						
					</c:otherwise>
				</c:choose>
					
				<c:forEach var="num" begin="${beginPage }" end="${endPage }">
					<li class="page-item ${param.pageno == num ? 'active' : ''0 }"><a class="page-link" href="foreach.jsp?pageno=${num }">${num }</a></li>
				</c:forEach>
					<c:choose>
						<c:when test="${param.pageno<50 }">						
							<li class="page-item"><a class="page-link" href="foreach.jsp?pageno=${param.pageno+1 }">다음</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item disabled"><a class="page-link" href="">다음</a></li>						
						</c:otherwise>
					</c:choose>				
				
			</ul>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12">

		</div>
	</div>
</div>
</body>
</html>