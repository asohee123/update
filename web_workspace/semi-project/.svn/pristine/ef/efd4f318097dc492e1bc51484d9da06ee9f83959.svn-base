<%@page import="semi.dao.NoticeDao"%>
<%@page import="semi.vo.Notice"%>
<%@page import="semi.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = StringUtil.strWithBr(request.getParameter("content"));
	
	Notice notice = new Notice();
	
	notice.setTitle(title);
	notice.setContent(content);
	
	NoticeDao noticeDao = new NoticeDao();
	
	noticeDao.insertNotice(notice);
	
	response.sendRedirect("notice.jsp");
%>