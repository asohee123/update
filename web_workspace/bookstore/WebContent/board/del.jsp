<%@page import="com.bookstore.dao.BoardDao"%>
<%@page import="sun.security.action.GetIntegerAction"%>
<%@page import="com.bookstore.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("boardno"));
	
	BoardDao boardDao = new BoardDao();
	
	boardDao.DelBoardNo(boardNo);
	
	response.sendRedirect("list.jsp");
%>