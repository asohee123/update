<%@page import="com.bookstore.dao.BoardDao"%>
<%@page import="com.bookstore.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	int password = Integer.parseInt(request.getParameter("password"));
	String content = request.getParameter("content");
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setPassword(password);
	board.setContent(content);
	
	BoardDao boardDao = new BoardDao();
	
	boardDao.insertBoard(board);
	
	response.sendRedirect("list.jsp");
%>