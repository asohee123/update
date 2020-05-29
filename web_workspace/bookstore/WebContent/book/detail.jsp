<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.vo.Review"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.dto.ReviewDto"%>

<%@page import="com.bookstore.dto.BookDetailDto"%>
<%@page import="com.bookstore.dao.BookDao"%>
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
			<h1>책 상세정보</h1>
		</div>
		<div class="body">
		<%
			int bookNo = Integer.parseInt(request.getParameter("bookno"));
		
			BookDao bookDao = new BookDao();
			BookDetailDto bookDetailDto = bookDao.getBookByNo(bookNo);
			
			ReviewDao reviewDao = new ReviewDao();
			List<ReviewDto> reviews = reviewDao.getReviewsByBookNo(bookNo);
			
		%>
			<div>
				<h3>책의 상세정보</h3>
				<table class="table bordered">
					<tr>
						<th>제목</th>
						<td colspan="3"><%=bookDetailDto.getTitle() %></td>
					</tr>
					<tr>
						<th>저자</th>
						<td><%=bookDetailDto.getWriter() %></td>
						<th>출판사</th>
						<td><%=bookDetailDto.getPublisher() %></td>
					</tr>
					<tr>
						<th>평점</th>
						<td><%=bookDetailDto.getPoint() %> 점</td>
						<th>리뷰수</th>
						<td><%=bookDetailDto.getReviewCnt() %></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getPrice()) %> 원</td>
						<th>할인가격</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getDiscountPrice()) %> 원</td>
					</tr>
					<tr>
						<th>추천수</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getLikes()) %></td>
						<th>재고</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getStock()) %> 권</td>
					</tr>
				</table>
				
				<div class="text-right">
					<a href="list.jsp"><strong>목록으로 가기</strong></a>
				</div>
			</div>
			
			<div>
				<h3>이 책의 리뷰</h3>
				<table class="table">
					<tbody>
					<%
					
					if(reviews.isEmpty()){
					
					%>	
					<tr>
						<td>등독된 리뷰가 존재하지 않습니다.</td>
					</tr>
					<% 
					}else {
						
						for(ReviewDto reviewDto : reviews){	
					
					%>
						<tr>
							<th>번호</th>
							<td><%=reviewDto.getNo() %></td>
							<th>작성자</th>
							<td><%=reviewDto.getUserName() %> 님</td>
							<th>평점</th>
							<td><%=reviewDto.getPoint() %> 점</td>
							<th>작성일</th>
							<td><%=reviewDto.getRegisteredDate() %></td>
						</tr>
						<tr>
							<td colspan="6"><%=StringUtil.textWithBr(reviewDto.getContent()) %></td>
						</tr>
					<%
						
						}
						
					}
					%>
					</tbody>
				</table>
			</div>
		</div>
			<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>