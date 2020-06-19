<%@page import="com.google.gson.Gson"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");

	UserDao userDao = new UserDao();
	
	Boolean checkYN = userDao.checkEmail(email);
	
	Gson gson = new Gson();
	
	out.write(gson.toJson(checkYN));
%>