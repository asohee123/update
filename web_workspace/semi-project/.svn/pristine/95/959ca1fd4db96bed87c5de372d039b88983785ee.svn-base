<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("아이디");

	if (!"admin".equals(id)) {
		response.sendRedirect("/semi-project/user/loginForm.jsp?error=permissiondeny");		
		return;
	}
%>