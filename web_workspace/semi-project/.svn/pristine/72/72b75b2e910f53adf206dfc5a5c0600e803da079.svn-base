<%@page import="semi.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int noticeNo = Integer.parseInt(request.getParameter("noticeno"));
	
	NoticeDao noDao = new NoticeDao();
	
	noDao.deleteNotice(noticeNo);
	
	response.sendRedirect("notice.jsp");		
%>