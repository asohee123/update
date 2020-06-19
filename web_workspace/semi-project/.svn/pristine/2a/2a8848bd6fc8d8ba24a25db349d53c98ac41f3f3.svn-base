<%@page import="semi.dao.UserDao"%>
<%@page import="semi.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	int birth = Integer.parseInt(request.getParameter("birth")) ;
	
	User user = new User();
	user.setUserId(userId);
	user.setPassword(pwd);
	user.setName(name);
	user.setAddress(addr);
	user.setPhone(phone);
	user.setEmail(email);
	user.setBirth(birth);
	
	session.setAttribute("joinInfo", user);
	
	UserDao userDao = new UserDao();
	
	userDao.insertUser(user);
	
	response.sendRedirect("joinComplete.jsp");
%>