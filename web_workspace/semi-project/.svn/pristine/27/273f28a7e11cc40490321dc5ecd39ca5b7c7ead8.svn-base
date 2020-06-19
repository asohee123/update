<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userid");
	
	UserDao userDao = new UserDao();
	User user = userDao.getUserById(userId);

	boolean result = user!= null ? true : false;
	
	// Gson은 자바객체를 Json형식의 텍스트로 변환해준다.
	Gson gson = new Gson();
	
	out.write(gson.toJson(result));
%>