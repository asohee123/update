<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	User user = new User();
	UserDao userDao = new UserDao();
	
	if(userDao.getByUserId(id) != null){
		
		response.sendRedirect("form.jsp?error=dup");
		return;
	}
	
		
		user.setName(name);
		user.setEmail(email);
		user.setId(id);
		user.setPassword(pwd);
		
		userDao.insertNewUser(user);
		
		response.sendRedirect("../home.jsp");
		
	
	
%>