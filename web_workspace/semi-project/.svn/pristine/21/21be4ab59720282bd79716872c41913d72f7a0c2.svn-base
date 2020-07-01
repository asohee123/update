<%@page import="semi.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDao recent = new ProductDao();
	recent.deleteRecentView((String)session.getAttribute("아이디"));	
	session.invalidate();
	
	response.sendRedirect("../home.jsp");
%>