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
	
		
		user.setId(id);
		user.setPassword(pwd);
		user.setName(name);
		user.setEmail(email);
		
		// 입력한 아이디로 사용자 정보를 조회했을 쌔 사용자정보가 존재하지 않으면
		userDao.insertNewUser(user);
		
		response.sendRedirect("../home.jsp");
		
	
	
%>