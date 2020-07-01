<%@page import="semi.dao.ReviewDao"%>
<%@page import="semi.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

	request.setCharacterEncoding("utf-8");
	
	int productNo = Integer.parseInt(request.getParameter("productno"));
	int reviewNo = Integer.parseInt(request.getParameter("reviewno"));
	
	Review review = new Review();

	review.setProductNo(productNo);
	review.setReviewNo(reviewNo);
	
	ReviewDao dao = new ReviewDao();
	dao.deleteReview(review);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
	
%>