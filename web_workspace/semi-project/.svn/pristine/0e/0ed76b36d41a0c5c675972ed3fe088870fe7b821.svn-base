<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userid");

	UserDao userDao = new UserDao();
	
	userDao.updateUserleaveStatebyUserID(userId);
	
	session.invalidate();
	
	response.sendRedirect("leaveSuccess.jsp");
%>