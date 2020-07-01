<%@page import="semi.dto.ReviewDto"%>
<%@page import="semi.vo.Review"%>
<%@page import="semi.dao.ReviewDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	int productNo = Integer.parseInt(request.getParameter("productno"));
	int reviewNo = Integer.parseInt(request.getParameter("reviewno"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Review review = new Review();
	review.setTitle(title);
	review.setReviewContent(content);
	review.setProductNo(productNo);
	review.setReviewNo(reviewNo);
	
	ReviewDao dao = new ReviewDao();
	dao.modifyReview(review);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
	
%>