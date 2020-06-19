<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String loginedUserId = (String)session.getAttribute("아이디");
	
	UserDao userDao = new UserDao();
	
	User finduser = userDao.getUserById(loginedUserId);
	
	String password = request.getParameter("password");
	
	String address = request.getParameter("address");
	String phoneNumber = request.getParameter("phoneNumber");
	String email = request.getParameter("email");
	
	String inputAddress = "N".equals(address) ? finduser.getAddress() : address;
	String inputPhoneNumber = "N".equals(phoneNumber) ? finduser.getPhone() : phoneNumber;
	String inputEmail = "N".equals(email) ? finduser.getEmail() : email;
	
	User user = new User();
	user.setUserId(loginedUserId);
	user.setPassword(password);
	user.setAddress(inputAddress);
	user.setPhone(inputPhoneNumber);
	user.setEmail(inputEmail);
	
	userDao.updateUserProfile(user);
	
	response.sendRedirect("../home.jsp");
	
%>