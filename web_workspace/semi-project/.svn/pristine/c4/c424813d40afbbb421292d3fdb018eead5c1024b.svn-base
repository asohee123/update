<%@page import="com.google.gson.Gson"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String phoneNumber = request.getParameter("phonenumber");

	UserDao userDao = new UserDao();
	
	Boolean checkYN = userDao.checkPhoneNumber(phoneNumber);
	
	Gson gson = new Gson();
	
	out.write(gson.toJson(checkYN));
%>