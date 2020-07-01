<%@page import="semi.dao.ReviewDao"%>
<%@page import="semi.vo.Review"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	
	String userId = request.getParameter("userid");
	int productNo = NumberUtil.stringToInt(request.getParameter("productno"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Review review = new Review();
	review.setUserId(userId);
	review.setProductNo(productNo);	
	review.setTitle(title);
	review.setReviewContent(content);
	
	ReviewDao reviewDao = new ReviewDao();
	reviewDao.insertReview(review);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>