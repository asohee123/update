<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//bookno, userid, point, content
	int bookNo = Integer.parseInt(request.getParameter("bookno"));
	String userId = request.getParameter("userid");
	int point = Integer.parseInt(request.getParameter("point"));
	String content = request.getParameter("content");
	
	Review review = new Review();
	review.setBookNo(bookNo);
	review.setUserId(userId);
	review.setPoint(point);
	review.setContent(content);
	
	ReviewDao reviewDao = new ReviewDao();
	reviewDao.insertReview(review);
	
	response.sendRedirect("../book/detail.jsp?bookno=" + bookNo);

%>