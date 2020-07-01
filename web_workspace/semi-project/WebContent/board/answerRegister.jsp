<%@page import="semi.dao.AnswerDao"%>
<%@page import="semi.vo.Answer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String answerTitle = request.getParameter("title");
	int questionNo = Integer.parseInt(request.getParameter("questionno"));
	int productNo = Integer.parseInt(request.getParameter("productno"));
	String answerContent = request.getParameter("content");
	
	Answer answer = new Answer();
	answer.setQuestionNo(questionNo);
	answer.setAnswerTitle(answerTitle);
	answer.setAnswerContent(answerContent);
	
	AnswerDao answerDao = new AnswerDao();
	answerDao.insertAnswer(answer);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>