<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = request.getParameter("contents");
	
	// 아래코드는 생략 
	// Board board = new Board();
	// board.setTitle(title);
	// board.setContents(contents);
	//
	// BoardDao boardDao = new BoardDao();
	// boardDao.insertBoard(board);
	
	response.sendRedirect("list.jsp");
%>