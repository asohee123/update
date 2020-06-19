<%@page import="semi.dao.QuestionDao"%>
<%@page import="semi.dto.QuestionDto"%>
<%@page import="semi.vo.Question"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String writer = request.getParameter("writer");
	String userId = request.getParameter("userid");
	int productNo = NumberUtil.stringToInt(request.getParameter("productno"));
	String content = request.getParameter("content");
	
	Question question = new Question();
	question.setUserId(userId);
	question.setProductNo(productNo);
	question.setContent(content);
	
	QuestionDao questionDao = new QuestionDao();
	questionDao.insertQuestion(question);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>