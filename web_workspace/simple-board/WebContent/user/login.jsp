<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	UserDao userDao = new UserDao();
	User user = userDao.getByUserId(id);
	
	if((user == null) || (!pwd.equals(user.getPassword()))){
		
		response.sendRedirect("loginform.jsp?error=fail");
		return;
		
	}
	
	session.setAttribute("LOGINED_USER_ID", id);
	session.setAttribute("LOGINED_USER_NAME", user.getName());
	session.setAttribute("LOGINED_YN", "Yes");
	
	response.sendRedirect("../home.jsp");
%>