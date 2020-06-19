<%@page import="semi.dao.BucketDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginedId = (String)session.getAttribute("아이디");

	BucketDao bucketDao = new BucketDao();
	
	bucketDao.deleteAll(loginedId);
	
	response.sendRedirect("../home.jsp");
%>