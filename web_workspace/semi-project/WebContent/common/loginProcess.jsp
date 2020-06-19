<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String logined = (String) session.getAttribute("로그인여부");

	if (!"Yes".equals(logined)) {
		response.sendRedirect("/semi-project/user/loginForm.jsp?error=deny");		
		return;
	}
%>