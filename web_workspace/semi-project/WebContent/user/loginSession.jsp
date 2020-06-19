<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("userid");
	String password = request.getParameter("userpwd");
	
	UserDao userDao = new UserDao();
	User user = userDao.getUserById(id);
	
	if(user == null) {
		response.sendRedirect("loginForm.jsp?error=noresult");
		return;
	}
	
	if(!user.getPassword().equals(password)) {
		response.sendRedirect("loginForm.jsp?error=fail");		
		return;
	} 
	
	if("Y".equals(user.getIsLeaved())) {
		response.sendRedirect("loginForm.jsp?error=noresult");		
		return;
	}
	
	session.setAttribute("이름", user.getName());
	session.setAttribute("아이디", user.getUserId());	
	session.setAttribute("로그인여부", "Yes");
	
	response.sendRedirect("/semi-project/home.jsp");

%>