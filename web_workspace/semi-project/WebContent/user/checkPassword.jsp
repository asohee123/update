<%@page import="com.google.gson.Gson"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String password = request.getParameter("password");
	String findId = (String) session.getAttribute("아이디");

	UserDao userDao = new UserDao();
	
	User user = userDao.getUserById(findId);
	
	Boolean CheckYN = false;
	
	if (password.equals(user.getPassword())) {
		CheckYN = true;
	}
	
	Gson gson = new Gson();
	
	out.write(gson.toJson(CheckYN));
	
%>