<%@page import="semi.dao.NoticeDao"%>
<%@page import="semi.util.StringUtil"%>
<%@page import="semi.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int noticeNo = Integer.parseInt(request.getParameter("noticeno"));
	String title = request.getParameter("title");
	String content = StringUtil.strWithBr(request.getParameter("content"));
	
	Notice notice = new Notice();
	
	notice.setTitle(title);
	notice.setContent(content);
	notice.setNoticeNo(noticeNo);
	
	NoticeDao noticeDao = new NoticeDao();
	
	noticeDao.modifyNotice(notice);
	
	response.sendRedirect("noticeDetail.jsp?noticeno=" + noticeNo);
%>