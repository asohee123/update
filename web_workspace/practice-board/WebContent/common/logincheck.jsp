<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		
	String loginedYn = (String)session.getAttribute("LOGINED_YN");
	String loginedUserId = (String)session.getAttribute("LOGINED_USER_ID");
	String loginedUserName = (String)session.getAttribute("LOGINED_USER_NAME");
	
	if(loginedYn == null){
		response.sendRedirect("/simple-board/user/loginform.jsp?error=deny");
		return;
	}
	
%>