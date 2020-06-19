<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	
	String pwd = request.getParameter("newPassword");
	String pwd2 = request.getParameter("newPassword2");
	String userId = request.getParameter("id");
		
	UserDao dao = new UserDao();
	User user = dao.getUserById(userId);
	user.setPassword(pwd);
	
	dao.changePassword(user);		
	response.sendRedirect("completePassword.jsp");
%>