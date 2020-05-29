<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션객체를 무효화,폐기 시키는 것, 해당 클라이언트의 세션을 폐기시킨다.
	session.invalidate();

	response.sendRedirect("/bookstore/home.jsp");
%>